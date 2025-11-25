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
	
	
	public void provoquer(Yakuza adversaire) {
		int force = 2*honneur;
		parler("Je t'ai retrouvé vermine, tu vas payer pour ce que tu as fait à ce pauvre marchand!");
		if (force >= adversaire.getReputation()) {
			parler("Je t'ai eu petit yakuza!");
			adversaire.perdre();
			honneur++;
		}else {
			parler("J'ai perdu contre ce yakuza, mon honneur et ma bourse ont en pris un coup.");
			honneur--;
			adversaire.gagner(getArgent());
		}
	}
	
}
