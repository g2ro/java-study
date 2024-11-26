package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileCopy {
	public static void main(String[] agrs) {
		InputStream is = null;
		OutputStream os = null;
		try {
			is = new FileInputStream("ham.png");
			os = new FileOutputStream("ham.copy.png");
			
			int data = -1;
			while((data = is.read()) != -1) { // -1을 return한다면 파일이 끝을 의미함.
				os.write(data);
			}
			
			
		} catch (FileNotFoundException e) {
			System.out.println("file not found:" + e);
		}catch (IOException e) {
			System.out.println("error:" + e); // 읽고 쓸때 문제 발생 가능성
		}
		finally {
			try {
				if(is != null) {
					is.close();
				}
				if(os != null) {
					os.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
