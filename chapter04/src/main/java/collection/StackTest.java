package collection;

import java.util.Stack;

public class StackTest {

	public static void main(String[] args) {
		Stack<String>s = new Stack(); //vector를 상속 받아 구성됨.
		
		s.push("둘리");
		s.push("마이콜");
		s.push("또치");
		
		while(!s.empty()) {
			String str = s.pop();
			System.out.println(str);
		}
		// 비어 있는 경우 예외발생
		// s.pop();
		
		s.push("둘리");
		s.push("마이콜");
		s.push("또치");
		
		System.out.println(s.pop());
		System.out.println(s.peek()); // pop을 하지 말고 맨위에 뭐가 있는지 확인.
	}

}
