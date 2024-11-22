package prob05;

public class Rectangle extends Shape implements Resizable {

	public Rectangle(int width, int height) {
		super(width, height);
	}

	@Override
	public void resize(double rate) {
		width = width * rate;
		height = height * rate;
		return;
	}

	@Override
	public double getArea() {
		double result = width * height;
		return result;
	}

	@Override
	public double getPerimeter() {
		double result = (width + height) * 2;
		return result;
	}

}
