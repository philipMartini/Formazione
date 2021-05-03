/**Inline Objects */

var myObj = {
    "foo" : "Value",
    "age" : 30,
    "address": {
        "street": "123 js",
        "city": "JS",
        "pincode": 12334
    }
};

 //Adding a property
 myObj.foo = "Value";

 //modify a property
 myObj.foo = 100;


//Accessing with [] notation
myObj.address["city"];

/******Creating Objects ******/
var emp1 = {};

emp1.firstName = "Michael";
emp1.lastName = "Scott";
emp1.gender = "M";
emp1.designation = "Regional Manager";

//La creazione delle props va ripetuta PER OGNI oggetto!!!!

//Porviamo con la funzione e valori dinamici
function createEmployeeObject(firstName, lastName, gender, designation){
    var newObject = {};
    newObject.firstName = firstName;
    newObject.lastName = lastName;
    newObject.gender = gender;
    newObject.designation = designation;
    return newObject;
}


var emp2 = createEmployeeObject("Foo", "Bar", "F", "Manager");
console.log(emp2);

//Funzioni che creano oggetti sono comuni e js le definisce come costruttori e di fatto è esattamente come quella scritta da noi
//ma la prima e la return sono implicite => basta aggiungere
//La new kw davanti alla chiamata del metodo creatore

function Employee(firstName, lastName, gender, designation){
    //var this = {};
    this.firstName = firstName;
    this.lastName = lastName;
    this.gender = gender;
    this.designation = designation;
    // return this;
}

//Questa è una proprietà del modo in cui chiami la funzione
//Non della funzione stessa
var emp3 = new Employee("John", "Doe", "M", "Tech Chief");
console.log(emp3);

//Se chiamo var emp3 = Employee("John", "Doe", "M", "Tech Chief");
//This si riferisce al precedente reference quindi le proprietà
//Vengono create sul precedente reference che in questo caso è la //window  => emp3 contiene undefined perche la funzione non torna nulla

/**Function execution types ****/

//Method 1

function foo(){
    console.log("foo");
    console.log(this); //this => window object ossia il global object
}

foo();

//Method 2

var obj = {};

obj.bar = function(){
    console.log("Hello");
    console.log(this); // this => obj
};

obj.bar();

//Method 3 usando la new keyword
new foo(); //this => newly created object

//Method 4 call(object) esegue la funzione e assegna il this all'oggetto passato in inpu
//foo().call();



/***Using this reference */

function Byclicle(cadence, speed, gear, tirePressure){
    this.cadence = cadence;
    this.speed = speed;
    this.gear = gear;
    this.tirePressure = tirePressure; //This => newly created

    this.inflateTires = function(){
        this.tirePressure +=3; //This => oggetto => method2
    };

}

function Mechanic(name){
    this.name = name;
}


var b1 = new Byclicle(50, 20, 4, 25);

var mike = new Mechanic("Mike");

mike.inflateTires = b1.inflateTires; //aggiungo la funzione a 
//Ma This nel contesto di Mechani si riferisce a mechanic che non ha la propprietà tirePressure !!!!!

//Questo si risolve usando il quarto metodo per chiamare le funzioni

mike.inflateTires.call(b1);

