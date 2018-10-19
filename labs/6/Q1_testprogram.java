public class Q1_testprogram {

	public static void main(String[] args) {
		Square square1 = new Square(40);
		Square square2 = new Square(35.9);
		
		System.out.println("Square1:\nWidth = " + square1.getWidth() + "\nArea = " + square1.getArea() + "\nPerimeter = " + square1.getPerimeter() + "\n");
		System.out.println("Square2:\nWidth = " + square2.getWidth() + "\nArea = " + square2.getArea() + "\nPerimeter = " + square2.getPerimeter());
	}

}
