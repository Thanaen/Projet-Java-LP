import javax.swing.JFrame;

import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuChoixNiveau extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1370735717685911963L;

	public MenuChoixNiveau() {
		setTitle("Choix des niveaux");
		getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnNiveau1 = new JButton("Niveau 1");
		btnNiveau1.addActionListener(new actionNiveau1());
		getContentPane().add(btnNiveau1);
		
		JButton btnNiveau2 = new JButton("Niveau 2");
		btnNiveau2.addActionListener(new actionNiveau2());
		getContentPane().add(btnNiveau2);
		
		JButton btnRetour = new JButton("<---------------");
		btnRetour.setToolTipText("Retour au menu pr\u00E9c\u00E9dent");
		btnRetour.addActionListener(new actionRetour());
		getContentPane().add(btnRetour);
	}

	private class actionNiveau1 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			new fenetreTest2("Niveau 1",1);
			dispose();
		}
	}
	
	private class actionNiveau2 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			new fenetreTest2("Niveau 2",2);
			dispose();
		}
	}
	
	private class actionRetour implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			new Interface();
			dispose();
		}
	}
}
