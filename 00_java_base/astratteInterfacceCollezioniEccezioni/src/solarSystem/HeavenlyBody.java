package solarSystem;

import java.util.HashSet;
import java.util.Set;

public abstract class HeavenlyBody {
	
	
	private final double orbitalPeriod;
	private final Set<HeavenlyBody> satellites;
	private final Key key;
	
	public enum BodyTypes{
		STAR,
		PLANET,
		DWARF_PLANET,
		MOON,
		COMET,
		ASTEROID
	}
	
	
	public HeavenlyBody(String name, double orbitalPeriod, BodyTypes bodyType){
		this.orbitalPeriod = orbitalPeriod;
		this.key = new Key(name, bodyType);
		this.satellites = new HashSet<>();
	}

	public boolean addSatellite(HeavenlyBody moon){
		return this.satellites.add(moon);
	}
	
	public Set<HeavenlyBody> getSatellites(){
		return new HashSet<>(this.satellites);
	}
	

	public double getOrbitalPeriod() {
		return orbitalPeriod;
	}
	
	public Key getKey(){
		return this.key;
	}
	
	public static Key makeKey(String name, BodyTypes bodyType){
		return new Key(name, bodyType);
	}
	
	//Final Non permette overriding nelle subclasses
	@Override
	public final int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		return result;
	}

	@Override
	public final boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HeavenlyBody other = (HeavenlyBody) obj;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		return true;
	}
	
	
	public static final class Key{
		private String name;
		private BodyTypes bodyType;
		
		private Key(String name, BodyTypes bodyType) {
			this.name = name;
			this.bodyType = bodyType;
		}

		public String getName() {
			return name;
		}

		public BodyTypes getBodyType() {
			return bodyType;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((bodyType == null) ? 0 : bodyType.hashCode());
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Key other = (Key) obj;
			if (bodyType != other.bodyType)
				return false;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Key [name=" + name + ", bodyType=" + bodyType + "]";
		}
		
		
	}



	
	
	
	
}
