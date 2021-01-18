import React, { Component } from 'react';
import DietPlanItems from './DietPlanItems';
import CreateDietPlanButton from './dietPlan/CreateDietPlanButton';
import {PropTypes} from "prop-types";
import { connect } from "react-redux";
import { getDietPlans } from "../actions/DietPlanActions";
class DietPlanDashboard extends Component {
    componentDidMount(){
        this.props.getDietPlans();
    }
    render() {
        const dietplans=this.props.dietplans.dietplans;
        return (
             <div className="dietplans">
                <div className="container">
                    <div className="row">
                        <div className="col-md-12">
                            <h1 className="display-4 text-center">Diet Plans</h1>
                            <br />
                            <CreateDietPlanButton/>
                            <br />
                            <hr />
                            {dietplans.map(dietplan=>(
                            <DietPlanItems key={dietplan.id} dietplan={dietplan}/>
                            ))}
                        

                        </div>
                    </div>
                </div>
            </div>
    );
    }
}
DietPlanDashboard.propTypes={
    dietplan:PropTypes.object.isRequired,
    getDietPlans:PropTypes.func.isRequired
};
const mapStateToProps=state=>({
    dietplans:state.dietplans
});
export default connect(mapStateToProps,{getDietPlans})(DietPlanDashboard);