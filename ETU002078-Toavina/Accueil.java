package composant;
import javax.swing.*;
import java.awt.*;
import java.net.*;
import client.*;
import server.*;
public class Accueil extends JFrame{
   
	JTextField message;
    JButton boutton;
	
    public Accueil(String nom)
    {   
		//this.setClient(new Client(this,nom, "127.0.0.1", 5000));
		setLayout(new FlowLayout());
        setMessage(new JTextField("Entrez votre message ici"));
		getMessage().setSize(new Dimension(70,20));
        setBoutton(new JButton("ok"));
        setTitle("Accueil de "+nom);
		this.add(getMessage());
		this.add(getBoutton());

	//	getBoutton().addMouseListener(new ListenerMouse(this));
        
		setSize(400,800);
        setVisible(true);
    }
/*-----------------------------------Getters and Setters------------------------------------- */
	public JTextField getMessage() {
		return message;
	}

	public void setMessage(JTextField message) {
		this.message = message;
	}
	public JButton getBoutton() {
		return boutton;
	}
	public void setBoutton(JButton boutton) {
		this.boutton = boutton;
	}
	
	public void afficherMessage(String mess)
	{
		JLabel lab1 = new JLabel(mess);
		this.add(lab1);
		this.repaint();
		this.revalidate();
	}
	
    
}
