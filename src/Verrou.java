
public class Verrou {
    // Attributs
    private boolean etat; // True = ouvert False = ferm�
    private boolean etatInitial;

    // CONSTRUCTEUR
    public Verrou(boolean etatInitial) {
        this.etatInitial = etatInitial;
        this.etat = etatInitial;
    }

    // Ferme le verrou s'il est ouvert, l'ouvre sinon
    public void changerEtat() {
		if(this.etat = false){ouvrir()}
		else{fermer()}
	}
    
    // Ouvre le verrou
    public void ouvrir() {
        this.etat = true;
    }

    // Ferme le verrou
    public void fermer() {
        this.etat = false;
    }
}

