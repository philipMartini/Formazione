package org.filippo.formazione.springbootjpaexample.repository;

import org.filippo.formazione.springbootjpaexample.model.Employee;
import org.springframework.data.repository.CrudRepository;

//Questa è l'interfaccia che permette ai business service di interagire con il DB
public interface EmployeeRepository extends CrudRepository<Employee, Integer>{

}
