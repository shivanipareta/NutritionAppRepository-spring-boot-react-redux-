import axios from "axios";
import { GET_ERRORS, GET_NUTRITIONPLANS, GET_NUTRITIONPLAN, DELETE_NUTRITIONPLAN } from "./type";
export const createNutritionPlan = (nutritionplan, history) => async dispatch => {
  try {
    const res = await axios.post("http://localhost:8095/api/nutritionplan", nutritionplan);
    history.push("/nutritionplan");
  } catch (error) {
    dispatch({
      type: GET_ERRORS,
      payload: error.response.data
    });
  }
};

export const getNutritionPlans=()=>async dispatch=>{
    const res= await axios.get("http://localhost:8095/api/nutritionplan/all");
    dispatch({
        type:GET_NUTRITIONPLANS,
        payload: res.data
    });
};

export const getNutritionPlan = (id, history) => async dispatch => {
  const res = await axios.get(`http://localhost:8095/api/nutritionplan/${id}`);
  dispatch({
    type: GET_NUTRITIONPLAN,
    payload: res.data
  });
};

export const deleteNutritionPlan = id => async dispatch => {
  await axios.delete(`http://localhost:8095/api/nutritionplan/${id}`);
  dispatch({
    type: DELETE_NUTRITIONPLAN,
    payload: id
  });
};