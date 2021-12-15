package org.filippo.formazione;

import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Triangle implements ApplicationContextAware, BeanNameAware, Shape{
	
//	private String type;
//	private int height;
//	
//	//Constructor injection
//	public Triangle(String type) {
//		this.type = type;
//	}
//	
//	//Questo costruttore potrebbe creare problemi dato che entrambi i costruttori hanno un argomento
//	//Ma come fa Spring a distingueli partendo dal tag constructor arg? devo aggiungere il type nel tag constructor arg
//	public Triangle(int height) {
//		this.height = height;
//	}
//	
//	public Triangle(String type, int height) {
//		super();
//		this.type = type;
//		this.height = height;
//	}
//
//
//
//	public String getType() {
//		return type;
//	}
//
//
//	//Spring usa il setter per inizializzare il valore di type scritto nel property tag => Setter injection
//	public void setType(String type) {
//		this.type = type;
//	}
//	
//	
//
//
//	public int getHeight() {
//		return height;
//	}
//
//
//	public void setHeight(int height) {
//		this.height = height;
//	}
//
//
//	public void draw() {
//		System.out.println(getType() + " Triangle drawn of Height: " + this.getHeight());
//	}
	
	private Point pointA;
	private Point pointB;
	private Point pointC;
	
	private List<Point> points;
	
	//Quando il container si inizializza questo dato membro viene settato automaticamente SE la classe implmenta
	//L'interfaccia ApplicationContextAware
	private ApplicationContext context = null;
	private String beanName = null;
	
	
	
	
	public Point getPointA() {
		return pointA;
	}
	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}
	public Point getPointB() {
		return pointB;
	}
	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}
	public Point getPointC() {
		return pointC;
	}
	public void setPointC(Point pointC) {
		this.pointC = pointC;
	}
	
	
	public List<Point> getPoints() {
		return points;
	}
	public void setPoints(List<Point> points) {
		this.points = points;
	}
	@Override
	public String toString() {
		return "Triangle [pointA=" + pointA + ", pointB=" + pointB + ", pointC=" + pointC + "]";
	}
	public void draw() {
		System.out.println(this);
	}
	
	public void drawPoints() {
		for(Point p : this.points)
			System.out.println(p);
	}
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.context = applicationContext;
		
	}
	public void setBeanName(String name) {
		this.beanName = name;
		
	}
	
//	//Dopo che le properties sono state inizializzate viene chiamato questo metodo 
	//La classe deve implementare InitializingBean
//	public void afterPropertiesSet() throws Exception {
//		System.out.println("InitializingBean init method call for Triangle");
//		
//	}
//	
//	//Chiamato prima della distruzione del bean
	//La classe deve implementare DisposableBean
//	public void destroy() throws Exception {
//		System.out.println("DesposableBean destroy method call for Triangle");
//		
//	}
	
	public void myInit() {
		System.out.println("My init method call for Triangle");
	}
	
	public void myDestroy() {
		System.out.println("My destroy method call for Triangle");
	}
	
}
