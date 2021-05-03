class UI{

  constructor(){
    this.location = document.getElementById('w-location');
    this.desc = document.getElementById('w-desc');
    this.longDesc = document.getElementById('w-string')
    this.temp = document.getElementById('w-temp');
    this.details = document.getElementById('w-details');
    this.humidty = document.getElementById('w-humidity');
    this.feelsLike = document.getElementById('w-feels-like');
    this.wind = document.getElementById('w-wind');
    this.icon = document.getElementById('w-icon');
  }



  paint(weather){
    this.location.textContent = weather.sys.country + ' ' + weather.name;
    this.desc.textContent = weather.weather[0].main;
    this.longDesc.textContent = weather.weather[0].description
    this.temp.textContent = `Temperature ${weather.main.temp}`;
    this.humidty.textContent = `Realtive Humidity: ${weather.main.humidity}`;
    this.feelsLike.textContent = `Feels Like ${weather.main.feels_like}`;
    this.wind.textContent = `Wind Speed ${weather.wind.speed}`;
    const iconUrl = `http://openweathermap.org/img/wn/${weather.weather[0].icon}@2x.png`;
    this.icon.setAttribute('src', iconUrl);
  }
}

