import React from 'react';
import NutritionPlanItems from './NutritionPlanItems';
import { PropTypes } from 'prop-types';
import { connect } from 'react-redux';
import { getNutritionPlans } from '../../actions/NutritionPlanActions';

class ViewNutritionPlans extends React.Component{
    componentDidMount(){
        this.props.getNutritionPlans();
    }
    render(){
        const { nutritionplans } = this.props.nutritionplans;
        return(
            <div className="nutritionplans">
               {nutritionplans.map(nutritionplan=>(
                   <NutritionPlanItems key={nutritionplan.id} nutritionplan={nutritionplan}/>
              ))}
            </div>
        );
    }
}

ViewNutritionPlans.propTypes={
    nutritionplan:PropTypes.object.isRequired,
    getNutritionPlans : PropTypes.func.isRequired
};

const mapStateToProps=state=>({
    nutritionplans:state.nutritionplans
});

export default connect(mapStateToProps,{getNutritionPlans})(ViewNutritionPlans);