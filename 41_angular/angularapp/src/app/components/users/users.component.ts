import { Component, OnInit, ViewChild } from '@angular/core';

import { User } from '../../models/user';

import { UserService } from '../../services/user.service';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {

  //Necessario per il data binding con il form
  //addUser
  user: User = {
    firstName: '',
    lastName: '',
    email: ''

  };

  users: User[];

  showExtended: boolean = false;
  //Se i dati venissero da una api esterna
  loaded: boolean = false;

  enableAdd: boolean = false;

  currentClasses = {};

  currentStyles = {};

  showUserForm: boolean = false;
  
  @ViewChild('userForm')
  form: any;

  data: any;

//In questo modod viene injectato il data Service
  constructor(private userService: UserService) {}

  ngOnInit(): void {

    this.userService.getData().subscribe( data => {console.log(data)} );

    //Simulazione del caricamento api
    this.userService.getUsers().subscribe( users => { 
      this.users = users;
      this.loaded = true;

     } );
      

     
   

    //Usa questo metodo per AJAX e chiamate ai servizi
    //Inizializzazione delle properties
    console.log('init....');

  }

/*   addUser(): void {
    this.user.isActive = true;
    this.user.registered = new Date();
    this.users.unshift(this.user);
    this.user = {
      firstName: '',
      lastName: '',
      age: null,
      address: {
        street:'',
        city: '',
        state: ''
      }
    };
  } */

  fireEvent(e) {
    console.log(e.target.value);
    console.log(e.type);
  }
/* 
  toggleHide(user: User){
    user.hide = !user.hide;
  } */

  onSubmit({value, valid}: {value: User, valid: boolean}){

    if(!valid){
      console.log('Form is Not Valid');
    }else{
      value.isActive = true;
      value.registered = new Date();
      value.hide = true;
      this.userService.addUser(value)
      this.form.reset();
    }
    
    
  }
}
