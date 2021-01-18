import React from 'react';
import { connect } from 'react-redux';
import { Link } from 'react-router-dom';
import {deleteNutritionPlan} from '../../actions/NutritionPlanActions';
import { PropTypes } from 'prop-types';

class NutritionPlanItems extends React.Component{

    onDeleteClick = id => {
        console.log("-------> method called.");
        this.props.deleteNutritionPlan(id);
      };

    render(){
        const {nutritionplan}=this.props;
        return(
            <div>
                <div className="container">
                     <div className="card card-body mb-3 bg-light border-success">
                        <div className="row">
                                <div className="col-2">
                                    <span className="mx-auto">Rs.{nutritionplan.price}</span>
                                </div>
                                <div className="col-lg-6 col-md-4 col-8">
                                    <h3>{nutritionplan.name}</h3>
                                    <p>{nutritionplan.planDescription}</p>
                                </div>
                                <div className="col-md-4 d-none d-lg-block">
                                    <ul className="list-group">
                                        <Link to={`/updatenutritionplan/${nutritionplan.id}`}>
                                            <li className="list-group-item list-group-item-success list-group-item-action
                                            update border-success">
                                                <i className="fa fa-edit pr-1">Update Plan</i>
                                            </li>
                                        </Link>
                                        <a href="">
                                            <li className="list-group-item list-group-item-success list-group-item-action
                                            delete border-success"
                                            onClick={this.onDeleteClick.bind(
                                                this,
                                                nutritionplan.id
                                              )}>
                                                <i className="fa fa-minus-circle pr-1 text-danger">Delete Plan</i>
                                            </li>
                                        </a>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
            </div>
        );
    }
}

NutritionPlanItems.propTypes={
    deleteNutritionPlan: PropTypes.func.isRequired
};
export default connect(
    null,
    {deleteNutritionPlan}
)(NutritionPlanItems);