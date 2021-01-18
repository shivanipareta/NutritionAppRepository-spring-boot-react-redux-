import React, { Component } from "react";
import PropTypes from "prop-types";
import { connect } from "react-redux";
import { createPayment } from "../../actions/PaymentActions";
import classnames from "classnames";

class AddPayment extends Component {
  constructor() {
    super();
    this.state = {
      payment: "",
      userId: "",
   //   discount: "",
      planId: "",
      errors: {}
    };
    this.onChange = this.onChange.bind(this);
    this.onSubmit = this.onSubmit.bind(this);
  }
s
  onChange(event) {
    this.setState({ [event.target.name]: event.target.value });
    // this.setState({payment:event.target.value}); --  this need to be done with each field, there is a shortcut for the same

  }

  // life cycle hook
  componentWillReceiveProps(nextProps) {
    if (nextProps.errors) {
      this.setState({ errors: nextProps.errors });
    }
  }

  onSubmit(event) {
    event.preventDefault();
    const newPayment = {
      payment: this.state.payment,
      userId: this.state.userId,
     // discount: this.state.discount,
      planId: this.state.planId
  
    };
    this.props.createPayment(newPayment, this.props.history);
  }
  render() {
    const { errors } = this.state;

    return (
      <div>
        <div className="payment">
          <div className="container">
            <div className="row">
              <div className="col-md-8 m-auto">
                <h5 className="display-4 text-center">Add Payment Information</h5>
                <hr />


                <form onSubmit={this.onSubmit}>

                  <div className="form-group">
                    <input
                      type="number"
                      className={classnames("form-control form-control-lg ", {
                      
                      })}
                      name="payment"
                      value={this.state.payment}
                     placeholder="Payment Amount"
                      onChange={this.onChange}
                    required/>
                   
                  </div>

                  <div className="form-group">
                    <input
                      type="number"
                      className={classnames("form-control form-control-lg", {
                      
                      })}
                      name="userId"
                      value={this.state.userId}
                     placeholder="User Id"
                      onChange={this.onChange}
                    required/>
                    
                  </div>
                 
                  <div className="form-group">
                    <input
                    type="number"
                      className={classnames("form-control form-control-lg", {
                       
                      })}
                      name="planId"
                      value={this.state.planId}
                      placeholder="Plan Id"
                      onChange={this.onChange}
                   required />
                  
                  </div>
                              
                  <input
                    type="submit"
                    className="btn btn-success btn-block mt-4"
                    
                  />
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

AddPayment.propTypes = {
  createPayment: PropTypes.func.isRequired,
  errors: PropTypes.object.isRequired
};

const mapStateToProps = state => ({
  errors: state.errors
});
export default connect(mapStateToProps, { createPayment })(AddPayment);