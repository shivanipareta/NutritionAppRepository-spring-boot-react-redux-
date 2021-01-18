import { GET_WEIGHTLOGS, GET_WEIGHTLOG, DELETE_WEIGHTLOG } from "../actions/type";

const initialState = {
  weightlogs: [],
  weightlog: {}
};

export default function(state = initialState, action) {
  switch (action.type) {
    case GET_WEIGHTLOGS:
      return {
        ...state,
        weightlogs: action.payload
      };
    case GET_WEIGHTLOG:
      return {
        ...state,
        weightlog: action.payload
      };
      case DELETE_WEIGHTLOG:
      return {
        ...state,
        weightlogs: state.weightlogs.filter(
          weightlog => weightlog.userId !== action.payload
        )
      };
    default:
      return state;
  }
}
