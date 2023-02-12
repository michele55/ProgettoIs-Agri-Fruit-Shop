package gestioneAccount;

import java.io.Serializable;

public class Amministratore implements Serializable {

	String nome;
	String cognome;
	String email;
	String pwd;
	String ruolo;
public Amministratore() {

	email="";
	pwd="";
	ruolo="";
	nome="";
	cognome="";
	
}

	
	
	
	

	public Amministratore(String nome, String cognome, String email, String pwd, String ruolo) {
	super();
	this.nome = nome;
	this.cognome = cognome;
	this.email = email;
	this.pwd = pwd;
	this.ruolo = ruolo;
}






	public String getNome() {
		return nome;
	}
	public String getCognome() {
		return cognome;
	}
	public String getEmail() {
		return email;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public void setEmail(String email) {
		this.email = email;
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
	
	public String getRuolo() {
		return ruolo;
	}

	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}
}
