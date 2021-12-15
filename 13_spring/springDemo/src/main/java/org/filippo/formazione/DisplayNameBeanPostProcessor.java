package org.filippo.formazione;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

//Questa classe viene usata come BeanPostProcessor ossia una classe il cui metodo xxxx viene chiamato
//PER OGNI inizializzazione di un nuovo bean.
//Utile quando si vuole far girare codice quando un bean viene inizializzato ma non si vuole scrivere un init
//All'interno della classe stessa
public class DisplayNameBeanPostProcessor implements BeanPostProcessor{

	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("In before Initialization Method. Bean name is " + beanName);
		return bean; //IMPORTANTE restituire il bean
		
	}

	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("In After Initialization Method. Bean name is " + beanName);
		return bean; //IMPORTANTE restituire il bean
	}

}
