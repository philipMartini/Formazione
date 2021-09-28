//Global UI variables
const search = document.getElementById('search');
const submit = document.getElementById('submit');
const random = document.getElementById('random');
const mealsEl = document.getElementById('meals');
const resultHeading = document.getElementById('result-heading');
const single_mealEl = document.getElementById('single-meal');



// Call The API to search for a meal 
function searchMeal(e) {
  e.preventDefault();

  //Clear previous single meal displayed
  single_mealEl.innerHTML = '';

  //Get the search term
  const term = search.value;

  //Check form empty
  if(term.trim()){

    fetch(`https://www.themealdb.com/api/json/v1/1/search.php?s=${term}`)
          .then(res => res.json())
          .then(
            data => {
              console.log(data);

              resultHeading.innerHTML = `<h2>Search results for '${term}': </h2>`;

              if(data.meals === null){
                resultHeading.innerHTML = `<p>There are no search results try again!</p>`;
              }else{
                mealsEl.innerHTML = data.meals.map( meal => 
                  `<div class="meal">
                  <img src="${meal.strMealThumb}" alt="${meal.strMeal}">
                  <div class="meal-info" data-mealID="${meal.idMeal}">
                    <h3>${meal.strMeal}</h3>
                  </div>
                </div>`
                ).join('');
                console.log(mealsEl);
              }
          });

          //Clear Search term
          search.value = '';
  }else{
    alert('Plase Enter a search term...');
  }

  console.log(term);
}


//Fetch meal by ID
function getMealById(mealID){

  fetch(`https://www.themealdb.com/api/json/v1/1/lookup.php?i=${mealID}`)
  .then(res => res.json())
  .then(data => {

    const meal = data.meals[0];
    addMealToDOM(meal);

  });

}

//Fetch random meal
function getRandomMeal(){
  //Clear meals and heading
  mealsEl.innerHTML = '';
  resultHeading.innerHTML = '';

  fetch(`https://www.themealdb.com/api/json/v1/1/random.php`)
    .then(res => res.json())
    .then(data => {
      
      const meal = data.meals[0];
      addMealToDOM(meal);

    })
    .catch(err => console.log(err));

}

//Add meal to THe DOM
function addMealToDOM(meal){

  let ingredients = [];
  console.log(meal);

  for(let i = 0; i <= 20; ++i){
    console.log(meal[`strIngredient${i}`]);
    if(meal[`strIngredient${i}`]){
      ingredients.push(`${meal[`strIngredient${i}`]} - ${meal[`strMeasure${i}`]}`);
      
    }
  }
  console.log(ingredients);
  single_mealEl.innerHTML = `
  <div class="single-meal">
  <h1>${meal.strMeal}</h1>
  <img src="${meal.strMealThumb}" alt="${meal.strMeal}">
  <div class="single-meal-info">
    ${meal.strCategory ? `<p>${meal.strCategory}</p>` : ''}
    ${meal.strArea ? `<p>${meal.strArea}</p>` : ''}

  </div>
  <div class="main">
    <p>
      ${meal.strInstructions}
    </p>
    <h2>Ingredients</h2>
    <ul>
      ${ingredients.map(ing => `<li>${ing}</li>`).join('')}
    </ul>
  </div>
</div>


  `;
}



//Event LIsteners
submit.addEventListener('submit', searchMeal);

mealsEl.addEventListener('click', (e) => {

  const mealInfo = e.path.find( item => {

    if(item.classList){
      return item.classList.contains('meal-info');
    }else{
      return false;
    }

  });
  if(mealInfo){
    const mealID = mealInfo.getAttribute('data-mealid');
    getMealById(mealID);
  }
});

random.addEventListener('click', getRandomMeal);