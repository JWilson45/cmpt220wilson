
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
//import javax.swing.JPanel;

public class Key_Listener implements KeyListener {
	
	private ArrayList<Long> results;
	private JFrame listen;
	private boolean closed;
	
	/** Constructor: sets the JFrame and variables*/
	public Key_Listener() {
		results = new ArrayList<Long>();
		closed = false;
		listen = new JFrame("Randy");
		listen.addKeyListener(this);
		listen.setSize(250, 250);
		listen.setVisible(true);
		listen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//DISPOSE_ON_CLOSE
	}

	@Override
	public void keyPressed(KeyEvent e) {
		results.add(e.getWhen());
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		results.add(e.getWhen());
	}

	@Override
	public void keyTyped(KeyEvent e) {
		if((int)e.getKeyChar() == 10) {
			closed = true;
			closeWindow();
		}
	}
	
	public ArrayList<Long> getResults() {
		return results;
	}

	public boolean isClosed() {
		return closed;
	}
	
	public void closeWindow() {
		listen.dispose();
	}
	
}

/**ZonedDateTime.now().toInstant().toEpochMilli() and e.getWhen() are equal*/