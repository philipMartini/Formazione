package org.advancia.filippo.data;

import java.util.List;

import org.advancia.filippo.data.entities.FourWheeler;
import org.advancia.filippo.data.entities.TwoWheeler;
import org.advancia.filippo.data.entities.UserDetails;
import org.advancia.filippo.data.entities.Vehicle;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class Application {
	
	public static void main(String[] args) {
		UserDetails user = new UserDetails();
		//user.setUserId(1);
		user.setUserName("First User");
		
		
		
		
		FourWheeler v2 = new FourWheeler();
		v2.setVehicleName("Ferrari");
		v2.setSteeringWheel("Ferrari Steeringwheel");
		
		
		TwoWheeler v3 = new TwoWheeler();
		v3.setVehicleName("Ducati Bike");
		v3.setSteeringHandle("Ducati Handle");
		//v1.getUsers().add(user);
		//v2.getUsers().add(user);
		
		//user.getVehicles().add(v1);
		//user.getVehicles().add(v2);
		
		/*Address addr1 = new Address();
		addr1.setCity("Milano");
		addr1.setState("Italy");
		addr1.setStreet("via fasulla 123");
		addr1.setPincode("7777");
		
		Address addr2 = new Address();
		addr2.setCity("Berlin");
		addr2.setState("Germany");
		addr2.setStreet("Ich Fasullen Sthict");
		addr2.setPincode("313");
		
		user.getListOfAddresses().add(addr1);
		user.getListOfAddresses().add(addr2);
		
		user.setJoinedDate(new Date());
		user.setDescription("Description First User");*/
		
		
		//Questo è un singleton e va inizializzato Una sola volta per APP.....
		SessionFactory sessionFactory = 
				new Configuration().configure().buildSessionFactory();
		//Session session = sessionFactory.openSession();
		//Linizio della transizione definisce l'unità di lavoro proprio come le transizioni nel DB
		//Volendo potrei fare molte più azioni......
		//session.beginTransaction();
		//session.save(user);
		
		//session.save(v2);
		//session.save(v3);
		
		//DELETE
		//Vehicle v = new Vehicle();
		//v.setVehicleId(2);
		//v.setVehicleName("UPDATED VEHICLE NAME");
		//session.update(v); // Passo l'oggetto aggiornato
		//session.delete(v);//Passo l'oggetto da eliminare settando anche solo la PK
		
		//session.save(v); //QUESTO RENDE L'OGGETTO PERSISTENT E QUINDI....	
		
		//v.setVechicleName("Other Update"); //....QUALSIASI MODIFICA DENTRO UNA TRANSACTION
											//SI RIFLETTE COME UPDATE NEL DB
		//Quando ho terminato committo....
		//session.getTransaction().commit();
		
		//E chiudo la sessione
		//session.close();//UNA VOLTA CHIUSA LA SESSIONE L'OGGETTO ENTRA NELLO STATO DETACHED 
						//E HIBERNATE NON TIENE TRACCIA DEI CAMBIAMENTI
		
		
		//Ora recuperiamo quello che abbiamo inserito
		/*user = null;
		session = sessionFactory.openSession();
		session.beginTransaction();
		user = (UserDetails) session.get(UserDetails.class, 5); //La classe da recuperare e la PK
		//Il comportamento di def non recupera la embedded list di Address, ma solo gli attriubuti di primo livello
		
		//session.close();//Se chiudo la sessione il risultato della stampa sarà un'eccezione
							//Perchè il proxy non riesce a fetchare i valori
		
		
		//Ma se chiamo....
		//System.out.println(user.getListOfAddresses().size()); //QUI viene effettuata un'altra query che recupera
		//Gli indirizzi dell'utente che abbiamo recuperato => *****LAZY INITIALIAZATION********
		//Quresto viene effettuato utilizzando una ProxyClass che è la vera classe che viene
		//Restituita dalla session.get, questa classe è trasparente per il developer
		//Ma le chiamate ai metodi vengono effettuate al proxy NON alla classe reale => 
		//Quando chiamiamo un getListOf... chiamiamo il metodo del proxy che fetcha i valory
		//dal db e popola la lista
		session.close();
		System.out.println(user);
		
		 
		
		
		//......E CHIUSO UNA SOLA VOLTA PER APPLICATION
		//session.getSessionFactory().close();*/
		
		//FROM DETACHED TO PERSISTENT il caso d'uso è quello del recupero del record dal db
		//attesa input utente e update del db => non si può aspettare l'input dentro una transazione
		//bisogna.....
		/*Session session = sessionFactory.openSession();
		session.beginTransaction();
		Vehicle v7 = (Vehicle) session.get(Vehicle.class, 7);
		session.getTransaction().commit();
		session.close(); //QUi l'oggetto entra nello stato detached
		
		//ora faccio gli update
		v7.setVehicleName("THE USER TOOK HIS TIME TO UPDATE");
		//E riapro la sessione per salvare la update
		session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(v7);//QUI l'oggetto è persistent quindi posso anche fare altre update..
		v7.setVehicleName("Another persistent update");
		session.getTransaction().commit();
		session.close();
		
		/****HQL******
		//Nella select tutte le funzioni di SQL della select continuano a funzionare in HQL
		session = sessionFactory.openSession();
		session.beginTransaction();
		
		//Table => Class e column => field member
		
		String  minVehicleId = "5";
		String vehicleName = "Vehicle 7";
		//Usare i parametri ci tutela anche da SQLIjection
		//Posso usare anonimus params
		//Query query = session.createQuery("select vehicleName from Vehicle where vehicleId > ? and vehicleName = ?");
		
		//Qui la posizione dei parametri parte da 0
		//query.setInteger(0, Integer.parseInt(minVehicleId));
		//query.setString(1, vehicleName);
		//Oppure dare un nome ai parametri
		//Query query = session.createQuery("select vehicleName from Vehicle where vehicleId > :vehicleId and vehicleName = :vName");
		//query.setInteger("vehicleId", Integer.parseInt(minVehicleId));
		
		
		//Query query = session.createQuery("select vehicleName from Vehicle"); //Se avessi piu di un campo su cui fare la select 
														//Posso fare ad esempio (select new map(vehicleId, vehicleName) from Vehicle)
								//In questo modo ho una lista di mappe ognuna delle quali contiene id e name
		//Pagination in Hibernate
		//query.setFirstResult(5);//Inizia a recuperare dal quinto record
		//query.setMaxResults(4);//La dimensione della pagina è 4
		
		/*Query query = session.getNamedQuery("Vehicle.byId");
		query.setInteger(0, 3);
		List<Vehicle> vehicles = query.list();//Lista di tutti i record recuperati e non recordSet come in JDBC
		session.close();
		System.out.println("LIST SIZE IS " + vehicles.size());
		for(Vehicle v : vehicles)
			System.out.println(v);
		
		/****Criteria API****
		Criteria criteria = session.createCriteria(Vehicle.class)
						.setProjection(Projections.property("vehicleName"))//Se non voglio tutto l'oggetto
						.addOrder(Order.desc("vehicleId")); //Order by clause
		//Criteria è molto simile alla WHERE
		//aggiungo una restrizione di uguaglianza
		criteria.add(Restrictions.eq("vehicleName", "Vehicle 7"))
				.add(Restrictions.gt("vehicleId", 5));
		vehicles = criteria.list();//Lista di tutti i record recuperati e non recordSet come in JDBC
		session.close();
		System.out.println("LIST SIZE IS " + vehicles.size());
		for(Vehicle v : vehicles)
			System.out.println(v);
		
		//Query by Example
		Vehicle veh = new Vehicle();
		//Setto tutte le prop che servono
		veh.setVehicleId(7);//NEgli example le PK vengono ignorate, vengono considerate solo le properties
		veh.setVehicleName(vehicleName);
		Example example = Example.create(veh);//Creo example object
		criteria = session.createCriteria(Vehicle.class)
								.add(example);*/
		
		/*******CACHEING********/
		//Configurazione cache che è valida tra diverse sessioni
		 Session session1 = sessionFactory.openSession();
		 session1.beginTransaction();
		 
		 Vehicle vh1 = (Vehicle) session1.get(Vehicle.class, 1);
		 session1.getTransaction().commit();
		 session1.close();
		 
		 Session session2 = sessionFactory.openSession();
		 session2.beginTransaction();
		 
		 Vehicle vh2 = (Vehicle) session2.get(Vehicle.class, 1);
		 session2.getTransaction().commit();
		 session2.close();
		
	}
		
	
}
