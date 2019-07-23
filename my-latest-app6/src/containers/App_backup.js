import React,{useState} from 'react';
import './App.css';
import Person from './Person/Person';


const App = props =>{
    const [personsState,setPersonsState] = useState({
      persons:[
        {name:'Max', age:20},
        {name:'Raj', age:30},
        {name:'Dhoni', age:35}
    
      ],
      otherproperties:'someOtherValue'
    });

    const switchNameHandler = ()=>{
    setPersonsState({
      persons:[
        {name:'Maxmillian',age: 20},
        {name:'Rajasekar Murugesan',age: 35},
        {name:'Mahendra Singh Dhoni', age:39}
        
      ],
      otherproperties: personsState.otherproperties
    
    });
    }

    return (
        <div className="App">
          <h1>Hi Welcome to React JS tutorial</h1>
          <button onClick={switchNameHandler}> Switch Name</button>
          <Person name={personsState.persons[0].name} age={personsState.persons[0].age}/>
          <Person name={personsState.persons[1].name} age={personsState.persons[1].age}>My Hobbies : Racing</Person>
          <Person name={personsState.persons[2].name} age={personsState.persons[2].age}/>
          
        </div>
  );
  //return React.createElement('div',{className:'App'},React.createElement('h1',null,'Welcome to React JS !!'));

  

}
export default App;





// function App() {
//   // return (
//   //   <div className="App">
//   //     <h1>Hi Welcome to React JS tutorial</h1>
//   //   </div>
//   // );
//   return React.createElement('div',{className:'App'},React.createElement('h1',null,'Welcome to React JS !!'));
// }


