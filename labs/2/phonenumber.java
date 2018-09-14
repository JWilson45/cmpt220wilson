
public class phonenumber {

	public static void main(String[] args) {
		
        for (int x = 0; x <= 2; x++) {
            int number = (int)(Math.random() * 10);
            if ((number == 1 || number == 0) && x == 0) {
            	x = -1;
            	continue;
            }else if(((((number == 1 || number == 0) && x == 0))==false) && x == 0){
            	System.out.print("(");
            }
            System.out.print(number);
        }
        
        System.out.print(") ");
        
        for (int x = 0; x <= 2; x++) {
        	int number = (int)(Math.random() * 10);
        	System.out.print(number);
        }
        
        System.out.print("-");
        
        for (int x = 0; x <= 3; x++) {
        	int number = (int)(Math.random() * 10);
        	System.out.print(number);
        }
        System.out.println("");

	}

}
