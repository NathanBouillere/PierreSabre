package personnages;

public class Humain {
	private String nom;
	private String boissonfavorite;
	private int argent;
	
	
	
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
	
	
	
	public int gagnerArgent(int gain) {
		argent += gain;
		return argent;
	}
	
	public int perdreArgent(int perte) {
		argent -= perte;
		return argent;
	}
	
	public void direBonjour() {
		parler("Bonjour ! Je m'appelle " + nom + " et j'aime boire du " + boissonfavorite + ".");
	}
	
	public void boire() {
		parler("Mmmm, un bon verre de " + boissonfavorite  + "! GLOUPS !");
	}
	
	
}
