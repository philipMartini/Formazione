package teatroPrenotazioni;

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
	}

}
