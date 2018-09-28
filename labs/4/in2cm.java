public class in2cm {

	public static void main(String[] args) {
		System.out.println("in     cm | cm     in");
		System.out.println("---------------------");
		for(int i=1,c=1; i <= 50; i++, c+=5) {
			System.out.printf("%2d %6.2f %s %2d %6.2f " , i ,convert(i,c,0),"|" , c , convert(i,c,1));
			System.out.println();
			
		}

	}
	public static float convert(int inches, int cent, int num) {
		float result = 0;
		if (num == 0) {
			result = (float)(inches * 2.54);
		}
		else if(num == 1) {
			result = (float)(cent*0.39370079);
		}
		return result;
		
	}

}
