package solarSystem;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import solarSystem.HeavenlyBody.BodyTypes;

public class Main {
	
	private static Map<HeavenlyBody.Key, HeavenlyBody> solarSystem = new HashMap<HeavenlyBody.Key, HeavenlyBody>();
	private static Set<HeavenlyBody> planets = new HashSet<>();

	public static void main(String[] args) {
		HeavenlyBody temp = new Planet("Mercury", 88);
		solarSystem.put(temp.getKey(), temp);
		planets.add(temp);
		
		
		temp = new Planet("Venus", 225);
		solarSystem.put(temp.getKey(), temp);
		planets.add(temp);
		
		temp = new Planet("Earth", 365);
		solarSystem.put(temp.getKey(), temp);
		planets.add(temp);
		
		
		temp = new Planet("Mars", 687);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        /*tempMoon = new HeavenlyBody("Deimos", 1.3);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addSatellite(tempMoon); // temp is still Mars
        
        HeavenlyBody tempMoon = new HeavenlyBody("Moon", 27);
		solarSystem.put(tempMoon.getName(), tempMoon);
		temp.addSatellite(tempMoon);

        tempMoon = new HeavenlyBody("Phobos", 0.3);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addSatellite(tempMoon); // temp is still Mars
        
        
        tempMoon = new HeavenlyBody("Io", 1.8);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addSatellite(tempMoon); // temp is still Jupiter

        tempMoon = new HeavenlyBody("Europa", 3.5);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addSatellite(tempMoon); // temp is still Jupiter

        tempMoon = new HeavenlyBody("Ganymede", 7.1);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addSatellite(tempMoon); // temp is still Jupiter

        tempMoon = new HeavenlyBody("Callisto", 16.7);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addSatellite(tempMoon); // temp is still Jupiter
*/
        temp = new Planet("Jupiter", 4332);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        

        temp = new Planet("Saturn", 10759);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        temp = new Planet("Uranus", 30660);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        temp = new Planet("Neptune", 165);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        temp = new Planet("Pluto", 248);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);
		
		System.out.println("Planets: ");
		for(HeavenlyBody planet : planets){
			System.out.println("\t" + planet.getKey());
		}
		
		HeavenlyBody body = solarSystem.get(HeavenlyBody.makeKey("Jupiter",BodyTypes.PLANET));
		System.out.println("Moons of: " + body.getKey());
		for(HeavenlyBody moon : body.getSatellites()){
			System.out.println("\t" + moon.getKey());
		}
		
		//Si vogliono ora trovare le lune di tutti i pianeti
		Set<HeavenlyBody> moons = new HashSet<>();
		for(HeavenlyBody planet : planets){
			moons.addAll(planet.getSatellites());
		}
		
		System.out.println("All moons: ");
		for(HeavenlyBody moon : moons){
			System.out.println("\t" + moon.getKey());
		}
	}

}
