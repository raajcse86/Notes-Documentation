import React,{Component} from 'react';
import classesVal from './App.css';
import Person from '../components/Persons/Person/Person';
import Radium from 'radium';
import { genericTypeAnnotation } from '@babel/types';
import Persons from '../components/Persons/Persons';
import Cockpit from '../components/Cockpit/Cockpit';
import withClass from '../hoc/withClass';
import Auxiliary from '../hoc/Auxiliary';
import AuthContext from '../context/auth-context';

class App extends Component{

  constructor(props){
    super(props);
    console.log("App js constructor.");
    this.state={
      persons:[
        {id:'asdasd', name:'Raj', age:30},
        {id:'fsdsfs',name:'Max', age:20},
        {id:'gggd',name:'Dhoni', age:35}
  
      ],
      showPersons:false,
      showCockpit:true,
      changeCounter:0,
      authenticated:false
  
    }
  }

  static getDerivedStateFromProps(props,state){
    console.log("[App.js] get derived state from props .",props);
    return state;
  }

  componentDidMount(){
    console.log("Component did mount is called..");
  }

  // componentWillMount(){
  //   console.log("Component will mount is called...");
  // }

  shouldComponentUpdate(){
    console.log("shouldComponentUpdate() - This will tell whether the update should proceed or cancel..");
    return true;
  }

  getSnapshotBeforeUpdate(){
    console.log("getSnapshotBeforeUpdate() - This will be used for last minute DOM ops...");
  }

  componentWillUnmount(){
    console.log("Removed triggers....")
  }

  switchNameHandler = (newName)=>{
  this.setState({
    persons:[
      {name:newName,age: 20},
      {name:'Rajasekar',age: 35},
      {name:'Mahendra Singh Dhoni', age:39}
    ]
  
  });

  }


  nameChangeHandler = (event,id)=>{
    const personIndex = this.state.persons.findIndex(p=>{
        return p.id === id;
    });
    const person = {
      ...this.state.persons[personIndex]
    };
    //const person = Object.assign({},this.state.persons[personIndex]);
    person.name = event.target.value;

    const persons = [...this.state.persons];
    persons[personIndex] = person;

    //this.setState({persons:persons,changeCounter:this.state.changeCounter+1});
    this.setState((prevState,props) =>{
      return{
        persons:persons,
        changeCounter:prevState.changeCounter+1
      };
    });

  }


    toggleListDisplay = ()=>{
      const doesShow = this.state.showPersons;
      this.setState({showPersons:!doesShow});
    
      }

      loginHandler = () =>{
        console.log("inside login handler..");
        this.setState({authenticated:true});
      }

     deletePersonHandler = (personIndex) =>{
       //const persons = this.state.persons.slice;
       const persons = [...this.state.persons];
       persons.splice(personIndex,1);
       this.setState({persons:persons});
     } 
  

  render(){
    console.log("Render method in [App.js ] is called..");
    const style = {
      backgroundColor:'white',
      font:'inherit',
      border:'1px solid blue',
      padding:'8px',
      cursor:'pointer',
      ':hover':{
        backgroundColor:'green',
        color:'yellow'
      }

    };

    

    let personList = null;
    if(this.state.showPersons){
        personList = (
          <div>
            {
              <Persons
              personlistprop = {this.state.persons}
              clickdeleteprop = {this.deletePersonHandler}
              changed = {this.nameChangeHandler}
              

             />
            }
           </div> 
        );
        style.backgroundColor = "red";
    }

    return (
       <div className = "App">
          <button onClick={()=>{this.setState({showCockpit: false})}}>RemoveCockpit</button>
          <AuthContext.Provider 
          value={{authenticated:this.state.authenticated,login:this.loginHandler}}>
          {
            this.state.showCockpit ? 
          <Cockpit 
          title={this.props.title} 
          persons={this.state.persons} 
          clicked={this.toggleListDisplay}
          login={this.loginHandler}>  
          </Cockpit>
          : null
          }
          
          {personList}
          </AuthContext.Provider>
          </div>
          
  );
  //return React.createElement('div',{className:'App'},React.createElement('h1',null,'Welcome to React JS !!'));

  }

}
export default withClass(App,classesVal.App);


// function App() {
//   // return (
//   //   <div className="App">
//   //     <h1>Hi Welcome to React JS tutorial</h1>
//   //   </div>
//   // );
//   return React.createElement('div',{className:'App'},React.createElement('h1',null,'Welcome to React JS !!'));
// }


