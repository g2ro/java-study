package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.Socket;
import java.util.Base64;
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
				
				if(data == null) {
					ChatServer.log("클라이언트로 부터 연결 끊김");
					break;
				}
				String decodedData = new String(Base64.getDecoder().decode(data), "utf-8");
				String [] tokens = decodedData.split(":");
				
				
				if("join".equals(tokens[0])) {
					join(tokens[1], pw);
				} else if("msg".equals(tokens[0])) {
					msg(nickname + ":" + tokens[1]);
				} else if("quit".equals(tokens[0])) {
					quit(pw);
				}
				
			}
			
		} catch (IOException e) {
			System.out.println("error " + e);
		} finally {
			if(socket != null && !socket.isClosed()) {
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}	
	}
	
	private void quit(PrintWriter pw) {
	    msg(nickname + "님이 퇴장했습니다.");
	    try {
	        pw.println(encodeBase64("quit ok")); // Base64로 인코딩 후 메시지 전송
	        writerPool.remove(pw);
	    } catch (Exception e) {
	        ChatServer.log("error" + e);
	    }
	}

	public void join(String nickname, PrintWriter pw) {
		setNickname(nickname);
		String enter = nickname + "님이 참가했습니다.";
		pw.println(encodeBase64("join:finish"));
		pw.println(encodeBase64("채팅방에 입장했습니다."));
		msg(enter);
		writerPool.add(pw);
	}
	
	public void msg(String s) {
		synchronized (writerPool) {
			for(Writer pw : writerPool) {
				((PrintWriter)pw).println(encodeBase64(s));
			}
		}
	}
	// Base64 인코딩 메서드
    private String encodeBase64(String message) {
        return Base64.getEncoder().encodeToString(message.getBytes());
    }
}
