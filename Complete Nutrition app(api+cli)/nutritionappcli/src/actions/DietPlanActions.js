import axios from 'axios';
import { GET_ERRORS, GET_DIETPLANS, GET_DIETPLAN, DELETE_DIETPLAN } from "./type";

export const createDietPlan=(dietplan,history)=>async dispatch=> {
    try {
        const res =await axios.post ("http://localhost:8095/api/dietPlan/add",dietplan)
        history.push("/dashboard");
    } catch (err) {
        dispatch({
            type:GET_ERRORS,
            payload:err.response.data
        });
    }
};
export const getDietPlans=(dietplan,history)=>async dispatch=> {
        const res =await axios.get ("http://localhost:8095/api/dietPlan/all",dietplan)
        dispatch({
            type:GET_DIETPLANS,
            payload:res.data
        });
    
};
export const getDietPlan=(id,history)=>async dispatch=> {
    const res =await axios.get (`http://localhost:8095/api/dietPlan/${id}`);
    dispatch({
        type:GET_DIETPLAN,
        payload:res.data
    });

};
export const deleteDietPlan=id=>async dispatch=> {
    const res =await axios.delete (`http://localhost:8095/api/dietPlan/${id}`);
    dispatch(getDietPlans());
    dispatch({
        type:DELETE_DIETPLAN,
        payload:id
    });

};