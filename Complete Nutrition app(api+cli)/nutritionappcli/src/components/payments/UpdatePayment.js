import React,{Component} from "react";
import PropTypes from "prop-types";
import { connect } from "react-redux";
import {getPayment} from "../../actions/PaymentActions";
import {createPayment} from "../../actions/PaymentActions";
class UpdatePayment extends Component{
    constructor(){
        super();
        this.state={
            id:"",
            payment: "",
            userId: "",
         //   discount: "",
            planId: "",
        };
        this.onChange=this.onChange.bind(this);
        this.onSubmit=this.onSubmit.bind(this);
    }
    onChange(event){
        this.setState({[event.target.name]:event.target.value});
    }
    onSubmit(event){
        event.preventDefault();
        const updateProject={
            id:this.state.id,
            payment:this.state.payment,
            userId:this.state.userId,
       //     discount:this.state.discount,
            planId:this.state.planId,

        };
        this.props.createPayment(updateProject,this.props.history);
    }
    componentWillReceiveProps(nextProps){
        const {id,payment,userId,discount,planId}=nextProps.payment;
        this.setState({
            id,payment,userId,discount,planId
        });
    }
    componentDidMount()
    {
        const {id}=this.props.match.params;
        this.props.getPayment(id,this.props.history);
    }
    render(){
        const {payment}=this.props;
        return(
            
            <div className="payment">
        <div className="container">
            <div className="row">
                <div className="col-md-8 m-auto">
                    <h5 className="display-4 text-center">Edit Payment Information</h5>
                    <hr />
                    <form onSubmit={this.onSubmit}>
                        <div className="form-group">
                            <input type="number" 
                            className="form-control form-control-lg " 
                            placeholder="Payment" name="payment" onChange={this.onChange} required/>
                        </div>

                        <div className="form-group">
                            <input type="number" 
                            className="form-control form-control-lg"
                             placeholder={'UserID: ' +payment.userId} name="userId"
                                disabled required/>
                        </div>
                

                        <div className="form-group">
                            <input type="number" 
                            className="form-control form-control-lg" 
                            placeholder="Plan Id" name="planId" onChange={this.onChange} required/>
                        </div>

                        <input type="submit" 
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
UpdatePayment.propTypes={
    getPayment:PropTypes.func.isRequired,
    createPayment:PropTypes.object.isRequired
};
const mapStateToProps=state=>({
    payment:state.payments.payment
});
export default connect(mapStateToProps,{getPayment,createPayment})(UpdatePayment);