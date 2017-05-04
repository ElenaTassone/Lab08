package it.polito.tdp.borders.model;

import java.util.List;
import java.util.Map;

public class TestModel {

	public static void main(String[] args) {

		Model model = new Model();

		System.out.println("TestModel -- TODO");
		
		System.out.println("Creo il grafo relativo al 1816");
		model.creaGrafo("1816");
		//System.out.println(model.getGraph());
		
		List<Country> countries = model.getCountries();
		System.out.format("Trovate %d nazioni\n", countries.size());
		//System.out.println(countries.toString());
		
		System.out.format("Numero componenti connesse: %d\n", model.getNumberOfConnectedComponents());
		
		Map<Country, Integer> stats = model.getCountries2();
		for (Country country : stats.keySet())
			System.out.format("%s %d\n", country, stats.get(country));		
		
	}

}
