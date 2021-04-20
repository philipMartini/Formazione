//UI Variables
const UIContainer = document.getElementById('todos-container');
const UIFilterInput = document.getElementById('filter-todo');
console.log(UIFilterInput);

//Color the DoneCheck respective to doneValue
colorDoneIcons();



UIContainer.addEventListener('click', function(e){
    //e.preventDefault();
    if(e.target.classList.contains('fa-caret-left') || e.target.classList.contains('fa-caret-down') ){
        let toDoId = e.target.parentElement.id.slice(-1);
        console.log(toDoId);
        showHideToDo(toDoId);
    }

    if(e.target.classList.contains('fa-check-circle') ){
        let toDoId = e.target.parentElement.id.slice(-1);
        //Cambia il valore contenuto nell'input del toDoDone
        let doneValueElement = e.target.parentElement.nextElementSibling;
        console.log(toDoId);
        markToDoDoneUndone(toDoId, e.target, doneValueElement);
    }

    if(e.target.classList.contains('fa-plus-circle')){
        addEditView = document.getElementById('todo-add-text-view');

        if(addEditView.style.display == '')
            addEditView.style.display = 'none';
        if(addEditView.style.display == 'none'){
            addEditView.style.display = 'flex';
        }
        else{
            addEditView.style.display = 'none';
        }
    }
    
});


UIFilterInput.addEventListener('keyup', filterTodos)


//Functions
function showHideToDo(toDoId){
     let toDoItem = document.getElementById(`todo-text-view-${toDoId}`);
     let showBtn = document.getElementById(`show-todo-text-${toDoId}`).firstElementChild;
    if(toDoItem.style.display === ''){
        toDoItem.style.display = 'none';
    }
    
   if(toDoItem.style.display === 'none'){

    console.log('Listening..... None');
       //Mostra il testo del todo
        toDoItem.style.display = 'flex';
        //Cambia l'icona del tag i all'interno del btn
        showBtn.className = "fas fa-caret-down fa-2x";

    }
    else{
        console.log( toDoItem.style.display);
        toDoItem.style.display = 'none';
        //Cambia l'icona del tag i all'interno del btn
        showBtn.className = "fas fa-caret-left fa-2x";
    }
    
}

function markToDoDoneUndone(toDoId, doneIcon, doneValueElement){

    let toDoTitle = document.getElementById(`todo-title-${toDoId}`);
    let toDoText = document.getElementById(`todo-text-${toDoId}`);
    console.log(doneValueElement.value);
   
    if(doneValueElement.value === 'false'){
        doneIcon.style.color = 'green';
        toDoTitle.style.textDecoration = 'line-through';
        toDoText.style.textDecoration = 'line-through';
        doneValueElement.value = 'true';
    }
    else{
        doneIcon.style.color = 'black';
        toDoTitle.style.textDecoration = 'none';
        toDoText.style.textDecoration = 'none';
        doneValueElement.value = 'false';
    }
}



function viewToDoDoneUndone(toDoId, doneIcon, doneValueElement){

    let toDoTitle = document.getElementById(`todo-title-${toDoId}`);
    let toDoText = document.getElementById(`todo-text-${toDoId}`);
    console.log(doneValueElement.value);
   
    if(doneValueElement.value === 'true'){
        doneIcon.style.color = 'green';
        toDoTitle.style.textDecoration = 'line-through';
        toDoText.style.textDecoration = 'line-through';
        doneValueElement.value = 'true';
    }
    else{
        doneIcon.style.color = 'black';
        toDoTitle.style.textDecoration = 'none';
        toDoText.style.textDecoration = 'none';
        doneValueElement.value = 'false';
    }
}


function filterTodos(e){
    const text = e.target.value.toLowerCase();

    document.querySelectorAll('.todo-group').forEach(
        function(toDoContainer){
            
            if(toDoContainer.id.includes('todo-group')){
                console.log(toDoContainer.firstElementChild.firstElementChild.children[0].children[1].value);
                //const item = task.firstChild.textContent;
                const item = toDoContainer.firstElementChild.firstElementChild.children[0].children[1].value;
            if(item.toLowerCase().indexOf(text) != -1){
                toDoContainer.style.display = 'block';
            }
            else{
                toDoContainer.style.display = 'none';
            }
            }
            
        }
    );

}

function colorDoneIcons(){

	document.querySelectorAll('.todo-group').forEach(
        function(toDoContainer){
            
            if(toDoContainer.id.includes('todo-group')){
                let toDoId = toDoContainer.id.slice(-1);
                let doneIcon = toDoContainer.firstElementChild.firstElementChild.firstElementChild.children[0].firstElementChild;
                let doneValue= toDoContainer.firstElementChild.firstElementChild.firstElementChild.children[1];
                console.log(toDoId);
                console.log(doneIcon);
                console.log(doneValue);
                viewToDoDoneUndone(toDoId, doneIcon, doneValue);
            
            }
            
        }
    );

}



