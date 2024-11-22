package exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileTest {

	public static void main(String[] args) {
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream("hello.txt"); // 파일을 바이트 단위로 읽는 class
			int data = fis.read();
			System.out.println((char)data);
		} catch (FileNotFoundException e) {
			// e.printStackTrace(); // 프로그램에서 쌓인 stack을 출력해주는 코드
			System.out.println("error: " + e);
		} catch (IOException e) {
			System.out.println("error: " + e);
		} finally {
			try {
				if(fis != null) {
					fis.close(); // nullException 발생할 수 있기 때문에
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
