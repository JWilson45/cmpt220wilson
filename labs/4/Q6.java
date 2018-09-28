
import java.util.Scanner;

public class Q6 {

	public static void main(String[] args) {
		System.out.print("Enter positive int into the list and end with -1: ");
		int[] list = new int [1000];
		Scanner in = new Scanner(System.in);
		int number = 0;
		for(int n; number < 1000;number++) {
			n = in.nextInt();
			if (n==-1)
				break;
			list[number] = n;
		}
		addEnd(number,list);
	}
	public static void addEnd(int lastnumber, int[] list) {
		for(int n = 1; n < 11; n++,lastnumber++) {
			list[lastnumber] = n;
		}
		for (int i = 0;i<lastnumber;i++) {
			System.out.print(list[i] + " ");
		}
		System.out.println();
		addAtPlace(lastnumber,list);
	}
	public static void addAtPlace(int lastnumber,int[] list) {
		list[2] = 10;
		list[6] = 100;
		for (int i = 0;i<lastnumber;i++) {
			System.out.print(list[i] + " ");
		}
	}

}
