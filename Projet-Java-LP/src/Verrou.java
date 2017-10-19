
public class Verrou {
	private boolean etat; // True = ouvert False = fermé
	private boolean etatInitial;
	
	public Verrou(etatInitial)
	{
		this.etatInitial = etatInitial;
		this.etat = etatInitial;
	}
	
	public ouvrir()
	{
		this.etat = true;
	}
	
	public fermer()
	{
		this.etat = false;
	}
}
