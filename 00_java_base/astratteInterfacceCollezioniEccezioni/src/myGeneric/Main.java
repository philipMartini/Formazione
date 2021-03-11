package myGeneric;

public class Main {

	public static void main(String[] args) {
		FootballPlayer p1 = new FootballPlayer("Joe");
		BaseballPlayer p2 = new BaseballPlayer("Pat");
		SoccerPlayer p3 = new SoccerPlayer("Beackham");
		
		Team<FootballPlayer> t1 = new Team<>("Adelaide Crows");
		t1.addPlayer(p1);
		

	}

}
