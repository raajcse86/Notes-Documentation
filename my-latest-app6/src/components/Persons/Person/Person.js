import React, {Component} from 'react';
import Radium from 'radium';
import classes from './Person.css';
import Auxiliary from '../../../hoc/Auxiliary';
import withClass from '../../../hoc/withClass';
import PropTypes from 'prop-types';
import AuthContext from '../../../context/auth-context';


// function person(){
//     return 

// }

// const person = (props) => {
//     console.log("[Person js] is rendering..");
//     return (
//     <div className="Person">
//     <p onClick={props.clickme}>Iam a person {props.name} of age {props.age}</p>
//    <p>{props.children}</p>
//    <input type="text" value={props.name} onChange={props.changed}/>
//     </div>
//     )

// };
// export default Radium(person);

class Person extends Component{

    constructor(props){
        super(props);
        this.inputElementRef = React.createRef();
    }
    static contextType = AuthContext;
    
    componentDidMount(){
        //this.inputElement.focus();
        this.inputElementRef.current.focus();
        console.log(this.context.authenticated);
    }

    
    render(){
        console.log("[Person js] is rendering..",this.props.isAuth);
            return (
                <Auxiliary>
                { 
                this.context.authenticated ? <p> Authenticated</p> : <p>Please Login</p>    
                }
                 
                
                <p onClick={this.props.clickme}>Iam a person {this.props.name} of age {this.props.age}</p>
                <p>{this.props.children}</p>
                <input
                key="i3"
               // ref = {(inputEl) =>{this.inputElement = inputEl}}
               ref = {this.inputElementRef}
                type="text" 
                value={this.props.name} 
                onChange={this.props.changed}
                />
                </Auxiliary>
            );
    }
}

Person.propTypes = {
    clickme: PropTypes.func,
    name:PropTypes.string,
    age:PropTypes.number,
    changed:PropTypes.func
}

export default withClass(Person,classes.Person);
