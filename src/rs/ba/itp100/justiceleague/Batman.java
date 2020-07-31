package rs.ba.itp100.justiceleague;

public class Batman extends SuperherojBezMoci implements Leti {

	public Batman() {
		this.ime="Batman";
		this.pravoIme="Bruce Wayne";
	}
	@Override
	public void leti() {
		System.out.println("Leti.");
	}

}
