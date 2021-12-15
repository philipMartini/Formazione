package org.filippo.formazione.annotation;

import org.filippo.formazione.annotation.scan.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//config();
		configScan();
	}
	
	private static void config() {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		User u = context.getBean("userBean", User.class);
		System.out.println(u.getUserInfo());
	}
	
	private static void configScan() {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfigScan.class);
		Role r = context.getBean("roleBean", Role.class);
		System.out.println(r.getRole());
	}

}
