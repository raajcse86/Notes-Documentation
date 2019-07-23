import Person from './Person/Person';
import React,{Component}from 'react';

import Auxiliary from '../../hoc/Auxiliary';




class Persons extends Component{

    // static getDerivedStateFromProps(props,state){
    //     console.log("[Persons.js] get derived state from props .",props);
    //     return state;
    //   }
    

     shouldComponentUpdate(nextProps, nextState){
        console.log("[Persons.js] shouldComponentUpdate() ");
        if(nextProps.personlistprop !== this.props.personlistprop)
        return true;
     }
     
     getSnapshotBeforeUpdate(prevProps, prevState){
        console.log("[Persons.js] getSnapshotBeforeUpdate() ");
        return null;
     }

     componentDidUpdate(){
        console.log("[Persons.js] componentDidUpdate() ");
     }

    render(){
        console.log("[Persons.js] is rendering...");
        return this.props.personlistprop.map((person,index) =>{
            return (
                <Person
                clickme={() => this.props.clickdeleteprop(index)} 
                name={person.name} 
                age={person.age}
                key={person.id}
                changed={(event) =>this.props.changed(event,person.id)}
                
                />
            );
        });
    }
}
export default Persons;
// const persons = (props) =>{
//     console.log("[Persons.js] is rendering...");
//     return props.personlistprop.map((person,index) =>{
//     return (
//     <Person
//     clickme={() => props.clickdeleteprop(index)} 
//     name={person.name} 
//     age={person.age}
//     key={person.id}
//     changed={(event) =>props.changed(event,person.id)}/>
//     );
    
// });
// }

// export default persons;
