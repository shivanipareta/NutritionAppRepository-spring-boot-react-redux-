import React, { Component } from "react";
import PropTypes from "prop-types";
import { connect } from "react-redux";
import { createDietPlan } from "../../actions/DietPlanActions";
import classnames from "classnames";

class CreateDietPlan extends Component {
  constructor() {
    super();
    this.state = {
      userId:"",
      foodType:"",
      slots:"",
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
    const newDietPlan = {
      userId: this.state.userId,
      foodType: this.state.foodType,
      slots: this.state.slots
    };
    this.props.createDietPlan(newDietPlan, this.props.history);
  }
  render() {
    const { errors } = this.state;

    return (
      <div>
        <div className="dietplan">
          <div className="container">
            <div className="row">
              <div className="col-md-8 m-auto">
                <h5 className="display-4 text-center">Add Diet Plan Info</h5>
                <hr />


                <form onSubmit={this.onSubmit}>

                
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
                    type="text"
                      className={classnames("form-control form-control-lg", {
                       
                      })}
                      name="foodType"
                      value={this.state.foodType}
                      placeholder="Slot"
                      onChange={this.onChange}
                   required />
                  
                  </div>
                  <div className="form-group">
                    <input
                    type="text"
                      className={classnames("form-control form-control-lg", {
                       
                      })}
                      name="slots"
                      value={this.state.slots}
                     
                      placeholder="Food Type"
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

CreateDietPlan.propTypes = {
    createDietPlan: PropTypes.func.isRequired,
  errors: PropTypes.object.isRequired
};

const mapStateToProps = state => ({
  errors: state.errors
});
export default connect(mapStateToProps, { createDietPlan })(CreateDietPlan);