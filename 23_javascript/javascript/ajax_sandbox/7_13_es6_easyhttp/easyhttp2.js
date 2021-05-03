
class EasyHttp {


  //Make an Htt GET req
  get(url){
    return new Promise((resolve, reject) => {
      fetch(url)
      .then(res => res.json())
      .then(data => resolve(data))
      .catch(err => reject(err))

    });
  }

  //MAke Http POST req
  post(url, data){
    return new Promise((resolve, reject) => {
      fetch(url, {
        method: 'POST',
        headers: {
          'Content-type': 'application/json'
        },

        body: JSON.stringify(data)

      }
        )
      .then(res => res.json())
      .then(data => resolve(data))
      .catch(err => reject(err))

    });

  }

  //MAke PUT req
  put(url, data){
    return new Promise((resolve, reject) => {
      fetch(url, {
        method: 'PUT',
        headers: {
          'Content-type': 'application/json'
        },

        body: JSON.stringify(data)

      }
        )
      .then(res => res.json())
      .then(data => resolve(data))
      .catch(err => reject(err))

    });

  }


  //Make http DELETE req
  delete(url){
    return new Promise((resolve, reject) => {
      fetch(url, {
        method : 'DELETE',
        headers: {
          'Content-type': 'application/json'
        }
      })
      .then(() => 'User Deleted')
      .then(data => resolve(data))
      .catch(err => reject(err))

    });
  }





}