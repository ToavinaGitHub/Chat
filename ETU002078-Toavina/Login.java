import javax.swing.*;
import java.awt.*;
public class Login extends JFrame{
    JTextField nom;
    JButton btn;
    
	public JTextField getNom() {
		return nom;
	}

	public void setNom(JTextField nom) {
		this.nom = nom;
	}
    public JButton getBtn() {
		return btn;
	}

	public void setBtn(JButton btn) {
		this.btn = btn;
	}

    public Login()
    {
        this.setTitle("Login");
        setLayout(new GridLayout(1,2));
        this.setSize(400,20);
        this.setNom(new JTextField());
        this.setBtn(new JButton("OK"));
        this.getNom().setSize(new Dimension(200,100));
        this.setSize(400,130);
        this.setResizable(false);
        this.add(getNom());
        add(getBtn());
        this.getNom().setText("Entrez votre nom ici");
        getBtn().addMouseListener(new ListenerMouse(this));
        this.setVisible(true);
    }

	
}
