import React from 'react';
import PropTypes from 'prop-types';
import { connect } from 'react-redux';
import { createNutritionPlan } from '../../actions/NutritionPlanActions';
import classNames from 'classnames';


class CreateNutritionPlan extends React.Component{
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
        if (nextProps.errors) {
          this.setState({ errors: nextProps.errors });
        }
      }

    onSubmit(event){
        event.preventDefault();
        const newNutritionPlan={
            id:this.state.id,
            name:this.state.name,
            planDescription:this.state.planDescription,
            created_At:this.state.created_At,
            updated_At:this.state.updated_At,
            price:this.state.price
        };
        console.log(newNutritionPlan);
        this.props.createNutritionPlan(newNutritionPlan,this.props.history);
    }

    onChange(event){
        this.setState({[event.target.name]:event.target.value});
    }

    render(){
        const {errors}=this.state;
        return(
        <div className="nutritionplan">
        <div className="container">
            <div className="row">
                <div className="col-md-7 m-auto">
                    <h6 className="display-4 text-center">Create / Edit Nutrition Plan</h6>
                    <hr />
                    <form onSubmit={this.onSubmit}>
                        <div className="form-group">
                            <input type="text" 
                            className={classNames("form-control form-control-lg shadow p-4 mb-4 bg-white",{"is-invalid": errors.name})} 
                            placeholder="Nutrition Plan Name"
                            name="name" 
                            value={this.state.name}
                            onChange={this.onChange}
                            />
                            {errors.name && (<div className="invalid-feedback">{errors.name}</div>)}
                        </div>
                        <div className="form-group">
                            <textarea 
                            className={classNames("form-control form-control-lg shadow p-4 mb-4 bg-white",{"is-invalid": errors.name})} 
                            placeholder="Plan Description"
                            name="planDescription" 
                            value={this.state.planDescription}
                            onChange={this.onChange}
                            ></textarea>
                            {errors.planDescription && (<div className="invalid-feedback">{errors.planDescription}</div>)}
                        </div>
                        
                        <div className="form-group">
                            <input type="number" className="form-control form-control-lg shadow p-4 mb-4 bg-white" 
                            placeholder="Plan Price" 
                            name="price" 
                            value={this.state.price}
                            onChange={this.onChange}
                            />
                            <p>{errors.price}</p>
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
CreateNutritionPlan.propTypes={
    createNutritionPlan: PropTypes.func.isRequired,
    errors: PropTypes.object.isRequired
};

const mapStateToProps=state=>({
    errors: state.errors
});

export default connect (mapStateToProps ,{createNutritionPlan})(CreateNutritionPlan);