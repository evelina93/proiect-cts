package classes;

import interfaces.ICupon;

public class BiletPariu implements ICupon{

	private String id;
	private String eventName;
	private String result;
	
	
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}


	



	@Override
	public String toString() {
		return "BiletPariu [id=" + id + ", eventName=" + eventName + ", result=" + result + "]";
	}

	@Override
	public Boolean check(String result) {
		if(this.result.equals(result))
			return true;
		else	
			return false;
	}

}
