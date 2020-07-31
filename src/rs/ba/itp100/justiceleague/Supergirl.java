package rs.ba.itp100.justiceleague;

public class Supergirl extends SuperherojSaMocima implements Leti {

	public Supergirl() {
		this.ime="Supergirl";
		this.pravoIme="Kara-Zor-El";
	}
	@Override
	public void leti() {
		System.out.println("Leti.");
	}
	
	@Override
	public String toString() {
		return "unistila ga je " + ime;
	}

}
