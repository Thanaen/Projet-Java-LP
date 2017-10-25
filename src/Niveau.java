import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Vector;

import javax.swing.text.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class Niveau {

	//ATTRIBUTS
	private int numero;					//le numéro du niveau
	private int nbVerrou ;				//le nombre de vérrou et de boutton que le coffre a.
	private Vector<Verrou> verrous;		//la liste des vérrous du niveau
	private Vector<Bouton> boutons;		//la liste des boutons du niveau
	
	//METHODES 
	
	public Niveau(int numero){

		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			File listeNiveaux = new File("listeNiveau.xml");
	        Document xml = (Document) builder.parse(listeNiveaux);

		}
		catch (FileNotFoundException fnf) {
			System.err.println("Pas de fichier disponible");
		}
		catch (IOException ioe) {
			System.err.println("lecture impossible");
			ioe.printStackTrace();
		}
		
//		public static void main(String[] args) {
//		      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//
//		      try {
//		         DocumentBuilder builder = factory.newDocumentBuilder();
//		         File fileXML = new File("test.xml");
//		         Document xml = builder.parse(fileXML);
//		         
//		         ArrayList<Element> list = new ArrayList<>();
//		         Element root = xml.getDocumentElement();
//		         getNodes(root, list);
//		         
//		         for(Element el : list){
//		            System.out.println("Nom : " + el.getNodeName() + " - Valeur : " + el.getTextContent());
//		         }         
//		      } catch (ParserConfigurationException e) {
//		         e.printStackTrace();
//		      } catch (SAXException e) {
//		         e.printStackTrace();
//		      } catch (IOException e) {
//		         e.printStackTrace();
//		      }
//		   }
		
	}
	
	public void lire(){
		
	}
	
}
