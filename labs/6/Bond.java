public class Bond {
	
	private double coupon;
	private int payments;
	private double interest;
	private double valueMaturity;
	
	public Bond(){
		
	}
	
	public Bond(double coupon, int payments, double interest, double valueMaturity) {
		this.coupon = coupon;
		this.payments = payments;
		this.interest = interest;
		this.valueMaturity = valueMaturity;
	}
	
	public double getPrice() {
		return (coupon * (1 -(1/Math.pow((1+interest),payments)))+ valueMaturity * 1 / Math.pow((1+interest),payments));
	}

}
