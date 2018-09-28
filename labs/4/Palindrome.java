
import java.util.Scanner;

public class Palindrome {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Input a string to check if it is a palindrome: ");
		String s = input.nextLine();
		s = s.toLowerCase();
		System.out.println(reverse(s));
		System.out.println(isPalindrome(reverse(s)));

	}
	  public static String reverse(String s) {
		  int s_length = s.length();
		  String rString = "";
		  for (int i=s_length -1; i >= 0; i--) {
			  rString += s.charAt(i);
		  }
		  return rString;
		  
	  }
      public static boolean isPalindrome(String s) {
    	  if(reverse(s).equals(s))
    			  return true;
    	  else
    		  return false;
      }

}