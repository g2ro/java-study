package httpd;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.file.Files;

public class RequestHandler extends Thread {
	private Socket socket;
	private final String DOCUMENT_ROOT = "./webapp";

	public RequestHandler(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			// get IOStream
			OutputStream outputStream = socket.getOutputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "EUC_KR"));

			// logging Remote Host IP Address & Port
			InetSocketAddress inetSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
			consoleLog("connected from " + inetSocketAddress.getAddress().getHostAddress() + ":"
					+ inetSocketAddress.getPort());
			
			String request = null;
			
			while(true) {
				String line = br.readLine();
				
				// 브라우저가 연결을 끊으면...
				if(line == null) {
					break;
				}
				
				//Simple HttpServer는 HTTP Heade만 읽는다.
				if("".equals(line)) {
					break;
				}
				
				// Request Header의 첫 줄만 읽음 
				if(request == null) {
					request = line;
					break;
				} 
			}
			
			consoleLog(request);
			String[] tokens = request.split(" ");
			// webapp 접근
			if("GET".equals(tokens[0])) {
				responseStaticResources(outputStream, tokens[1], tokens[2]);
			} else {
				// method : POST, DELETE, PUT, HEAD, CONNECT, ...
				// SimpleHttpServer에서는 무시(400 Bad request)
//				responseStaticResources400(outputStream, tokens[1], tokens[2]);
				response400Error(outputStream, tokens[2]);
			}
			
			
			// 예제 응답입니다.
			// 서버 시작과 테스트를 마친 후, 주석 처리 합니다.
//			outputStream.write("HTTP/1.1 200 OK\n".getBytes("UTF-8"));
//			outputStream.write("Content-Type:text/html; charset=utf-8\n".getBytes("UTF-8"));
//			outputStream.write("\n".getBytes());
//			outputStream.write("<h1>이 페이지가 잘 보이면 실습과제 SimpleHttpServer를 시작할 준비가 된 것입니다.</h1>".getBytes("UTF-8"));

		} catch (Exception ex) {
			consoleLog("error:" + ex);
		} finally {
			// clean-up
			try {
				if (socket != null && socket.isClosed() == false) {
					socket.close();
				}

			} catch (IOException ex) {
				consoleLog("error:" + ex);
			}
		}
	}
	

	private void responseStaticResources(OutputStream os, String url, String protocol) throws IOException{
		// default(welcom) file
		if("/".equals(url)) {
			url = "/index.html";
		}
		File file = new File(DOCUMENT_ROOT + url);
		if(!file.exists()) {
			// 404 response
			response404Error(os, protocol);
			
//			File file404 = new File(DOCUMENT_ROOT + "/error/404.html");
//			byte[] body = Files.readAllBytes(file404.toPath());
//			String contentType = Files.probeContentType(file404.toPath());
//			os.write("HTTP/1.1 404 NOT FOUND\n".getBytes("UTF-8"));
//			os.write(("Content-Type:" + contentType +"; charset=utf-8\n").getBytes("UTF-8"));
//			os.write("\n".getBytes());
//			os.write(body); // body가 없다면, 브라우져가 재공하는 에러 html로 이동한다.
			return;
		}
		
		// nio
		byte[] body = Files.readAllBytes(file.toPath()); //try_catch를 나를 부른 쪽으로 우회(회피하는 방법) => throws IOException
		String contentType = Files.probeContentType(file.toPath()); // contentType을 알아낼 수 있다. SMTP=메일 프로토콜
		
		os.write((protocol +" 200 OK\n").getBytes("UTF-8"));
		os.write(("Content-Type:" + contentType +"; charset=utf-8\n").getBytes("UTF-8"));
		os.write("\n".getBytes());
		os.write(body);
	}
	private void response404Error(OutputStream os, String protocol) {
		/*
		 HTTP/1.1 404 File Not Found\n
		 Content-Type: text/html; charset=utf-8\n
		 \n
		 
		 */
		
	}
	
	private void response400Error(OutputStream outputStream, String string) {
		/*
		 HTTP/1.1 400 Bod Request\n
		 Content-Type: text/html; charset=utf-8\n
		 \n
		 
		 */
		
	}
	
	private void responseStaticResources400(OutputStream os, String url, String protocol) throws IOException{
		File file400 = new File(DOCUMENT_ROOT + "/error/400.html");
		byte[] body = Files.readAllBytes(file400.toPath());
		String contentType = Files.probeContentType(file400.toPath());
		os.write("HTTP/1.1 400 bad request\n".getBytes("UTF-8"));
		os.write(("Content-Type:" + contentType +"; charset=utf-8\n").getBytes("UTF-8"));
		os.write("\n".getBytes());
		os.write(body);
		return;
	}

	public void consoleLog(String message) {
		System.out.println("[RequestHandler#" + getId() + "] " + message);
	}
}
