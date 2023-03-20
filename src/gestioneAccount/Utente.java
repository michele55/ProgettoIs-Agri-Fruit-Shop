package gestioneAccount;

import java.io.Serializable;

public class Utente implements Serializable {

	String nome;
	String cognome;
	String indirizzo;
	String citta;
	String provincia;
	String codice_fiscale;
	String email;
	String pwd;
	String civico;
	String ruolo;
	String cap;
	int id;
public Utente() {

	email="";
	pwd="";
	nome="";
	cognome="";
	
}

	
	
	public String getCitta() {
	return citta;
}



public void setCitta(String citta) {
	this.citta = citta;
}



public String getProvincia() {
	return provincia;
}



public void setProvincia(String provincia) {
	this.provincia = provincia;
}



public int getId() {
	return id;
}



public void setId(int id) {
	this.id = id;
}



	public Utente(String nome, String cognome, String indirizzo,String citta, String provincia, String codice_fiscale, String email, String pwd,
		String civico, String ruolo, String cap, int id) {
	super();
	this.nome = nome;
	this.cognome = cognome;
	this.indirizzo = indirizzo;
	this.citta=citta;
	this.provincia=provincia;
	this.codice_fiscale = codice_fiscale;
	this.email = email;
	this.pwd = pwd;
	this.civico = civico;
	this.ruolo = ruolo;
	this.cap = cap;
	this.id = id;
}



	public String getCivico() {
		return civico;
	}

	public void setCivico(String civico) {
		this.civico = civico;
	}

	public String getCap() {
		return cap;
	}

	public void setCap(String cap) {
		this.cap = cap;
	}

	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getCodice_fiscale() {
		return codice_fiscale;
	}

	public void setCodice_fiscale(String codice_fiscale) {
		this.codice_fiscale = codice_fiscale;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getRuolo() {
		return ruolo;
	}
	
	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}
	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	public boolean isEmpty() {
		return email=="";
	}
	
	
}
