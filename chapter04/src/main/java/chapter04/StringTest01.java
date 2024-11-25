package chapter04;

public class StringTest01 {

	public static void main(String[] args) {
		// c:\temp
		System.out.println("c:\temp"); // \t는 제어 문자 \\t를 통해 이스케이프진행.
		System.out.println("c:\\temp");
		
		// \t: tab
		// \r: carriage return
		// \n: newline
		// \b: beep
		
		System.out.print("hello\r\n");
		
		// "hello" -> js에선 '"hello"'
		System.out.println("\"hello\"");
		
		// '
		System.out.println('\'');
	}

}
