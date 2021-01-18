import axios from "axios";
import { GET_ERRORS, GET_WEIGHTLOGS, GET_WEIGHTLOG , DELETE_WEIGHTLOG} from "./type";

export const createWeightlog = (weightlog, history) => async dispatch => {
  try {
    const res = await axios.post("http://localhost:8095/api/weightlog", weightlog);
    history.push("/dashboard");
  } catch (err) {
    dispatch({
      type: GET_ERRORS,
      payload: err.response.data
    });
  }
};

export const getWeightlogs = () => async dispatch => {
  const res = await axios.get("http://localhost:8095/api/weightlog/all");
  dispatch({
    type: GET_WEIGHTLOGS,
    payload: res.data
  });
};
export const getWeightlog = (userId, history) => async dispatch => {
  const res = await axios.get(`http://localhost:8095/api/weightlog/${userId}`);
  dispatch({
    type: GET_WEIGHTLOG,
    payload: res.data
  });
};
export const deleteWeightlog = userId => async dispatch => {
    await axios.delete(`http://localhost:8095/api/weightlog/${userId}`);
    dispatch({
      type: DELETE_WEIGHTLOG,
      payload: userId
    });
  
};