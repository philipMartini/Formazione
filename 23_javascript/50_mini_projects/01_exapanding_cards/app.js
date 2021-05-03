//Ui Variables
const panels = document.querySelectorAll('.panel');

//Loop though
panels.forEach((panel) => {

  panel.addEventListener('click', (e) => {

    //Remove the previous active one
    const activePanel = document.querySelector('.active');
    activePanel.classList.remove('active');

    //Add active class to clicked one
    e.target.classList.add('active');

  
  });

});


