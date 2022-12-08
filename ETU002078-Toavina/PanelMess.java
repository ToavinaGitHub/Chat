
import java.awt.Color;
import java.awt.Font;

import javax.swing.*;
public class PanelMess extends JTextArea{
	public PanelMess()
	{
        this.setBackground(new Color(1,131,173));
        this.setForeground(Color.white);
		this.setEditable(false);
		this.setLineWrap(true);
		this.setFont(new Font("Consolas",Font.PLAIN,20));
		this.setBorder(BorderFactory.createLineBorder(Color.black));
	}
}