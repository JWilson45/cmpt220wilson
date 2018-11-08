import java.util.Scanner;

public class TriangleTest {

	private static Scanner input;

	public static void main(String[] args) {
		input = new Scanner(System.in);
		System.out.println("Enter 3 sides of a triangle: ");
		
		double s1 = input.nextDouble();
		double s2 = input.nextDouble();
		double s3 = input.nextDouble();
		
		Triangle t1 = null;
		try {
			t1 = new Triangle(s1,s2,s3);
		} catch (IllegalTriangleException e) {
			e.printStackTrace();
			System.exit(0);
		} 
		
		System.out.println("Enter a color: ");
		
		t1.setColor(input.next());
		
		System.out.println("Is the triangle filled? true or false(boolean value): ");
		t1.setFilled(input.nextBoolean());
		
		System.out.println(t1.toString());
		System.out.println("Area - "+t1.getArea());
		System.out.println("Perimeter - "+t1.getPerimeter());
		System.out.println("Color - "+t1.getColor());
		System.out.println("Filled? "+(t1.isFilled() ? "yes" : "no"));
	}
}