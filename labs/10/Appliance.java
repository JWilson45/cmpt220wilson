public class Appliance implements Comparable<Appliance> {
	private double voltage;
	private String color;
	private String madeIn;
	private double price;
	
	Appliance(double voltage, String color, String madeIn, double price) {
		this.voltage = voltage;
		this.color = color;
		this.madeIn = madeIn;
		this.price = price;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getVoltage() {
		return voltage;
	}

	public String getColor() {
		return color;
	}

	public String getMadeIn() {
		return madeIn;
	}

	@Override
	public String toString() {
		return "Voltage = " + voltage + " Color = " + color + " Made in = " + madeIn + " Price = " + price;
	}

	@Override
	public int compareTo(Appliance o) {
		if(this.price > o.getPrice()) 
			return 1;
		else if (this.getPrice() == o.getPrice())
			return 0;
		else return -1;
	}

}