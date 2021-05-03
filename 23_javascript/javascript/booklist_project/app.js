//Book constructor
function Book(title, author, isbn){
    this.title = title;
    this.author = author;
    this.isbn = isbn;
}


//UI Constructor

function UI() {


    UI.prototype.addBookToList = function(book) {
       const list = document.getElementById('book-list');
       //Create tr
       const row = document.createElement('tr');
       //Insert cols
       row.innerHTML = `
        <td>${book.title}</td>
        <td>${book.author}</td>
        <td>${book.isbn}</td>
        <td><a href="#" class="delete">X</a></td>
        `;
        
        list.appendChild(row);
    };

    UI.prototype.deleteBook= function(target){
        if(target.className === 'delete'){
            //Da <a> => <td> => <tr> che è quello che dobbiamo cancellare
            target.parentElement.parentElement.remove();
        };
    }


    UI.prototype.clearFields = function(){
        document.getElementById('title').value = '';
        document.getElementById('author').value = '';
        document.getElementById('isbn').value = '';
    };

    UI.prototype.showAlert = function(message, className){
        const div = document.createElement('div');
        div.className = `alert ${className}`;
        div.innerText = message;

        const container = document.querySelector('.container');
        const form = document.querySelector('#book-form');
        container.insertBefore(div, form);

        //disapper after 3 secs
        setTimeout(function(){
            document.querySelector('.alert').remove();
        }, 3000);
    };
}


//Event Listeners

document.getElementById('book-form').addEventListener('submit',
    function(e){

        //Get form values
        e.preventDefault();
        const title = document.getElementById('title').value,
            author = document.getElementById('author').value,
            isbn = document.getElementById('isbn').value;
        //Instantiate the book
        const book = new Book(title, author, isbn);

        //Instantiate UI
        const ui = new UI();

        //Validate
        if(title === '' || author === '' || isbn === ''){
            //Error alter
            ui.showAlert('Please Fill In All the Fields', 'error')

        }else{

            //Add book to list
            ui.addBookToList(book);

            ui.showAlert('Book Added', 'success');

            //Clear fields
            ui.clearFields();
        }

       // console.log(book);

    });



//Event listener for delete (Using event delegation)
document.getElementById('book-list').addEventListener('click',
    function(e){
        e.preventDefault();

        const ui = new UI();
        ui.deleteBook(e.target);

        ui.showAlert('Book Removed', 'success');

    }
);
