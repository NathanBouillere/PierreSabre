package personnages;

public class Humain {
	private String nom;
	private String boissonfavorite;
	private int argent;
	protected int nbConnaissance;
	protected Humain[] memoire = new Humain[30];
	
	
	
	public Humain(String nom, String boissonfavorite, int argent) {
		this.nom = nom;
		this.boissonfavorite = boissonfavorite;
		this.argent = argent;
	}

	public String getNom() {
		return nom;
	}

	public int getArgent() {
		return argent;
	}
	
	protected void parler(String texte) {
		System.out.println("(" + nom + ") - "  + texte);
	}
	
	public void acheter(String bien, int prix) {
		if (prix > argent) {
			parler("Je n'ai plus que " + argent + " sous en poche. Je ne peux même pas m'offir un " + bien + " à " + prix + " sous.");
		}else {
			parler("J'ai " + argent + " sous en poche. Je vais pouvoir m'offir " + bien + " à " + prix + " sous.");
			argent = perdreArgent(prix);
		}
	}
	
	protected int gagnerArgent(int gain) {
		argent += gain;
		return argent;
	}
	
	protected int perdreArgent(int perte) {
		argent -= perte;
		return argent;
	}
	
	public void direBonjour() {
		parler("Bonjour ! Je m'appelle " + nom + " et j'aime boire du " + boissonfavorite + ".");
	}
	
	public void boire() {
		parler("Mmmm, un bon verre de " + boissonfavorite  + "! GLOUPS !");
	}
	
	public void faireConnaissanceAvec(Humain autrehumain) {
		direBonjour();
		autrehumain.repondre(this);
		memoriser(autrehumain);
		
	}
	
	protected void memoriser(Humain humain) {
		if (memoire.length == nbConnaissance) {
			for(int i=0;i<nbConnaissance-1;i++) {
				memoire[i] = memoire[i+1];
			}
			memoire[nbConnaissance-1] = humain; 
		}else {
			memoire[nbConnaissance] = humain;
			nbConnaissance++;
		}
	}
	
	private void repondre(Humain humain) {
		direBonjour();
		memoriser(humain);
	}
	
	public void listerConnaissance() {
		String connaissance = "";
		for (int i=0;i<nbConnaissance;i++) {
			connaissance += memoire[i].getNom();
			if (i<nbConnaissance-1) {
				connaissance += ", ";
			}
		}
		parler("Je connais beaucoup de monde dont : " + connaissance);
	}
}
