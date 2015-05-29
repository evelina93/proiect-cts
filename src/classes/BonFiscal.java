package classes;


import interfaces.ICupon;

public class BonFiscal implements ICupon{

	
	private String cod_fiscal;
	private String luna;
	private String zi;
	private String valoare;
	
	
	
	
	public String getCod_fiscal() {
		return cod_fiscal;
	}

	public void setCod_fiscal(String cod_fiscal) {
		this.cod_fiscal = cod_fiscal;
	}

	public String getLuna() {
		return luna;
	}

	public void setLuna(String luna) {
		this.luna = luna;
	}
	
	public String getZi() {
		return zi;
	}

	public void setZi(String zi) {
		this.zi = zi;
	}

	public String getValoare() {
		return valoare;
	}

	public void setValoare(String valoare) {
		this.valoare = valoare;
	}

	
	
	


	@Override
	public String toString() {
		return "BonFiscal [cod_fiscal=" + cod_fiscal + ", luna=" + luna
				+ ", zi=" + zi + ", valoare=" + valoare + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((cod_fiscal == null) ? 0 : cod_fiscal.hashCode());
		result = prime * result + ((luna == null) ? 0 : luna.hashCode());
		result = prime * result + ((valoare == null) ? 0 : valoare.hashCode());
		result = prime * result + ((zi == null) ? 0 : zi.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BonFiscal other = (BonFiscal) obj;
		if (cod_fiscal == null) {
			if (other.cod_fiscal != null)
				return false;
		} else if (!cod_fiscal.equals(other.cod_fiscal))
			return false;
		if (luna == null) {
			if (other.luna != null)
				return false;
		} else if (!luna.equals(other.luna))
			return false;
		if (valoare == null) {
			if (other.valoare != null)
				return false;
		} else if (!valoare.equals(other.valoare))
			return false;
		if (zi == null) {
			if (other.zi != null)
				return false;
		} else if (!zi.equals(other.zi))
			return false;
		return true;
	}

	@Override
	public Boolean check(String result) {
		
		String[] params = result.split("\\|");
		String luna = params[0];
		String zi = params[1];
		String valoare = params[2];
		
		if(this.luna.equals(luna)&&this.zi.equals(zi) && this.valoare.equals(valoare))
			return true;
		else
			return false;
	}

}
