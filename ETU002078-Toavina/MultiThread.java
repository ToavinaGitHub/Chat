package server;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import client.*;
import server.*;
public class MultiThread implements Runnable {
	Serveur server;										
	Socket client;										
	Thread serverThread;
	BufferedReader in;
	PrintWriter out;
	int clientId = 0;
	String clientName;
	String message;
	
	public MultiThread(Socket client, Serveur server) {
		this.client = client;
		this.server = server;
		try {
			in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			out = new PrintWriter(client.getOutputStream());
			clientId = server.addClient(client);
			serverThread = new Thread(this);
			
			serverThread.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void run() {
		try {
			message = in.readLine();
			clientName = message;
			message = in.readLine();
			while (message != null) {
				server.sendToAll(message);
				message = in.readLine();
			}
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
				server.deleteClient(clientId);
				client.close();
				serverThread.join();
			} catch (IOException | InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
