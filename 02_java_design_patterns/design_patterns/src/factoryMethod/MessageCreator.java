package factoryMethod;

import factoryMethod.message.Message;

/**
 * This is our abstract "creator". 
 * The abstract method createMessage() has to be implemented by
 * its subclasses.
 */
public abstract class MessageCreator {

	public Message getMessage() {
		Message msg = createMessage();
		//Additional processing before returning the object
		msg.addDefaultHeaders();
		msg.encrypt();
		
		return msg;
	}
	
	//Factory Method => sub classes will provide implementation of the fact method
	public abstract Message createMessage();
}
