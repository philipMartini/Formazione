//UI Constructor

class  UI{


  constructor(){
    //Qui mettiamo i principali input utilizzati
  }

  //Ui Functions

  colorDoneBtns(){

    //Take all donebtns, todo-titles, todo-texts

    const doneBtns = document.querySelectorAll('[id^="done-btn-"]'); //id che inizia con done-btn-*
    const toDosTitles = document.querySelectorAll('[id^="todo-title-"]');
    const toDosTexts = document.querySelectorAll('[id^="todo-text-"] .form-control');
    console.log(toDosTitles);
    console.log(toDosTexts);
    
    doneBtns.forEach(function(doneBtn, index){

      const doneIcon = doneBtn.firstElementChild;
      
      if(doneBtn.value === 'true'){
        console.log(doneBtn.value);
        console.log(index);
        doneIcon.style.color = 'green';
        toDosTitles[index].style.textDecoration = 'line-through';
        toDosTexts[index].style.textDecoration = 'line-through';

      }else{
        doneIcon.style.color = 'black';
        toDosTitles[index].style.textDecoration = 'none';
        toDosTexts[index].style.textDecoration = 'none';
      }

    });
  }


  filterToDos(filterInput, toDosItems){

    const textFilter = filterInput.toLowerCase();
    console.log(textFilter);
    //Take all the titles
    const toDosTitles = document.querySelectorAll('[id^="todo-title-"]');
    console.log(toDosTitles);
    
    toDosTitles.forEach( function(toDoTitle, index){
      console.log(toDoTitle.value.toLowerCase());
      if(toDoTitle.value.toLowerCase().indexOf(textFilter) != -1){
        toDosItems[index].style.display  = 'block';
      }else{
        toDosItems[index].style.display  = 'none';
      }
    });



  }


}
