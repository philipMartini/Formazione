const easyHttp = new EasyHttp();

//Get posts
easyHttp.get('https://jsonplaceholder.typicode.com/posts', function(error, posts){
  
  if(error){
    console.log(error);
  }else{
    console.log(posts);
  }
});



//Get Single Post

easyHttp.get('https://jsonplaceholder.typicode.com/posts/1', function(error, post){
  
  if(error){
    console.log(error);
  }else{
    console.log(post);
  }
});

//Create Data
const data = {
  title: 'Custom Post',
  body: 'This is a custom post'
};

/* easyHttp.post('https://jsonplaceholder.typicode.com/posts', data, function(error, post){

  if(error){
    console.log(error);
  }else{
    console.log(post)
  }
}); 

easyHttp.put('https://jsonplaceholder.typicode.com/posts/1', data, function(error, post){

 if(error){
    console.log(error);
  }else{
    console.log(post)
  }
});*/

easyHttp.delete('https://jsonplaceholder.typicode.com/posts/1', function(error, response){

  if(error){
    console.log(error);
  }else{
    console.log(response)
  }

});
