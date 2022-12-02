import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	static Socket clientSocket;      
	static BufferedReader in;       									///Lire ce qu'il a ecrit
	static PrintWriter out;												///Pour pouvoir ecrire
	static Scanner sc = new Scanner(System.in);    						///Prendre ce qu il a tapé
	Accueil a;
	String IpServer = "127.0.0.1";
	int port = 5000;
	String nomClient;

	public Client(Accueil a,String nom,String serverIp, int port) { 						
		this.setA(a);
		this.IpServer = serverIp;
		this.port = port;
		this.setNomClient(nom);
		Scanner sc = new Scanner(System.in);
		runThread();
	}
	public void sendMessage(String mess) throws Exception
	{
		out = new PrintWriter(clientSocket.getOutputStream()); 
		out.println(this.getNomClient()+"|"+mess);
		out.flush();
	}
	public void runThread() {										///Lancement du thread qui envoi le mess et afficher le mess 
		try {
			clientSocket = new Socket(getServerIp(), getPort());
			out = new PrintWriter(clientSocket.getOutputStream()); 
			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			out.println(getClientName());
			Thread recevoir = new Thread(new Runnable() {
				String msg;
				@Override
				public void run() {
					try {
						msg = in.readLine();
						while(msg != null) {
							System.out.println(msg);
							msg = in.readLine();	
							getA().afficherMessage(msg);
						}
						System.out.println("Serveur déconnecté");
						out.close();
					} catch (IOException e) {}
				}
			});
			recevoir.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/*------------------------------Getters and setters------------------------------------ */
	public static Socket getClientSocket() {
		return clientSocket;
	}

	public static void setClientSocket(Socket clientSocket) {
		Client.clientSocket = clientSocket;
	}

	public static BufferedReader getIn() {
		return in;
	}

	public static void setIn(BufferedReader in) {
		Client.in = in;
	}

	public static PrintWriter getOut() {
		return out;
	}

	public static void setOut(PrintWriter out) {
		Client.out = out;
	}
	
	public static Scanner getSc() {
		return sc;
	}

	public static void setSc(Scanner sc) {
		Client.sc = sc;
	}

	public String getServerIp() {
		return IpServer;
	}

	public void setServerIp(String serverIp) {
		this.IpServer = serverIp;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getClientName() {
		return nomClient;
	}

	public void setClientName(String clientName) {
		this.nomClient = clientName;
	}
	/*------------------------------------------------------------------------------------- */
	public String getIpServer() {
		return IpServer;
	}

	public void setIpServer(String ipServer) {
		IpServer = ipServer;
	}

	public String getNomClient() {
		return nomClient;
	}
	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	public Accueil getA() {
		return a;
	}

	public void setA(Accueil a) {
		this.a = a;
	}
}
