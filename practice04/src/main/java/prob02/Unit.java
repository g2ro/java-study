package prob02;

public class Unit {
	private int x;
	private int y;
	
	void move(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	void stop() {
		System.out.println("Stop:[현재위치(" + x + ',' + y +")입니다]");
	}
}
