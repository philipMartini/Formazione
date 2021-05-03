//Search input
const searchUser = document.getElementById('searchUser');

//Instantiate github object
const github = new Github();

const ui = new UI();

//Search input event listener
searchUser.addEventListener('keyup', (e) => {

  //Get input text
  const userText = e.target.value;

  if(userText !== ''){
    //Make http req to github api
    
    github.getUser(userText)
      .then(data => {

        if(data.profile.message === 'Not Found'){
          //Show alert
          ui.showAlert('User Not Found', 'alert alert-danger');
        }else{
          //Show Profile
          ui.showProfile(data.profile);
          ui.showRepos(data.repos);
        }
      })
      .catch(err => console.log(err));
  }else{
    //Clear profile
    ui.clearProfile();
  }


});