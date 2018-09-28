
public class Onethousand {

	public static void main(String[] args) {
		int[] numbers = new int[1000];
		int total = 0;
		for (int i=0;i<1000;i++) {
			numbers[i] = (int)(Math.random() * 10000);
			total += numbers[i];
		}
		int average = total / 1000;
		
		int above = 0;
		int below = 0;
		
		for (int i = 0;i<1000;i++) {
			if (numbers[i] < average) {
				above++;
			}
			else if (numbers[i]>average) {
				below++;
			}
		}
		System.out.println("The amount of numbers above the average is: " + above);
		System.out.println("The amount of numbers below the average is: " + below);

	}

}
