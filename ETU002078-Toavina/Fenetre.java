import java.awt.*;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;

import javax.swing.*;

public class Fenetre extends JFrame{
    Client client;
	PanelMess box;
	JTextField message;
	JButton sendMessage;

    public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public PanelMess getBox() {
		return box;
	}
	public void setBox(PanelMess box) {
		this.box = box;
	}
	public JTextField getMessage() {
		return message;
	}
	public void setMessage(JTextField message) {
		this.message = message;
	}
	public JButton getSendMessage() {
		return sendMessage;
	}
	public void setSendMessage(JButton sendMessage) {
		this.sendMessage = sendMessage;
	}
	public Fenetre(String nom) {
        this.setTitle("Accueil de "+nom);
        this.setClient(new Client(this,nom, "127.0.0.1", 5000));
		this.setLayout(new BorderLayout());
		this.setSize(400, 800);
        this.setResizable(false);
		box = new PanelMess();
		box.setSize(new Dimension(400,400));
		this.add(BorderLayout.CENTER,box);
		/*-----------------*/
		JPanel temp = new JPanel();
		this.setMessage(new JTextField("                                                                 "));
		this.setSendMessage(new JButton(">"));
		temp.setLayout(new FlowLayout());
		temp.add(this.getMessage());
		temp.add(this.getSendMessage());
		/*-----------------*/
		JPanel user = new JPanel();
        user.setSize(300,50);
		user.setLayout(new BorderLayout());
		JTextArea userName = new JTextArea(nom);
        userName.setFont(new Font("Consolas",Font.PLAIN,20));
        userName.setForeground(Color.red);
		user.add(BorderLayout.CENTER,userName);
		/*-----------------*/
		this.add(BorderLayout.SOUTH,temp);
		this.add(BorderLayout.NORTH,user);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.add(new JScrollPane(box), BorderLayout.CENTER);

        this.getSendMessage().addMouseListener(new ListenerMouse(this));
		this.setVisible(true);
	}
	public void afficherMessage(String mess)
	{
		this.getBox().append(mess+"\n");
		this.repaint();
		this.revalidate();
	}
}
