public class Circle_Test {

	public static void main(String[] args) {
		Circle c1 = new Circle(2,2,5.5);
		System.out.println("Area of c1: " + c1.getArea());
		System.out.println("Perimeter of c1: " + c1.getPerimeter());
		System.out.println("Coes c1 contain point 3,3? " + c1.contains(3, 3));
		System.out.println("Circle at point 4,5 with r = 10.5 within c1? " + c1.contains(new Circle(4,5,10.5)));
		System.out.println("Circle at point 3,5 with r = 2.3 overlap c1? " + c1.overlaps(new Circle(3,5,2.3)));
	}

}
