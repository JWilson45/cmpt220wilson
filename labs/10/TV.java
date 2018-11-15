public class TV extends Appliance {
	private String pixels;
	private boolean smartTv;
	private int numberOfHDMI;

	TV(double voltage, String color, String madeIn, double price) {
		super(voltage, color, madeIn, price);
	}
	
	TV(double voltage, String color, String madeIn, double price, String pixels, boolean smartTv, int numberOfHDMI) {
		super(voltage, color, madeIn, price);
		this.pixels = pixels;
		this.smartTv = smartTv;
		this.numberOfHDMI = numberOfHDMI;
	}

	public String getPixels() {
		return pixels;
	}

	public void setPixels(String pixels) {
		this.pixels = pixels;
	}

	public boolean isSmartTv() {
		return smartTv;
	}

	public void setSmartTv(boolean smartTv) {
		this.smartTv = smartTv;
	}

	public int getNumberOfHDMI() {
		return numberOfHDMI;
	}

	public void setNumberOfHDMI(int numberOfHDMI) {
		this.numberOfHDMI = numberOfHDMI;
	}

	public String toString() {
		return "TV: " + super.toString();
	}
}