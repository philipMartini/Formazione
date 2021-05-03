//Constructor
function EasyHttp(){
  
  this.http = new XMLHttpRequest();

  //Make Http GET req
  EasyHttp.prototype.get = function(url, callback){
    this.http.open('GET', url, true);

    this.http.onload = function(){
      if(this.status === 200){ //Qui siamo nello scope di http
       
        //Non possiamo fare semplicemnte return
        //Perchè la chiamata è asincrona
        //Quindi potremmo avere un return di unfefined quindi usiamo una callback
        callback(null, this.responseText);
      }else{
        callback('Error: '+ this.status);
      }
    };

    this.http.send();
  }

  //MAke Post Req
  EasyHttp.prototype.post = function(url, data, callback){

    this.http.open('POST', url, true);
    this.http.setRequestHeader('Content-type',
    'application/json');

    this.http.onload = function(){
      callback(null, this.responseText);
    }

    this.http.send(JSON.stringify(data));

  }


  //Make a PUT req
  EasyHttp.prototype.put = function(url, data, callback){

    this.http.open('PUT', url, true);
    this.http.setRequestHeader('Content-type',
    'application/json');

    this.http.onload = function(){
      callback(null, this.responseText);
    }

    this.http.send(JSON.stringify(data));

  };


  //Make DELETE req
  EasyHttp.prototype.delete = function(url, callback){
    this.http.open('DELETE', url, true);

    this.http.onload = function(){
      if(this.status === 200){ //Qui siamo nello scope di http
       
        //Non possiamo fare semplicemnte return
        //Perchè la chiamata è asincrona
        //Quindi potremmo avere un return di unfefined quindi usiamo una callback
        callback(null, 'Post Deleted!');
      }else{
        callback('Error: '+ this.status);
      }
    }

    this.http.send();

  };
}