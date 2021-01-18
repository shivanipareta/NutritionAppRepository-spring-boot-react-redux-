import {combineReducers} from 'redux';
import errorReducer from './errorReducer';
import PaymentReducer from './PaymentReducer';
import nutritionPlanReducer from './nutritionPlanReducer';
import weightlogReducer from "./weightlogReducer";
import dietPlanReducer from './dietPlanReducer';
export default combineReducers ({
    errors: errorReducer,
    payments:PaymentReducer,
    nutritionplans:nutritionPlanReducer,
    weightlog:weightlogReducer,
    dietplans:dietPlanReducer
});