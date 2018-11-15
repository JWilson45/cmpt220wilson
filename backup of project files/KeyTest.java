package project2;

import java.util.Arrays;

//import javax.swing.JFrame;

public class KeyTest {

	public static void main(String[] args) {
		Key_Listener keyListener = new Key_Listener();
		
		while(!keyListener.isClosed()) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		long[] arr = keyListener.getResults();
		System.out.println(Arrays.toString(arr));
	}
}

/**Could implement this by having the enter command kill the 
 * window and call another method to continue the program
 * one the random data is collected.
 * Could make it more efficient, something to think about once
 * this class is implemented.
 */