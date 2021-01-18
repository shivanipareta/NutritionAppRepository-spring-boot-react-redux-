import React, { Component } from 'react';
import {connect} from "react-redux";
import {PropTypes} from "prop-types";
import {deleteDietPlan} from "../actions/DietPlanActions";

import { Link } from "react-router-dom";
class DietPlanItems extends Component {
    onDeleteClick=id=>{
        this.props.deleteDietPlan(id);
    }
    render() {
        const {dietplan}=this.props;
        return (
            <div className="container">{
                console.log("value="+this.props.dietplan)
            }
                <div className="card card-body bg-light mb-3">
                    <div className="row">
                        <div className="col-2">
        <span className="mx-auto">user Id<h3>{dietplan.userId}</h3></span>
                        </div>
                        <div className="col-lg-6 col-md-4 col-8">
                    
                        Diet meals<p>{dietplan.meals}</p>
                        Food Type:<p>{dietplan.slots}</p>
                        
                        </div>
                        <div className="col-md-4 d-none d-lg-block">
                            <ul className="list-group">
                                <Link to={`/updateProject/${dietplan.userId}`}>
                                   
                                </Link>
                                    <li className="list-group-item delete" onClick={this.onDeleteClick.bind(
                                        this,dietplan.userId
                                    )}>
                                        <i className="fa fa-minus-circle pr-1"> Delete Diet Plan</i>
                                    </li>
                               
                            </ul>
                        </div>
                    </div>
                </div>
            </div>                      
        );
    }
}
DietPlanItems.propTypes={
    deleteDietPlan:PropTypes.func.isRequired
};
export default connect(null,{deleteDietPlan})(DietPlanItems);