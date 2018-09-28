
import java.util.Scanner;

public class Remove_Dupp {

	private static Scanner input;

	public static void main(String[] args) {
		input = new Scanner(System.in);
		System.out.println("I will remove any duplicates you input.");
		System.out.print("How many numbers do you wish to enter? ");
		int n = input.nextInt();
		
		int[] user_in = new int[n];
		
		System.out.print("Enter " + n + " numbers: ");
		for(int i = 0;i<n;i++) {
			int num = input.nextInt();
			user_in[i] = num;
		}
		System.out.println("Removing duplicates...");
		int count = 0;
		int count2 = 0;
		
		int[] rm = new int[n];
				
		for(int i = 0;i < n;i++) {
			for(int j = 0; j < n; j++) {
				if(user_in[i] == user_in[j])
					count++;
			}
			if(count == 1) {
				rm[count2] = user_in[i];
				count2++;
			}
			count = 0;
		}
			for(int i = 0; i < count2; i++) {
				System.out.print(rm[i] + " ");
		}
	}

}

