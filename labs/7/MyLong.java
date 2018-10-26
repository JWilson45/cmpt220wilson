public class MyLong {
	private long value;
	
	public MyLong(long value) {
		this.value = value;
	}

	public long getValue() {
		return value;
	}
	
	public boolean isEven() {
		return value % 2 == 0;
	}
	
	public boolean isOdd() {
		return value % 2 == 1;
	}
	
	public boolean isPrime() {
		for(long i = 2;i<value;i++) {
			if(value % i == 0)
				return false;
		}
		return true;
	}
	
	public static boolean isEven(long l) {
		return l % 2 == 0;
	}
	
	public static boolean isOdd(long l) {
		return l % 2 == 1;
	}
	
	public static boolean isPrime(long l) {
		for(long i = 2;i<l;i++) {
			if(l % i == 0)
				return false;
		}
		return true;
	}
	
	public static boolean isEven(MyLong l) {
		return MyLong.isEven(l.getValue());
	}
	
	public static boolean isOdd(MyLong l) {
		return MyLong.isOdd(l.getValue());
	}
	
	public static boolean isPrime(MyLong l) {
		return MyLong.isPrime(l.getValue());
	}
	
	public boolean equals(long l) {
		return value == l;
	}
	
	public boolean equals(MyLong l) {
		return equals(l.getValue());
	}
	
	public static long parseLong(char[] l) {
		String s = "";
		for(int i = 0; i<l.length;i++)
			 s += "" + l[i];
	return parseLong(s);
	}
	
	public static long parseLong(String l) {
		return Long.parseLong(l);
	}

}
