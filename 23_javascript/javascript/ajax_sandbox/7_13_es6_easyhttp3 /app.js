
const easyHttp = new EasyHttp();

//Get users
easyHttp.get('https://jsonplaceholder.typicode.com/users')
    .then(data => console.log(data))
    .catch(err => console.log(err));


//User data
const data = {
    "name": "Foo Bar",
    "username": "FOOOOOOOO",
    "email": "FOOO@FOOO.com"
    
};

//Add user
easyHttp.post('https://jsonplaceholder.typicode.com/users',data)
.then(data => console.log(data))
.catch(err => console.log(err));

//Update user
easyHttp.put('https://jsonplaceholder.typicode.com/users/2',data)
.then(data => console.log(data))
.catch(err => console.log(err));


//Delete user
easyHttp.delete("https://jsonplaceholder.typicode.com/users/2")
  .then(msg => console.log(msg))
  .catch(err => console.log(err));
