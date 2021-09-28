//Global UI Variables
const word = document.getElementById('word');
const text = document.getElementById('text');
const scoreEl = document.getElementById('score');
const timeEl = document.getElementById('time');
const endgameEl = document.getElementById('end-game-container');
const settingsBtn = document.getElementById('settings-btn');
const settings = document.getElementById('settings');
const settingsForm = document.getElementById('settings-form');
const difficultySelect = document.getElementById('difficulty');

// List of words for game
const words = [
  'sigh',
  'tense',
  'airplane',
  'ball',
  'pies',
  'juice',
  'warlike',
  'bad',
  'north',
  'dependent',
  'steer',
  'silver',
  'highfalutin',
  'superficial',
  'quince',
  'eight',
  'feeble',
  'admit',
  'drag',
  'loving'
];

//Init word
let randomWord;

//Init score
let score = 0;

//Time
let time = 10;

let difficulty = localStorage.getItem('difficulty') !== null ? localStorage.getItem('difficulty') : 'medium';

//Set diff select value
difficultySelect.value = difficulty;

//FOcus on text on start
text.focus();


//Start counting down
const timeInterval = setInterval(updateTime, 1000);


//Generate random words from array
function getRandomWord(){

  return words[Math.floor(Math.random() * words.length)];

}


function addWordToDOM(){
  randomWord = getRandomWord();
  console.log(randomWord);
  word.innerHTML = randomWord;
}

function updateScore(){

  ++score;
  scoreEl.innerHTML = score;
}

//Update Time
function updateTime(){

  --time;
  timeEl.innerHTML = time + 's';

  if(time === 0){
    clearInterval(timeInterval);
    //end game
    gameOver();
  }


}


function gameOver(){
  endgameEl.innerHTML = `
  <h1>Time Ran Out</h1>
  <p>Your Final Score is ${score}</p>
  <button onclick="location.reload()">Reload</button>
  
  
  `;

  endgameEl.style.display = 'flex';
}

addWordToDOM();


//Event listeners 


//Typing
text.addEventListener('input', e => {
  const insertedText = e.target.value;
  
  if(insertedText === randomWord){

    addWordToDOM();
    updateScore();
    e.target.value = '';

    if(difficulty === 'hard'){
      time += 2;
    }else if(difficulty === 'medium'){
      time += 3;
    }
    else{
      time += 5;
    }
    updateTime();
  }

});

//Settings btn click
settingsBtn.addEventListener('click', () => {

  settings.classList.toggle('hide');
});

settingsForm.addEventListener('change', e => {

  difficulty = e.target.value;
  localStorage.setItem('difficulty', difficulty);

});