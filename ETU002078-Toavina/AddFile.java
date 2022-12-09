package composant;
import javax.swing.*;
import java.awt.*;
import client.*;
import server.*;
public class AddFile extends JFrame{
    
    JButton btnAdd;
    public void setBtnAdd(JButton btn)
    {
        this.btnAdd = btn;
    }
    public JButton getBtnAdd()
    {
        return btnAdd;
    }
    public AddFile()
    {
        this.setLayout(new FlowLayout());
        this.setSize(300,200);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}