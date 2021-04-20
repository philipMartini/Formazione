//Game values
let min = 1, 
    max = 10,
    winningNum = getRandomNumb(min, max),
    guessesLeft = 3;

//UI elements
const UIGame = document.getElementById('game'),
        UIminNum = document.querySelector('.min-num'),
        UImaxNum = document.querySelector('.max-num'),
        UIGuessBtn = document.querySelector('#guess-btn'),
        UIGuessInput = document.querySelector('#guess-input'),
        UIMessage = document.querySelector('.message');

//Assign UI Min and MAx
UIminNum.textContent = min;
UImaxNum.textContent = max;


//Play again event listen dobbiamo usare un parent perchè la classe
//play again è stata aggiunta dopo
UIGame.addEventListener('mousedown', function(e){
    if(e.target.className === 'play-again'){
        window.location.reload();
    }
    
})



//Listen for guess
UIGuessBtn.addEventListener('click', function(e){
    let guess = parseInt(UIGuessInput.value);
    
    //Validate
    if(isNaN(guess) || guess < min || guess > max){
        setMessage(`Please Enter a number between ${min} and ${max}`, 'red');
    }
    else{

        //Check if won
        if(guess === winningNum){
            UIGuessResponse(`${winningNum} is Correct, YOU WIN!`, 'green');
            UIGuessBtn.value = 'Play Again?'
            UIGuessBtn.className += 'play-again';
            
        }else{
            //Wrong number
            guessesLeft -= 1;

            //Game Over
            if(guessesLeft === 0){
                UIGuessResponse(`${winningNum} Was The Guess, YOU LOST!`, 'red');
                UIGuessBtn.value = 'Play Again?'
                UIGuessBtn.className += 'play-again';
                
            }else{
                UIGuessResponse(`${guess} is Not Correct, you have ${guessesLeft} guesses left`, 'red');

            }
        }
}

});

function UIGuessResponse(outMessage, color) {
    //Coloro border
    UIGuessInput.style.borderColor = color;
    setMessage(outMessage, color);

    //If lost or win disable input
    if(color === 'green' || guessesLeft === 0){
        UIGuessInput.disabled = true;
    }
    else{
        UIGuessInput.value = '';
    }
}

function setMessage(errorMessage, color){
    UIMessage.style.color = color;
    UIMessage.textContent = errorMessage;
}

function getRandomNumb(min, max){
    return Math.floor((Math.random() * (max - min + 1)+ min));
}