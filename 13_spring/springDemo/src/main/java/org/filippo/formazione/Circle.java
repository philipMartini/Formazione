package org.filippo.formazione;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

//Questa annotazione definisce la classe come Spring bean di nome circle al posto di creare il bean nell'xml
//Ovviamente il bean rimane unico non posso definirne di piu come nell'xml
@Component
public class Circle implements Shape, ApplicationEventPublisherAware {
	
	
	private Point center;
	//@Autowired
	private MessageSource message;
	private ApplicationEventPublisher publisher;
	
	

	public MessageSource getMessage() {
		return message;
	}

	
	public void setMessage(MessageSource message) {
		this.message = message;
	}


	public Point getCenter() {
		return center;
	}


	//Questo dato membro NON puo essere nullo il checking viene fatto da un beanPostProcessor di Spring
	//Che va dichiarato nella conf xml
	//@Required
	
	//Anche in questo caso serve un post processor per effettuare autowiring
	//Va prima per Type, se ci sono piu bean dello stesso tipo va per nome.
	//@Autowired
	//Oppure uso un qualifier che posso specificare nell xml
	//@Qualifier("circleRelated")
	
	//Injection by name cerca un bean con nome pointC
	//@Resource(name = "pointC")
	public void setCenter(Point center) {
		this.center = center;
	}

	@PostConstruct
	public void initializeCircle() {
		System.out.println("Init of Circle");
	}
	
	@PreDestroy
	public void destroyCircle() {
		System.out.println("Destroy Circle");
	}

	@Override
	public String toString() {
		return "Circle [center=" + center + "]";
	}




	public void draw() {
		System.out.println(this + this.message.getMessage("greeting", null, "Default Greeting", null));
		this.publisher.publishEvent(new DrawEvent(this));

	}


	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		this.publisher = applicationEventPublisher;
		
	}

}
