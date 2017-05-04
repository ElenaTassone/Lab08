package it.polito.tdp.borders.model;

public class Border {

	private int dyad ;
	private Country c1 ;
	private Country c ;
	private int year ;
	
	
	public Border(int dyad, Country c1, Country c, int year) {
		super();
		this.dyad = dyad;
		this.c1 = c1;
		this.c = c;
		this.year = year;
	}

	public int getDyad() {
		return dyad;
	}

	public void setDyad(int dyad) {
		this.dyad = dyad;
	}

	
	public Country getC1() {
		return c1;
	}

	public void setC1(Country c1) {
		this.c1 = c1;
	}

	public Country getC() {
		return c;
	}

	public void setC(Country c) {
		this.c = c;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + dyad;
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
		Border other = (Border) obj;
		if (dyad != other.dyad)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Border dyad:" + dyad + ", c1:" + c1 + ", c2:" + c + ", year:" + year + "\n";
	}
	
	
	

}
