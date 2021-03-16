package teatroPrenotazioni;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		Theatre t1 = new Theatre("Olympian", 8, 12);
		t1.getSeats();
		
		if(t1.reserveSeat("H11")){
			System.out.println("Seat reserved please pay");
		}else{
			System.out.println("Sorry Seat taken");
		}
		
		if(t1.reserveSeat("H11")){
			System.out.println("Seat reserved please pay");
		}else{
			System.out.println("Sorry Seat taken");
		}
		
		List<Theatre.Seat> priceSeats = new ArrayList<>(t1.getSeats());
		priceSeats.add(t1.new Seat("B00", 13.00));
		priceSeats.add(t1.new Seat("A00", 13.00));
		
		Collections.sort(priceSeats, Theatre.PRICE_ORDER);
	}

}
