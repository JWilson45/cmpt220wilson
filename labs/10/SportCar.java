public class SportCar implements Printable{
	private String make;
	private long modelNumber;
	
	SportCar() {
		
	}
	
	SportCar(String make, long modelNumber) {
		this.make = make;
		this.modelNumber = modelNumber;
	}

	@Override
	public void print() {
		System.out.println("SportCar - Make = " + make + "Model Number = " + modelNumber);
	}
	
	
}
