/****Objects**********/
var myObj = {}; //empty inline object

console.log(myObj);
console.log(typeof myObj)

//adding a property dinamically
myObj.prop = "Hello!";

console.log(myObj) //In JS gli oggetti si comprtano come
                    //I dictionaries in Python!!!!

myObj.prop2 = 123;

console.log(myObj);

//Access a property
console.log(myObj.prop2);

/**Object literal => con le property nella definizione*/
var myObj2 = {"prop": "Hello", "prop2" : true};
console.log(myObj2);
//NON CI SONO ACCESSS LIMITATOR !!!! => tutte le property sono PUBLIC

//Accessing non existing properties
console.log(myObj2.prop3); // => undefined

//[] notation 
console.log(myObj2["prop"]); // === myObj2.prop

//fondamentale quando le property names sono dynamic Ad esempio
var propertyName = "prop2";
console.log(myObj2[propertyName]);

/***Nested Objects */

var nestedObj = {
    "prop": "Hello", 
    "prop2" : true,
    "prop3":{
        "nprop1":123,
        "nprop2":"World!"
    },

    "prop4": null

};

console.log(nestedObj.prop3["nprop2"]);
//Oppure tutta dot notation o [] notation
//Aggiungo una nuova propert nell'inner obj
nestedObj.prop3.nprop3 = "New Inner!";
console.log(nestedObj.prop3["nprop3"]);

/***** Equality for Objects *******/
//ANche in Js le variabili obj puntano a reference per gli oggetti nello HEap del browser
//Di fatto myObj3 e myObj2 puntano allo stesso oggetto
var myObj3 = myObj2;

console.log(myObj3.prop);

if(myObj3 === myObj2)// Quindi sono uguali
    console.log("They are Equal");


//Remove a property
delete myObj2.prop2;

console.log(myObj2);

/********Arrays********/
//Simili alle liste Python
var myArray = ["Hello", "World", true];
console.log(myArray[3]); //=> undefined
//Aggiungere un valore
myArray[3] = 123;
console.log(myArray[3]);

console.log(myArray.length);//Questa è una property
//Gli array in JS sono oggetti quindi sotto c'è un object
console.log(myArray)
//A conferma di questo
console.log(myArray["0"]);//Le property names sono numeri e quindi non si puo usare il dot operator

//Qui Js fa type cohercion
console.log(myArray[0]);

//Per assurdo potrei aggiungere un index non contiguo o non numerico!!!!!
myArray[400] = 123;
console.log(myArray.length) //401 perchè guarda la property dell'ultimo elemento non conta il numero di elementi

myArray["foo"] = "bar";

console.log(myArray);

/***Wrapper Objects ******/
//Come in java anche in JS i tipi primiti hanno equivalenti
//In oggetti infatti è possibile fare:
var str = "Hello World";
console.log(str.length);