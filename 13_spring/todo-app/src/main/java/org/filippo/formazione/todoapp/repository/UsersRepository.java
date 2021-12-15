package org.filippo.formazione.todoapp.repository;

import org.filippo.formazione.todoapp.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<User, String> {

}
