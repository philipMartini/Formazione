package org.advancia.filippo.model;

import java.io.Serializable;

/**
 * This one is the DAO used to
 * connect with the Database
 * @author Enrico
 */
@SuppressWarnings("serial")
public class Person implements Serializable{
	private String firstName;
	private String lastName;
	private int age;
	private int id;

	public Person(int id, String firstName, String lastName, int age) {
		setId(id);
		setFirstName(firstName);
		setLastName(lastName);
		setAge(age);
	}

	public void setFirstName(String fn){
		this.firstName = fn;
	}

	public void setLastName(String ln){
		this.lastName = ln;
	}

	public void setAge(int a){
		this.age = a;
	}

	public void setId(int i){
		this.id = i;
	}

	public String getFirstName(){
		return firstName;
	}

	public String getLastName(){
		return lastName;
	}

	public int getAge(){
		return age;
	}

	public int getId(){
		return id;
	}


}
