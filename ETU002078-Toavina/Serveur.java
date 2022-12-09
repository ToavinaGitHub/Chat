package server;
import java.io.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.Vector;
import client.*;

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
	/*---------------------------------------All fonctions-------------------------------------------- */
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
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		Serveur server = new Serveur();
		ServerSocket serverSocket = null;;
		Socket sock = null;;
		FileOutputStream fos=null;
		BufferedOutputStream bos=null;
		try {
			serverSocket = new ServerSocket(5000);
			/* ------------------------------transfert de fichier------------------------------ */

			// try {
			// 	sock = serverSocket.accept();
			// 	Scanner in = new Scanner(sock.getInputStream());
			// 	InputStream is = sock.getInputStream();
				
			// 	PrintWriter pr= new PrintWriter(sock.getOutputStream(),true); 
			// 	String FileName = in.nextLine();
				
			// 	fos = new FileOutputStream(FileName);
			// 	bos = new BufferedOutputStream(fos);
			// 	byte[] bitearray = new byte[4*1024];
				
			// 	int file = is.read(bitearray ,0 , bitearray.length);
			// 	bos.write(bitearray,0,file);
				
			// 	System.out.println("File :" + FileName);
			// 	System.out.println("Size :" + Filesize + "Byte");
				
			// } catch (Exception e) {
			// 	e.printStackTrace();
			// }
			/* ----------------------------------------X------------------------------------------ */
			while (true) {
				new MultiThread(serverSocket.accept(), server);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				bos.close();
				sock.close();	
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		
	}
}
