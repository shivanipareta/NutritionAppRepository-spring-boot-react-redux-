import React, { Component } from "react";
import { connect } from "react-redux";
import { Link } from "react-router-dom";
import PropTypes from "prop-types";
import {deleteWeightlog} from "../../actions/weightlogActions";

class WeightlogItem extends React.Component {
  onDeleteClick=userId=>{
    this.props.deleteWeightlog(userId);
  };
  render() {
    const {weightlog}=this.props;
    return (
      <div className="container">
        <div className="card card-body bg-light mb-3">
          <div className="row">
            <div className="col-2">
              <span className="mx-auto"><h2>{weightlog.userId}</h2></span>
            </div>
            <br/>
            <div className="col-lg-6 col-md-4 col-8">
            <p>{}</p>
            <h6>{weightlog.weight}</h6>
              
            </div>
            <div className="col-md-4 d-none d-lg-block">
              <ul className="list-group">
                
                <Link to="/components/Weightlog/UpdateWeightlog">
                  <li className="list-group-item update">
                    <i className="fa fa-edit pr-1"> Update WeightLog Info</i>
                  </li>
                </Link>
              
                  <li className="list-group-item delete" onClick={this.onDeleteClick.bind(this,weightlog.userId)}>
                    <i className="fa fa-minus-circle pr-1"> Delete WeightLog</i>
                  </li>
              </ul>
            </div>
          </div>
        </div>
      </div>
    );
  }
}
WeightlogItem.propTypes={
  deleteWeightlog: PropTypes.func.isRequired
};
export default connect(null,{
  deleteWeightlog
})(WeightlogItem);
