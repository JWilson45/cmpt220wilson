import java.util.Scanner;

public class anotherbrick {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int h = input.nextInt();
		int w = input.nextInt();
		int n = input.nextInt();
		
		int[] bricks = new int[n];
		int place = 0;
		
		boolean cando = true;
				
		for (int i = 0; i < n; i++) 
			bricks[i] = input.nextInt();
		
		for (int i = 0;i < h; i++) {
			if (cando == false)
				break;
			for(int total=0;;) {
				if (place >= n) {
					cando = false;
					break;
				}
				total += bricks[place];
				place++;
				if(total == w)
					break;
				if (total > w) {
					cando = false;
					break;
				}
					
			}
		}
		if(cando)
			System.out.println("YES");
		if(!cando)
			System.out.println("NO");
	}

}
