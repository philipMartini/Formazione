package org.filippo.formazione;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {
	
	public static void main(String[] args) {
		
		//xmlConfig();
		//annotationCongig();
		//xmlConfigVariabili();
		//dipendenzaBean();
		//dependsonBean();
		//autowire();
		//scopes();
		//property();
		//propertyContext();
		//annotationBeans();
		annotationBeansAutowire();
	}
	
	
	public static void xmlConfig() {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		//Passo al container id della classe scritto nel file xml e classe da istanziare
		OrdineService ordine = context.getBean("ordine", OrdineService.class);
		ProdottoService prodotto = context.getBean("prodotto", ProdottoService.class);
		System.out.println(ordine.hello());
		System.out.println(prodotto.getProdotto());
		
		//Richiede la distruzione esplicita del bean specificato
		BeanDefinitionRegistry registry = (BeanDefinitionRegistry) context.getAutowireCapableBeanFactory();
		registry.removeBeanDefinition("ordine");
		registry.removeBeanDefinition("prodotto");
		
	}
	
	public static void annotationCongig() {
		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		OrdineService ordine = context.getBean("ordineServiceAnnotation", OrdineService.class);
		System.out.println(ordine.hello());
		
	}
	
	public static void xmlConfigFactory() {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans-factory.xml");
		
		//Passo al container id della classe scritto nel file xml e classe da istanziare
		OrdineService ordine = context.getBean("ordine", OrdineService.class);
		System.out.println(ordine.hello());
	}
	
	public static void xmlConfigVariabili() {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans-variabili.xml");
		
		ClienteService cliente = context.getBean("cliente", ClienteService.class);
		OrdineService ordine = context.getBean("ordine", OrdineService.class);
		
		System.out.println(cliente.getHelloMessage());
		String[] prodotti = ordine.listaProdotti();
		for(String prod : prodotti) {
			System.out.println(prod);
		}
	}
		
		public static void xmlConfigTipoVariabili() {
			ApplicationContext context = new ClassPathXmlApplicationContext("beans-variabili.xml");
			
			//Se non conosco il tipo del bean che voglio creare posso usare questo metodo
			Class<?> type = context.getType("cliente");
			System.out.println(type.getName());
		
	}
		
		public static void dipendenzaBean() {
			ApplicationContext context = new ClassPathXmlApplicationContext("beans-costruttore.xml");
			
			FatturaService fattura = context.getBean("fattura", FatturaService.class);
			System.out.println(fattura.stampaFattura());
		}
		
		public static void dependsonBean() {
			ApplicationContext context = new ClassPathXmlApplicationContext("depends-on-beans.xml");
			BeanA a = context.getBean("A", BeanA.class);
			a.getMessage();
		}
		
		public static void autowire() {
			ApplicationContext context = new ClassPathXmlApplicationContext("beans-autowire.xml");
			BeanAutoB autoB = context.getBean("autoB", BeanAutoB.class);
			System.out.println(autoB.hello());
			BeanAutoD autoD = context.getBean("autoD", BeanAutoD.class);
			System.out.println(autoD.hello());
			BeanAutoE autoE = context.getBean("autoE", BeanAutoE.class);
			System.out.println(autoE.hello());
		}
		
		public static void scopes() {
			
			ApplicationContext context = new ClassPathXmlApplicationContext("beans-scope.xml");
			//Qui viene restituita SEMPRE la stessa istanza
			BeanSingleton s1 = context.getBean("beanSingleton", BeanSingleton.class);
			s1.setMessage("Hello From Bean Singleton!");
			System.out.println(s1.hello());
			BeanSingleton s2 = context.getBean("beanSingleton", BeanSingleton.class);
			System.out.println(s2.hello());
			
			//Qui per ogni richiesta viene istanziato un nuovo bean
			BeanPrototype p1 = context.getBean("beanPrototype", BeanPrototype.class);
			p1.setMessage("Hello From Bean Proto!");
			System.out.println(p1.hello());
			
			BeanPrototype p2 = context.getBean("beanPrototype", BeanPrototype.class);
			System.out.println(p2.hello());
			
		}
		
		public static void property() {
			ApplicationContext context = new ClassPathXmlApplicationContext("beans-property.xml");
			BeanProperty pr = context.getBean("prop", BeanProperty.class);
			System.out.println(pr.hello());
			
		}
		
		public static void propertyContext() {
			ApplicationContext context = new ClassPathXmlApplicationContext("beans-property-context.xml");
			BeanProperty pr = context.getBean("prop", BeanProperty.class);
			System.out.println(pr.hello());
			
		}
		
		public static void annotationBeans() {
			ApplicationContext context = new ClassPathXmlApplicationContext("beans-annotation.xml");
			BeanAnnotation bean = context.getBean("annot", BeanAnnotation.class);
			bean.hello();
			
		}
		
		public static void annotationBeansAutowire() {
			ApplicationContext context = new ClassPathXmlApplicationContext("beans-annotation.xml");
			org.filippo.formazione.autowire.OrdineService bean = context.getBean("ordine", org.filippo.formazione.autowire.OrdineService.class);
			System.out.println(bean.getOrdineInfo());
			//Richiede la distruzione esplicita del bean specificato
			BeanDefinitionRegistry registry = (BeanDefinitionRegistry) context.getAutowireCapableBeanFactory();
			registry.removeBeanDefinition("ordine");
			
		}
}
