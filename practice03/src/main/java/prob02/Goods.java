package prob02;

public class Goods {
	
	private String name;
	private int price;
	private int number;
	
	public Goods(String name, int price, int number) {
		this.name = name;
		this.price = price;
		this.number = number;
	}
	
	public void printInfo() {
		System.out.println(
				this.name + "(가격:" +
				this.price + "원)이 " + 
				this.number + "개 입고 되었습니다.");
	}
}