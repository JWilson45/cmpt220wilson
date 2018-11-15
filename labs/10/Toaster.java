public class Toaster extends Appliance {
	private int toastHoles;
	private boolean variableToasterSettings;
	private boolean thingsThatCloseAroundTheBread;

	Toaster(double voltage, String color, String madeIn, double price) {
		super(voltage, color, madeIn, price);
	}
	
	Toaster(double voltage, String color, String madeIn, double price, int toastHoles, boolean variableToasterSettings, boolean thingsThatCloseAroundTheBread) {
		super(voltage, color, madeIn, price);
		this.toastHoles = toastHoles;
		this.variableToasterSettings = variableToasterSettings;
		this.thingsThatCloseAroundTheBread = thingsThatCloseAroundTheBread;
		
	}

	public int getToastHoles() {
		return toastHoles;
	}

	public void setToastHoles(int toastHoles) {
		this.toastHoles = toastHoles;
	}

	public boolean isVariableToasterSettings() {
		return variableToasterSettings;
	}

	public void setVariableToasterSettings(boolean variableToasterSettings) {
		this.variableToasterSettings = variableToasterSettings;
	}

	public boolean isThingsThatCloseAroundTheBread() {
		return thingsThatCloseAroundTheBread;
	}

	public void setThingsThatCloseAroundTheBread(boolean thingsThatCloseAroundTheBread) {
		this.thingsThatCloseAroundTheBread = thingsThatCloseAroundTheBread;
	}
	
	public String toString() {
		return "Toaster: " + super.toString();
	}

}