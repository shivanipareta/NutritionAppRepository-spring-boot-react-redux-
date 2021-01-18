import React from 'react';
import PropTypes from "prop-types";
import { connect } from "react-redux";
import classnames from "classnames";
import { createWeightlog} from "../../actions/weightlogActions";
class AddWeightlog extends React.Component{

    constructor() {
        super();
    
        this.state = {
          userId: "",
         weight:"",
          errors: {}
        };
    
        this.onChange = this.onChange.bind(this);
        this.onSubmit = this.onSubmit.bind(this);
      }
    
      //life cycle hooks
      componentWillReceiveProps(nextProps) {
        if (nextProps.errors) {
          this.setState({ errors: nextProps.errors });
        }
      }
    
      onChange(e) {
        this.setState({ [e.target.name]: e.target.value });
      }
    
      onSubmit(e) {
        e.preventDefault();
    
        const newWeightlog= {
          userId: this.state.userId,
         weight:this.state.weight
        };
        this.props.createWeightlog(newWeightlog, this.props.history);
      }
    render(){
        const { errors } = this.state;
        return(
            <div className="project">
            <div className="container">
              <div className="row">
                <div className="col-md-8 m-auto">
                  <h5 className="display-4 text-center">Create WeightLog</h5>
                  <hr />
                  <form onSubmit={this.onSubmit}>
                    <div className="form-group">
                      <input
                        type="text"
                        className={classnames("form-control form-control-lg", {
                          "is-invalid": errors.userId
                        })}
                        placeholder="WeightLog user id"
                        name="userId"
                        value={this.state.userId}
                        onChange={this.onChange}
                      />
                      {errors.userId && (
                        <div className="invalid-feedback">{errors.userId}</div>
                      )}
                    </div>
                    <div className="form-group">
                      <input
                        type="text"
                        className={classnames("form-control form-control-lg", {
                          "is-invalid": errors.name
                        })}
                        placeholder="weight"
                        name="weight"
                        value={this.state.weight}
                        onChange={this.onChange}
                      />
                      {errors.weight && (
                        <div className="invalid-feedback">
                          {errors.weight}
                        </div>
                      )}
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
        );
    }
}

AddWeightlog.propTypes = {
    createWeightlog: PropTypes.func.isRequired,
    errors: PropTypes.object.isRequired
  };

  const mapStateToProps = state => ({
    errors: state.errors
  });
  export default connect(
    mapStateToProps,
   { createWeightlog }
  )(AddWeightlog);
