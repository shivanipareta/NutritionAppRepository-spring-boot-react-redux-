import React from "react";
import { Link } from "react-router-dom";



function CreateWeightlogButton() {
  return (
    <React.Fragment>
      <Link to="/components/Weightlog/AddWeightlog" className="btn btn-outline-success btn-lg">
        Create WeightLog
      </Link>
    </React.Fragment>
  );
}

export default CreateWeightlogButton;