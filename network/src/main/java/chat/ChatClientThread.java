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
			if (!"join:finish".equals(br.readLine())) {
			    System.out.println("연결 실패: 서버에서 'join:finish' 메시지를 받지 못했습니다.");
			    socket.close();
			    System.exit(0);
			}

			
			while (true) {
				String data = br.readLine();
				System.out.println(data);
			}

		} catch (UnsupportedEncodingException e) {
			ClientLog("error" + e);
		} catch (IOException e) {
			ClientLog("error" + e);
		}

	}

	public static void ClientLog(String message) {
		System.out.println("[Client]" + message);
	}

}
