import { Component, OnInit } from '@angular/core';
import { User } from '../../models/user'

@Component({
  selector: 'app-user',
  //template: '<h2>John Doe</h2>'
  templateUrl:'./user.component.html',
  styleUrls: ['./user.component.css']
  /* styles: [
    `h2: {
      color: blue;
    }
    `
  ] */

})

export class UserComponent implements OnInit {
  //Properties
  /*firstName: string;
  lastName:string;
  age: number;

  address;

  //Può essere qualsiasi tipo
  foo: any;

  hasKids: boolean;

  numberArray: number[];

  stringArray: string[];

  mixedArray: any[];

  myTuple: [string, number, boolean];

  unusable: void;

  u: undefined;

  n: null;
  */
  user: User;



  //Constructor
  constructor(){
    /*this.firstName = 'John';
    this.lastName = 'Doe';
    this.age = 30;
    this.address = {
      street : '50 Main St.',
      city: 'Boston',
      state: 'MA'
    };

    this.foo = 3.14;
    this.hasKids = true;

    this.numberArray = [1,2,3,4];
    this.stringArray = ["Hello", "World"];
    this.mixedArray = [1, "Hello", true, null];
    //NON Posso aggiungere anche altri elementi
    this.myTuple = ['hello', 1, true];
    console.log('Hello from Constructor');

    this.unusable = undefined;
    this.n = null;

    console.log(this.addNumbers(5,2));

    //this.sayHello();
    //console.log(this.age);
    //this.hasBirthDay();
    //console.log(this.age);
    */

    
    
  }
  //Methods
  /*
  sayHello(){
    console.log(`Hello ${this.firstName}`);
  }

  hasBirthDay(){
    this.age += 1;
  }

  showAge() {
    return this.age;
  }

  addNumbers(num1: number, num2: number): number{
    return num1 + num2;
  }*/

  ngOnInit() {
    this.user = {
      firstName: 'John',
      lastName: 'Doe',
      email: 'John@Doe.com'
    }
  }

}


