package main;

import classes.BiletPariu;
import classes.BonFiscal;
import classes.CheckResults;
import classes.CompanyDetails;
import classes.ProvidedCupons;
import classes.ProvidedResults;

public class Main {

	
	public static void main(String[] args) {
		
		CompanyDetails.log("Welcome");
		
		
		ProvidedCupons providedCupons = new ProvidedCupons();
		try {
			providedCupons.fileRead("providedCupons.txt");
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		CompanyDetails.log("Numar bilete primite: "+ProvidedCupons.idPentruBilet.size()+" <> Numar bonuri primite: "+ProvidedCupons.listaBonuri.size()+"");
		CompanyDetails.log(" ");
		

		ProvidedResults providedResults =  new ProvidedResults();
		try {
			providedResults.fileRead("providedResults.txt");
		} catch (Exception e) {
			e.printStackTrace();
		}
		CompanyDetails.log("Numar rezultate primite pentru bilete de pariuri:"+ ProvidedResults.outcomes.size());
		CompanyDetails.log("Datele extragerii: "+ProvidedResults.e.toString());
		CompanyDetails.log(" ");
		
		
		CheckResults cr = new CheckResults();
		
		cr.verificareBonuriFiscale();
		CompanyDetails.log("Numar bonuri castigatoare: "+cr.getListaBonuriCastigatoare().size());
		for(BonFiscal b :cr.getListaBonuriCastigatoare())
			CompanyDetails.log(b.toString());
		CompanyDetails.log(" ");
		
		
		cr.verificareBiletepariu();
		CompanyDetails.log("Numarul de bilete castigatoare: "+cr.getListaBileteCastigatoare().size());
		for(BiletPariu b:cr.getListaBileteCastigatoare())
			CompanyDetails.log(b.toString());
		
	}
}
