package rs.ba.itp100.justiceleague;

public class WonderWoman extends SuperherojSaMocima implements Leti {

	public WonderWoman() {
		this.ime="Wonder Woman";
		this.pravoIme="Princess Diana of Themyscira";
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
