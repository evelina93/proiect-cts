package classes;

import interfaces.IBilet;

public class BiletAdaptat implements IBilet{
	
	private BiletPariu biletPariu;

	@Override
	public Boolean verifica(String result) {
		return biletPariu.check(result);
	}
	
	

}
