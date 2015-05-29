package classes;


/**
 * 
 * Used for logging company details</br>
 * 
 * @author Evelina
 *
 */

public class CompanyDetails {
	
	private String name;
	private String CUI;
	
	private static CompanyDetails instance = null;
	
	private CompanyDetails(){
		name = "SC LOTObet SRL";
		CUI = "RO329832";
	}

	public static CompanyDetails getInstance(){
		if(instance==null){
			instance = new CompanyDetails();
		}
		return instance;
	}

	
	public static void log(String message){
		System.out.println( CompanyDetails.getInstance().toString() + message);
	}
	
	
	@Override
	public String toString() {
		return "[Company name: " + name + "|CUI: " + CUI + "] ";
	}
	
	
	
}
