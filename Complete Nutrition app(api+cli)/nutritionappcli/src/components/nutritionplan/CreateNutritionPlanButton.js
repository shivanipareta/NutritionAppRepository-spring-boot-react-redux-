import {Link} from 'react-router-dom';
import React, { Component }  from 'react';
const CreateNutritionPlan=()=>{
    return(
        <Link to="/createnutritionplan" className="btn btn-outline-success btn-lg">
            Create New Plan
        </Link>
    );
};
export default  CreateNutritionPlan;