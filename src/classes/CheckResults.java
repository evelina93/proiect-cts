package classes;

import interfaces.ICupon;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CheckResults {

	
	private List<BonFiscal> bonuriCastigatoare = new ArrayList<BonFiscal>();
	Extragere extragere = ProvidedResults.e;
	List<ICupon> listaBonuriDeVerificat = ProvidedCupons.listaBonuri;
	
	
	private List<BiletPariu> bileteCastigatoare = new ArrayList<BiletPariu>();
	List<OutcomeEvent> listaBileteRezultate = ProvidedResults.outcomes;
	Map<String,ICupon> bileteDeVerificat = ProvidedCupons.idPentruBilet;
	
	
	public void verificareBonuriFiscale(){
		
		for(ICupon bf:listaBonuriDeVerificat){
			BonFiscal bon = (BonFiscal) bf;
			Boolean bonCastigator = bon.check(extragere.getLuna()+"|"+extragere.getZi()+"|"+extragere.getValoare());
			if(bonCastigator)
				bonuriCastigatoare.add(bon);
		}
	}
	
	
	public void verificareBiletepariu(){
		
		for(OutcomeEvent o:listaBileteRezultate){
			BiletPariu bilet = (BiletPariu) bileteDeVerificat.get(o.getEventId());
			Boolean biletCastigator = bilet.check(o.getOutcome());
			if(biletCastigator)
				bileteCastigatoare.add(bilet);
		}
	}
	
	
	public List<BiletPariu> getListaBileteCastigatoare(){
		return bileteCastigatoare;
	}
	
	public List<BonFiscal> getListaBonuriCastigatoare(){
		return bonuriCastigatoare;
	}
	
}
