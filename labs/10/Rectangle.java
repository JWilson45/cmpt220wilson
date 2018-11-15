public class Rectangle implements Printable {
	private int length;
	private int width;
	
	Rectangle() {
		
	}
	
	Rectangle(int length, int width) {
		this.length = length;
		this.width = width;
	}

	@Override
	public void print() {
		System.out.println("Rectangle - Length " + length + " Width = " + width);
	}
	
}