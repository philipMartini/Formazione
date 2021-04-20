//Global variables (for this script)
let minNum = 1,
    maxNum = 10,
    answerNum = 2,
    guessesLeft = 3;


//UI Variables

//Spans over the guess Input max-min num
let UIEnterPhraseMin = document.querySelector('.min-num');
let UIEnterPhraseMax = document.querySelector('.max-num');
//OutputPhrase for the Game Output
let UIOutMessage = document.querySelector('.message');

//The input text for the guess
let UIGuessInput = document.getElementById('guess-input');
//The submit button for the guess
let UISubmitBtn = document.getElementById('guess-btn');

//Display current min-max for the guess
UIEnterPhraseMin.textContent = minNum;
UIEnterPhraseMax.appendChild(document.createTextNode(maxNum));


//Listeners
UISubmitBtn.addEventListener('click', function (e) {
    e.preventDefault();

    //Take the input value
    let guess = parseInt(UIGuessInput.value);
    playGame(guess);
    

})



function playGame(guess){

    if(guess === answerNum){
        gameOver(guess, 'green');
    }else{
        if(guessesLeft === 0 ){
            gameOver(answerNum, 'red');
        }

        else{
            guessesLeft -= 1;
            UIGuessInput.value = '';
            UIGuessInput.style.borderColor = 'red';
            UIOutMessage.style.color = 'red';
            UIOutMessage.textContent = `${guess} Is Not The correct Number You Have ${guessesLeft} guesses left`;

        }
    }
}

function gameOver(guess, color){
    UIGuessInput.disabled = true;
    UIGuessInput.style.borderColor = color;
    UIOutMessage.style.color = color;

    if(color === 'green'){
       
        UIOutMessage.textContent = `You WIN! ${guess} was The Correct Number!`;
        
    }else{
        UIOutMessage.textContent = `You LOST! ${guess} was The correct Number!`;
    }
}



