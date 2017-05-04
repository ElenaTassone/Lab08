package it.polito.tdp.borders.model;

import java.util.*;

import org.jgrapht.Graphs;
import org.jgrapht.UndirectedGraph;
import org.jgrapht.alg.ConnectivityInspector;
import org.jgrapht.graph.Multigraph;
import org.jgrapht.graph.SimpleGraph;

import it.polito.tdp.borders.db.BordersDAO;

public class Model {

	BordersDAO dao ;

	List<Country> paesi = new ArrayList<Country> () ;
	
	List<Border> confini = new ArrayList<Border> () ;
	
	UndirectedGraph <Country, Border> grafo ;
	
	List<Country> paesianno ;
	
	Map<Country, Integer> mappa ;
	
	public Model() {
		grafo = new SimpleGraph <> (Border.class) ;
		dao = new BordersDAO() ;
	}

	public void creaGrafo(String anno) {
		paesi = dao.loadAllCountries() ;
		//paesianno = new ArrayList<Country> () ;
		confini = dao.getCountryPairs(Integer.parseInt(anno)) ;
		for(Border b : confini){
			this.trovaStati(b);
				if(!grafo.containsVertex(b.getC()))
					grafo.addVertex(b.getC()) ;
				if(!grafo.containsVertex(b.getC1()))
					grafo.addVertex(b.getC1()) ;
				grafo.addEdge(b.getC(), b.getC1(), b) ;
		}
		
	}
	
	public void trovaStati(Border b){
		String stato1 = b.getC().getStAbb().toLowerCase();
		String stato2 = b.getC1().getStAbb().toLowerCase();
		for(Country c : paesi){
			if(c.getStAbb().toLowerCase().compareTo(stato1)==0){
				b.getC().setCcode(c.getCcode());
				b.getC().setName(c.getName());
				}
			if(c.getStAbb().toLowerCase().compareTo(stato2)==0){
				b.getC1().setCcode(c.getCcode());
				b.getC1().setName(c.getName());
				}
			}
		
	}

	public List<Country> getCountries() {
		 return paesi;
	}
	
	public Map<Country, Integer> getCountries2() {
		mappa = new HashMap <Country, Integer> () ;
		 for(Country c : grafo.vertexSet()){
			 c.setNConfinanti(grafo.degreeOf(c));
			 mappa.put(c, grafo.degreeOf(c));
		 }
		 return mappa ;
	}
	
	public String getGraph() {
		
		return grafo.toString();
	}

	public Integer getNumberOfConnectedComponents() {
		ConnectivityInspector <Country, Border> connessioni = new ConnectivityInspector <Country, Border> (grafo) ;
		return connessioni.connectedSets().size();
	}

}
