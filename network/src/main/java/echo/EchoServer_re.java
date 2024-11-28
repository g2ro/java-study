package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class EchoServer_re {
	public static final int PORT = 60000;
	public static void main(String[] args) {
		ServerSocket serverSocket = null;

		try {
			serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress("0.0.0.0", PORT));
			Log("starts...[port:" + PORT +"]");

			Socket socket = serverSocket.accept();
			try {
				InetSocketAddress inetRemoteSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
				String remoteHostAddress = inetRemoteSocketAddress.getAddress().getHostAddress();
				int remotePort = inetRemoteSocketAddress.getPort();

				Log("connected by client[" + remoteHostAddress + ":" + remotePort + "]");

				// 4.IO Stream 받아오기
//				InputStream is = socket.getInputStream();
//				OutputStream os = socket.getOutputStream();
				
				PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"),true);
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
				while (true) {
//					byte[] buffer = new byte[256];
//					int readByteCount = br.read(buffer); // blocking
					String data = br.readLine(); // \r을 붙여서 보내야함
					if (data == null) {
						Log("closed by client");
						break;
					}

					Log("receive: " + data);

					// 6. 데이터 쓰기
//					pw.println(data);
					pw.print(data + "\n");
				}
			} catch (IOException e) {
				Log("error: " + e);
			} finally {
				try {
					if (socket != null && !socket.isClosed()) {
						socket.close(); // inputStream이 닫히면서 같이 닫힐 수 가 있음.
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} catch (SocketException e) {
			Log("Socket Exception:" + e);
		} catch (IOException e) {
			Log("error:" + e);
		} finally {
			try {
				if (serverSocket != null && serverSocket.isClosed()) {
					serverSocket.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
	}
	public static void Log(String message) {
		System.out.println("[Echo server]" + message);
	}
	
}


