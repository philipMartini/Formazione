package org.filippo.formazione.moviecatalogservice.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.filippo.formazione.moviecatalogservice.model.CatalogItem;
import org.filippo.formazione.moviecatalogservice.model.Movie;
import org.filippo.formazione.moviecatalogservice.model.Rating;
import org.filippo.formazione.moviecatalogservice.model.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.reactive.function.client.WebClientAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
	
	//This is the spring rest client
	@Autowired
	private RestTemplate restTemplate;
	
	/*This is the modern spring sync/async rest client
	@Autowired
	private WebClient.Builder webClientBuilder;*/
	
	@RequestMapping("{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){
		
		
		
		//Get all rated movie IDs by userId
		UserRating userRating = this.restTemplate.getForObject("http://ratings-data-service/ratingsdata/users/" + userId, UserRating.class);
		
		
		//For each movie ID, call movie info service and get details
		return userRating.getUserRatings().stream().map(rating -> {
			Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(), Movie.class);
			
			/*Doing same thing with WebClient
			Movie movie = webClientBuilder.build() // Builda il webclient
								.get() //Use this http method
								.uri("http://localhost:8082/movies/" + rating.getMovieId()) //A questo uri
								.retrieve()//Effettua la richiesta
								.bodyToMono(Movie.class)//Qualsiasi body ricevi convertilo in questa classe
								//Mono è una sorta di promise in JS
								.block();//Usando Block rendo la chiamata sync*/
			return new CatalogItem(movie.getName(), "desc", rating.getRating());
		}).collect(Collectors.toList());
		
		//Put them together in a catalog item
		
		
		
//		List<CatalogItem> catalog = new ArrayList<>();
//		catalog.add(new CatalogItem("Transformers", "test", 4));
		
		//return catalog;
	}
}
