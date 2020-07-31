package rs.ba.itp100.justiceleague.main;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import rs.ba.itp100.justiceleague.Aquaman;
import rs.ba.itp100.justiceleague.Batman;
import rs.ba.itp100.justiceleague.GreenArrow;
import rs.ba.itp100.justiceleague.Leti;
import rs.ba.itp100.justiceleague.Supergirl;
import rs.ba.itp100.justiceleague.Superheroj;
import rs.ba.itp100.justiceleague.Superman;
import rs.ba.itp100.justiceleague.Trci;
import rs.ba.itp100.justiceleague.WonderWoman;
import rs.ba.itp100.justiceleague.zlikovci.Zlikovac;
import rs.ba.itp100.justiceleague.zlikovci.ZlikovacPostojiException;

public class Supercity {

	public static void main(String[] args) throws Exception {
		// kreiranje matrice
		Object grad[][] = new Object[30][90];

		// kreiranje 6 zlikovaca
		Zlikovac[] zlikovci = new Zlikovac[] { new Zlikovac("Joker", false), new Zlikovac("Dr. Doom", false),
				new Zlikovac("The Riddler", false), new Zlikovac("Lex Luthor", true), new Zlikovac("Bane", false),
				new Zlikovac("Ra's al Ghul", false) };

		// postavljanje zlikovaca na random pozicije u matrici
		for (int i = 0; i < 6; i++) {
			int red = 0;
			int kolona = 0;
			do {
				red = (int) (Math.random() * 30);
				kolona = (int) (Math.random() * 90);
				if (grad[red][kolona] != null) {
					throw new ZlikovacPostojiException("Zlikovac postoji na ovoj poziciji. Probajte neku drugu.");
				}
			} while (grad[red][kolona] != null);
			grad[red][kolona] = zlikovci[i];
		}

		// izdvajanje argumenata komandne linije
		String nazivPrveDatoteke = null, nazivDrugeDatoteke = null;
		if (args.length < 2) {
			System.out.println("Nisu navedeni argumenti komandne linije.");
		} else {
			nazivPrveDatoteke = args[0];
			nazivDrugeDatoteke = args[1];
		}
		
		// upis zlikovaca u fajl
		if (nazivPrveDatoteke != null) {
			upisUFajl(nazivPrveDatoteke, grad, true);
		}
		
		// kreiranje superheroja
		Aquaman aquaman = new Aquaman();
		ArrayList<Leti> lete = new ArrayList<>();
		Batman batman = new Batman();
		Superman superman = new Superman();
		WonderWoman wonderWoman = new WonderWoman();
		Supergirl supergirl = new Supergirl();
		lete.add(batman);
		lete.add(superman);
		lete.add(wonderWoman);
		lete.add(supergirl);
		ArrayList<Trci> trce = new ArrayList<>();
		trce.add(batman);
		trce.add(superman);
		trce.add(wonderWoman);
		trce.add(supergirl);
		trce.add(aquaman);
		trce.add(new GreenArrow());

		// simulacija
		for (int red = 0; red < 30; red++) {
			for (int kolona = 0; kolona < 89; kolona++) {
				if (grad[red][kolona] != null) {
					Zlikovac zlikovac = (Zlikovac) grad[red][kolona];
					System.out.print(zlikovac.toString() + ", [" + red + ", " + kolona + "]: ");
					if (kolona < 30) {
						// vazduh
						boolean zlikovacUnisten = false;
						do {
							int redniBrojLetaca = (int) (Math.random() * lete.size());
							Superheroj superheroj = (Superheroj) lete.get(redniBrojLetaca);
							if (superheroj instanceof Superman && zlikovac.isImaKriptonit()) {
								System.out.println("unistio Supermana");
								lete.remove(redniBrojLetaca);
								trce.remove(superman);
								redniBrojLetaca = (int) (Math.random() * lete.size());
								Superheroj drugiSuperheroj = (Superheroj) lete.get(redniBrojLetaca);
								grad[red][kolona] = drugiSuperheroj;
								System.out.println(drugiSuperheroj);
								zlikovacUnisten = true;
							} else {
								grad[red][kolona] = superheroj;
								System.out.println(superheroj);
								zlikovacUnisten = true;
							}
						} while (!zlikovacUnisten);
					} else if (kolona < 60) {
						// zemlja
						boolean zlikovacUnisten = false;
						do {
							int redniBrojTrkaca = (int) (Math.random() * trce.size());
							Superheroj superheroj = (Superheroj) trce.get(redniBrojTrkaca);
							if (superheroj instanceof Superman && zlikovac.isImaKriptonit()) {
								System.out.println("unistio Supermana");
								trce.remove(redniBrojTrkaca);
								lete.remove(superman);
								redniBrojTrkaca = (int) (Math.random() * trce.size());
								Superheroj drugiSuperheroj = (Superheroj) trce.get(redniBrojTrkaca);
								grad[red][kolona] = drugiSuperheroj;
								System.out.println(drugiSuperheroj);
								zlikovacUnisten = true;
							} else {
								grad[red][kolona] = superheroj;
								System.out.println(superheroj);
								zlikovacUnisten = true;
							}
						} while (!zlikovacUnisten);
					} else {
						grad[red][kolona] = aquaman;
						System.out.println("unistio ga je Aquaman");
					}
				}
			}
		}
		
		// upis superheroja u fajl
		if (nazivDrugeDatoteke != null) {
			upisUFajl(nazivDrugeDatoteke, grad, false);
		}
	}
	
	public static void upisUFajl(String nazivDatoteke, Object grad[][], boolean daLiJeZlikovac) {
		try {
			FileWriter fw = new FileWriter(nazivDatoteke);
			for (int i = 0; i < grad.length; i++) {
				for (int j = 0; j < grad[i].length; j++) {
					if (grad[i][j] == null) {
						fw.write("x");
					} else {
						if(daLiJeZlikovac) {
							Zlikovac zlikovac = (Zlikovac) grad[i][j];
							fw.write(zlikovac.getIme().charAt(0));
						} else {
							Superheroj superheroj = (Superheroj) grad[i][j];
							fw.write(superheroj.getIme().charAt(0));
						}
					}
				}
				fw.write("\n");
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
