import React from "react";
import { Link } from "react-router-dom";

const CreatePaymentButton = () => {
  return (
    <React.Fragment>
      <Link to="/addProject" className="btn btn-outline-success btn-lg">
        Make Payment
      </Link>
    </React.Fragment>
  );
};

export default CreatePaymentButton;