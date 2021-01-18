import React, { Component } from "react";
import { getWeightlog, createWeightlog } from "../../actions/weightlogActions";
import PropTypes from "prop-types";
import { connect } from "react-redux";
import classnames from "classnames";

class UpdateWeightlog extends Component {
  constructor() {
    super();

    this.state = {
      userId: "",
      weight:""
     };
    this.onChange = this.onChange.bind(this);
    this.onSubmit = this.onSubmit.bind(this);
  }

  componentWillReceiveProps(nextProps) {
    const {
      userId,
      weight    } = nextProps.weightlog;

    this.setState({
      userId,
      weight
    });
  }

  componentDidMount() {
    const { userId } = this.props.match.params;
    this.props.getWeightlog(userId, this.props.history);
  }

  onChange(e) {
    this.setState({ [e.target.name]: e.target.value });
  }

  onSubmit(e) {
    e.preventDefault();

    const updateWeightlog = {
      userId: this.state.userId,
      weight: this.state.weight,
    };

    this.props.createWeightlog(updateWeightlog, this.props.history);
  }
  render() {
    return (
      <div className="project">
        <div className="container">
          <div className="row">
            <div className="col-md-8 m-auto">
              <h5 className="display-4 text-center">Update WeightLog</h5>
              <hr />
              <form onSubmit={this.onSubmit}>
                <div className="form-group">
                  <input
                    type="text"
                    className="form-control form-control-lg "
                    placeholder="userId"
                    name="userId"
                    value={this.state.userId}
                    onChange={this.onChange}
                  />
                </div>
               
                <div className="form-group">
                  <textarea
                    className="form-control form-control-lg"
                    placeholder="weight"
                    name="weight"
                    value={this.state.weight}
                    onChange={this.onChange}
                  />
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

UpdateWeightlog.propTypes = {
  getWeightlog: PropTypes.func.isRequired,
  createWeightlog: PropTypes.func.isRequired,
  weightlog: PropTypes.object.isRequired
};

const mapStateToProps = state => ({
  weightlog: state.weightlog.weightlog
});
export default connect(
  mapStateToProps,
  { getWeightlog, createWeightlog }
)(UpdateWeightlog);
