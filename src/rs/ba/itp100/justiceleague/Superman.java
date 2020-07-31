package rs.ba.itp100.justiceleague;

public class Superman extends SuperherojSaMocima implements Leti {

	public Superman() {
		this.ime="Superman";
		this.pravoIme="Clark Kent";
	}
	@Override
	public void leti() {
		System.out.println("Leti.");
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Superman) return true;
		else return false;
	}

}
