package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;

public class TCPClient {

	public static void main(String[] args) {
		Socket socket = null; // try chatch, closed를 쉽게 하기 위해

		try {
			// 1. 소켓 생성
			socket = new Socket();

			// 2. 서버연결 connect
			socket.connect(new InetSocketAddress("192.168.0.109", 60000));

			// 3. IO Stream 받아오기
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();

			// 4. 쓰기
			String data = "Hello World";
			os.write(data.getBytes("utf-8"));

			// 5. 읽기
			byte[] buffer = new byte[256];
			int readByteCount = is.read(buffer); // 읽은 Byte의 수 출력
			if (readByteCount == -1) { // 상태편이 close를 명시적으로 호출할때,
				System.out.println("[client] closed by server");
				return;
			}
			data = new String(buffer, 0, readByteCount, "utf-8"); // byte -> string
			System.out.println("[client] received:" + data);

		} catch (SocketException e) {
			System.out.println("[Client] Socket Exception:" + e);
		} catch (IOException e) {
			System.out.println("[Client] error:" + e);
		} finally {

			try {
				if (socket != null && !socket.isClosed()) {
					socket.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
