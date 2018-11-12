import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.time.ZonedDateTime;
import java.util.ArrayList;

import javax.swing.JFrame;
//import javax.swing.JPanel;

public class Key_Listener implements KeyListener {
	
	private ArrayList<Long> results;
	private JFrame listen;
	private boolean closed;
	private final long startMilli;
	
	/** Constructor: sets the JFrame and variables*/
	public Key_Listener() {
		results = new ArrayList<Long>();
		closed = false;
		startMilli = ZonedDateTime.now().toInstant().toEpochMilli();
		listen = new JFrame("Randy");
		listen.addKeyListener(this);
		listen.setSize(250, 250);
		listen.setVisible(true);
		listen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//DISPOSE_ON_CLOSE
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
		if((int)e.getKeyChar() == 10) {
			closed = true;
			closeWindow();
		}
	}
	
	public long[] getResults() {
		return createResults();
	}

	public boolean isClosed() {
		return closed;
	}
	
	public void closeWindow() {
		listen.dispose();
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
	
	public static long[] random() {
		Key_Listener keyListener = new Key_Listener();
		while(!keyListener.isClosed()) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return keyListener.getResults();
	}
	
}

/**ZonedDateTime.now().toInstant().toEpochMilli() and e.getWhen() are equal*/