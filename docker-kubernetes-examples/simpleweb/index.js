const express = require ('express');
const app = express();

app.get('/',(req,res) =>{
    res.send('Hi There welcome to Node Js');
});

app.listen(8080,()=>{
    console.log("Listening on port 8080");
});