class Github {

  constructor(){
    //Normalmente queste sarebbero richieste al server e non esposte lato client ma ai fini dell'applicazione in questo caso non importa
    this.client_id = '036b13ab2dd06a51abab';
    this.client_secret = '642703ff5acee97fbb0e4222c1cbacec1b6e61f0';

    this.reposCount = 5;
    this.reposSort = 'created: asc';
  }


  async getUser(user){

    const profileResponse = await fetch(`https://api.github.com/users/${user}?client_id=${this.client_id}&client_secret=${this.client_secret}
    `)

    const reposResponse = await fetch(`https://api.github.com/users/${user}/repos?per_page=${this.reposCount}&sort=${this.reposSort}&client_id=${this.client_id}&client_secret=${this.client_secret}
    `)

    const profileData = await profileResponse.json();

    const reposData = await reposResponse.json();

    return {
      profile: profileData,
      repos : reposData
    };

  }


}