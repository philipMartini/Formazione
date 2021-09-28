const form = document.getElementById('form');
const username = document.getElementById('username');
const email = document.getElementById('email');
const password = document.getElementById('password');
const password2 = document.getElementById('password2');


//Show Input Error Message
function showError(input, message){
  const formControl = input.parentElement;
  //Remove error/success class if present
  formControl.classList.remove('error');
  formControl.classList.remove('success');
  formControl.classList.add('error');
  const errorElement = formControl.querySelector('small');
  errorElement.innerText = message;
}

//Show Success Outline
function showSuccess(input){
  const formControl = input.parentElement;
   //Remove error/success class if present
   formControl.classList.remove('error');
   formControl.classList.remove('success');
  formControl.classList.add('success');
}

//Check Email validity
function checkEmail(input){
  const re = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
  if(re.test(String(input.value).toLowerCase())){
    showSuccess(input);
  }else{
    showError(input, 'Email is Not Valid');
  }

}

//Check Required Fields
function checkRequired(inputArray){
  inputArray.forEach((input) => {
    if(input.value.trim() === '')
      showError(input, `${getFieldName(input)} Is Required!`);
    else
      showSuccess(input);
  });
}

//Check input Length
function checkLength(input, min, max){
  if(input.value.length < min)
    showError(input, `${getFieldName(input)} Must Be at Least ${min} characters`);
  else if(input.value.length > max)
    showError(input, `${getFieldName(input)} Must Be Less Than ${max} characters`);
  else
    showSuccess(input);
}

//Check password match
function checkPasswordsMatch(input1, input2){
  if(input1.value !== input2.value){
    showError(input2, 'Passwords Do Not Match!');
  }
}

//Get Field Name
function getFieldName(input) {
  return input.id.charAt(0).toUpperCase() + input.id.slice(1);
}

//Event Listeners
form.addEventListener('submit', (e) => {
  e.preventDefault();

  checkRequired([username, email, password, password2]);
  checkLength(username, 3, 15);
  checkLength(password, 8, 20);
  checkEmail(email)
  checkPasswordsMatch(password, password2);
  
});

