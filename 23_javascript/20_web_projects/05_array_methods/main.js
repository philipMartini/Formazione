//UI Global Variables
const main = document.getElementById('main');
const addUserBtn = document.getElementById('add-user');
const doubleBtn = document.getElementById('double');
const showMillionaresBtn = document.getElementById('show-millionaires');
const sortBtn = document.getElementById('sort');
const calculateWealthBtn = document.getElementById('calculate-wealth');


//Qui verranno inseriti i dati provenienti dall'api
let data = [];

getRandomUser();
getRandomUser();
getRandomUser();


//****** Functions *************/

//Fetch random user and add money
async function getRandomUser(){
  const res = await fetch('https://randomuser.me/api');
  const data = await res.json();
  const user = data.results[0];

  const newUser = {
    name: `${user.name.first} ${user.name.last}`,
    money: Math.floor(Math.random() * 1000000)

  };

  addData(newUser);
}

//Double the money of all users
function doubleMoney(){
  data = data.map( (user) => {

    return {name: user.name, money: user.money * 2 };
  });

  updateDOM();
}

//Sort by wealth (RICHEST TOP)
function sortByRichest(){
  
  data.sort((a, b) => b.money - a.money);
  updateDOM();

}

//Filter out NON milionares Users
function showMillionares(){

  data = data.filter((user) => user.money > 1000000);
  updateDOM();
}

//Calculate entire Wealth
function calculateWealth(){

  const wealth = data.reduce( (accumulator, user) => accumulator += user.money, 0);
  
  const wealthElement = document.createElement('div');
  wealthElement.innerHTML = `<h3>Total Wealth: <strong>${formatMoney(wealth)}</strong></h3>`;
  main.appendChild(wealthElement);

}


//Add new obj to data arr
function addData(obj){
  data.push(obj);
  updateDOM();
}

//Il default value è il data array
function updateDOM(providedData = data){

  //Clear the main div
  main.innerHTML = '<h2><strong>Person</strong> Wealth</h2>';

  providedData.forEach( item => {

    const element = document.createElement('div');
    element.classList.add('person');
    element.innerHTML = `<strong>${item.name}</strong> ${formatMoney(item.money)}`;

    //iNSERT IN THE DOM 
    main.appendChild(element);


  });

}


//Format number as money
function formatMoney(number){

  return '$ '+((number).toFixed(2).replace(/\d(?=(\d{3})+\.)/g, '$&,'));
}





/***** EVENT LISTENERS  *********/
addUserBtn.addEventListener('click', getRandomUser);
doubleBtn.addEventListener('click', doubleMoney);
sortBtn.addEventListener('click', sortByRichest);
showMillionaresBtn.addEventListener('click', showMillionares);
calculateWealthBtn.addEventListener('click', calculateWealth);