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
	
	String IpServer = "127.0.0.1";
	int port = 5000;
	String nomClient;

	
	public Client(String serverIp, int port) {
		this.IpServer = serverIp;
		this.port = port;
		Scanner sc = new Scanner(System.in);
		System.out.print("Entrez votre nom: ");
		this.nomClient = sc.nextLine();
		System.out.println("Bienvenue "+nomClient);
		runThread();
	}
	
	public void runThread() {											///Lancement du thread qui envoi le mess et afficher le mess 
		try {
			clientSocket = new Socket(getServerIp(), getPort());
			out = new PrintWriter(clientSocket.getOutputStream());
			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			out.println(getClientName());
			Thread envoi = new Thread(new Runnable() {				
				String msg;
				@Override
				public void run() {
					while(true) {
						msg = sc.nextLine();
						out.println(msg);
						out.flush();
					}
				}	
			});
			envoi.start();
			Thread recevoir = new Thread(new Runnable() {
				String msg;
				@Override
				public void run() {
					try {
						msg = in.readLine();
						while (msg != null) {
							System.out.println(msg);
							msg = in.readLine();
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
	/*-------------------------------------Main------------------------------------------------- */
	public static void main(String[] args) {
		new Client("127.0.0.1", 5000);
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
}
