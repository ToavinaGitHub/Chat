import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
public class ListenerMouse implements MouseListener{
    Login login;
    Accueil accueil;
	Fenetre fenetre;
    public ListenerMouse(Login l)
    {
        this.setLogin(l);
    }
	public ListenerMouse(Accueil a)
	{
		this.setAccueil(a);
	}
	public ListenerMouse(Fenetre f)
	{
		this.setFenetre(f);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(getAccueil()==null && getFenetre()==null)
		{
			if(e.getSource()==getLogin().getBtn())
       		{
				//new Accueil(getLogin().getNom().getText());
				new Fenetre(getLogin().getNom().getText());
			}
		}else if(getAccueil()!=null){
			if(e.getSource()==getAccueil().getBoutton())	
			{
				try {
					getAccueil().getClient().sendMessage(getAccueil().getMessage().getText());
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}else if(getFenetre()!=null){
			if(e.getSource()==getFenetre().getSendMessage())
			{
				try {
					getFenetre().getClient().sendMessage(getFenetre().getMessage().getText());
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
    public Fenetre getFenetre() {
		return fenetre;
	}
	public void setFenetre(Fenetre fenetre) {
		this.fenetre = fenetre;
	}
}
