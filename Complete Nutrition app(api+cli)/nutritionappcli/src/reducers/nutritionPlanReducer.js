import { GET_NUTRITIONPLANS, GET_NUTRITIONPLAN, DELETE_NUTRITIONPLAN } from "../actions/type";

const initialState={
    nutritionplans:[],
    nutritionplan:{}
};
export default function(state=initialState,action){
    switch(action.type){
        case GET_NUTRITIONPLANS:
            return{
                ...state,
                nutritionplans: action.payload
            };
        case GET_NUTRITIONPLAN:
            return {
                ...state,
                nutritionplan: action.payload
              };

        case DELETE_NUTRITIONPLAN:
                return {
                  ...state,
                  nutritionplans: state.nutritionplans.filter(
                    nutritionplan => nutritionplan.id != action.payload
                  )
                };      
            default:
                return state;
    }
}