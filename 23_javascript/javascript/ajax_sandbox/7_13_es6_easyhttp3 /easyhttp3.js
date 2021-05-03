
class EasyHttp {


  //Make an Htt GET req
  async get(url){
    const response = await fetch(url);
    const resData = await response.json();
    return resData;
  }

  //MAke Http POST req
  async post(url, data){
    
      const response = await fetch(url, {
        method: 'POST',
        headers: {
          'Content-type': 'application/json'
        },

        body: JSON.stringify(data)

      });
      
      const responseData = await response.json();
      return responseData;

  

  }

  //MAke PUT req
  async put(url, data){
    
     const response = await  fetch(url, {
        method: 'PUT',
        headers: {
          'Content-type': 'application/json'
        },

        body: JSON.stringify(data)

      });
      
      const responseData = await response.json();
      return responseData;
  }


  //Make http DELETE req
  async delete(url){
    
      const response = await fetch(url, {
        method : 'DELETE',
        headers: {
          'Content-type': 'application/json'
        }
      });

      const responseData = await 'Resource Deleted';
      return responseData;
      
  }





}