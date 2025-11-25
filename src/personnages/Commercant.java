package personnages;

public class Commercant extends Humain {
	private int argent_commercant;

	public Commercant(String nom, String boissonfavorite, int argent) {
		super(nom, boissonfavorite, argent);
	}

	public int seFaireExtorquer() {
		int argent_vole = argent_commercant;
		argent_commercant = 0;
		parler("J'ai tout perdu! Le monde est trop injuste...");
		return argent_vole;
	}
	
	public void recevoir(int argent) {
		parler(argent + " sous! Je te remercie généreux donateur!");
		argent_commercant  += argent; 
	}
}
