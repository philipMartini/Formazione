import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { of } from 'rxjs';

import { User } from '../models/user';


@Injectable({
  providedIn: 'root'
})
export class UserService {

  users: User[];

  data: Observable<any>


  constructor() {
    this.users = [
      {
        firstName: 'John',
        lastName: 'Doe',
        email: 'John@Doe.com',
        isActive: true,
        registered: new Date('01/02/2018 08:30:00'),
        hide: true
      },

      {
        firstName: 'Kevin',
        lastName: 'Bar',
       isActive: false,
       email: 'Kevin@Bar.com',
        registered: new Date('03/02/2019 08:30:00'),
        hide: true

      },

      {
        firstName: 'Jen',
        lastName: 'Foo',
        email: 'Jen@Foo.com',
        isActive: true,
        
        registered: new Date('04/02/2020 08:30:00'),
        hide: true
      },
      

    ]; 
   }


   addUser(user: User){
     this.users.unshift(user);
   }


   getUsers(): Observable<User[]>{
     return of(this.users);
   }

   getData() {
     this.data = new Observable(observer => {
       setTimeout(() => {
         observer.next(1);
       }, 1000);


       setTimeout(() => {
        observer.next(2);
      }, 2000);

      setTimeout(() => {
        observer.next(3);
      }, 3000);

      setTimeout(() => {
        observer.next(4);
      },4000);
     
     
     
      });

      return this.data;
     
   }
}
