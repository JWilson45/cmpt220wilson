package project2;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.time.ZonedDateTime;
import java.util.ArrayList;

/**
 * @author Jason Wilson
 */
public class RandomGenerator implements KeyListener {
	
	private ArrayList<Long> results;
	private final long startMilli;
	
	/** Constructor: sets the JFrame and variables*/
	public RandomGenerator() {
		results = new ArrayList<Long>();
		startMilli = ZonedDateTime.now().toInstant().toEpochMilli();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		results.add((e.getWhen() - startMilli) +((int)e.getKeyChar()));
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		results.add((e.getWhen() - startMilli) +((int)e.getKeyChar()));
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	
	public long[] getResults() {
		return createResults();
	}
	
	private long[] createResults() {
		ArrayList<Long> r_nums = new ArrayList<Long>();
		for (int i = 0; i<results.size()-1;i+=2) {
			long n =(results.get(i) - results.get(i+1)) < 0 ? (-1*(results.get(i) - results.get(i+1))):(results.get(i) - results.get(i+1));
			if(n != 0)
				r_nums.add(((results.get(i) - results.get(i+1)) < 0 ? (-1*(results.get(i) - results.get(i+1))):(results.get(i) - results.get(i+1))));
		}
		return toArray(r_nums);
	}
	
	private static long[] toArray(ArrayList<Long> r) {
		long[] array = new long[r.size()];
		for (int i = 0; i<r.size();i++)
			array[i] = r.get(i);
		return array;
	}
	
	public void resetGenerator() {
		results.clear();
	}

}

/**ZonedDateTime.now().toInstant().toEpochMilli() and e.getWhen() are equal*/