import React from "react";
import { Link } from "react-router-dom";

const CreateDietPlanButton = () => {
  return (
    <React.Fragment>
      <Link to="/createdietPlan" className="btn btn-outline-success btn-lg">
      Create New DietPlan
      </Link>
    </React.Fragment>
  );
};

export default CreateDietPlanButton;