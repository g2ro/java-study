package prob04;

public class MyStackTest02 {

	public static void main(String[] args) {
		try {
			MyStack02 stack = new MyStack02(3);
			stack.push("Hello");
			stack.push("World");
			stack.push("!!!");
//			stack.push("java");
			stack.push(1); // boxing 발생
			stack.push(".");

			while (stack.isEmpty() == false) {
//				String s = (String)stack.pop(); // miss casting 문제가 발생할 가능성이 생김.
				Object s = stack.pop();
				System.out.println(s);
			}

			System.out.println("======================================");

			stack = new MyStack02(3);
			stack.push("Hello");

			System.out.println(stack.pop());
			System.out.println(stack.pop());

		} catch (MyStackException ex) {
			System.out.println(ex);
		}
	}
}