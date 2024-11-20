package prob01;

import java.util.Scanner;

public class Sol01 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("금액: ");
		int temp = 0;
		int result = scanner.nextInt();
		final int[] MONEYS = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1};

		for(int i: MONEYS) {
			temp = result / i;
			System.out.println(i + "원:" + temp + "개");
			result = result - (i * temp);
		}
		
		scanner.close();
 	}
}