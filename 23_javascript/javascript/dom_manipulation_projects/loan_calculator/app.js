//Listen for submit

document.getElementById('loan-form').addEventListener('submit', function(e){
    
    //Hide results
    document.getElementById('results').style.display = 'none';
   document.getElementById('loading').style.display = 'block'
    setTimeout(calculateResults, 2000);
    e.preventDefault();
});

//Calculate Results
function calculateResults(e){
    
    console.log('calculating....');

    //UI variables
    const amount = document.getElementById('amount');
    const interest = document.getElementById('interest');
    const years = document.getElementById('years');
    const monthlyPayment = document.getElementById('monthly-payment');
    const totalPayment = document.getElementById('total-payment');
    const totalInterest = document.getElementById('total-interest');


    const principal  = parseFloat(amount.value);
    const calculatedInterests = parseFloat(interest.value) / 100 / 12;
    const calculatedPayments = parseFloat(years.value) * 12;
    
    //Compute monthly payments
    const x = Math.pow(1 + calculatedInterests, calculatedPayments);
    const monthly = (principal* x * calculatedInterests)/(x -1);
    
    if(isFinite(monthly)){
        monthlyPayment.value = monthly.toFixed(2);
        totalPayment.value = (monthly * calculatedPayments).toFixed(2);
        totalInterest.value = ((monthly * calculatedPayments) - principal).toFixed(2);
        document.getElementById('results').style.display = 'block';
        document.getElementById('loading').style.display = 'none';
        
    }else{

        showError('Please check your Input');
    }
}


//Show Error
function showError(message){

    document.getElementById('results').style.display = 'none';
    document.getElementById('loading').style.display = 'none';
        

    //Get elements
    const card = document.querySelector('.card');
    const heading = document.querySelector('.heading');

    //Create a div
    const errorDiv = document.createElement('div');
    errorDiv.className = 'alert alert-danger';
    errorDiv.appendChild(document.createTextNode(message));


    //Insert error above heaing
    card.insertBefore(errorDiv, heading);

    //Clear error after 3 sec
    setTimeout(clearError, 3000);


}



function clearError(){
    document.querySelector('.alert').remove();
}