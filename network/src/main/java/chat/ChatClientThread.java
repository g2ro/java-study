package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;

public class ChatClientThread extends Thread {
	private Socket socket;

	public ChatClientThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			while(true) {
				String data = br.readLine();
				System.out.println(data);
			}
		} catch (UnsupportedEncodingException e) {
			System.out.println("error" + e);
		} catch (IOException e) {
			System.out.println("error" + e);
		}
		
		
	}
	
	
}
