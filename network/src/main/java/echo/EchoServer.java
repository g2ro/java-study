package echo;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;


public class EchoServer {
	public static final int PORT = 59996;

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket socket = null;

		try {
			// 1. 서버소켓 생성
			serverSocket = new ServerSocket();

			// 2. 바인딩
			// Socket에 InetSocketAddress[InetAddress(IPAddress) + port]
			// IPAddress: 0.0.0.0: 특정 호스트 IP를 바인딩 하지 않는다. -> 전부 수용하겠다는 의미
			serverSocket.bind(new InetSocketAddress("0.0.0.0", PORT)); // 호스트 네임, 포트
			log("starts...[port:" + PORT + "]");

			// 3. accept
			while(true) {
				socket = serverSocket.accept(); // blocking 중에 다시 실행하지 말고 반납 후 다시 사용
				new EchoReceiveHandler(socket).start();

			}
		
		} catch (IOException e) { // 예외처리 2 : 서버 소켓(ServerSocket)과 관련된 작업에서 발생하는 예외를 처리
			log("error : " + e);

		} finally {
			try {
				if (serverSocket != null && !serverSocket.isClosed()) {
					serverSocket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public static void log(String message) {
		System.out.println("[Echo Server] " + message);
	}
}