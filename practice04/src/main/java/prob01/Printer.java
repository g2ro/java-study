package prob01;

public class Printer {
	
	public void println(int a) {
		System.out.println(a);
	}
	
	public void println(boolean a) {
		if(a) {
			System.out.println("True");
		}
		else {
			System.out.println("False");
		}
	}
	
	public void println(double f) {
		System.out.println(f);
	}
	
	public void println(String name) {
		System.out.println(name);
	}
}
