public class Circle {
	double x , y;
	double radius;
	
	public Circle() {
		x = 0;
		y = 0;
		radius = 1;
	}
	
	public Circle(double x, double y, double radius) {
		this.x = x;
		this.y = y;
		this.radius = radius;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getRadius() {
		return radius;
	}
	
	public double getArea() {
		return Math.PI * Math.pow(radius, 2);
	}
	
	public double getPerimeter() {
		return 2*Math.PI*radius;
	}
	
	public boolean contains(double x, double y) {
		return Math.sqrt(Math.pow(x - this.x, 2) + Math.pow(y - this.y, 2)) < radius;
	}
	
	public double getD(Circle circle) {
		return Math.sqrt(Math.pow(circle.getX() - x, 2) + Math.pow(circle.getY() - y, 2));
	}
	
	public boolean contains(Circle circle) { 
		return getD(circle) < radius - circle.getRadius();
	}
	
	public boolean overlaps(Circle circle) {
		return getD(circle) < radius + circle.getRadius();
	}
}