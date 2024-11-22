package paint;

public class PaintApp {

	public static void main(String[] args) {
		Point point1 = new Point();
		point1.setX(10);
		point1.setY(20);
		// point1.show();
//		drawPoint(point1); // static?
		draw(point1);
		
		
		Point point2 = new Point(100,200);
		//point2.show();
//		drawPoint(point2);
		draw(point2);
		// point2.disappear();
		point2.show(false);
		
		// ColorPoint point3 = new ColorPoint();
		
		// point3.setX(50);
		// point3.setY(100);
		// point3.setColor("red");
		// drawColorPoint(point3);
		
		Point point3 = new ColorPoint(50,100,"blue");
//		drawPoint(point3);
		draw(point3);
		
//		drawTriangle(new Triangle());
//		drawReactangle(new Rectangle());
		
//		drawShape(new Triangle());
//		drawShape(new Rectangle());
//		drawShape(new Circle());
		
		draw(new Triangle());
		draw(new Rectangle());
		draw(new Circle());
		
		draw(new GraphicText("안녕"));
	}
	
	public static void draw(Drawable drawable) {
		drawable.draw();
	}
	
//	public static void drawPoint(Point point) {
//		point.show();
//	} => drawable 추상 클래스 생성하면서 주석처리
	
//	public static void drawColorPoint(ColorPoint colorpoint) {
//		colorpoint.show();
//	}
	
//	public static void drawShape(Shape shape) {
//		shape.draw();
//	} => drawable 추상 클래스 생성하면서 주석처리
	
	// shape을 추상 class 생성 후 casting을 이용해 하나의 함수로 정리.
//	public static void drawTriangle(Triangle triangle) {
//		triangle.draw();
//	}
//	
//	public static void drawReactangle(Rectangle rectangle) {
//		rectangle.draw();
//	}
	
}
