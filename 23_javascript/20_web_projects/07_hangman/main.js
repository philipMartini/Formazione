//UI global variables

const wordEl = document.getElementById('word');
const wrongLettersEl = document.getElementById('wrong-letters');
const playAgainBtn = document.getElementById('play-button');
const popup = document.getElementById('popup-container');
const notification = document.getElementById('notification-container');
const finalMessage = document.getElementById('final-message');

const figureParts = document.querySelectorAll('.figure-part');

let words;
let selectedWord;




const correctLetters = [];
const wrongLetters = [];

//Fetch Words from api

async function fetchWords(){
  const response = await fetch('https://random-word-api.herokuapp.com/word?number=15');
  return response;

  
}

//Show hidden word
function displayWord(){
  wordEl.innerHTML = `
    ${selectedWord
      .split('')
      .map( letter => `<span class="letter">${correctLetters.includes(letter) ? letter : ''} </span>`).join('')
    
    }
  `;

  const innerWord = wordEl.innerText.replace(/\n/g, '');
  if(innerWord === selectedWord){
    finalMessage.innerText = 'Congratulation! You won!';
    popup.style.display = 'flex';
  }
}


//Update Wrong Letters
function updateWrongLettersEl(){
  wrongLettersEl.innerHTML = `
    ${wrongLetters.length > 0 ? '<p>Wrong</p>' : ''}
    ${wrongLetters.map(letter => `<span>${letter}</span>`)}
  `;

  figureParts.forEach( (part, index) => {
    const errors = wrongLetters.length;

    if(index < errors){
      part.style.display = 'block'
    }
    else{
      part.style.display = 'none';
    }
  });

  //Check if lost
  if(wrongLetters.length === figureParts.length){
    finalMessage.innerText = `You Lost! The Word was: ${selectedWord}`;
    popup.style.display = 'flex';
  }
}

function showNotification(){
  notification.classList.add('show');

  setTimeout(() => {notification.classList.remove('show');}, 2000);
}

// Keydown letter press
window.addEventListener('keydown', e => {
  if(e.keyCode >= 65 && e.keyCode <= 90){
    const letter = e.key;
    if(selectedWord.includes(letter)){
      if(!correctLetters.includes(letter)){
        correctLetters.push(letter);

        displayWord();
      }
      else{
        showNotification();
      }
    }else{
      if(!wrongLetters.includes(letter)){
        wrongLetters.push(letter);
        updateWrongLettersEl();
      }
      else{
        showNotification();
      }
    }
  }
});

//Restart Game and play again
playAgainBtn.addEventListener('click', () => {
  correctLetters.splice(0);
  wrongLetters.splice(0);

  selectedWord = words[Math.floor(Math.random() * words.length)];
  console.log(selectedWord);
  displayWord();
  updateWrongLettersEl();
  popup.style.display = 'none';

});


fetchWords()
  .then(res => res.json())
  .then(data => {
    words = data;
    selectedWord =  words[Math.floor(Math.random() * words.length)];
    displayWord();
  });



