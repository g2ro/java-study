package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class TCPClient {

	public static void main(String[] args) {
		Socket socket = null; // try chatch, closed를 쉽게 하기 위해

		try {
			// 1. 소켓 생성
			socket = new Socket();
			
			// 1-1. 소켓버퍼 사이즈 확인
			int rcvBufferSize = socket.getReceiveBufferSize();
			int sndBufferSize = socket.getSendBufferSize();
			
			System.out.println(rcvBufferSize + ":" + sndBufferSize);
			
			// 1-2. 소켓버퍼 사이즈 변경
			socket.setReceiveBufferSize(1024 * 10);
			socket.setSendBufferSize(1024 * 10);
			
			int rcvBufferSize2 = socket.getReceiveBufferSize();
			int sndBufferSize2= socket.getSendBufferSize();
			
			System.out.println(rcvBufferSize2 + ":" + sndBufferSize2);
			
			// 1-3. SO_NODELAY(Nagle Algorith OFF)
			socket.setTcpNoDelay(true);
			
			// 1-4 SO_TIMEOUT
			socket.setSoTimeout(3000);
			
			// 2. 서버연결 connect
			socket.connect(new InetSocketAddress("192.168.0.109", 60000));

			// 3. IO Stream 받아오기
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();

			// 4. 쓰기
			String data = "Hello World"; 
			// SO_TIMEOUT Test
//			try {
//				Thread.sleep(4000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
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

		} catch (SocketTimeoutException e) {
			System.out.println("[Client] Timeout!!:" + e);
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
