import { GET_DIETPLANS, GET_DIETPLAN, DELETE_DIETPLAN } from "../actions/type";

const initialState={
    dietplans:[],
    dietplan:{}
};
export default function(state=initialState,action){
    switch(action.type){
        case GET_DIETPLANS:
            return{
                ...state,
                dietplans: action.payload
            };
        case GET_DIETPLAN:
            return {
                ...state,
                dietplan: action.payload
              };

        case DELETE_DIETPLAN:
                return {
                  ...state,
                  dietplans: state.dietplans.filter(
                    dietplan => dietplan.id != action.payload
                  )
                };      
            default:
                return state;
    }
}




