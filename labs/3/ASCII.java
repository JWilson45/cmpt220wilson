

public class ASCII {

	public static void main(String[] args) {
		for(int n = 1, spacing = 0; n <= 100; n++) {
			if(spacing < 20) {
				System.out.print((char)(n) + " ");
				spacing++;
			}else{
				System.out.println();
				System.out.print((char)(n) + " ");
				spacing = 1;
			}
		}
	}
	
}