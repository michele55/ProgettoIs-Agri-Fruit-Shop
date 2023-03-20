package gestioneAcquisti;

public class spedizione {

	int id;
	int numeroordine;
	String modalitaspedizione;
	String citta;
	String via;
	String provincia;
	int civico;
	int cap;
	
	int costospedizione;
	
	public spedizione() {
		id=0;
		numeroordine=0;
		citta="";
		via="";
		provincia="";
		civico=0;
		cap=0;
		modalitaspedizione="";
		costospedizione=0;
		
	}
	


	public spedizione(int id, int numeroordine, String modalitaspedizione, String citta, String via, String provincia,
			int civico, int cap, int costospedizione) {
		super();
		this.id = id;
		this.numeroordine = numeroordine;
		this.modalitaspedizione = modalitaspedizione;
		this.citta = citta;
		this.via = via;
		this.provincia = provincia;
		this.civico = civico;
		this.cap = cap;
		this.costospedizione = costospedizione;
	}



	public String getCitta() {
		return citta;
	}



	public void setCitta(String citta) {
		this.citta = citta;
	}



	public String getVia() {
		return via;
	}



	public void setVia(String via) {
		this.via = via;
	}



	public String getProvincia() {
		return provincia;
	}



	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}



	public int getCivico() {
		return civico;
	}



	public void setCivico(int civico) {
		this.civico = civico;
	}



	public int getCap() {
		return cap;
	}



	public void setCap(int cap) {
		this.cap = cap;
	}



	public int getCostospedizione() {
		return costospedizione;
	}

	public void setCostospedizione(int costospedizione) {
		this.costospedizione = costospedizione;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNumeroordine() {
		return numeroordine;
	}
	public void setNumeroordine(int numeroordine) {
		this.numeroordine = numeroordine;
	}
	public String getModalitaspedizione() {
		return modalitaspedizione;
	}
	public void setModalitaspedizione(String modalitaspedizione) {
		this.modalitaspedizione = modalitaspedizione;
	}
	
	
}
