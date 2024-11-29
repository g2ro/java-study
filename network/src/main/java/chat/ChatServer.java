package chat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
	public final static int PORT = 9999;
	
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket();
			
			serverSocket.bind(new InetSocketAddress("0.0.0.0", PORT));
			System.out.println("Server start [" + PORT + "]");
			while(true) {
				Socket socket = new Socket();
				socket = serverSocket.accept();
				
				//thread 객체 만들고 read, write는 thread가 처리하도록 하면 되겠지?
				new ChatServerThread(socket).start();
				
			}
			
		} catch (IOException e) {
			System.out.println("error" + e);
		} finally {
			if(serverSocket != null && !serverSocket.isClosed()) {
				try {
					serverSocket.close();
				} catch (IOException e) {
					System.out.println("error" + e);
				}
			}
		}

	}

}