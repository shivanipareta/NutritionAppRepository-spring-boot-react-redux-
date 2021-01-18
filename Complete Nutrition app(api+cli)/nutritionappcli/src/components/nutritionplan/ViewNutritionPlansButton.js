import React from 'react'
import ReactDOM from 'react-dom'
import {Link} from 'react-router-dom';
const ViewNutritionPlansButton=()=>{
    return(
        <Link to="/viewnutritionplans" className="btn btn-outline-success btn-lg">
            View All Plans
        </Link>
    );
};
export default  ViewNutritionPlansButton;