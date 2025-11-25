package personnages;

public class Yakuza extends Humain {
	private String clan;
	private int reputation=0;
	
	public Yakuza(String nom, String boissonfavorite, int argent, String clan) {
		super(nom, boissonfavorite, argent);
		this.clan = clan;
	}
	
	public void extorquer(Commercant victime) {
		parler("Tiens, tiens, ne seait-ce pas un faible marchand qui passe par là ?");
		parler(victime.getNom() + ", si tu tiens à la vie donne moi ta bourse!");
		int argent_vole = victime.seFaireExtorquer();
		gagnerArgent(argent_vole);
		reputation++;
		parler("J'ai piqué les " + argent_vole + " sous de " + victime.getNom() + ", ce qui me fait " + getArgent() + " sous dans ma poche. Hi! Hi!");
	}
	
	
	public int perdre() {
		int argent = getArgent();
		perdreArgent(argent);
		reputation--;
		parler("J'ai perdu mon duel et mes " + argent + " sous, snif... J'ai déshonoré le clan de " + clan + ".");
		return argent;
	}
	
	public void gagner(int gain) {
		gagnerArgent(gain);
		reputation++;
		parler("Ce ronin pensait vraiment battre " + getNom() + " du clan " + clan + "? Je l'ai dépouillé de ses " + gain + " sous.");
	}

	public int getReputation() {
		return reputation;
	}

	@Override
	public void direBonjour() {
		super.direBonjour();
		parler("Mon clan est " + clan + ".");
	}
	
	
	
	
	
	
	
}
