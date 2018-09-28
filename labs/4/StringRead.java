
import java.util.Arrays;
import java.util.Scanner;

public class StringRead {

public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
	
	System.out.print("Enter a string of Text: ");
	String s = input.nextLine();
	s = s.toLowerCase();
	int s_Length = s.length(); 
	
	char[] c = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	int[] n = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	
	for(int i = 0; i < s_Length; i++) {
		for (int j = 0; j < 26; j++) {
			if (s.charAt(i) == c[j]) {
				n[j]++;
			}
			
		}
		
	}
	
	for (int i = 0; i < 26; i++) {
		if(n[i]==0)
			continue;
		System.out.println(c[i] + " - " + n[i]);
	}
}
}