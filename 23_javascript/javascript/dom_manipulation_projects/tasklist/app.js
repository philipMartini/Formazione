//Define ui vars

const form = document.querySelector('#task-form');
const taskList = document.querySelector('.collection');
const clearBtn = document.querySelector('.clear-tasks');
const filter = document.querySelector('#filter');
const taskInput = document.querySelector('#task');


//Load all event listeners
loadEventListeners();

//Load all event listeners

function loadEventListeners() {

    //Dom load event
    document.addEventListener('DOMContentLoaded', getTasks);

    //Add task event
    form.addEventListener('submit', addTask);

    //Delete task event
    taskList.addEventListener('click', removeTask);

    //Clear tasks
    clearBtn.addEventListener('click', clearTasks);

    //Filter Task event
    filter.addEventListener('keyup', filterTasks);
}

//Get Tasks from local storage
function getTasks(){

    let tasks;
    if(localStorage.getItem('tasks') === null){
        tasks = [];
    }
    else{
        tasks = JSON.parse(localStorage.getItem('tasks'));
        tasks.forEach(
            function(task){

                //Create li eleemnt

                const li = document.createElement('li')
                li.className = 'collection-item';
                //Create text node and append to li
                li.appendChild(document.createTextNode(task));
                //Create new link element
                const link = document.createElement('a');
                //Add a class
                link.className = 'delete-item secondary-content'
                //Add icon
                link.innerHTML = '<i class="fa fa-remove"></i>'
                li.appendChild(link);
                
                //append li to ul
                taskList.appendChild(li);

            }
        );
    }
}


//Add task
function addTask(e) {

    if(taskInput.value === ''){
        alert('Add a task')
    }

    //Create li eleemnt

    const li = document.createElement('li')
    li.className = 'collection-item';
    //Create text node and append to li
    li.appendChild(document.createTextNode(taskInput.value));
    //Create new link element
    const link = document.createElement('a');
    //Add a class
    link.className = 'delete-item secondary-content'
    //Add icon
    link.innerHTML = '<i class="fa fa-remove"></i>'
    li.appendChild(link);
    
    //append li to ul
    taskList.appendChild(li);

    //Store in local storage
    storeTaskInLocalStorage(taskInput.value);

    //Clear input
    taskInput.value = '';

    e.preventDefault();
   
}


//Store Task
function storeTaskInLocalStorage(taskText) {
    let tasks;
    if(localStorage.getItem('tasks') === null){
        tasks = [];
    }
    else{
        tasks = JSON.parse(localStorage.getItem('tasks'));
    }

    tasks.push(taskText);
    localStorage.setItem('tasks', JSON.stringify(tasks));
}


//Remove Task
function removeTask(e) {

    //Il listener è tutta la ul quindi bisogna filtrare ancora e prendere la classe del a tag
    if(e.target.parentElement.classList.contains('delete-item')){
        if(confirm('Are you Sure?')){
            //Doddiamo rimuovere li
            e.target.parentElement.parentElement.remove();
            //Remove from LS
            removeTaskFromLocalStorage(e.target.parentElement.parentElement);
        }

    }

    
}


//Remove From local Storage
function removeTaskFromLocalStorage(taskItem){
    let tasks;
    if(localStorage.getItem('tasks') === null){
        tasks = [];
    }
    else{
        tasks = JSON.parse(localStorage.getItem('tasks'));
    }
    tasks.forEach(function(task, index){
        if(taskItem.textContent === task){
            tasks.splice(index, 1);
        }
    })

    localStorage.setItem('tasks', JSON.stringify(tasks));
}

//CLear Tasks
function clearTasks(e){
    while(taskList.firstChild){
        taskList.removeChild(taskList.firstChild);
    }

    //Clear from local storage
    clearTasksFromLocalStorage();
}


function clearTasksFromLocalStorage(){
    localStorage.clear();
}

//filter tasks
function filterTasks(e){
    const text = e.target.value.toLowerCase();

    document.querySelectorAll('.collection-item').forEach(
        function(task){
            const item = task.firstChild.textContent;
            if(item.toLowerCase().indexOf(text) != -1){
                task.style.display = 'block';
            }
            else{
                task.style.display = 'none';
            }
        }
    );

}