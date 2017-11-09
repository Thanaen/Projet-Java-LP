import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Interface extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5529336786288984928L;

	public Interface() {

		// Paramètres de la fenêtre
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,400);
		setLocationRelativeTo(null);//Permet de centrer la fenêtre dans l'écran de l'utilisateur
		setTitle("Jeu du coffre");
		getContentPane().setLayout(new GridLayout(0, 1, 0, 0));

		JButton btnJouer = new JButton("Jouer");
		getContentPane().add(btnJouer);

		btnJouer.addActionListener(new actionJouer());
		btnJouer.setAlignmentX(Component.CENTER_ALIGNMENT);

		JButton btnCopyrights = new JButton("Credits");
		getContentPane().add(btnCopyrights);

		btnCopyrights.addActionListener(new actionCopy());
		btnCopyrights.setAlignmentX(Component.CENTER_ALIGNMENT);

		JButton btnQuitter = new JButton("Quitter");
		getContentPane().add(btnQuitter);

		btnQuitter.addActionListener(new actionQuitter());
		btnQuitter.setAlignmentX(Component.CENTER_ALIGNMENT);

		setVisible(true);
		//pack();
	}

	// Termine la machine virtuelle java
	private class actionQuitter implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}

	// Lance l'interface dédiée au jeu, et ferme la fenêtre actuelle
	private class actionJouer implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			dispose();
		}
	}
	
	// Affiche une pop-up contenants diverses informations sur le programme.
	private class actionCopy implements ActionListener {
		public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null,
				"Le Jeu du coffre a été réalisé par Basil Soubrevilla, Loïc Barbé et Clément Costedoat, le 10/11/2017.");
		}
	}

}
