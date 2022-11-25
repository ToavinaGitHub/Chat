
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.Vector;

public class Serveur {
	Vector<Socket> Allclients = new Vector<Socket>();                        ///Les clients connecté
	int nbClient = 0;
	/*------------------------Getters and setters------------------------- */
	public Vector<Socket> getAllclients() {
		return Allclients;
	}
	public void setAllclients(Vector<Socket> allclients) {
		Allclients = allclients;
	}
	public int getNbClient() {
		return nbClient;
	}
	public void setNbClient(int nbClient) {
		this.nbClient = nbClient;
	}
	/*-------------------------All fonctions-------------------------------------------- */
	public int addClient(Socket client) {									///Ajouter nouveau client
		Allclients.add(client);
		this.setNbClient(getAllclients().size());
		return Allclients.size() - 1;
	}
	public void deleteClient(int i) {										///Supprimer un client
		Allclients.removeElementAt(i);
		this.setNbClient(getAllclients().size());
	}
	public void sendToAll(String mess) {									///Envoyer un message a tout les clients
		for (int i = 0; i < Allclients.size(); i++) {
			try {
				PrintWriter out = new PrintWriter(Allclients.get(i).getOutputStream());   
				out.println(mess);
				out.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		Serveur server = new Serveur();
		final ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(5000);
			while (true) {
				new MultiThread(serverSocket.accept(), server);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
