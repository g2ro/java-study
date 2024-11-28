package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;

public class EchoReceiveHandler extends Thread {
	private Socket socket ;
	
	public EchoReceiveHandler(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		
		try {
			// 클라이언트의 원격 주소 정보를 출력
			InetSocketAddress inetRemoteSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
			String remoteHostAddress = inetRemoteSocketAddress.getAddress().getHostAddress();
			int remotePort = inetRemoteSocketAddress.getPort();
			EchoServer.log("connected by client + [" + remoteHostAddress + " : " + remotePort + "]");

			// 4. IO Stream 받아오기
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"utf-8"), true); //autoFlush == true
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(),"EUC_KR")); //Flush가 없어도 돼

			// 5. 데이터 읽기
			while (true) {
				//byte[] buffer = new byte[256];
				//int readByteCount = is.read(buffer);
				String data = br.readLine();

				if (data == null) { // 꽉 차있다 == 소켓을 닫은 것
					// closed by clinet
					EchoServer.log("closed by client");
					break;
				}
				// -1이 아니라는 것 = 무언가 읽음

				EchoServer.log("received : " + data);
				// 6. 데이터 쓰기
				pw.println(data);
			}

		} catch (SocketException e) {
			EchoServer.log("Socket Exception : " + e);
		} catch (IOException e) { // 예외처리 1 : socket 객체와 관련된 작업(주로 데이터 송수신 과정)에서 발생하는 예외를 처리
			EchoServer.log("error : " + e);

		} finally {
			
			try {
				if (socket != null && !socket.isClosed()) {
					socket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}