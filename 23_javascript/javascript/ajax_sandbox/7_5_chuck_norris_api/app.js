//Global Ui Vars
const UIJokesBtn = document.querySelector('.get-jokes');

//Listeners

UIJokesBtn.addEventListener('click', getJokes);





//Functions
function getJokes(e){

  const number = document.querySelector('input[type="number"]').value;
  console.log(number);

  const xhr = new XMLHttpRequest();
  
  //Prepare the request
  xhr.open('GET', `http://api.icndb.com/jokes/random/${number}`,true);


  //Display jokes on http 200 response
  xhr.onload = function(){
    if(this.status === 200){
      const response = JSON.parse(this.responseText);
      console.log(response);
      let output = '';

      if(response.type === 'success'){

        let jokes = response.value;
        jokes.forEach(function(joke){
          output += `<li>${joke.joke}</li>`;
        });

      }else{
        output += '<li>something went wrong</li>';
      }

      document.querySelector('.jokes').innerHTML = output;
    }
  }

  //Send the request
  xhr.send();

  e.preventDefault();
}