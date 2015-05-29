package classes;

public class Extragere {

	private String luna;
	private String zi;
	private String valoare;
	
	
	public Extragere() {
	}

	public Extragere(String luna, String zi, String valoare) {
		this.luna = luna;
		this.zi = zi;
		this.valoare = valoare;
	}

	public String getLuna() {
		return luna;
	}

	public String getZi() {
		return zi;
	}

	public String getValoare() {
		return valoare;
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Extragere other = (Extragere) obj;
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
	public String toString() {
		return "Extragere [luna=" + luna + ", zi=" + zi + ", valoare=" + valoare + "]";
	}
	
	
	
}
