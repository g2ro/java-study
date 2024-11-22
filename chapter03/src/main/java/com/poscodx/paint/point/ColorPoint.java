package com.poscodx.paint.point;

public class ColorPoint extends Point {
	private String color;
	
	public ColorPoint(int x, int y, String color) {
		// this.x = x; // 불가능 -> Point에서 x는 private
		// super();
		// 현재 부모의 기본생성자가 있기 때문에 괜찮음 원래는 super를 이용 
		
		// 부모의 생성자를 선택할 수 있다.
		// setX(x);
		// setY(y);
		
		super(x, y); // 부모 생성자가 앞으로 와야함.
		this.color = color;
	}
	
	
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		//super.show(); 이걸 사용하면 부분 재구현 => 부모의 구현을 어느정도 사용한다는 의미
		// 사용하지 않는다면 완전 재구현
		
		System.out.println("Point[x=" + getX() + " ,y=" + getY() +", color="  + color + "]를 그렸습니다.");
	}



	@Override
	public void draw() {
//		super.draw();
		show();
	}
	
	
}

