package rs.ba.itp100.justiceleague;

public class Aquaman extends SuperherojSaMocima implements Pliva {

	public Aquaman() {
		this.ime="Aquaman";
		this.pravoIme="Arthur Curry";
	}
	
	@Override
	public void superMoci() {
		System.out.println("Ima super moci.");
	}

	@Override
	public void pliva() {
		System.out.println("Pliva.");
	}

}
