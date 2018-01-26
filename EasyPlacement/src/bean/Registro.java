package bean;


public class Registro {

	private String data;
	private boolean isFirmed;
	private int id;

	public Registro() {	
	}


	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public boolean getIsFirmed() {
		return isFirmed;
	}
	public void setIsFirmed(boolean isFirmed) {
		this.isFirmed = isFirmed;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
