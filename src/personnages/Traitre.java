package personnages;

import java.util.Random;

public class Traitre extends Samourai{

	private int niveauTraitrise = 1;
	private Random random = new Random();
	
	public Traitre(String seigneur, String nom, String boissonfavorite, int argent) {
		super(seigneur, nom, boissonfavorite, argent);
		this.niveauTraitrise = niveauTraitrise;
	}
	
	@Override
	public void direBonjour() {
		super.direBonjour();
		parler("Mais je suis un traitre et mon niveau de traîtrise est : " + niveauTraitrise + ". Chut!");
	}
	
	public void ranconner(Commercant commercant) {
		if (niveauTraitrise<3) {
			int argent_commercant = commercant.getArgent();
			int argent_ranconner = argent_commercant * 2/10;
			commercant.perdreArgent(argent_ranconner);
			gagnerArgent(argent_ranconner);
			niveauTraitrise++;
			parler("Si tu veux ma protection contre les Yakuzas, il va falloir payer! donne-moi " + argent_ranconner + " sous ou gare à toi!");
			commercant.parler("Tout de suite grand " + getNom() + ".");
		}else {
			parler("Mince je ne peux plus ranconner personne sinon un samourai risque de me démasquer");
		}
		
	}
	
	public void faireLeGentil(Humain ami) {
		
		if (nbConnaissance <1) {
			parler("Je ne peux faire ami ami avec personne car je ne conni personne! Snif.");
		}else {
			String nomAmi = memoire[random.nextInt(nbConnaissance)].getNom();
			int don = getArgent()*1/20;
			parler("Il faut absolument remonter ma cote de confiance. Je vais fair eami ami avec " + nomAmi + ".");
			parler("Bonjour l'ami! " + " Je voudrais vous aider en vous donnant " + don + " sous.");
			ami.gagnerArgent(don);
			perdreArgent(don);
			String nom = getNom();
			ami.parler("Merci " + nom + ". Vous êtes quelqu'un de bien.");
			if (niveauTraitrise > 1) {
				niveauTraitrise--;
			}
		}
		
	}
	
	
	
	
	
}
