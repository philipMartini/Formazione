package myGeneric;

import java.util.ArrayList;
import java.util.List;

public class Team<T extends Player> implements Comparable<Team<T>>{
	
	private String name;
	private int played = 0;
	private int won = 0;
	private int lost = 0;
	private int tied = 0;
	
	private List<T> members;
	
	public Team(String name){
		this.name = name;
		this.members = new ArrayList<>();
	}
	
	public String getName() { return this.name; }
	
	public boolean addPlayer(T player) {
		if(!this.members.contains(player))
			return this.members.add(player); 
		return false;
	}
	
	public int numPlayers() { return this.members.size(); }
	
	public void matchResult(Team<T> opponent, int ourScore, int theirScore){
		if(ourScore > theirScore)
			++this.won;
		else if(ourScore < theirScore)
			++this.lost;
		else
			++this.tied;
		++this.played;
		if(opponent != null){
			opponent.matchResult(null, theirScore, ourScore);
		}
	}
	
	public int ranking(){ return (won * 2 ) + tied;}

	@Override
	public int compareTo(Team<T> o) {
		if(this.ranking() < o.ranking())
			return 1;
		else if(this.ranking() > o.ranking())
			return -1;
		else
			return 0;
	}

}
