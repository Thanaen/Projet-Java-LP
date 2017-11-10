import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.GridLayout;

public class MenuChoixNiveau extends JFrame {
	public MenuChoixNiveau() {
		setTitle("Choix des niveaux");
		getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnNiveau1 = new JButton("Niveau 1");
		getContentPane().add(btnNiveau1);
		
		JButton btnNiveau2 = new JButton("Niveau 2");
		getContentPane().add(btnNiveau2);
		
		JButton btnRetour = new JButton("<---------------");
		btnRetour.setToolTipText("Retour au menu pr\u00E9c\u00E9dent");
		getContentPane().add(btnRetour);
	}

}
