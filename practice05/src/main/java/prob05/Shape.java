package prob05;

public abstract class Shape {
	protected double width;
	protected double height;
	
	public Shape(int width, int height) {
		this.width = width;
		this.height = height;
	}
	abstract public double getArea();
	abstract public double getPerimeter();
}
