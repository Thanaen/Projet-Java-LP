import java.util.Vector;

public class Bouton {
	// Attributs
	private Vector<Verrou> listeVerrous;
	
	// Constructeur
	public Bouton(Vector<Verrou> listeVerrous, int numero){
		this.listeVerrous = listeVerrous;
	}
	
	// Changer état verrous
	public void changerEtat(){
		for(int i=0; i<listeVerrous.size(); i++)
		{
			listeVerrous.elementAt(i).changerEtat();
		}
	}
}
