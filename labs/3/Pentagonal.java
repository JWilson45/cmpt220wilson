

public class Pentagonal {

	public static void main(String[] args) {
		for (int i = 1, sorter = 1; i <= 50; i++, sorter++) {
			if (sorter > 10)
				sorter = 1;
			pent(i,sorter);
		}

	}
	
	public static void pent(int n, int sort) {
		int pNumber = ((3 * (n*n)) - n)/ 2;
		
		if(sort < 10) {
			System.out.print(pNumber + " ");
		}else {
			System.out.println(pNumber + " ");
		}
		
	}

}
