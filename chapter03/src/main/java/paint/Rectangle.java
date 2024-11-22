package paint;

public class Rectangle extends Shape{
	// Shape 생성 후 필드 삭제.
//	private Point[] points;
//	private String lineColor;
//	private String fillColor;
	
	@Override
	public void draw() {
		System.out.println("사각형을 그렸습니다.");
	}
}
