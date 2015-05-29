package classes;
import interfaces.ICupon;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import enums.Cupons;


public class ProvidedCupons {
	
	public static final List<ICupon> listaBonuri = new ArrayList<ICupon>();
	public static final Map<String, ICupon> idPentruBilet = new HashMap<String, ICupon>();
	
	CuponsFactory factory = new CuponsFactory();
	ICupon cupon;
	
	
	private final static Map<Integer, Integer> monthToDays = new HashMap<Integer, Integer>();
	static{
		monthToDays.put(1, 31);
		monthToDays.put(2, 28);
		monthToDays.put(3,31);
		monthToDays.put(4,30);
		monthToDays.put(5, 31);
		monthToDays.put(6,30);
		monthToDays.put(7,31);
		monthToDays.put(8,31);
		monthToDays.put(9,30);
		monthToDays.put(10,31);
		monthToDays.put(11,30);
		monthToDays.put(12,31);
	}
	
	public void fileRead(String fileName) throws Exception {


	    try {
	    	
	        BufferedReader br = new BufferedReader(new FileReader(fileName));
	        String line = br.readLine();

	        while( line != null && line.length()!=0) {
	        	polutateListsWithprovidedCupons(line);
	            line =  br.readLine();
	        }

	        br.close();
	    }catch (FileNotFoundException e) {
	    	System.out.println("File not found exception!!!");
	    } catch (IOException e) {
	    	System.out.println("IOException!!!");
	    }
	    
	}

	
	public void polutateListsWithprovidedCupons(String line) throws Exception {
		
		if(line.startsWith("Bon")){
			BonFiscal cupon = (BonFiscal) factory.createInstance(Cupons.BonFiscal);
			if(line.contains("|")){
				String[] params = line.split("\\|");
				if(params.length == 5){
					setParamsToBonFiscal(params,cupon);
					listaBonuri.add(cupon);
				}else
					throw new Exception(CompanyDetails.getInstance() + "Field does not contain 5 params.");
			}else
				throw new Exception(CompanyDetails.getInstance()+"Field does not contain |");
			
			
		}else if(line.startsWith("Bilet")){
			BiletPariu cupon = (BiletPariu)factory.createInstance(Cupons.BiletPariu);
			if(line.contains("|")){
				String[] params = line.split("\\|");
				if(params.length == 4){
					setParamsToBiletPariu(params, cupon);
					idPentruBilet.put(params[1], cupon);
				}else
					throw new Exception(CompanyDetails.getInstance() + "Field does not contain 3 params.");
			}else
				throw new Exception(CompanyDetails.getInstance()+"Field does not contain |");
			
			
			
		}else
			throw new IllegalArgumentException();
		
		
	};


	
	//CREATE BILET PARIU
	private void setParamsToBiletPariu(String[] params, BiletPariu bilet) {
		String id = params[1];
		String eventName = params[2];
		String result = params[3];
		
		if(eventName_valid(eventName) && result_valid(result)){
			bilet.setId(id);
			bilet.setEventName(eventName);
			bilet.setResult(result);
		}else
			throw new IllegalArgumentException();
		
	}

	
	
	private boolean result_valid(String result) {
		
		if(result.equalsIgnoreCase("x") || result.equals("1") || result.equals("2"))
			return true;
		else
			throw new IllegalArgumentException();
	}


	private boolean eventName_valid(String eventName) {
		if(eventName.toLowerCase().contains(" vs "))
			return true;
		else
			throw new IllegalArgumentException();
	}


	//CREATE BON FISCAL
	private void setParamsToBonFiscal(String[] params, BonFiscal bonFiscal) {
		String luna = params[2];
		String zi = params[3];
		String valoare = params[4];
		
		if( zi_valida(luna, zi) //
				&& luna_valida(luna)//
				&& limita_inferioara_valoare(valoare) //
				&& limita_superioara_valoare(valoare))
		{ 
			bonFiscal.setCod_fiscal(params[1]);
			bonFiscal.setLuna(luna);
			bonFiscal.setZi(zi);
			bonFiscal.setValoare(valoare);
		}else
			throw new IllegalArgumentException();
	}
	
	
	public Boolean luna_valida(String l){
		
		Integer luna = null;
		
		try {
			luna = Integer.parseInt(l);
		} catch (Exception e) {
			System.out.println("Please check ProvidedCupons file for BonFiscal as NumberFormatException has been caught!");
		}
		
		if(luna < 12 && luna != 0)
			return true;
		else
			throw new IllegalArgumentException();
	}
	
	
	public Boolean zi_valida(String l, String z){
		
		Integer luna = null;
		Integer zi = null;
		
		
		try {
			luna = Integer.parseInt(l);
			zi = Integer.parseInt(z);
		} catch (Exception e) {
			System.out.println("Please check ProvidedCupons file for BonFiscal as NumberFormatException has been caught!");
		}
		
		if( zi < monthToDays.get(luna) && zi > 0)
			return true;
		else 
			throw new IllegalArgumentException();
			
	}
	
	
	public  Boolean limita_inferioara_valoare(String v){
		Integer valoare = null;
		
		try {
			valoare = Integer.parseInt(v);
		} catch (Exception e) {
			System.out.println("Please check ProvidedCupons file for BonFiscal as NumberFormatException has been caught!");
		}
		if( valoare > 0)
			return true;
		else 
			throw new IllegalArgumentException();
	}
	
	public Boolean limita_superioara_valoare(String v){
		Integer valoare = null;
		
		try {
			valoare = Integer.parseInt(v);
		} catch (Exception e) {
			System.out.println("Please check ProvidedCupons file for BonFiscal as NumberFormatException has been caught!");
		}
		
		if( valoare < 999)
			return true;
		else 
			throw new IllegalArgumentException();
	}
	
}
