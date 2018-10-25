public class Q1_Test {

	public static void main(String[] args) {
		MyLong myLong = new MyLong(7);
		char[] c = {'1','2','4','3','8'};
		
		System.out.println("myLong value: " + myLong.getValue());
		
		System.out.println("Even? " + myLong.isEven());
		System.out.println("Odd? " + myLong.isOdd());
		System.out.println("Prime? " + myLong.isPrime());
		
		System.out.println("\nValue = 8");
		
		System.out.println("Even? " + MyLong.isEven(8));
		System.out.println("Odd? " + MyLong.isOdd(8));
		System.out.println("Prime? " + MyLong.isPrime(8));
		
		System.out.println("\nStatic myLong");
		
		System.out.println("Even? " + MyLong.isEven(myLong));
		System.out.println("Odd? " + MyLong.isOdd(myLong));
		System.out.println("Prime? " + MyLong.isPrime(myLong));
		
		System.out.println("\nmyLong = 7, myLong2 = 8, value = 8");
		
		MyLong myLong2 = new MyLong(8);
		System.out.println(myLong.equals(8));
		System.out.println(myLong.equals(myLong2));
		
		System.out.println("\nParsing Long");
		
		System.out.println(MyLong.parseLong(c));
		System.out.println(MyLong.parseLong("537"));

	}

}
