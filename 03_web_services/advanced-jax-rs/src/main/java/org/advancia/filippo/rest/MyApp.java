package org.advancia.filippo.rest;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

//Questo metodo è alternativo alla configuazione della JAXRS servlet nel web.xml
//Che per lo sviluppo è perfetto.
//Basta lanciare il progetto dentro un container come Tomcat
@ApplicationPath("webapi")
public class MyApp extends Application{
	//Tuttel le classi con @Path nel classpath verranno incluse
	

}
