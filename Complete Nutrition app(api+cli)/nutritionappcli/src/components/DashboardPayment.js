import React, { Component } from 'react';
import PaymentItem from './PaymentItem';
import CreatePaymentButton from './payments/CreatePaymentButton';
import {PropTypes} from "prop-types";
import { connect } from "react-redux";
import { getPayments } from "../actions/PaymentActions";
class DashboardPayment extends Component {
    componentDidMount(){
        this.props.getPayments();
    }
    render() {
        const payments=this.props.payments.payments;
        return (
             <div className="payments">
                <div className="container">
                    <div className="row">
                        <div className="col-md-12">
                            <h1 className="display-4 text-center">Payments</h1>
                            <br />
                            <CreatePaymentButton/>
                            <br />
                            <hr />
                            {payments.map(payment=>(
                            <PaymentItem key={payment.id} payment={payment}/>
                            ))}
                        

                        </div>
                    </div>
                </div>
            </div>
    );
    }
}
DashboardPayment.propTypes={
    payment:PropTypes.object.isRequired,
    getPayments:PropTypes.func.isRequired
};
const mapStateToProps=state=>({
    payments:state.payments
});
export default connect(mapStateToProps,{getPayments})(DashboardPayment);