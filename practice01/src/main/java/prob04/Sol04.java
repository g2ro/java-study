package prob04;

import java.util.Scanner;

public class Sol04 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("문자열을 입력하세요 :");
		String str = scanner.nextLine();
		
		int len = str.length();
		for(int i = 0; i<len; i++) {
			for(int ele=0; ele<=i ; ele++) {
				System.out.print(str.charAt(ele));
			}
			System.out.println();
		}
		
		
		scanner.close();
	}
}