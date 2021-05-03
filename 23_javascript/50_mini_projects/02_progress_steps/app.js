//Variables

const progress = document.getElementById('progress');
const prev = document.getElementById('pre');
const next = document.getElementById('next');

const circles = document.querySelectorAll('.circle');

//Active node
let currentActive = 0;

next.addEventListener('click', (e) => {

  currentActive = (currentActive + 1) % 4;
  console.log(currentActive);
  update();

});

prev.addEventListener('click', (e) => {

  currentActive = (currentActive - 1) % 4;
  console.log(currentActive);

  update();

});


function update(){
  circles.forEach((circle, index) => {

    if(index <= currentActive){
      circle.classList.add('active');
    }else{
      circle.classList.remove('active');
    }
  });

  const actives = document.querySelectorAll('.active');
  const barLenght = (actives.length - 1 )/ (circles.length - 1) *100;

  progress.style.width = barLenght+'%';

  if(currentActive === 0){
    prev.disabled = true;
  }else if(currentActive === circles.length - 1){
    next.disabled = true;
  }else{
    prev.disabled = false;
    next.disabled = false;
  }

}