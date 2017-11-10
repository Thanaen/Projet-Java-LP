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

public class fenetreTest2 extends JFrame{
	private JButton commencer;
	private JLabel imgFond;
	private JButton bouton1;
	private JButton bouton2;
	private JButton bouton3;
	
	private Verrou verrou1;
	private Verrou verrou2;
	private Verrou verrou3;
	
	private JLabel imgVerrou1;
	private JLabel imgVerrou2;
	private JLabel imgVerrou3;
	
	private Bouton monBouton1;
	private Bouton monBouton2;
	private Bouton monBouton3;
	
	ImageIcon imgVerrou1II;
	ImageIcon imgVerrou2II;
	ImageIcon imgVerrou3II;
	
	public fenetreTest2(String nomFenetre, int numero)
	{
		super(nomFenetre);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//récupération des données du niveau
		
		Niveau leNiveau = new Niveau(numero);
		
		verrou1 = leNiveau.getVerrou(0);
		verrou2 = leNiveau.getVerrou(1);
		verrou3 = leNiveau.getVerrou(2);
		
		monBouton1 = leNiveau.getBouton(0);
		monBouton2 = leNiveau.getBouton(1);
		monBouton3 = leNiveau.getBouton(2);
		
		// Mise en place de l'interface
		BorderLayout placement=new BorderLayout();
		getContentPane().setLayout(placement);	
		
		JPanel barreVerrous = new JPanel();
		getContentPane().add(barreVerrous, BorderLayout.NORTH);
		barreVerrous.setLayout(new FlowLayout(FlowLayout.CENTER, 8, 40));
		
		// Peuplement barre verrous
		verrousOuvertOuFerme();
		imgVerrou1 = new JLabel(imgVerrou1II);
		imgVerrou2 = new JLabel(imgVerrou2II);
		imgVerrou3 = new JLabel(imgVerrou3II);
		barreVerrous.add(imgVerrou1);
		barreVerrous.add(imgVerrou2);
		barreVerrous.add(imgVerrou3);
		
		// Image de fond du jeu
		ImageIcon monImg = new ImageIcon("coffre_ferme2.png.png");
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
			verrousOuvertOuFerme();
			setImageVerrous();
			
			if(verrou1.getEtat()==true && verrou2.getEtat()==true && verrou3.getEtat()==true)
			{
				//setImageFond(new ImageIcon("Grand_coffre.gif"));
				//attendreOuverture();
				setImageFond(new ImageIcon("coffre_ouvert2.png.png"));
			}
		}
	}
	
	public void setImageFond(ImageIcon img)
	{
		this.imgFond.setIcon(img);
	}
	
	public void setImageVerrous()
	{
		this.imgVerrou1.setIcon(imgVerrou1II);
		this.imgVerrou2.setIcon(imgVerrou2II);
		this.imgVerrou3.setIcon(imgVerrou3II);
	}
	
	public void attendreOuverture()
	{
		//delai(2000);
	}
	
	public void verrousOuvertOuFerme()
	{
		if(verrou1.getEtat()==true)
		{
			imgVerrou1II = new ImageIcon("cadenas_ouvert2.png");
		}
		else
		{
			imgVerrou1II = new ImageIcon("cadenas_ferme2.png");
		}
		
		if(verrou2.getEtat()==true)
		{
			imgVerrou2II = new ImageIcon("cadenas_ouvert2.png");
		}
		else
		{
			imgVerrou2II = new ImageIcon("cadenas_ferme2.png");
		}
		
		if(verrou3.getEtat()==true)
		{
			imgVerrou3II = new ImageIcon("cadenas_ouvert2.png");
		}
		else
		{
			imgVerrou3II = new ImageIcon("cadenas_ferme2.png");
		}
	}
}

