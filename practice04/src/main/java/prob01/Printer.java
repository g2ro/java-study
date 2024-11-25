package prob01;

public class Printer {

	// 다형성, 오버로드방식으로 해결
//	public void println(int a) {
//		System.out.println(a);
//	}
//	
//	public void println(boolean a) {
//		if(a) {
//			System.out.println("True");
//		}
//		else {
//			System.out.println("False");
//		}
//	}
//	
//	public void println(double f) {
//		System.out.println(f);
//	}
//	
//	public void println(String name) {
//		System.out.println(name);
//	}
	// 제네릭 return type이나 매개변수 type을 설정할 수 있다.
	
	public <T> void println(T t) {
		System.out.println(t);
	}
	
	public <T> void println(T... ts) {
		for(T t : ts) {
			System.out.print(t + " ");
		}
		System.out.print("\n");
	}

	public int sum(Integer... nums) {
		int s = 0;
		for(Integer n: nums) {
			s += n;
		}
		return s;
	}
}
