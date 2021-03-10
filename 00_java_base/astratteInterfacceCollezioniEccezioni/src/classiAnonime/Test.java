package classiAnonime;

public class Test {

	public static void main(String[] args) {
		Film f1 = new Film("Signore degli anelli", "Fantasy", 3);
		Film f2 = new Film("Star wars", "Fantascienza", 4);
		Film f3 = new Film("Pulp Fiction", "Drama", 5);
		
		Videoteca v = new Videoteca();
		v.addFilm(f1);
		v.addFilm(f2);
		v.addFilm(f3);
		
		//Qui uso la classe anomima, o in alternativa una lambda
		//In questo caso vengono filtrati i film con media recensioni > 3
		Film[] filmBelli = v.filterFilms(new FilmFilter(){

			@Override
			public boolean filter(Film film) {
				return film.getMediaRecensioni() > 3;
			}
			
		});
		
		System.out.println(filmBelli.length);
		
		for(Film f : filmBelli){
			System.out.println(f);
		}

	}

}
