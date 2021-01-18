import React from "react";
import './App.css';
import "bootstrap/dist/css/bootstrap.min.css";
import Header from './components/Layout/Header';
import WeightlogDashboard from './components/WeightlogDashboard';
import { BrowserRouter as Router, Route } from "react-router-dom";
import AddWeightlog from './components/Weightlog/AddWeightlog';
import UpdateWeightlog from './components/Weightlog/UpdateWeightlog';
import { Provider } from "react-redux";
import store from "./store";

function App() {
  return (
    <Provider store={store}>
  <Router>
        <div className="App">
          <Header />
          <Route exact path="/components/WeightlogDashboard" component={WeightlogDashboard} />
          <Route exact path="/components/Weightlog/AddWeightlog" component={AddWeightlog} />
          <Route exact path="/components/Weightlog/UpdateWeightlog" component={UpdateWeightlog} />
          <Route exact path="/dashboard" component={WeightlogDashboard} />


       
        </div>
      </Router>
       </Provider>
  );
}

export default App;
