package voloMultiTratta;

public class Aeroporti {
	
	private static final String[] AEROPORTI = {"LIN", "SFO","FCO", "MXP"};
	
	public static boolean aeroportoValido(String aeroporto){
		for(String a : Aeroporti.AEROPORTI){
			if(a.equals(aeroporto))
				return true;
		}
		
		return false;
	}

}
