public class Q3 {
	
	public static void main(String[] args) {
		try {
			int decimal = bin2Dec("1001011");
			System.out.println(decimal);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}

	public static int bin2Dec(String binaryString) throws NumberFormatException {
		checkBinary(binaryString);
		int result = 0;
		for (int i = 0, j = binaryString.length() - 1; i < binaryString.length();i++,j--) {
			if(binaryString.charAt(i) == '0')
				continue;
			result += Math.pow(2 , j);
		}
		return result;
	}

	private static void checkBinary(String bin) throws NumberFormatException {
		char[] charArray = bin.toCharArray();
		for(int i : charArray) {
			if (i < '0' || i > '1')
				throw new NumberFormatException("Enter only 1's and 0's for a binary string");
		}
	}
}