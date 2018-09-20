

public class Prime {

	public static void main(String[] args) {
		int divideby = 14998, testnumber = 14999;
		while (true){
			if(testnumber % divideby != 0) {
				divideby--;
			}else {
				testnumber--;
				divideby = testnumber - 1;
			}
			if (divideby == 1) {
				System.out.println(testnumber);
				break;
			}

		}	

	}

}
