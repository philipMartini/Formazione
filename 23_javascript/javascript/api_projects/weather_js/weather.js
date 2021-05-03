class Weather{

  constructor(city, state){
    this.apiKey = '0a42a153230ad54d908d974ca379ab9d';
    this.city = city;
    this.state = state;
  }

  //Fetch weather from api
  async getWeather(){

    const response = await fetch(`http://api.openweathermap.org/data/2.5/weather?q=${this.city},${this.state}&units=metric&appid=${this.apiKey}`);

    const responseData = await response.json();

    return responseData;
  }


  //Change weather location
  changeLocation(city, state){
    this.state = state;
    this.city = city;
  }

}
