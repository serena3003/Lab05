package it.polito.tdp.anagrammi.controller;

import java.net.URL;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;

import it.polito.tdp.anagammi.DAO.AnagrammaDAO;
import it.polito.tdp.anagrammi.model.AnagrammiModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AnagrammiController {
	
	private AnagrammiModel model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtInsert;

    @FXML
    private Button btnAnagramma;

    @FXML
    private TextArea txtCorretti;

    @FXML
    private TextArea txtErrati;

    @FXML
    private Button btnReset;

    @FXML
    void doAnagramma(ActionEvent event) {
    	
    	String str = txtInsert.getText();
    	Set<String> res = model.anagramma(str);
    	
    	AnagrammaDAO ad = new AnagrammaDAO();
    	
    	for(String s : res) {
    		System.out.println(s + "\n");
    		if(ad.isCorrect(s)) {
    			txtCorretti.appendText(s + "\n");
    		} else {
    			txtErrati.appendText(s + "\n");
    		}
    	}
    	
    }

    @FXML
    void doReset(ActionEvent event) {
    	txtInsert.clear();
    	txtCorretti.clear();
    	txtErrati.clear();
    	model.getRes().clear();
    }

    @FXML
    void initialize() {
        assert txtInsert != null : "fx:id=\"txtInsert\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert btnAnagramma != null : "fx:id=\"btnAnagramma\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert txtCorretti != null : "fx:id=\"txtCorretti\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert txtErrati != null : "fx:id=\"txtErrati\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Anagrammi.fxml'.";

    }

	public void setModel(AnagrammiModel model) {
		this.model = model;
	}
}
