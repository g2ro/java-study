package chat.gui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Scanner;

import chat.ChatServer;

public class ChatWindow {
	public final static String IPaddr = "127.0.0.1"; 
	private PrintWriter pw;
	private BufferedReader br;
	private Socket socket = new Socket();
	private Frame frame;
	private Panel pannel;
	private Button buttonSend;
	private TextField textField;
	private TextArea textArea;

	public ChatWindow(String name) {
		frame = new Frame(name);
		pannel = new Panel();
		buttonSend = new Button("Send");
		textField = new TextField();
		textArea = new TextArea(30, 80);
	}

	public void show() {
		// Button
		buttonSend.setBackground(Color.GRAY);
		buttonSend.setForeground(Color.WHITE);
		buttonSend.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) { // ActionEvent는 이벤트를 디테일하게 진행하고 싶을 때 이용함.
				sendMessage();
			}
		});
//		buttonSend.addActionListener(actionEvent -> {});
		
		// Textfield
		textField.setColumns(80);
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				char keyChar = e.getKeyChar();
				if(keyChar == KeyEvent.VK_ENTER) {
					sendMessage();
				}
			}
		});
		// Pannel
		pannel.setBackground(Color.LIGHT_GRAY);
		pannel.add(textField);
		pannel.add(buttonSend);
		frame.add(BorderLayout.SOUTH, pannel);

		// TextArea
		textArea.setEditable(false);
		frame.add(BorderLayout.CENTER, textArea);

		// Frame
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				finish();
			}
		});
		frame.setVisible(true);
		frame.pack();
		// 1. 서버 연결 작업
		// System.out.println(frame.getTitle());
		
		
		try {
			socket.connect(new InetSocketAddress(IPaddr, ChatServer.PORT), 0);
			
			// 2. IO Stream Setting
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"),true); // 보내는 기능.

			new ChatClientThread(socket).start();
			joinMessage(pw, frame.getTitle());

			
		} catch (IOException e1) {
			System.out.println("[error] : " + e1);
		}
		
		
		
		// 3. JOIN Protocol
		// 4. ChatClientThread 생성
	}
	private void joinMessage(PrintWriter pw, String name) {
		pw.println("join:" + name);
		try {
			String joinmsg = br.readLine();
			System.out.println(joinmsg);
		} catch (IOException e) {
			System.out.println("error" + e);
		}
	}
	
	private void sendMessage() {
		String message = textField.getText();
//		System.out.println("메시지를 보내는 프로토콜 구현 !: " + message);
		pw.println("msg:" + message);
		
		textField.setText(""); // 보낸 뒤 text필드 비우기
		textField.requestFocus(); // 커서 설정
		
		//ChatClientThread에서 서버로 부터 받은 메세지가 있다고 치고~
		//updateTextArea("아무개:" + message); // 나중에 지워야함.	
	}
	
	private void updateTextArea(String message) {
		textArea.append(message);
		textArea.append("\n");
	}
	private void finish() {
		// quit protocol 구현
		// java program 종료 => exit
		// exit java application
		if(socket != null && !socket.isClosed()) {
			try {
				pw.println("quit");
				if(br.readLine().equals("quit ok")) {
					socket.close();
				}
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		System.exit(0);
	}
	private class ChatClientThread extends Thread{
		private Socket socket;

		public ChatClientThread(Socket socket) {
			this.socket = socket;
		}

		@Override
		public void run() {
			try {
				br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
				while(true) {
					String data = br.readLine();
					updateTextArea(data);
				}
			} catch (UnsupportedEncodingException e) {
				System.out.println("error" + e);
			} catch (IOException e) {
				System.out.println("error" + e);
			}
			
			
		}
	}
}
