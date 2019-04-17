package it.polito.tdp.anagrammi.model;

import java.util.HashSet;
import java.util.Set;

import javafx.scene.control.TextInputControl;

public class AnagrammiModel {
	
	private Set<String> res;
	
	public AnagrammiModel() {
		res = new HashSet<String>();
	}
	
	
	public void calcolaAnagramma(String s1, String s2, int l) {
		
	     if(l == 0)
	         res.add(s2);
	      
	      for(int i = 0; i < s1.length(); i++){
	           calcolaAnagramma(s1.substring(0, i) + s1.substring(i+1, s1.length()), s1.charAt(i) + s2, l-1);
	      }
	}


	public Set<String> anagramma(String str) {
		calcolaAnagramma(str,"", str.length());
		return res;
	}


	public Set<String> getRes() {
		return this.res;
	}
	
	
	
}