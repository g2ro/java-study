package chat;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {

	public static void main(String[] args) {
		Socket socket = new Socket();
		try {
			socket.connect(new InetSocketAddress("127.0.0.1", ChatServer.PORT));
			Scanner scanner = new Scanner(System.in);
			new ChatClientThread(socket).start();
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"),true); // 보내는 기능.
			
			System.out.print("닉네임 :");
			String nickname = scanner.nextLine();
			
			pw.println("join:" + nickname);
			while(true) {
				String line = scanner.nextLine();
				if(line.equals("quit")) {
					pw.println("quit");
					break;
				}else {
					String text = "msg:" + line;
					pw.println(text);
				}
//				pw.println(line);

				
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("error" + e);
		} finally {
			if(socket != null && !socket.isClosed()) {
				try {
					socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}

}
