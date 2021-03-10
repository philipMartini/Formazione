package classiAnonime;

import java.util.ArrayList;
import java.util.List;

public class Videoteca {
	
	private Film[] films;
	
	public Videoteca(){
		this.films = new Film[10];
	}
	
	public void addFilm(Film film){
		for(int i = 0; i < this.films.length; ++i){
			if(this.films[i] == null){
				this.films[i] = film;
				break;
			}
		}
	}
	
	public Film[] filterFilms(FilmFilter filter){
		List<Film> result = new ArrayList<>();
		for(int i = 0; i < this.films.length; ++i){
			if(this.films[i] != null && filter.filter(this.films[i]))
				result.add(this.films[i]);
		}
		return result.toArray(new Film[0]);
	}
}
