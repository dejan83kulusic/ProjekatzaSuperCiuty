package rs.ba.itp100.justiceleague;

public abstract class Superheroj implements Trci {
	protected String ime="";
	protected String pravoIme="";
	
	public void trci() {
		System.out.println("Trci.");
	}
	
	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPravoIme() {
		return pravoIme;
	}

	public void setPravoIme(String pravoIme) {
		this.pravoIme = pravoIme;
	}

	@Override
	public String toString() {
		return "unistio ga je " + ime;
	}
}
