package prob06;

import java.util.Random;
import java.util.Scanner;

public class Sol06 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while(true) {
			
			/* 게임 작성 */

			// 정답 램덤하게 만들기
			Random random = new Random();
			int correctNumber = random.nextInt(100) + 1;
			
			int result = 0;
			int min = 0;
			int max = 100;
			int i = 0;
			
			System.out.println("수를 결정하였습니다. 맞추어보세요:");
			while(result != correctNumber) {
				
				System.out.println(min + "-" + max);
				System.out.print((++i) + ">>");
				result = scanner.nextInt();
				
				if((result < correctNumber) && (result > min)) {
					min = result;
					System.out.println("더 높게");
				}
				else if((result > correctNumber) && (result < max)) {
					max = result;
					System.out.println("더 낮게");
				}
				
			}
			System.out.println("맞췄습니다.");
			//새 게임 여부 확인하기
			System.out.print("다시 하겠습니까(y/n)>>");
			String answer = scanner.next();
			if("y".equals(answer) == false) {
				break;
			}
		}
		
		scanner.close();
	}
}