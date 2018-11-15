import java.util.Arrays;

public class TestAppliance {

	public static void main(String[] args) {
		Appliance[] array = {
				new Toaster(120, "Black", "Japan", 100.00),
				new TV(120, "Silver", "China", 500.00),
				new Telephone(60, "Gold", "Africa", 1000.00),
				new Toaster(120, "Black", "Japan", 130.00),
				new TV(120, "Silver", "China", 540.00),
				new Telephone(60, "Gold", "Africa", 1100.00),
				new Toaster(120, "Black", "Japan", 140.00),
				new TV(120, "Silver", "China", 560.00),
				new Telephone(60, "Gold", "Africa", 1100.00),
				new Toaster(120, "Black", "Japan", 900.00),
				new TV(120, "Silver", "China", 300.00),
				new Telephone(60, "Gold", "Africa", 10847.00),
				new Toaster(120, "Black", "Japan", 20.98),
				new TV(120, "Silver", "China", 700.00),
				new Telephone(60, "Gold", "Africa", 45.00),
				new Toaster(120, "Black", "Japan", 180.00),
				new TV(120, "Silver", "China", 542.00),
				new Telephone(60, "Gold", "Africa", 6214.00),
				new Toaster(120, "Black", "Japan", 551.00),
				new TV(120, "Silver", "China", 921.00),
				new Telephone(60, "Gold", "Africa", 812.56),
				new Toaster(120, "Black", "Japan", 90.01),
				new TV(120, "Silver", "China", 701.01),
				new Telephone(60, "Gold", "Africa", 200.10),
				new Toaster(120, "Black", "Japan", 20.00),
				new TV(120, "Silver", "China", 3415.00),
				new Telephone(60, "Gold", "Africa", 883.00),
				new Toaster(120, "Black", "Japan", 1000000.00),
				new TV(120, "Silver", "China", 500.00),
				new Telephone(60, "Gold", "Africa", 481.00),
				new Toaster(120, "Black", "Japan", 10.00),
				new TV(120, "Silver", "China", 10324.00),
				new Telephone(60, "Gold", "Africa", 503.00),
				new Toaster(120, "Black", "Japan", 74.00),
				new TV(120, "Silver", "China", 6503.00),
				new Telephone(60, "Gold", "Africa", 1199.00),
				new Toaster(120, "Black", "Japan", 98.00),
				new TV(120, "Silver", "China", 8310.00),
				new Telephone(60, "Gold", "Africa", 583.00),
				new Toaster(120, "Black", "Japan", 77.00),
		};

		array = sort(array);
		
		for (Appliance i: array) {
			System.out.println(i.toString());
		}
	}

	public static Appliance[] sort(Appliance[] o) {
		for (int i = 0; i < o.length; i++) {
			Appliance currentMin = o[i];
			int currentMinIndex = i;
			for (int j = i + 1; j < o.length; j++) {
				if (o[j].getPrice() < currentMin.getPrice()) {
					currentMin = o[j];
					currentMinIndex = j;
				}
			}
			if (currentMinIndex != i) {
				o[currentMinIndex] = o[i];
				o[i] = currentMin;
			}
		}
		return o;
	}

}
