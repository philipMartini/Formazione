package generici;

public class Test {

	public static void main(String[] args) {
		
		Carnivoro<Erbivoro> tigre = new Carnivoro<>();
		Erbivoro<Erba> mucca = new Erbivoro<>();
		Erba erba = new Erba();
		mucca.mangia(erba);
		tigre.mangia(mucca);
	}

}
