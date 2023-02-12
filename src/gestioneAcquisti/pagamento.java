package gestioneAcquisti;

public class pagamento {
int id;
int numeropagamento;
String modalitapagamento;

public pagamento() {
	id=0;
	numeropagamento=0;
	modalitapagamento="";
	
}



public pagamento(int id, int numeropagamento, String modalitapagamento) {
	super();
	this.id = id;
	this.numeropagamento = numeropagamento;
	this.modalitapagamento = modalitapagamento;
}



public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getNumeropagamento() {
	return numeropagamento;
}
public void setNumeropagamento(int numeropagamento) {
	this.numeropagamento = numeropagamento;
}
public String getModalitapagamento() {
	return modalitapagamento;
}
public void setModalitapagamento(String modalitapagamento) {
	this.modalitapagamento = modalitapagamento;
}

}
