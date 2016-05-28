package it.polito.tdp.porto.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.porto.Model.Model;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;

public class PortoController {
	private Model model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ChoiceBox<String> Autore1;

    @FXML
    private ChoiceBox<String> Autore2;

    @FXML
    private Button btnCoautori;

    @FXML
    private Button btnCluster;

    @FXML
    private Button btnArticoli;
    
    @FXML
    private TextArea txtResult;

    
	public void setModel(Model m) {
		model=m;
		model.creaGrafo();
		Autore1.getItems().addAll(model.getAutori());
		Autore2.getItems().addAll(model.getAutori());
	}
    @FXML
    void doCalcolaArticoli(ActionEvent event) {
    	String s1 = Autore1.getValue();
    	String s2 = Autore2.getValue();
    	String tot="";
    	tot= model.articoliCondivisi(s1, s2);
    	txtResult.appendText(tot);
    	
    }

    @FXML
    void doCalcolaCluster(ActionEvent event) {
    	String tot="";
    	tot= model.componentiConnesse();
    	txtResult.appendText(tot);
    }

    @FXML
    void doCalcolaCoautori(ActionEvent event) {

    	String autore = Autore1.getValue();
    	String r ="Gli autori che hanno scritto almeno un articolo con l'autore selezionato sono:\n\n";
    	for(String s:model.getCoautori(autore)){
    		r+=s+",\n";
    	}
    	txtResult.setText(r);
    	
    }

    @FXML
    void initialize() {
    	assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Porto.fxml'.";
        assert Autore1 != null : "fx:id=\"Autore1\" was not injected: check your FXML file 'Porto.fxml'.";
        assert Autore2 != null : "fx:id=\"Autore2\" was not injected: check your FXML file 'Porto.fxml'.";
        assert btnCoautori != null : "fx:id=\"btnCoautori\" was not injected: check your FXML file 'Porto.fxml'.";
        assert btnCluster != null : "fx:id=\"btnCluster\" was not injected: check your FXML file 'Porto.fxml'.";
        assert btnArticoli != null : "fx:id=\"btnArticoli\" was not injected: check your FXML file 'Porto.fxml'.";

    }


}
