package prob05;

public class RectTriangle extends Shape {
	public RectTriangle(int width, int height) {
		super(width, height);
	}

	@Override
	public double getArea() {
		double result;
		result = (width * height) * 0.5;
		return result;
	}

	@Override
	public double getPerimeter() {
		double result;
		result = width + height + Math.sqrt(width*width + height*height);
		return result;
	}

}
