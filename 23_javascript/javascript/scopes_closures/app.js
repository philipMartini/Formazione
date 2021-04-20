/***Function Recap 

function foo(){
    console.log("Function foo called");
}

//Function expression

var bar = function() {
    console.log("Function bar called");
};

foo();//Calling
bar();//Calling

/*****Scopes*****
//Come posso creare un nuovo scope?
//Scoping è basato sulle funzioni

var a = "Bar"

if(a == "Bar"){
    var dep = "Science";
}

console.log(a);
console.log(dep);//Viene stampato Science dato che if NON crea un nuovo scope

function allocateDepartment(){
    if(a == "Bar"){
        var dep1 = "Science";
    }
}
*
allocateDepartment();
console.log(dep1)//RUNTIME ERROR perchè dep1 non è disponibile aldi fuori dello scope della funzione*/

//Example
var top = 10;
var inner = 50;

function foo() {
    var inner = 20;
    console.log(inner);
}

foo(); //stampa 20
console.log(inner); //stampa 50 


/****Window object */
//Ogni volta che dichiari una nuova variabile globale questa viene aggiunta tra le porperty della window object
var abc = 100;

var def = "Hello Wolrd"

//
console.log(def === window.def); //true

//Questo vale anche per le funzioni


/****Compilation and Interpret phase */
//Compilazione registra funzioni e variabili nel global scope
let notGlobScope;

//Esempio importante 
console.log(x);//Printa undefined percheè la variabile esiste nel global scope e viene 
//presa durante la fase di compiling
//Ma il suo valore a runtime in quel punto del codice è undefined
var x = 10;

/*******Closures********** */

var a = 10;

function outer() {
    var b = 20;

    var inner = function() {
        console.log(b);
        console.log(a);
    };

    return inner;
}

var innerFn = outer();

innerFn(); //10 20 => Closure ossia viene memorizzato uno snapshot dello scope quando la funzione interna viene dichiarata quindi b anche se è nello scope di outer può essere acceduto anche nelle successive chiamate a inner() => 
//Da qui la definizione di Clusures = 
//Una funzione che ha il suo scope memorizzato anche se successivamente viene eseguita in uno scope diverso come nell'esempio sopra.
//Per ogni chiamata a outer() una nuova copia di b viene creata

/*****Clusures exaples *******/

var fn = function() {
    console.log(a);
};

//wait for one second e poi esegui fn
setTimeout(fn,1000);

console.log("Done"); //Viene prima stampato DONE!!!!

//Module pattern per simulare dati membro privati

//Step 1

var myObj = {
    "firstName" : 'Foo',
    "lastName": 'Bar', //Aggiungo i getters
    "getFirstName": function(){ return this.firstName; },
    "getLastName" : function() { return this.lastName; }
};

//Cosi facendo pero continuo a poter accedere dall'esterno a myObj.property???? Quindi come faccio??? Sposto la dichiarazione delle properties in un altro scope NON accessibile dall 'esterno così...

function createPerson(){
    var firstName = "Foo";
    var lastName = 'Bar';

    //Ora l'oggetto contiene solo i metodi
    var myObj = {
        "getFirstName": function(){ return firstName; },
        "getLastName" : function() { return lastName; },
        "setFirstName": function(name){ firstName = name; },
        "setLastName" : function(lname) { lastName = lname; }

    };

    return myObj;
}

var result = createPerson();

//Ora la chiamata result.firstName mi rida undefined e la chiamata
//result.getFirstNAme() mi restituisce il nome grazie alle Closures
//Vengono infatti memorizzati i valori di scope al momento della creazione delle funzioni interne

result.setFirstName('John');
console.log(result.getFirstName());


//altro esempio
var i;


for(i= 0; i < 10; ++i){
(function(currentValueOfI) {
    setTimeout(
        function(){
            console.log(currentValueOfI);
        }
    , 16000);
})(i)
}