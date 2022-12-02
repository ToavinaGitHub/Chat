import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
public class ListenerMouse implements MouseListener{
    Login login;
    Accueil accueil;
	
    public ListenerMouse(Login l)
    {
        this.setLogin(l);
    }
	public ListenerMouse(Accueil a)
	{
		this.setAccueil(a);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(getAccueil()==null)
		{
			if(e.getSource()==getLogin().getBtn())
       		{
				new Accueil(getLogin().getNom().getText());
            }
		}else{
			if(e.getSource()==getAccueil().getBoutton())	
			{
				try {
					getAccueil().getClient().sendMessage(getAccueil().getMessage().getText());
				} catch (Exception ex) {
					ex.printStackTrace();
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
	public Accueil getAccueil() {
		return accueil;
	}
	public void setAccueil(Accueil accueil) {
		this.accueil = accueil;
	}
    
}
