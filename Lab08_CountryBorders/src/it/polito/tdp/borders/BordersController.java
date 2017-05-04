/**
 * Skeleton for 'Borders.fxml' Controller Class
 */

package it.polito.tdp.borders;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.*;

import it.polito.tdp.borders.model.Country;
import it.polito.tdp.borders.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class BordersController {

	Model model;

	Map<Country,Integer> mappa = new HashMap<Country, Integer> () ;
	
	@FXML // ResourceBundle that was given to the FXMLLoader
	private ResourceBundle resources;

	@FXML // URL location of the FXML file that was given to the FXMLLoader
	private URL location;

	@FXML // fx:id="txtAnno"
	private TextField txtAnno; // Value injected by FXMLLoader

	@FXML // fx:id="txtResult"
	private TextArea txtResult; // Value injected by FXMLLoader

	@FXML
	void doCalcolaConfini(ActionEvent event) {
		String anno = txtAnno.getText() ;
		model.creaGrafo(anno) ;
		mappa = model.getCountries2() ;
		for (Country country : mappa.keySet())
			txtResult.appendText(country+" stati confinanti "+ mappa.get(country)+"\n \n");		
		txtResult.appendText(model.getNumberOfConnectedComponents().toString());
//				c.getName()+": paesi confinanti " + c.getNConfinanti()+"\n");
	}

	public void setModel(Model m){
		this.model = m ;
	}
	@FXML // This method is called by the FXMLLoader when initialization is complete
	void initialize() {
		assert txtAnno != null : "fx:id=\"txtAnno\" was not injected: check your FXML file 'Borders.fxml'.";
		assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Borders.fxml'.";
	}
}
