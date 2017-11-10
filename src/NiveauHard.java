import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class NiveauHard extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 465984409984516L;
	
	private JButton retourMenu;
	private JLabel imgFond;
	private JButton bouton1;
	private JButton bouton2;
	private JButton bouton3;
	private JButton bouton4;
	
	private Verrou verrou1;
	private Verrou verrou2;
	private Verrou verrou3;
	private Verrou verrou4;
	
	private JLabel imgVerrou1;
	private JLabel imgVerrou2;
	private JLabel imgVerrou3;
	private JLabel imgVerrou4;
	
	private Bouton Bouton1;
	private Bouton Bouton2;
	private Bouton Bouton3;
	private Bouton Bouton4;
	
	ImageIcon imgVerrou1II;
	ImageIcon imgVerrou2II;
	ImageIcon imgVerrou3II;
	ImageIcon imgVerrou4II;
	
	public NiveauHard(String nomFenetre)
	{
		super(nomFenetre);
		setSize(400,400);
		setLocationRelativeTo(null);//Permet de centrer la fenêtre dans l'écran de l'utilisateur
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//récupération des données du niveau
		
		
		verrou1 = new Verrou(true);
		verrou2 = new Verrou(false);
		verrou3 = new Verrou(false);
		verrou4 = new Verrou(false);
		
		Vector<Verrou> verrousB1 = new Vector<Verrou>();
		verrousB1.add(verrou1);
		verrousB1.add(verrou3);
		Bouton1 = new Bouton(verrousB1);
		
		Vector<Verrou> verrousB2 = new Vector<Verrou>();
		verrousB2.add(verrou1);
		verrousB2.add(verrou2);
		Bouton2 = new Bouton(verrousB2);
		
		Vector<Verrou> verrousB3 = new Vector<Verrou>();
		verrousB3.add(verrou1);
		verrousB3.add(verrou2);
		verrousB3.add(verrou3);
		Bouton3 = new Bouton(verrousB3);
		
		Vector<Verrou> verrousB4 = new Vector<Verrou>();
		verrousB4.add(verrou1);
		verrousB4.add(verrou4);
		Bouton4 = new Bouton(verrousB4);
		
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
		imgVerrou4 = new JLabel(imgVerrou4II);
		barreVerrous.add(imgVerrou1);
		barreVerrous.add(imgVerrou2);
		barreVerrous.add(imgVerrou3);
		barreVerrous.add(imgVerrou4);
		
		// Image de fond du jeu
		ImageIcon monImg = new ImageIcon("res/coffre_ferme2.png.png");
		imgFond = new JLabel(monImg);
		getContentPane().add(imgFond, BorderLayout.CENTER);
		
		// Barre du bas
		JPanel barreBas = new JPanel();
		getContentPane().add(barreBas, BorderLayout.SOUTH);
		barreBas.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 5));
		
		
		retourMenu = new JButton("Menu");
		retourMenu.addActionListener(new actionRetour());
		barreBas.add(retourMenu);
		
		
		bouton1 = new JButton("bouton1");
		bouton1.addMouseListener(new ClicDeSouris());
		barreBas.add(bouton1);
		
		bouton2 = new JButton("bouton2");
		bouton2.addMouseListener(new ClicDeSouris());
		barreBas.add(bouton2);
		
		bouton3 = new JButton("bouton3");
		bouton3.addMouseListener(new ClicDeSouris());
		barreBas.add(bouton3);
		
		bouton4 = new JButton("bouton4");
		bouton4.addMouseListener(new ClicDeSouris());
		barreBas.add(bouton4);
		
		pack();
		setVisible(true);
	}
	
	private class ClicDeSouris extends MouseAdapter
	{
		public synchronized void mouseClicked(MouseEvent e) 
		{
			if(e.getSource() == bouton1){Bouton1.changerEtat();}
			if(e.getSource() == bouton2){Bouton2.changerEtat();}
			if(e.getSource() == bouton3){Bouton3.changerEtat();}
			if(e.getSource() == bouton4){Bouton4.changerEtat();}
			verrousOuvertOuFerme();
			setImageVerrous();
			
			if(verrou1.getEtat()==true && verrou2.getEtat()==true && verrou3.getEtat()==true && verrou4.getEtat()==true)
			{
				//setImageFond(new ImageIcon("Grand_coffre.gif"));
				//attendreOuverture();
				setImageFond(new ImageIcon("res/coffre_ouvert2.png.png"));
			}
		}
	}
	
	private class actionRetour implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			new Interface();
			dispose();
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
		this.imgVerrou4.setIcon(imgVerrou4II);
	}
	
	public void attendreOuverture()
	{
		//delai(2000);
	}
	
	public void verrousOuvertOuFerme()
	{
		if(verrou1.getEtat()==true)
		{
			imgVerrou1II = new ImageIcon("res/cadenas_ouvert2.png");
		}
		else
		{
			imgVerrou1II = new ImageIcon("res/cadenas_ferme2.png");
		}
		
		if(verrou2.getEtat()==true)
		{
			imgVerrou2II = new ImageIcon("res/cadenas_ouvert2.png");
		}
		else
		{
			imgVerrou2II = new ImageIcon("res/cadenas_ferme2.png");
		}
		
		if(verrou3.getEtat()==true)
		{
			imgVerrou3II = new ImageIcon("res/cadenas_ouvert2.png");
		}
		else
		{
			imgVerrou3II = new ImageIcon("res/cadenas_ferme2.png");
		}
		
		if(verrou4.getEtat()==true)
		{
			imgVerrou4II = new ImageIcon("res/cadenas_ouvert2.png");
		}
		else
		{
			imgVerrou4II = new ImageIcon("res/cadenas_ferme2.png");
		}
	}
}

