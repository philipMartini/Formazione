package org.advancia.filippo.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.advancia.filippo.dataOperations.DatabaseOperations;
import org.advancia.filippo.model.ToDo;
import org.advancia.filippo.model.User;
import org.hibernate.Session;

public class CreateAndPopulateTables {

	public static void main(String[] args) {
		
		//create_populate_tables();
		test_search_by_keyword();
		

	}
	
	private static void test_search_by_keyword() {
		User u1 = new User();
		u1.setId(1);
		Collection<ToDo> toDos = DatabaseOperations.searchKeywordInText(u1, "%%");
		for(ToDo t : toDos)
			System.out.println(t.getText());
		
	}

	private static void create_populate_tables() {
		//Crea un po di ToDO
		ToDo t1 = new ToDo();
		t1.setTitle("Hello title");
		t1.setText("Hello Text");
		ToDo t2 = new ToDo();
		t2.setTitle("C++ Title");
		t2.setText("C++ text");
		List<ToDo> firstUserToDo = new ArrayList<>();
		firstUserToDo.add(t1);
		firstUserToDo.add(t2);
		User u1 = new User();
		u1.setUserName("admin");
		u1.setPassword("admin");
		u1.setToDos(firstUserToDo);
		u1.setTodosUser();
		
		
		ToDo t3 = new ToDo();
		t3.setTitle("Third Title");
		t3.setText("Third Text");
		ToDo t4 = new ToDo();
		t4.setTitle("Fourth Title");
		t4.setText("Fourth text");
		List<ToDo> secondUserToDo = new ArrayList<>();
		secondUserToDo.add(t3);
		secondUserToDo.add(t4);
		User u2 = new User();
		u2.setUserName("root");
		u2.setPassword("root");
		u2.setToDos(secondUserToDo);
		u2.setTodosUser();
		
		
		
		//Apro la sessione
		Session session = HibernateUtil.currentSession();
		session.beginTransaction();//Apro la transazione
		
		session.save(u1); //Avendo attivato il cascading basta salvare gli utenti e verranno salvati anche i ToDos
		session.save(u2);
		
		session.getTransaction().commit();//Quando ho finito commito e....
		HibernateUtil.closeSession();//Chiudo la sessione
	}

}
