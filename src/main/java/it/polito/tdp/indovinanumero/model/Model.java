package it.polito.tdp.indovinanumero.model;

import java.security.InvalidParameterException;

public class Model {
	private final int NMAX = 100;
	private final int TMAX = 8;
	private int segreto;
	private int tentativiFatti;
	private boolean inGioco;
	
	public Model() {
		this.inGioco=false;
		this.tentativiFatti=0;
	}
	public void nuovaPartita() {
		//gestione dell'inizio di una nuova partita - Logica del gioco
		this.segreto = (int)(Math.random() * NMAX) + 1;
    	this.tentativiFatti = 0;
    	this.inGioco = true; 
	}
	public int tentativo(int tentativo) {
		// controllo se la partita e' in corso
		if(!inGioco) {
			throw new IllegalStateException("La partita e' gia' terminata");
		}
		//controllo se il tentativo e' nell'intervallo 1-100
		if(!tentativoValido(tentativo)) {
			throw new InvalidParameterException("Devi inserire un numero tra 1 e "+NMAX);
		}
		this.tentativiFatti ++;
		if(tentativiFatti == TMAX) {
			this.inGioco=false;
		}
    	if(tentativo == this.segreto) {
    		this.inGioco = false;
    		return 0;
    	}
    	if(tentativo < this.segreto) {
    		return -1;
    	}
    	else {
    		return 1;
    	}
	}
	private boolean tentativoValido(int tentativo) {
		if((tentativo<1)||(tentativo>NMAX)) {
			return false;
		}
		else {
			return true;
		}
	}
	public int getTentativiFatti() {
		return tentativiFatti;
	}
	public void setTentativiFatti(int tentativiFatti) {
		this.tentativiFatti = tentativiFatti;
	}
	public int getSegreto() {
		return segreto;
	}
	public void setSegreto(int segreto) {
		this.segreto = segreto;
	}
	public int getTMAX() {
		return TMAX;
	}
	
}
