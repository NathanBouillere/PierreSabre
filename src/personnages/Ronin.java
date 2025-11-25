package personnages;

public class Ronin extends Humain{
	private int honneur = 1;

	public Ronin(String nom, String boissonfavorite, int argent) {
		super(nom, boissonfavorite, argent);
		// TODO Auto-generated constructor stub
	}
	
	public void donner(Commercant beneficiaire) {
		int argent = getArgent();
		int argent_donne = argent/10;
		parler(beneficiaire.getNom() + " prend ces " + argent_donne + " sous.");
		perdreArgent(argent_donne);
		beneficiaire.recevoir(argent_donne);
	}
}
