package org.filippo.formazione;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

public class DrawingApp {

	public static void main(String[] args) {
		//QUesto è il modo classico di creare dei bean....
		//Triangle t1 = new Triangle();
		
		//Ora usiamo la beanFactory di Spring
		//BeanFactory factory = new XmlBeanFactory(new FileSystemResource("spring.xml"));
		//Passo il bean-id che ho scritto nel file di configurazione xml
		//QUesto oggetto è creato nello Spring container e otteniamo il reference tramite
		//La bean factory
		//Triangle t1 = (Triangle) factory.getBean("triangle");
		
		//In ogni caso è meglio usare ApllicationContext che ha le stesse funzioni della beanFactory
		//E molte altre
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		//Una volta registrato il metodo la destroy è chiamata su ogni bean alla chiusura dell'applicazione
		context.registerShutdownHook();
		//Triangle t1 = (Triangle) context.getBean("triangle");
		//Coding to the interface
		Shape shape = (Shape) context.getBean("circle");
		
		
		shape.draw();
		//System.out.println(context.getMessage("greeting", null, "Default Greeting", null));

	}

}
