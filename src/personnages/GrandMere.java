package personnages;

import java.util.Random;

public class GrandMere extends Humain{
	private enum TypeHumain { COMMERCANT,RONIN,SAMOURAI,TRAITRE,YAKUZA,GRANDMER,HABITANT}
	private Random random = new Random();
	
	public GrandMere(String nom, int argent) {
		super(nom, "tisane", argent);
		memoire = new Humain[5];
	}

	@Override
	public void memoriser(Humain humain) {
		if (nbConnaissance<5) {
			super.memoriser(humain);
		}else {
			parler("Oh ma tête ! Je ne peux plus retenir le nom d'une personne supplémentaire !");
		}
		
	}
	
	public String humainHasard() {
		TypeHumain[] types = TypeHumain.values();
		int index = random.nextInt(types.length);
		
		return types[index].toString().toLowerCase();
	}
	
	public void ragoter() {
		for (int i=0;i<nbConnaissance;i++) {
			Humain humain = memoire[i];
			if (humain instanceof Traitre) {
				parler("Je sais que " + humain.getNom() + " est un traitre. petit chenapan!");
			}else {
				parler("je crois que " + humain.getNom() + " est un " + humainHasard()); 
			}
		}
	}
	
	
}
