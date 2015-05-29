package classes;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ProvidedResults {

	
	public static Extragere e ;
	public static final List<OutcomeEvent> outcomes = new ArrayList<OutcomeEvent>();
	public static OutcomeEvent outcome;
	String[] params;
	
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
	
	
	public  void fileRead(String fileName) throws Exception {


	    try {
	    	
	        BufferedReader br = new BufferedReader(new FileReader(fileName));
	        String line = br.readLine();

	        while( line != null && line.length()!=0) {
	        	polutateListsWithProvidedResults(line);
	            line =  br.readLine();
	        }

	        br.close();
	    }catch (FileNotFoundException e) {
	    	System.out.println("File not found exception!!!");
	    } catch (IOException e) {
	    	System.out.println("IOException!!!");
	    }
	    
	}

	
	public  void polutateListsWithProvidedResults(String line) throws Exception {
		if(line.startsWith("Extragere")){
			
			if(line.contains("|")){
				params = line.split("\\|");
				if(params.length == 4)
					createExtragere(params);
				else
					throw new Exception(CompanyDetails.getInstance()+"Field does not contain 4 params.");
			}else
				throw new Exception(CompanyDetails.getInstance()+"Field does not contain |");
			
		}else if(line.startsWith("OutcomeEvent")){
			
			if(line.contains("|")){
				
				 params = line.split("\\|");
				if(params.length ==3){
					createOutcome(params);
					outcomes.add(outcome);
				}else
					throw new Exception(CompanyDetails.getInstance()+"Field does not contain 3 params.");
			}else
				throw new Exception(CompanyDetails.getInstance()+"Field does not contain |");
		}else
			throw new IllegalArgumentException();
		
	}


	public OutcomeEvent createOutcome(String[] params) {
		String id = params[1];
		String result = params[2];
		
		if(result_valid(result)){
			return outcome = new OutcomeEvent(id,result);
		}else
			throw new IllegalArgumentException();
		
	}

	
	private boolean result_valid(String result) {
		
		if(result.equalsIgnoreCase("x") || result.equals("1") || result.equals("2"))
			return true;
		else
			throw new IllegalArgumentException();
	}

	
	public  Extragere createExtragere(String[] params) throws Exception {
		String luna = params[1];
		String zi = params[2];
		String valoare = params[3];
		if(zi_valida(luna, zi)&&luna_valida(luna))
			 return e = new Extragere(luna, zi, valoare);
		else
			throw new Exception("Paramentrii invalizi la extragere!");
	}
	
	
	public Boolean luna_valida(String l){
		
		int luna = Integer.parseInt(l);
		
		if(luna < 12 && luna != 0)
			return true;
		else
			throw new IllegalArgumentException();
	}
	
	
	public  Boolean zi_valida(String l, String z){
		
		int luna = Integer.parseInt(l);
		int zi = Integer.parseInt(z);
		
		if( zi < monthToDays.get(luna) && zi > 0)
			return true;
		else 
			throw new IllegalArgumentException();
			
	}


	public void setExtragere(Extragere e) {
		ProvidedResults.e = e;
	}


	public void setOutcome(OutcomeEvent outcome) {
		ProvidedResults.outcome = outcome;
	}


	public Extragere getExtragere() {
		return e;
	}


	public OutcomeEvent getOutcome() {
		return outcome;
	}

	
	

	
}
