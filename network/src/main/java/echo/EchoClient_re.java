package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class EchoClient_re {
    private static final String SERVER_IP = "192.168.0.211";
    private static final int SERVER_PORT = 60000;

    public static void main(String[] args) {
        try (Socket socket = new Socket();
             Scanner scanner = new Scanner(System.in)) {

            // 1. 서버 연결
            socket.connect(new InetSocketAddress(SERVER_IP, SERVER_PORT));
            log("Connected to server: " + SERVER_IP + ":" + SERVER_PORT);

            // 2. IO Stream 설정
            try (PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
                 BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"))) {

                while (true) {
                    System.out.print(">> ");
                    String line = scanner.nextLine();

                    if ("exit".equals(line)) {
                        log("Exiting...");
                        break;
                    }

                    // 3. 서버로 메시지 전송
                    pw.print(line + "\n");

                    // 4. 서버 응답 읽기
                    String data = br.readLine();
                    if (data == null) {
                        log("Server closed connection.");
                        break;
                    }
                    System.out.println("<< " + data);
                }
            }
        } catch (SocketException e) {
            log("Socket Exception: " + e.getMessage());
        } catch (IOException e) {
            log("I/O Exception: " + e.getMessage());
        }
    }

    private static void log(String message) {
        System.out.println("[Echo Client] " + message);
    }
}
