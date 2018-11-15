public class Telephone extends Appliance {
	private boolean waterProof;
	private int batteryMAH;
	private double megaPixels;

	Telephone(double voltage, String color, String madeIn, double price) {
		super(voltage, color, madeIn, price);
	}
	
	Telephone(double voltage, String color, String madeIn, double price, boolean waterProof , int batteryMAH, double megaPixels) {
		super(voltage, color, madeIn, price);
		this.waterProof = waterProof;
		this.batteryMAH = batteryMAH;
		this.megaPixels = megaPixels;
	}

	public boolean isWaterProof() {
		return waterProof;
	}

	public void setWaterProof(boolean waterProof) {
		this.waterProof = waterProof;
	}

	public int getBatteryMAH() {
		return batteryMAH;
	}

	public void setBatteryMAH(int batteryMAH) {
		this.batteryMAH = batteryMAH;
	}

	public double getMegaPixels() {
		return megaPixels;
	}

	public void setMegaPixels(double megaPixels) {
		this.megaPixels = megaPixels;
	}
	
	public String toString() {
		return "Telephone: " + super.toString();
	}
}