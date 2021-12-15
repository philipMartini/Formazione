package org.filippo.formazione.ratingsdataservice.resources;

import java.util.Arrays;
import java.util.List;

import org.filippo.formazione.ratingsdataservice.model.Rating;
import org.filippo.formazione.ratingsdataservice.model.UserRating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ratingsdata")
public class RatingsDataResource {
	
	@RequestMapping("/{movieId}")
	public Rating getRating(@PathVariable("movieId") String movieId) {
		return new Rating(movieId, 4);
	}
	
	@RequestMapping("/users/{userId}")
	public UserRating getRatingsForUser(@PathVariable("userId") String userId){
		
		UserRating userRating = new UserRating();
		userRating.setUserRatings(Arrays.asList(
				new Rating("1234", 3),
				new Rating("5678", 7)
				
				));
		return userRating;
	}
}
