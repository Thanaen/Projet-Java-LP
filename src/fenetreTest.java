import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class fenetreTest extends JFrame{
	private JButton commencer;
	private JLabel imgFond;
	private JButton bouton1;
	private JButton bouton2;
	private JButton bouton3;
	
	private Verrou verrou1;
	private Verrou verrou2;
	private Verrou verrou3;
	
	private Bouton monBouton1;
	private Bouton monBouton2;
	private Bouton monBouton3;
	
	public fenetreTest(String nomFenetre)
	{
		super(nomFenetre);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		verrou1 = new Verrou(true);
		verrou2 = new Verrou(false);
		verrou3 = new Verrou(true);
		
		Vector<Verrou> verrousB1 = new Vector<Verrou>();
		verrousB1.add(verrou1);
		verrousB1.add(verrou3);
		monBouton1 = new Bouton(verrousB1);
		
		Vector<Verrou> verrousB2 = new Vector<Verrou>();
		verrousB2.add(verrou2);
		monBouton2 = new Bouton(verrousB2);
		
		Vector<Verrou> verrousB3 = new Vector<Verrou>();
		verrousB3.add(verrou1);
		verrousB3.add(verrou2);
		verrousB3.add(verrou3);
		monBouton3 = new Bouton(verrousB3);
		
		// Mise en place de l'interface
		BorderLayout placement=new BorderLayout();
		getContentPane().setLayout(placement);	
		
		// Image de fond du jeu
		ImageIcon monImg = new ImageIcon("coffre_ferme.png");
		imgFond = new JLabel(monImg);
		getContentPane().add(imgFond, BorderLayout.CENTER);
		
		// Barre du bas
		JPanel barreBas = new JPanel();
		getContentPane().add(barreBas, BorderLayout.SOUTH);
		barreBas.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 5));
		
		commencer = new JButton("Commencer");
		barreBas.add(commencer);
		
		bouton1 = new JButton("bouton1");
		bouton1.addMouseListener(new ClicDeSouris());
		barreBas.add(bouton1);
		
		bouton2 = new JButton("bouton2");
		bouton2.addMouseListener(new ClicDeSouris());
		barreBas.add(bouton2);
		
		bouton3 = new JButton("bouton3");
		bouton3.addMouseListener(new ClicDeSouris());
		barreBas.add(bouton3);
		
		pack();
		setVisible(true);
	}
	
	private class ClicDeSouris extends MouseAdapter
	{
		public synchronized void mouseClicked(MouseEvent e) 
		{
			if(e.getSource() == bouton1){monBouton1.changerEtat();}
			if(e.getSource() == bouton2){monBouton2.changerEtat();}
			if(e.getSource() == bouton3){monBouton3.changerEtat();}
			
			if(verrou1.getEtat()==true && verrou2.getEtat()==true && verrou3.getEtat()==true)
			{
				setImageFond(new ImageIcon("Grand_coffre.gif"));

				setImageFond(new ImageIcon("coffre_ouvert.png"));
			}
		}
	}
	
	public void setImageFond(ImageIcon img)
	{
		this.imgFond.setIcon(img);
	}
	
	public void attendreOuverture()
	{
		//Delay(2000);
	}
}

