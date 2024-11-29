package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

public class ChatServerThread extends Thread {
	private Socket socket;
	private String nickname;
	
	private static List<Writer> writerPool = new LinkedList<>();
	
	public ChatServerThread(Socket socket) {
		this.socket = socket;
		
	}
	
	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	
	@Override
	public void run() {
		try {
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"),true); // 보내는 기능.
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8")); // 읽어 오는 기능
			
			
			while(true) {
				String data = br.readLine(); // client 
				// join, msg, quit => client 메시지 보낼지 
				
				
				String [] tokens = data.split(":");
				
				
				if("join".equals(tokens[0])) {
					setNickname(tokens[1]);
					join(tokens[1], pw);
				}
				else if("msg".equals(tokens[0])) {
					String nickname = getNickname();
					String message =  nickname + ":" + tokens[1];
					msg(message);
				}
				else if("quit".equals(tokens[0])) {
					String nickname = getNickname();
					String message =  nickname + "님이 퇴장했습니다.";
					msg(message);
					quit(pw);
					break;
				}
				
			}
			
		} catch (IOException e) {
			System.out.println("error " + e);
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
	
	private void quit(PrintWriter pw) {
		writerPool.remove(pw);
	}

	public void join(String s, PrintWriter pw) {
		String nickname = getNickname();
		String enter = nickname + "님이 참가했습니다.";
		msg(enter);
		writerPool.add(pw);
		pw.println("채팅방에 입장했습니다.");
	}
	
	public void msg(String s) {
		synchronized (writerPool) {
			for(Writer pw : writerPool) {
				((PrintWriter)pw).println(s);
			}
		}
		
	}
}
