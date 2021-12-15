package strategy;


import java.util.LinkedList;

//Context 
public class PrintService {
	
	private OrderPrinter printer;
	
	//Sarà il client a scegliere la strategy concreta da utilizzare
	//Sarebbe meglio avere una strategy di default
    public PrintService(OrderPrinter printer) {
    	this.printer = printer;
    }
    
    //Se gli argomenti fossero molti vanno inseriti nel Context e passarlo direttamente
    //Alla strategy
    public void printOrders(LinkedList<Order> orders) {
        this.printer.print(orders);
    }
}
