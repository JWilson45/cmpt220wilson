

public class Divide_five_seven {

	public static void main(String[] args) {
		for (int n = 100, spacing = 0;n <= 500;n++) {
			if((n % 7 == 0) ^ (n % 5 == 0)) {
				if(spacing < 10) {
					System.out.print(n + " ");
					spacing++;
				}else{
					System.out.println();
					System.out.print(n + " ");
					spacing = 1;
				}
			}
				
		}

	}

}
