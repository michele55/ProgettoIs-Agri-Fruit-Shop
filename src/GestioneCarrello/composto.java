package GestioneCarrello;

public class composto {
int quantita;
String ssn;
int numero;
int autoGeneratedID;

	public int getAutoGeneratedID() {
	return autoGeneratedID;
}

public void setAutoGeneratedID(int autoGeneratedID) {
	this.autoGeneratedID = autoGeneratedID;
}

	public composto() {
		
		quantita=0;
		ssn="";
		numero=0;
		autoGeneratedID=0;
		
	}

	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}




}
