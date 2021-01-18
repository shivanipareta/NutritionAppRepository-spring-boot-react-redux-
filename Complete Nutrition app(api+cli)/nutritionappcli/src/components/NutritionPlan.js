import React from 'react';
import CreateNutritionPlanButton from './nutritionplan/CreateNutritionPlanButton'
import NutritionPlanItems from './nutritionplan/NutritionPlanItems';
import { connect } from 'react-redux';
import { getNutritionPlans } from '../actions/NutritionPlanActions';
import { PropTypes } from 'prop-types';
import ViewNutritionPlansButton from './nutritionplan/ViewNutritionPlansButton';
class NutritionPlan extends React.Component{
    render(){
       
        return(
            <div>
            <div className="card text-center border-success mb-3" style={{width : '500px', margin:'auto', marginTop:'10px'}}>
                <div className="card-header bg-transparent border-success">
                     </div>
             <div className="card-body">
            <CreateNutritionPlanButton/><br/><br/>
          <ViewNutritionPlansButton/>
        </div>
        <div className="card-footer bg-transparent border-success text-muted">
           
        </div>
        </div>
           
    </div>
        );
    }
}
export default NutritionPlan;