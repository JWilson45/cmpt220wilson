import java.util.Scanner;

public class SmallestFactors {

	private static Scanner input;

	public static void main(String[] args) {
		input = new Scanner(System.in);
		System.out.print("Enter a positive integer: ");
		int posInt = input.nextInt();
		
		StackOfIntegers factors = new StackOfIntegers();
		
		for (int i=2;posInt/i !=1;) {
			if(posInt % i == 0) {
				factors.push(i);
				posInt = posInt / i;
			}
			else i++;
		}
		factors.push(posInt);
		while(!factors.empty())
			System.out.println(factors.pop());
	}

}