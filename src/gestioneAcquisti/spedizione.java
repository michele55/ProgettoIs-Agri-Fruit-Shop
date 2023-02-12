package gestioneAcquisti;

public class spedizione {

	int id;
	int numeroordine;
	String modalitaspedizione;
	int costospedizione;
	
	public spedizione() {
		id=0;
		numeroordine=0;
		modalitaspedizione="";
		costospedizione=0;
		
	}
	
	public spedizione(int id, int numeroordine, String modalitaspedizione, int costospedizione) {
		super();
		this.id = id;
		this.numeroordine = numeroordine;
		this.modalitaspedizione = modalitaspedizione;
		this.costospedizione = costospedizione;
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
