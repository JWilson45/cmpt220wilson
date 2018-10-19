public class Square {
	
	private double width;
	
	Square(){
		this.width = 1;
	}
	
	public Square(double width_set) {
		this.width = width_set;
	}

	public double getArea() {
		return Math.pow(width, 2);
	}

	public double getPerimeter() {
		return width * 4;
	}
	
	public double getWidth() {
		return width;
	}

}