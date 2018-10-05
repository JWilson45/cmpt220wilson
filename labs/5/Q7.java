

public class Q7 {

	public static void main(String[] args) {
		double[][] matrix = {
				{2,3,4},
				{0,3,2},
				{0,0,4}
				};
		
		System.out.print("This matrix " + (isUpperTriangular(matrix) ? "is":"is not") + " an upper triangular matrix");
	}
	
	public static boolean isUpperTriangular(double[][] array) {
		int l = array.length;
		for(int i = 0;i<l;i++) {
			for(int j = 0;j<l;j++) {
				if((array[i][j]!=0 && i>j)^(array[i][j]==0 && i<=j))
					return false;
			}
		}
		return true;
	}

}