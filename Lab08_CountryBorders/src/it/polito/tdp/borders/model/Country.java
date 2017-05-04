package it.polito.tdp.borders.model;

public class Country {
	private int ccode ;
	private String stName ;
	private String stAbb ;
	private int nConfinanti ;
	
	public Country (String stAbb){
		this.stAbb=stAbb ;
	}
		
	public Country(int ccode, String stAbb, String stName ) {
		super();
		this.ccode = ccode;
		this.stName = stName;
		this.stAbb = stAbb;
	}
	public String getName() {
		return stName;
	}
	public void setName(String name) {
		this.stName = name;
	}
	public int getNConfinanti() {
		return nConfinanti;
	}
	public void setNConfinanti(int nConfinanti) {
		this.nConfinanti = nConfinanti;
	}
	
	public void addConfine() {
		nConfinanti++;
	}
	public int getCcode() {
		return ccode;
	}
	public void setCcode(int ccode) {
		this.ccode = ccode;
	}
	public String getStAbb() {
		return stAbb;
	}
	public void setStAbb(String stAbb) {
		this.stAbb = stAbb;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((stAbb == null) ? 0 : stAbb.hashCode());
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
		Country other = (Country) obj;
		if (stAbb == null) {
			if (other.stAbb != null)
				return false;
		} else if (!stAbb.equals(other.stAbb))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ccode:" + ccode + ", stName:" + stName + ", stAbb:" + stAbb + "\n " ;
				
	}
	
}
