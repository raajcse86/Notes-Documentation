import React,{useEffect,useContext} from 'react';
import AuthContext from '../../context/auth-context';

const Cockpit = (props) =>{

    const authContextObj = useContext(AuthContext);
    useEffect(()=>{
        console.log("[useEffect() cockpit js ] rendered again..");

        return(()=>{
            console.log("Cockpit is removed -- clean up activity...")
        });
    },[]);

    useEffect(()=>{
        console.log("[2nd -- useEffect() cockpit js ] rendered again..");

        return(()=>{
            console.log("2nd --- Cockpit is removed -- clean up activity...")
        });
    });

    const classes=[];
    if(props.persons.length <= 2){
      classes.push('red');
    }
    if(props.persons.length <=1){
      classes.push('bold');
    }
       return(

       <div className={classes}>
        <h1>Hi Welcome to React JS tutorial</h1>
        <h2>Designation : {props.title}</h2>
        <p className={classes.join(" ")} >Welcome to all persons who have onboarded today.</p>
        <button  onClick={() => props.clicked()}> ToggleDisplayList</button>
        
            <button onClick={authContextObj.login}>Login</button> 
                
        </div>
        );
};

export default Cockpit;