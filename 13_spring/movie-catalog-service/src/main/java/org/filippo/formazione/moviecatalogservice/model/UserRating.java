package org.filippo.formazione.moviecatalogservice.model;

import java.util.List;

//Questa è una classe wrapper che contiene una lista di Ratings
//Ci sono due motivi per wrappare le collezioni in un oggetto:
//1) Se restituisco direttamente unarray in json se volessi aggiungere una property globale
//Devo cambiare il contratto da collezione ad oggetto => il codice client si rompe
//2) introduco delle inutili complicazioni nella chiamata di restTemplate dato che il tipo collezione è generico
public class UserRating {
	
	private List<Rating> userRatings;

	public UserRating() {}

	public List<Rating> getUserRatings() {
		return userRatings;
	}

	public void setUserRatings(List<Rating> userRatings) {
		this.userRatings = userRatings;
	}
	
	
	
	
}
