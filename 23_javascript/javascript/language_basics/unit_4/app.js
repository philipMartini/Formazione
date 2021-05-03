/****Arrays Methods ******/


var myArray = [1,"Hello", true, 3, {}];
myArray.push("World"); //aggiungi un elemento alla coda dell'array
console.log(myArray);
myArray.pop() //togli lultimo elemento
console.log(myArray);
//Lavaora con il primo elemento shift/unshift
myArray.shift();
console.log(myArray);
myArray.unshift("MyFIRST");
console.log(myArray);


/****For each*****/
myArray.forEach( function(item, index) {
    //Usiamo l'elemento dell array basta dichiarare l'elemento come argomento della funzione anonima
    console.log("FOR AN ELEMEN T " + item + " At index " + index); //La esegue per tutti gli elementi
});