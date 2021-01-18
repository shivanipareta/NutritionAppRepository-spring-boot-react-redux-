import React,{Component} from "react";
import CreateWeightlogButton from "./Weightlog/CreateWeightlogButton";
import { connect } from "react-redux";
import { getWeightlogs } from "../actions/weightlogActions";
import PropTypes from "prop-types";
import WeightlogItem from "./Weightlog/WeightlogItem";
class WeightlogDashboard extends React.Component{
  componentDidMount() {
    this.props.getWeightlogs();
  }
    render(){
      const { weightlogs } = this.props.weightlog;
        return(

            <div className="projects">
            <div className="container">
              <div className="row">
                <div className="col-md-12">
                  <h2 className="display-4 text-center">Weight Log</h2>
                  <br />
                  <CreateWeightlogButton/>
                  <br />
                  <hr />
                  {weightlogs.map(weightlog => (
                <WeightlogItem key={weightlog.user_id} weightlog={weightlog} />
              ))}
                </div>
              </div>
            </div>
          </div>
        );
    }
}
WeightlogDashboard.propTypes = {
  weightlog: PropTypes.object.isRequired,
  getWeightlogs: PropTypes.func.isRequired
};

const mapStateToProps = state => ({
  weightlog: state.weightlog
});

export default connect(
  mapStateToProps,
  { getWeightlogs}
)(WeightlogDashboard);