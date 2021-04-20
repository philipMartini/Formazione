let val;

val = document;
val = document.all; //Collezione di tutti gli elementi del dom
val = document.head
val = document.body;
val = document.doctype;
val = document.domain;
val = document.URL;


val = document.forms; //Tutti i form del document
val = document.forms[0];
val = document.forms[0].id;
val = document.forms[0].method;
val = document.forms[0].action;

val = document.links;


val = document.scripts[2].getAttribute('src');


//Convertire collection to Array (per poi usare for each)
let scripts = document.scripts;


let scriptsArr = Array.from(scripts);
console.log(scriptsArr)


console.log(val);


/******Single Element selector *********/

//document.getElementById()

console.log(document.getElementById('task-title'));

//Get things from the element
console.log(document.getElementById('task-title').className)

const taskTitle = document.getElementById('task-title');

//Change Styling
taskTitle.style.background = '#333';

taskTitle.style.color = '#fff';

taskTitle.style.padding = '2rem';

//Change content
taskTitle.textContent = 'Task LIst'

taskTitle.innerText = ' MY Task LIst'

taskTitle.innerHTML = 
    '<span style="color:red">Task List</span>';

/***Query Selector****** */
console.log(document.querySelector('#task-title'));
console.log(document.querySelector('.card-title'));
console.log(document.querySelector('h5')); //Se c'è ne sono di piu restituisce il primo

document.querySelector('ul li').style.color = 'red';

document.querySelector('ul li:last-child').style.color = 'blue';


document.querySelector('ul li:nth-child(3)').style.color = 'yellow';

document.querySelector('ul li:nth-child(4)').textContent= 'Hello World!';



//*****Multiple elements selector *********/

let items = document.getElementsByClassName('collection-item');

console.log(items)

items[3].style.color = 'red';


const listItems = document.querySelector('ul').getElementsByClassName('collection-item');

console.log(listItems)

//COnvert to array

items = Array.from(items);

items.reverse();

items.forEach(function (li, index){
    console.log(li);
    console.log(li.className);
    li.textContent = `Hello: ${index}`;
});


//query selector all

const items
