/****Functions *******/
function sayHello(name, timeOfday) {
    console.log("HEllo! " + name + " Time " + timeOfday);
}//void returna undefined


function echo(sentence){
    return sentence;
}

var myName = "Filippo";
var myDate = "afternoon";
sayHello(myName, myDate);

//Posso chiamare anche sayHello(myName) e il secondo parametro è undefined
sayHello(myName);

sayHello(myName, myDate, 3);//3 viene semplicemnte ignorato

//Questo fa capire perche non sia possibile fare overloading in JS

var myEcho = echo("Echo this One!");
console.log(myEcho);

/***Functional programming */
//Le funzioni in JS sono esse stesse dei valori
var f = function foo() { console.log("World!"); };
//la funzione è ASSEGNATA a f

//Qui la chiamo
f();

/**Anonimous Functions  ******/
//nell'esempio precedente il nome foo è inutile dato che verrà chiamata 
//solo tramite f quindi ......
var f1 = function (name ) { console.log("Anonimous! "+ name); };
f1();

/**Functions as Arguments*****/
function executor(fn, name){
    console.log(fn);
    fn(name);//Qui chiama la funzione fn passata come argomento

}

executor(f1, "Filippo");

/******Aggiungere funcions agli oggetti ****/
//La funzione vieene aggiunta come property dell'oggetto
var myObj = {"prop1" : true, "fun1": executor};

//Qui la eseguo
myObj.fun1(f1, "Filippo");


/*****THIS keyword */
var person = {
    "firstName" : "Filippo",
    "lastName" : "Martini",
    "address" : {
        "street": "via le",
        "city" : "JS",
        "state": "CA"

    },
    "getFullName" : function(){
        //this è riferito a QUESTO oggetto
        return this.firstName + " " + this.lastName;
    },

    "isFromState":function(state){
        return state === this.address["state"];
    }

};


console.log(person.getFullName());
console.log(person.isFromState("CA"));
console.log(person.isFromState("PA"));

/*****Default arguments function */

var add = function(){
    console.log(arguments); //è un oggetto anche se viene usato come array
    var result = 0;
    for(i = 0; i < arguments.length; ++i)
        result += arguments[i];

    return result;

};

console.log(add(1,2,3));
console.log(add(1,2,3,4));

