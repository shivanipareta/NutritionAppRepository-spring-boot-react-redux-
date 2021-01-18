import axios from 'axios';
import { GET_ERRORS, GET_PAYMENTS, GET_PAYMENT, DELETE_PAYMENT } from './type';

export const createPayment=(payment,history)=>async dispatch=> {
    try {
        const res =await axios.post ("http://localhost:8095/api/payments",payment)
        history.push("/dashboard");
    } catch (err) {
        dispatch({
            type:GET_ERRORS,
            payload:err.response.data
        });
    }
};
export const getPayments=(payment,history)=>async dispatch=> {
        const res =await axios.get ("http://localhost:8095/api/payments/all",payment)
        dispatch({
            type:GET_PAYMENTS,
            payload:res.data
        });
    
};
export const getPayment=(id,history)=>async dispatch=> {
    const res =await axios.get (`http://localhost:8095/api/payments/${id}`);
    dispatch({
        type:GET_PAYMENT,
        payload:res.data
    });

};
export const deletePayment=id=>async dispatch=> {
    const res =await axios.delete (`http://localhost:8095/api/payments/${id}`);
    dispatch(getPayments());
    dispatch({
        type:DELETE_PAYMENT,
        payload:id
    });

};