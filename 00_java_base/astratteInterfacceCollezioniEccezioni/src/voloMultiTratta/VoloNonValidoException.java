package voloMultiTratta;

//Non intendo serializzare
@SuppressWarnings("serial")
public class VoloNonValidoException extends Exception {
	
	public VoloNonValidoException(){ super(); }
	
	public VoloNonValidoException(String msg) { super(msg); } 

}
