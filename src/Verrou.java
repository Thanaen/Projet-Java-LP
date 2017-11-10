
public class Verrou {
    private boolean etat; // True = ouvert False = ferm�
    @SuppressWarnings("unused")
	private boolean etatInitial;

    public Verrou(boolean etatInitial) {
        this.etatInitial = etatInitial;
        this.etat = etatInitial;
    }
	
	public void changerEtat() {
		if(this.etat == false){ouvrir();}
		else{fermer();}
	}
    public void ouvrir() {
        this.etat = true;
    }

    public void fermer() {
        this.etat = false;
    }
    
    public boolean getEtat(){return this.etat;}
}
