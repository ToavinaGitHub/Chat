package controller;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import java.io.*;
import client.*;
import server.*;
import composant.*;
public class ListenerMouse implements MouseListener{
    Login login;
	Fenetre fenetre;
    public ListenerMouse(Login l)
    {
        this.setLogin(l);
    }
	public ListenerMouse(Fenetre f)
	{
		this.setFenetre(f);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(getFenetre()==null)
		{
			if(e.getSource()==getLogin().getBtn())
       		{
				new Fenetre(getLogin().getNom().getText());
			}
		}else if(getFenetre()!=null){
			if(e.getSource()==getFenetre().getSendMessage())
			{
				try {
					
					getFenetre().getClient().sendMessage(getFenetre().getMessage().getText(),false);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			else if(e.getSource()==getFenetre().getSendFileBtn())
			{
				try {
					getFenetre().getClient().sendMessage(getFenetre().getMessage().getText(),true);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			else if(e.getSource()==getFenetre().getSendFile()){
				JFileChooser fc=new JFileChooser();    
				int i=fc.showOpenDialog(getFenetre());    
				if(i==JFileChooser.APPROVE_OPTION){    
					File f=fc.getSelectedFile();    
					String filepath=f.getPath();    
					try{  
					BufferedReader br=new BufferedReader(new FileReader(filepath));    
					String s1="",s2="";                         
					while((s1=br.readLine())!=null){    
						s2+=s1+"\n";    
					}    
					getFenetre().getMessage().setText(f.getName());  
					br.close();    
					}catch (Exception ex) {ex.printStackTrace();  }  
       
				}    
				
			}
		}
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public Login getLogin() {
		return login;
	}
	public void setLogin(Login login) {
		this.login = login;
	}
	
    public Fenetre getFenetre() {
		return fenetre;
	}
	public void setFenetre(Fenetre fenetre) {
		this.fenetre = fenetre;
	}
}
