package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class EchoClient {
	private static final String SERVER_IP = "127.0.0.1";
	public static void main(String[] args) {
		
		Socket socket = null;
		Scanner scanner = null;
		
		try {
			// 1. 소켓 생성
			socket = new Socket();
			scanner = new Scanner(System.in, "UTF-8");

			// 2. 서버 연결
			socket.connect(new InetSocketAddress(SERVER_IP, EchoServer.PORT));
			
			
			
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"utf-8"), true); //autoFlush == true
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(),"utf-8")); //Flush가 없어도 돼

			while (true) {
				System.out.print(">>");
				String line = scanner.nextLine();
				
				if ("exit".equals(line)) {
					break;
				}
				
				pw.println(line);
				
//				pw.print(line + "\n"); // flush가 안됨
				String data = br.readLine();
				
				if (data == null) {
					log("closed by server");
					break;
				}
				System.out.println("<<" + data); 
			}
			
		} catch (SocketException e) {
			log("Socket Exception:" + e);
		} catch (IOException e) {
			log("error:" + e);
		} finally {
			if (scanner != null) {
				scanner.close();
			}
			try {
				if (socket != null && !socket.isClosed()) {
					socket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void log(String message) {
		System.out.println("[Echo client] " + message);
	}

}