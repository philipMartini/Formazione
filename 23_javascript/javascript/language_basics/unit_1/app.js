
//Ogni valore numerico in Js è 64bit double precision number
var a = 10; 
var b = 20;
var c = a + b;
console.log(a);
console.log(b);
console.log(c);

//Non ci sono char esistono solo le String
var d = "Hello";
//Esistono i boolean
var e = true;

console.log(d);
console.log(e);
//Non ci sono strong types quindi posso 
//Assegnare nuovamente il valore di una variabile di tipo diverso
//LOOSE TYPING
a = "Hello JS";
console.log(a);

//Undefined type
//Avviene quando una var è dichiarata ma NON gli è stato
//assegnato un valore => il tipo in quel caso è undefined che contiene un unico valore undefined
var f;
//Qui undefined
console.log(f);

//Null type
// tipo null con un unico valore null
var g = null;
console.log(g);

//Ma quale è la differenza fra undefined e null?
//null va esplicitamente assegnato e quindi permette di capire che una variabile
//è staata toccata per assegnarle quel valore.
//Undefined invece è il tipo/valore a cui di default
//Sono inizializzate tutte le variabili solo dichiarate in JS non .

//Per capire quale tipo sia una var posso usare
// typeof <var>

console.log(typeof a);
console.log(typeof b);
console.log(typeof e);
console.log(typeof f);
console.log(typeof g); //QUesto restituisce object anche se dovrebbe restituire null, bug iniziale del linguaggio!!!!!

/*******Type Cohercion******* */
console.log(123 + "4"); //=> "1234"

/*****Comparison***********/
var x = 10;
var y = 10;
var z = "10";

if(x == y)
    console.log("Values are equal! == "); //<=

//Questo è true perchè se i due tipi sono diversi
//Viene effettuate la type cohercion e confrontato il valore
//QUindi in questo caso int 10 => string 10 == string 10
if(x == z)
    console.log("Values are equal! == "); //<=


//Un operatore di uguaglianza SENZA type conversion è ===
//USARE QUESTO!!!!!!!
if(x === z)
    console.log("Values are equal!");
else
    console.log("Values are NOT equal! ===");

//Come in C++ => false sse b === 0
//"" => false
//undefined e null => false
if(b)
    console.log("b is true!");



//Scopes with let var and const

var r = 1;
let t = 2;
const v = 3;

console.log('Global scope: ', r, t, v);

function test(){//FUnction scope
    var r = 4;
    let t = 5;
    const v = 6;
    console.log('Function scope ', r, t, v);
}

test();

//Block Scope

if(true){
    var r = 4;
    let t = 5;
    const v = 6;
    console.log('Global scope: ', r, t, v);
}

console.log('Global scope: ', r, t, v);