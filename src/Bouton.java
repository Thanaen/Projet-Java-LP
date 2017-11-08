import java.util.Vector;

public class Bouton {
	//Attributs
	private Vector<Verrou> listeVerrous;
	private int numero;
	
	//Constructeur
	public Bouton(Vector<Verrou> listeVerrous, int numero){
		this.listeVerrous = listeVerrous;
		this.numero=numero;
	}
}
