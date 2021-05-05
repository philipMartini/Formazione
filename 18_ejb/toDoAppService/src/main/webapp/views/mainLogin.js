//global variables
const errorDiv = document.querySelector('#error');
let currentErrorDivText = errorDiv.innerText
const inputs = document.querySelectorAll('.form-control')


showError();



function showError(){
	if(currentErrorDivText !== ''){
		console.log(currentErrorDivText);
    

    //console.log(usernameInput.classList);
    inputs.forEach((formInput) => {
      console.log(formInput);
      formInput.classList.add('is-invalid');
    });
   
    //console.log(usernameInput.classList);
  }
}


//Clean error on keyup
function cleanError(){
  if(currentErrorDivText !== ''){
		console.log(currentErrorDivText);
    inputs.forEach((formInput) => {
      console.log(formInput);
      formInput.classList.remove('is-invalid');
    });

    
    errorDiv.innerText = '';
    
  }

}

//Listeners

document.getElementById('username').addEventListener('keyup', (e) => {
  cleanError();
});




