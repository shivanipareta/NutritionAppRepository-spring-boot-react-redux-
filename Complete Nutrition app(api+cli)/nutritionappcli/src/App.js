import React from 'react';
import './App.css';
import DashboardPayment from './components/DashboardPayment';
import "bootstrap/dist/css/bootstrap.min.css";
import {BrowserRouter as Router,Route} from "react-router-dom";
import AddPayment from './components/payments/AddPayment';
import {Provider} from "react-redux";
import store from './store';
import UpdatePayment from './components/payments/UpdatePayment';
import NutritionPlan from './components/NutritionPlan';
import Header from './components/Header';
import ViewNutritionPlans from './components/nutritionplan/ViewNutritionPlans';
import CreateNutritionPlan from './components/nutritionplan/CreateNutritionPlan';
import UpdateNutritionPlan from './components/nutritionplan/UpdateNutritionPlan';
import WeightlogDashboard from './components/WeightlogDashboard';
import AddWeightlog from './components/Weightlog/AddWeightlog';
import UpdateWeightlog from './components/Weightlog/UpdateWeightlog';
import DietPlanDashboard from './components/DietPlanDashboard';
import CreateDietPlan from './components/dietPlan/CreateDietPlan';
import HeaderImage from './components/HeaderImage';
class App extends React.Component{
  render(){
    return(
      <Provider store={store}>
      <Router>
        <div className="App">
          
          <Header/>
          <Route path="/nutritionplan" component={NutritionPlan}/>
          <Route path="/viewnutritionplans" component={ViewNutritionPlans}/>
          <Route path="/createnutritionplan" component={CreateNutritionPlan}/>
          <Route path="/updatenutritionplan/:id" component={UpdateNutritionPlan}/>
          <Route path="/payment" component={DashboardPayment}/>
          <Route path="/addProject" component={AddPayment}/>
          <Route path="/updateProject/:id" component={UpdatePayment}/>
          <Route exact path="/components/WeightlogDashboard" component={WeightlogDashboard} />
          <Route exact path="/components/Weightlog/AddWeightlog" component={AddWeightlog} />
          <Route exact path="/components/Weightlog/UpdateWeightlog" component={UpdateWeightlog} />
          <Route exact path="/weightlog" component={WeightlogDashboard} />
          <Route path="/dietplan" component={DietPlanDashboard}/>
          <Route path="/createdietplan" component={CreateDietPlan}/>
          <HeaderImage/>
          </div>
      </Router>
      </Provider>
    );
  }
}

export default App;

