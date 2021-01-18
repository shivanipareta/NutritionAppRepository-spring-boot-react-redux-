import React from 'react';
import PropTypes from 'prop-types';
import { connect } from 'react-redux';
import { createNutritionPlan, getNutritionPlan } from '../../actions/NutritionPlanActions';
class UpdateNutritionPlan extends React.Component{
    constructor(props){
        super(props);
        this.state={
            id:"",
            name:"",
            planDescription:"",
            created_At:"",
            updated_At:"",
            price:"",
            errors:{}
        };
        this.onChange=this.onChange.bind(this);
        this.onSubmit=this.onSubmit.bind(this);
    }

    componentWillReceiveProps(nextProps) {
        const{
            id, name, planDescription, created_At, updated_At, price
        }=nextProps.nutritionplan;
        this.setState({
            id, name, planDescription, created_At, updated_At, price
        });
        }

    onSubmit(event){
        event.preventDefault();
        const updateNutritionPlan={
            id:this.state.id,
            name:this.state.name,
            planDescription:this.state.planDescription,
            created_At:this.state.created_At,
            updated_At:this.state.updated_At,
            price:this.state.price
        };
        this.props.createNutritionPlan(updateNutritionPlan,this.props.history);
    }

    onChange(event){
        this.setState({[event.target.name]:event.target.value});
    }

    componentDidMount() {
        const { id } = this.props.match.params;
        this.props.getNutritionPlan(id, this.props.history);
      }

    render(){
        
        return(
        <div className="nutritionplan">
        <div className="container">
            <div className="row">
                <div className="col-md-7 m-auto">
                    <h6 className="display-4 text-center">Update Nutrition Plan</h6>
                    <hr />
                    <form onSubmit={this.onSubmit}>
                        <div className="form-group">
                            <input type="text" 
                            className="form-control form-control-lg shadow p-4 mb-4 bg-white" 
                            placeholder="Nutrition Plan Name"
                            name="name" 
                            value={this.state.name}
                            onChange={this.onChange}
                            />
                        </div>
                        <div className="form-group">
                            <textarea 
                            className="form-control form-control-lg shadow p-4 mb-4 bg-white" 
                            placeholder="Plan Description"
                            name="planDescription" 
                            value={this.state.planDescription}
                            onChange={this.onChange}
                            ></textarea>
                        </div>
                    
                        <div className="form-group">
                            <input type="number" className="form-control form-control-lg shadow p-4 mb-4 bg-white" 
                            placeholder="Plan Price" 
                            name="price" 
                            value={this.state.price}
                            onChange={this.onChange}
                            />
                        </div>
                        <input type="submit" className="btn btn-success btn-block mt-4" />
                    </form>
                </div>
            </div>
        </div>
    </div>
        );
    }
}
UpdateNutritionPlan.propTypes = {
    getNutritionPlan: PropTypes.func.isRequired,
    createNutritionPlan: PropTypes.func.isRequired,
    nutritionplan: PropTypes.object.isRequired
  };
  
  const mapStateToProps = state => ({
    nutritionplan: state.nutritionplans.nutritionplan
  });
  export default connect(
    mapStateToProps,
    { getNutritionPlan, createNutritionPlan }
  )(UpdateNutritionPlan);