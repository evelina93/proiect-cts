package classes;

import enums.Cupons;
import interfaces.ICupon;

public class CuponsFactory {
	
	public ICupon createInstance(Cupons cupon){
		switch (cupon) {
		case BiletPariu: return new BiletPariu();
		case BonFiscal: return new BonFiscal();
		}
		
		return null;
	}
	
}
