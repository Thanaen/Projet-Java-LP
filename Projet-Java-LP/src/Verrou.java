
public class Verrou {
	private boolean etat; // True = ouvert False = fermé
	private boolean etatInitial;
	
	public Verrou(boolean etatInitial)
	{
		this.etatInitial = etatInitial;
		this.etat = etatInitial;
	}
	
	public void ouvrir()
	{
		this.etat = true;
	}
	
	public void fermer()
	{
		this.etat = false;
	}
}
