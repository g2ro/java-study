package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

public class FileReaderTest {

	public static void main(String[] args) {
		Reader in = null;
		InputStream is = null;
		try {
			in = new FileReader("test.txt");
			is = new FileInputStream("test.txt");

			int data = -1;
			int count = 0;

			while ((data = in.read()) != -1) {
				System.out.print((char) data);
				count++;
			}
			System.out.println("");
			System.out.println("count:" + count);
			System.out.println("=====================");
			
			count = 0;
			data = -1;
			while((data = is.read()) != -1) {
				System.out.print((char)data); // is.read는 byte단위 => char 형변환하면 깨질것으로 예상됨.
				count++;
			}
			System.out.println("");
			System.out.println("count:" + count);
		} catch (FileNotFoundException e) {
			System.out.println("File not found: " + e);
		} catch (IOException e) {
			System.out.println("Error: " + e);
		} finally {
			try {
				if (in != null) {
					in.close();
				}
				if (is != null) {
					is.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
