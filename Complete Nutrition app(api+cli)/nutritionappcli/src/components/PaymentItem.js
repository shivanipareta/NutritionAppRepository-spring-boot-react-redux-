import React, { Component } from 'react';
import {connect} from "react-redux";
import {PropTypes} from "prop-types";
import {deletePayment} from "../actions/PaymentActions";

import { Link } from "react-router-dom";
class PaymentItem extends Component {
    onDeleteClick=id=>{
        this.props.deletePayment(id);
    }
    render() {
        const {payment}=this.props;
        return (
            <div className="container">{
                console.log("value="+this.props.payment)
            }
                <div className="card card-body bg-light mb-3">
                    <div className="row">
                        <div className="col-2">
        <span className="mx-auto">PAYMENT: <h3>{payment.payment}</h3></span>
                        </div>
                        <div className="col-lg-6 col-md-4 col-8">
                        USER ID: <h3>{payment.userId}</h3>
                        DISCOUNT:  <p>{payment.discount}</p>
                        PLAN ID:  <p>{payment.planId}</p>
                        </div>
                        <div className="col-md-4 d-none d-lg-block">
                            <ul className="list-group">
                                <Link to={`/updateProject/${payment.userId}`}>
                                    <li className="list-group-item update">
                                        <i className="fa fa-edit pr-1"> Update Payment Info</i>
                                    </li>
                                </Link>
                                    <li className="list-group-item delete" onClick={this.onDeleteClick.bind(
                                        this,payment.userId
                                    )}>
                                        <i className="fa fa-minus-circle pr-1"> Delete Payment</i>
                                    </li>
                               
                            </ul>
                        </div>
                    </div>
                </div>
            </div>                      
        );
    }
}
PaymentItem.propTypes={
    deletePayment:PropTypes.func.isRequired
};
export default connect(null,{deletePayment})(PaymentItem);