package teatroPrenotazioni;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;

public class Theatre {
	
	private final String theatreName;
	private List<Seat> seats;
	
	static final Comparator<Seat> PRICE_ORDER  = new Comparator<Seat>(){
		
		@Override
		public int compare(Seat s1, Seat s2){
			if(s1.getPrice() < s2.getPrice())
				return -1;
			else if( s1.getPrice() > s2.getPrice())
				return 1;
			else
				return 0;
		}
	};
	
	
	public Theatre(String theatreName, int numRows, int seatsPerRow){
		this.theatreName = theatreName;
		this.seats = new ArrayList<>();
		
		int lastRow = 'A' + (numRows - 1);
		for(char row = 'A'; row <= lastRow; ++row){
			for(int seatNum = 1; seatNum <= seatsPerRow; ++seatNum){
				double price = 12.0;
				if(row < 'D' && seatNum >= 4 && seatNum <= 9)
					price = 14.0;
				if(row > 'F' || (seatNum < 4 || seatNum > 9))
					price = 7.0;
				Seat seat = new Seat(row + String.format("%02d", seatNum), price);
				this.seats.add(seat);
			}
		}
		
	}
	
	public String getTheatreName(){
		return theatreName;
	}
	
	public boolean reserveSeat(String seatNumber){
		Seat requestedSeat = new Seat(seatNumber, 0);
		//Il comparator object è null perche viene usato il compareTo implementato nella classe Seat
		int foundSeat = Collections.binarySearch(this.seats, requestedSeat, null);
		
		if(foundSeat >= 0){
			return this.seats.get(foundSeat).reserve();
		}else{
			System.out.println("There is no seat " + seatNumber);
			return false;
		}
		
	}
	
	
	public Collection<Seat> getSeats(){
		return this.seats;
	}
	
	//Pubblica ai fini di testing
	public class Seat implements Comparable<Seat>{
		
		private final String seatNumber;
		private double price;
		private boolean reserved;
		
		public Seat(String seatNumber, double price){
			this.seatNumber = seatNumber;
			this.price = price;
		}
		
		public boolean reserve(){
			if(!this.reserved){
				this.reserved = true;
				System.out.println("Seat " + seatNumber + " Reserved");
				return true;
			}else{
				return false;
			}
		}
		
		public boolean cancel(){
			if(this.reserved){
				this.reserved = false;
				System.out.println("Seat " + seatNumber + " Cancelled");
				return true;
			}else{
				return false;
			}
		}
		
		public String getSeatNumber(){ return this.seatNumber; }
		
		public double getPrice() { return this.price; }


		@Override
		public int compareTo(Seat seat) {
			return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());
		}
		
	}
	
	
}
