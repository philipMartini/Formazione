//Global variables
const  filterToDoInput = document.getElementById('todo-filter');
const toDoList = document.getElementById('toDosList');
const toDos = toDoList.children;


/**TODO Manca la validazione degli input lato client e relativi alert di successo o danger  */


console.log("HERE");
const ui = new UI();
ui.colorDoneBtns();



//Listeners
filterToDoInput.addEventListener('keyup', function(e){
  
  ui.filterToDos(e.target.value, toDos);
});


toDosList.addEventListener('click', function(e){

  //Animate arrow
  if(e.target.classList.contains('fa-caret-left') || e.target.classList.contains('fa-caret-down') ){
    console.log(e.target);
    changeArrowDirection(e.target);
  }

  //Delete submit req
  if(e.target.id.indexOf('delete-btn') != -1){
    e.target.nextElementSibling.nextElementSibling.name = 'delete';
    let toDoId = e.target.id.split('-')[2];
    document.getElementById(`todo-form-${toDoId}`).submit();
    
  }

  //Update submit req
  if(e.target.id.indexOf('update-btn') != -1){
    e.target.nextElementSibling.nextElementSibling.name = 'update';
    let toDoId = e.target.id.split('-')[2];
    document.getElementById(`todo-form-${toDoId}`).submit();
    
  }

  //async done/undone update
  if(e.target.classList.contains('fa-check-circle')){
    /*e.target.nextElementSibling.nextElementSibling.name = 'done';*/
    let toDoId = e.target.parentElement.id.split('-')[2];
    let doneValue = document.getElementById(`done-btn-${toDoId}`).value;
    let formData = new FormData();
    formData.append('done', 'done');
    formData.append('toDoId', toDoId);
    formData.append('doneValue', doneValue);
    myPost('http://localhost:8080/toDoAppService/todos', formData);
    toDoDoneUndone(toDoId);


  }

});


//Login form validation and async req





//Add Form validation
document.getElementById('add-todo-btn').addEventListener('click', function(e){

  
  //Get form values to check 
  const formInput = document.getElementById('add-todo-title');
  const toDoTitle = formInput.value;
  console.log(toDoTitle);

  if(toDoTitle === ''){
    console.log(formInput);
    let errorMessageItem = document.getElementById('add-todo-form').firstElementChild.children[5];
    console.log(errorMessageItem);
    formInput.classList.add('is-invalid');
    errorMessageItem.textContent = 'ToDo Title cannot be empty!';
    console.log(errorMessageItem);
    //Mostra il messaggio
  }
  else{
  	//Altrimenti qui dovrebbe partire la chiamata alla servlet
  	console.log(document.getElementById('add-todo-form').method);
  	console.log(document.getElementById('add-todo-form').action);
    document.getElementById('add-todo-form').submit();
  }
  
  e.preventDefault();
});


//Remove add form empty title after first char input
document.getElementById('add-todo-title').addEventListener('keyup', function(e){ 
  if(e.target.classList.contains('is-invalid')){
    e.target.classList.remove('is-invalid');
  }
});


//Functions
function toDoDoneUndone(toDoId){

  console.log(toDoId);
  
  const doneBtn = document.getElementById(`done-btn-${toDoId}`);
  const toDoTitle = document.getElementById(`todo-title-${toDoId}`);
  const toDoText = document.getElementById(`todo-text-${toDoId}`);
  console.log(toDoText);
  const doneIcon = doneBtn.firstElementChild;

  if(doneBtn.value === 'false'){
    doneBtn.value = 'true';
    doneIcon.style.color = 'green';
    toDoTitle.style.textDecoration = 'line-through';
    toDoText.style.textDecoration = 'line-through';
    
  }else{
    doneBtn.value = 'false';
    doneIcon.style.color = 'black';
    toDoTitle.style.textDecoration = 'none';
    toDoText.style.textDecoration = 'none';

  }



}


function changeArrowDirection(arrowElement){
  if(arrowElement.classList.contains('fa-caret-left')){
    arrowElement.classList = 'fas fa-caret-down fa-2x'
  }
  else{
    arrowElement.classList = 'fas fa-caret-left fa-2x'
  }

}




 //Make an Htt GET req
 async function myGet(url){
  const response = await fetch(url);
  const resData = await console.log('Done!');
}


//MAke Http POST req
async function myPost(url, data){
    
  const response = await fetch(url, {
    method: 'POST',
    body: data

  });
   
}

