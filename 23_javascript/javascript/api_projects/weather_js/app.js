//Init storage
const storage = new Storage();

//Get storage location 

const weatherLocation = storage.getLocationData();


//Init weather obj
const weather = new Weather(weatherLocation.city, weatherLocation.state);

//Init UI object
const ui = new UI();






//Call getweather on DOM load
document.addEventListener('DOMContentLoaded', getWeather)


//Cahnge location event
document.getElementById('w-change-btn').addEventListener('click', (e) => {

  const city = document.getElementById('city').value;
  const state = document.getElementById('state').value;

  //Change location in storage
  storage.setLocationData(city, state);

  //Change location in UI
  weather.changeLocation(city, state);

  //Get and display new loc weather
  getWeather();

  //Close modal
  $('#locmodal').modal('hide');


})


function getWeather(){
  weather.getWeather()
    .then((data) => {
      ui.paint(data);
    })
    .catch((err) => console.log(err));
}