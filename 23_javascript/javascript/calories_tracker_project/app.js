//Storage Controller
const StorageCtrl = (function(){

  /*Private members and Functions */



  /*Public functions */
  return {

    storeItem: function(item){
        let items;
        //Check if any items in local storage
        if(localStorage.getItem('items') === null){
          items = [];
          items.push(item);
          //Set local storage
          localStorage.setItem('items', JSON.stringify(items));
        }else{
          items = JSON.parse(localStorage.getItem('items'));
          items.push(item);
          //Re set local storage
          localStorage.setItem('items', JSON.stringify(items));
        }
      },

      deleteItemStorage: function(id) {
        let items = JSON.parse(localStorage.getItem('items'));
        items.forEach((item, index) => {
          if(item.id === id){
            items.splice(index,1);
          }

        });
        //Set local storage Again
        localStorage.setItem('items', JSON.stringify(items));
      },

      clearItemsStorage: function(){
        localStorage.removeItem('items');

      },

      updateItemStorage: function(updatedItem){
        let items = JSON.parse(localStorage.getItem('items'));
        items.forEach((item, index) => {
          if(updatedItem.id === item.id){
            items.splice(index,1, updatedItem);
          }

        });

        //Set local storage Again
        localStorage.setItem('items', JSON.stringify(items));

      },

    getItemsFromStorage: function(){
      let items;
      if(localStorage.getItem('items') === null){
        items = [];
      }else{
        items = JSON.parse(localStorage.getItem('items'));
      }
      return items;
  
    }
        
  };


})();



//Item Controller
const ItemCtrl = (function(){
  /*Private Members */
  
  //Item constructor
  const Item = function(id, name, calories){
    this.id = id;
    this.name = name;
    this.calories = calories;
  };
  
  //Data Strcure / State
  const data = {
    /* items : [
      {id:0, name: 'Steak Dinner', calories: 1200},
      {id:1, name: 'Egg', calories: 300},
      {id:2, name: 'Cookies', calories: 700}
    ] */
    items: StorageCtrl.getItemsFromStorage(),
    currentItem: null, // Item selezionato,
    totalCalories: 0
  };

  /**Public Methods */
  return {
    logData: function(){
      return data;
    },

    getItems: function(){
      return data.items;
    },

    getItemById: function(id){
      let found = null;
      data.items.forEach((item) => {
        if(item.id === id)
          found = item;

      });
      return found;
    },

    setCurrentItem: function(item){
      data.currentItem = item;
    },

    getCurrentItem: function() { return data.currentItem; },

    addItem: function(name, calories){
      let id;
      //Create Id
      if(data.items.length > 0){
        id = data.items[data.items.length -1].id + 1; //New id = last_el_id + 1
        console.log()
      }else{
        id = 0;
      }

      //Calories to number
      calories = parseInt(calories);
      //Create the new Item
     const newItem =  new Item(id, name, calories);
     //Add to data obj
     data.items.push(newItem);
     //Return it
     return newItem;
    },

    updateItem: function(name, calories){
      //Calories to number
      calories = parseInt(calories);

      let found = null;
      data.items.forEach((item)=> {
        if(item.id === data.currentItem.id){
          item.name = name;
          item.calories = calories;
          found = item;
        }
      });

      return found;

    },

    deleteItem: function(id){

      //Get all ids
      const ids = data.items.map((item) => { return item.id; });

      //Get index
      const index = ids.indexOf(id);

      //Remove item
      data.items.splice(index, 1);
    },

    clearAllItems: function() {
      data.items = [];
    },


    getTotalCalories: function(){
      let total = 0;
      data.items.forEach((item) => {
        total += item.calories;
      });

      data.totalCalories = total
      
      return data.totalCalories;
    }
  };

})();

/*****UI Controller******/
const UICtrl = (function(){


  const UISelectors = {
    itemList: '#item-list',
    listItems: '#item-list li',
    addBtn: '.add-btn',
    updateBtn: '.update-btn',
    deleteBtn: '.delete-btn',
    backBtn: '.back-btn',
    clearBtn: '.clear-btn',
    itemNameInput: '#item-name',
    itemCaloriesInput: '#item-calories',
    totalCalories: '.total-calories'

  }

  //public functions
  return {
    populateItemsList: function(items){

      let html = '';

      items.forEach(item => {
        html += `

        <li class="collection-item" id="item-${item.id}">
        <strong>${item.name}: </strong><em>${item.calories} Calories</em>
        <a href="#" class="secondary-content"><i class="edit-item fa fa-pencil-alt"></i></a>
        </li>
        `
      });

      //Insert li's to ul
      document.querySelector(UISelectors.itemList).innerHTML = html;


    },

    getSelectors: function(){ return UISelectors; },

    getItemInput: function(){
      return {
        name: document.querySelector(UISelectors.itemNameInput).value,
        calories: document.querySelector(UISelectors.itemCaloriesInput).value

      };
    },

    addListItem: function(item){

      //Show the list
      document.querySelector(UISelectors.itemList).style.display = 'block';

      //Create li element
      const li = document.createElement('li');
      //Add classes
      li.className = 'collection-item';
      //Add id
      li.id = `item-${item.id}`;
      //Add html
      li.innerHTML = `
      
      <strong>${item.name}: </strong><em>${item.calories} Calories</em>
      <a href="#" class="secondary-content"><i class="edit-item fa fa-pencil-alt"></i></a>
      
      `;
      //Insert in ul
      document.querySelector(UISelectors.itemList).insertAdjacentElement('beforeend', li);

    },

    deleteListItem: function(id){
      const itemId = `item-${id}`;
      const item = document.getElementById(itemId);
      item.remove();

    },

    removeItems: function(){
      let listItem = document.querySelector(UISelectors.itemList);
      listItem.innerHTML = '';
    },

    updateListItem: function(item){

       const listItem =  document.getElementById(`item-${item.id}`);
       listItem.innerHTML = `
       <strong>${item.name}: </strong><em>${item.calories} Calories</em>
       <a href="#" class="secondary-content"><i class="edit-item fa fa-pencil-alt"></i></a>
       
       
       `;

       


      },


    clearInput: function(){
      document.querySelector(UISelectors.itemNameInput).value = '';
      document.querySelector(UISelectors.itemCaloriesInput).value = '';
    },

    hideList: function(){
      document.querySelector(UISelectors.itemList).style.display = 'none';

    },

    showToTalCalories: function(total){
      document.querySelector(UISelectors.totalCalories).textContent = total;

    },

    clearEditState: function(){
      UICtrl.clearInput();

      document.querySelector(UISelectors.updateBtn).style.display = 'none';
      document.querySelector(UISelectors.deleteBtn).style.display = 'none';
      document.querySelector(UISelectors.backBtn).style.display = 'none';
      document.querySelector(UISelectors.addBtn).style.display = 'inline';

    },

    showEditState: function(){
      

      document.querySelector(UISelectors.updateBtn).style.display = 'inline';
      document.querySelector(UISelectors.deleteBtn).style.display = 'inline';
      document.querySelector(UISelectors.backBtn).style.display = 'inline';
      document.querySelector(UISelectors.addBtn).style.display = 'none';

    },

    addItemToForm: function(){
      document.querySelector(UISelectors.itemNameInput).value = ItemCtrl.getCurrentItem().name;
      document.querySelector(UISelectors.itemCaloriesInput).value = ItemCtrl.getCurrentItem().calories;

      //Show edit buttons
      UICtrl.showEditState();
    }





  };

})();


/****App Controller******/
const App = (function(ItemCtrl, UICtrl, StorageCtrl){

  //Load Event listeners
  const loadEventListeners = function(){
    //Get UISelectors
    const UISelectors = UICtrl.getSelectors();

    //Add item event
    document.querySelector(UISelectors.addBtn).addEventListener('click', itemAddSubmit);

    //DIsable submit on enter
    document.addEventListener('keypress', (e) => {
      if(e.keyCode === 13 || e.which === 13){
          e.preventDefault();
          return false;
      }

    });

    //Edit icon click event
    document.querySelector(UISelectors.itemList).addEventListener('click', itemEditClick);

    //Update item Event
    document.querySelector(UISelectors.updateBtn).addEventListener('click', itemUpdateSubmit)
    
    //Back button event
    document.querySelector(UISelectors.backBtn).addEventListener('click', UICtrl.clearEditState);

     //Delete button event
     document.querySelector(UISelectors.deleteBtn).addEventListener('click', itemDeleteSubmit);

     //Clear all button event
     document.querySelector(UISelectors.clearBtn).addEventListener('click', clearrAllItemsClick);


  };
  
  //Add item submit
  const itemAddSubmit = function(e){

    e.preventDefault();

    //Get form input from UI COntroller
    const input = UICtrl.getItemInput();
    console.log(input);

    //Simple Validation
    if(input.name !== '' && input.calories !== ''){
      //Add item
      const newItem = ItemCtrl.addItem(input.name, input.calories);
      //Add item to ui list
      UICtrl.addListItem(newItem);

      //Get total calories
      const totalCalories = ItemCtrl.getTotalCalories();

      //Add total calories to UI
      UICtrl.showToTalCalories(totalCalories);

      //Store in localStorage
      StorageCtrl.storeItem(newItem);

      //Clear inpust fields
      UICtrl.clearInput();

      console.log(newItem);
    }


    console.log(input);
    

  }

  //Update item submit
  const itemEditClick = function(e){
    e.preventDefault();
    if(e.target.classList.contains('edit-item')){
      console.log(e.target)
      //Get list item id
      const listId = e.target.parentElement.parentElement.id;
      //Break into array to get ONLY the item id
      const listIdArray = listId.split('-');
      //Get the last element
      const itemId = parseInt(listIdArray[1]);
      //Get item
      const itemToEdit = ItemCtrl.getItemById(itemId);
      //Set current item
      ItemCtrl.setCurrentItem(itemToEdit);
      //Add item to form
      UICtrl.addItemToForm();

      console.log(itemToEdit);
    }
  }

  const itemUpdateSubmit = function(e){

    console.log(e.target);
    //Get item Input
    const input = UICtrl.getItemInput();
    //Update Item
    const updatedItem = ItemCtrl.updateItem(input.name, input.calories);

    //Add updated item to UI
    UICtrl.updateListItem(updatedItem);

     //Get total calories
     const totalCalories = ItemCtrl.getTotalCalories();

     //Add total calories to UI
     UICtrl.showToTalCalories(totalCalories);

     //Update Local Storage
     StorageCtrl.updateItemStorage(updatedItem);

     UICtrl.clearEditState();
    e.preventDefault()

  }


  const itemDeleteSubmit = function(e){
    //Get current item
    const currentItem = ItemCtrl.getCurrentItem();
    //Delete from data structure
    ItemCtrl.deleteItem(currentItem.id);
    //Delete form ui
    UICtrl.deleteListItem(currentItem.id);

    //Get total calories
    const totalCalories = ItemCtrl.getTotalCalories();

    //Add total calories to UI
    UICtrl.showToTalCalories(totalCalories);

    //Delete From Local storage
    StorageCtrl.deleteItemStorage(currentItem.id);

    UICtrl.clearEditState();


    e.preventDefault();
    
  }

  //Clear all items event
  const clearrAllItemsClick = function(e){
    console.log(e.target);
    //Dele all items from data structure
    ItemCtrl.clearAllItems();
    //Delete from UI
    UICtrl.removeItems();

    //Get total calories
    const totalCalories = ItemCtrl.getTotalCalories();

    //Add total calories to UI
    UICtrl.showToTalCalories(totalCalories);

    //rEMOVE from local storage
    StorageCtrl.clearItemsStorage();


    UICtrl.hideList();

  }
  
  //Public Methods
  return {
    init: function(){
      console.log('Initializing App....');
      //Clear edit state
      UICtrl.clearEditState();
      //Fetch Items from data structure
      const items = StorageCtrl.getItemsFromStorage();
      console.log(items);
      //Check if any items
      if(items.length === 0)
        UICtrl.hideList();
      else{
        //Populate Ul with items
        UICtrl.populateItemsList(items);
      }
      
       //Get total calories
       const totalCalories = ItemCtrl.getTotalCalories();

       //Add total calories to UI
       UICtrl.showToTalCalories(totalCalories);
 

       //Load Event listeners
       loadEventListeners();
    }
  };

})(ItemCtrl, UICtrl, StorageCtrl);


//Init app
App.init();