/**Prototypes */
//Ogni volta che creo una funzione due oggetti vengono creati
//la funzione stessa e il suo prototype

function foo() {}
console.log(foo);
console.log(foo.prototype);
//Ridefiniamo una prop del prototype
foo.prototype.test = "This is the test propery of prototype of foo Object";

//Quando un oggetto viene creato con la new kw dentro l'oggetto creato viene inserita una property __proto__: ConstructorPrototype

var obj1 = new foo();

var obj2 = new foo();

//Ovviamente tutti gli oggetti puntano allo stesso prototype di foo
console.log(foo.prototype === obj1.__proto__)

//Quando viene chiamata una prop su un oggetto JSengine guarda
//prima tra le prop dell'oggetto e se non lo trova guarda il prototype se non lo trova guarda il prototype di Object.
// Questo è il motivo per cui questa chiamata funziona
console.log(obj1.test);


//Usage of prototypes

function Employee(firstName){
    //var this = {};
    this.firstName = firstName;
    //Se facessimo cosi
    //this.playPranks = function (){ console.log("This is a prank"); }
    //Ogni Empl obj avrebbe la propria copia indipendende della funzione => Qui entrano in gioco i prototypes

    Employee.prototype.playPranks = function() { console.log("This is a prank"); };

    Employee.prototype.getName = function() { return this.firstName; };
    // return this;
}

var emp1 = new Employee("Foo");
var emp2 = new Employee("Bar");

emp1.playPranks();
console.log(emp2.getName());

/***Object Function */
console.log(Object)

//Aggiungendo una prop al prototype di Object questa è una property
//COndivisa da TUTTI gli oggetti della window

/**** Inheritance ******/

//Come puo Manager estendere Employee?
function Manager(name, department) {
    this.firstName = name;
    this.department = department;

    Manager.prototype.getDept = function(){ return this.department; };
    Manager.prototype.__proto__ = Employee.prototype;
}

var m1 = new Manager("Doe", "Tech");

console.log(m1.getDept());
console.log(m1.getName());

//Basta cambiare __proto__ del Prototype di  Manager e farlo puntare al Prototype di Employee e NON di Object