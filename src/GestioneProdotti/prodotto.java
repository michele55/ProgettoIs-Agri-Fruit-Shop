package GestioneProdotti;

import java.io.Serializable;

public class prodotto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public prodotto(float prezzo, String nome, String descrizione, String ssn, int quantita, String categoria,
			String idfoto, int dispcarrello) {
		super();
		this.prezzo = prezzo;
		this.nome = nome;
		this.descrizione = descrizione;
		this.ssn = ssn;
		this.quantita = quantita;
		this.categoria = categoria;
		this.idfoto = idfoto;
		this.dispcarrello = dispcarrello;
	}

	float prezzo;
	String nome;
	String descrizione;
	String ssn;
	int quantita;
	String categoria;
	String idfoto;
	int dispcarrello;
	
	public int getDispcarrello() {
		return dispcarrello;
	}


	public void setDispcarrello(int dispcarrello) {
		this.dispcarrello = dispcarrello;
	}


	public String getIdfoto() {
		return idfoto;
	}


	public void setIdfoto(String idfoto) {
		this.idfoto = idfoto;
	}


	public prodotto () {
		
		ssn="0";
		nome="";
		descrizione="";
		prezzo=0;
		quantita=0;
		categoria="";
		dispcarrello=0;
	}


	public String getCategoria() {
		return categoria;
	}


	public void setCtegoria(String categoria) {
		this.categoria = categoria;
	}
	

	public int getQuantita() {
		return quantita;
	}


	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getDescrizione() {
		return descrizione;
	}


	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}


	public float getPrezzo() {
		return prezzo;
	}


	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}


	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn=ssn;
	}
	
	
	public boolean isEmpty() {
		return ssn=="0";
	}
	
	
	@Override
	public boolean equals(Object other) {
		return this.getSsn()== ((prodotto) other).getSsn();
	}
	
	@Override
	public String toString() {
		return nome +"("+ ssn +")"+ prezzo +","+quantita+","+descrizione;
	}
	
	
	
	
}
