package rs.ba.itp100.justiceleague.zlikovci;

public class Zlikovac {
	private boolean imaKriptonit=false;
	private String ime="";
	
	public Zlikovac(String ime, boolean imaKriptonit) {
		this.ime=ime;
		this.imaKriptonit=imaKriptonit;
	}
	
	@Override
	public String toString() {
		return "Zlikovac: " + ime;
	}

	public boolean isImaKriptonit() {
		return imaKriptonit;
	}

	public void setImaKriptonit(boolean imaKriptonit) {
		this.imaKriptonit = imaKriptonit;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}
}
