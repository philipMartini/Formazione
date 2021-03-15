package teatroPrenotazioni;

import java.util.ArrayList;
import java.util.List;

public class Theatre {
	
	private final String theatreName;
	private List<Seat> seats;
	
	public Theatre(String theatreName, int numRows, int seatsPerRow){
		this.theatreName = theatreName;
		this.seats = new ArrayList<>();
		
		int lastRow = 'A' + (numRows - 1);
		for(char row = 'A'; row <= lastRow; ++row){
			for(int seatNum = 1; seatNum <= seatsPerRow; ++seatNum){
				Seat seat = new Seat(row + String.format("%02d", seatNum));
				this.seats.add(seat);
			}
		}
		
	}
	
	public String getTheatreName(){
		return theatreName;
	}
	
	public boolean reserveSeat(String seatNumber){
		Seat requestedSeat = null;
		for(Seat seat: this.seats){
			if(seat.getSeatNumber().equals(seatNumber)){
				requestedSeat = seat;
				break;
			}
		}
		
		if(requestedSeat == null){
			System.out.println("There is no seat: " + seatNumber);
			return false;
		}
		
		return requestedSeat.reserve();
	}
	
	
	public void getSeats(){
		for(Seat seat : seats){
			System.out.println(seat.getSeatNumber());
		}
	}
	
	private class Seat{
		
		private final String seatNumber;
		private boolean reserved;
		
		public Seat(String seatNumber){
			this.seatNumber = seatNumber;
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
		
	}
	
	
}
