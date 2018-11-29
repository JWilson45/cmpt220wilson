package project2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.swing.JCheckBox;
import javax.swing.JTextPane;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

import javax.swing.JPanel;
import javax.swing.DropMode;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;

import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JProgressBar;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JCheckBoxMenuItem;

public class EncryptWindow extends Save implements ActionListener{

	private JFrame frmEncryptionV;
	private JFrame frmRandomGen;
	private JTextField decryptedTextUserInput;
	private Encrypt encrypt;
	private Decrypt decrypt;
	private RandomGenerator randomGenerator;
	private JTextField filePathTextField1;
	private JButton btnBrowse;
	private JButton btnSave;
	private JTextArea encrytpedTextBox;
	private JFileChooser fileChooser;
	private String defaultKeyFile;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EncryptWindow window = new EncryptWindow();
					window.frmEncryptionV.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public EncryptWindow() {
		initialize();
	}

	private void initialize() {
		encrypt = new Encrypt();
		decrypt = new Decrypt();
		randomGenerator = new RandomGenerator();
		defaultKeyFile = "src/project2/data/DefaultKey.txt";

		frmEncryptionV = new JFrame();
		frmEncryptionV.getContentPane().setEnabled(false);
		frmEncryptionV.setResizable(false);
		frmEncryptionV.setTitle("Encryption v1.0");
		frmEncryptionV.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEncryptionV.getContentPane().setLayout(null);
		frmEncryptionV.setSize(892, 532);

		frmRandomGen = new JFrame("Random Number Generator");
		frmRandomGen.setAlwaysOnTop(true);
		frmRandomGen.setBounds(100, 100, 450, 176);
		frmRandomGen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmRandomGen.getContentPane().setLayout(null);

		JLabel promptToType = new JLabel("Type randomly on your key board to generate\ntruly random numbers.\n\nClick okay when finished");
		promptToType.setHorizontalAlignment(SwingConstants.CENTER);
		promptToType.setBounds(5, 6, 440, 46);
		frmRandomGen.getContentPane().add(promptToType);
		
		JLabel lblClickDone = new JLabel("Click done when finished");
		lblClickDone.setHorizontalAlignment(SwingConstants.CENTER);
		lblClickDone.setBounds(5, 37, 440, 70);
		frmRandomGen.getContentPane().add(lblClickDone);
		lblClickDone.addKeyListener(randomGenerator);

		JButton btnDone = new JButton("Done");
		btnDone.setBounds(5, 119, 440, 29);
		frmRandomGen.getContentPane().add(btnDone);
		btnDone.addKeyListener(randomGenerator);
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmRandomGen.dispose();
			}});

		JLabel lblTextToEncrypt = new JLabel("Text to encrypt:");
		lblTextToEncrypt.setBounds(6, 6, 109, 16);
		frmEncryptionV.getContentPane().add(lblTextToEncrypt);

		decryptedTextUserInput = new JTextField();
		decryptedTextUserInput.setToolTipText("Enter text that you wish to encrypt here");
		decryptedTextUserInput.setBounds(6, 25, 419, 26);
		frmEncryptionV.getContentPane().add(decryptedTextUserInput);
		decryptedTextUserInput.setColumns(10);
		decryptedTextUserInput.addKeyListener(randomGenerator);

		JButton btnEncrypt = new JButton("Encrypt");
		btnEncrypt.setBounds(6, 86, 117, 29);
		frmEncryptionV.getContentPane().add(btnEncrypt);
		btnEncrypt.addActionListener(this);

		JLabel lblEncryptedText = new JLabel("Encrypted Text:");
		lblEncryptedText.setBounds(6, 132, 107, 16);
		frmEncryptionV.getContentPane().add(lblEncryptedText);

		JCheckBox autoSave = new JCheckBox("Save to File");
		autoSave.setBounds(16, 51, 107, 23);
		frmEncryptionV.getContentPane().add(autoSave);
		autoSave.addActionListener(this);

		btnSave = new JButton("Save as...");
		btnSave.setBounds(6, 455, 117, 29);
		frmEncryptionV.getContentPane().add(btnSave);
		btnSave.addActionListener(this);

		filePathTextField1 = new JTextField();
		filePathTextField1.setToolTipText("Enter file path to folder");
		filePathTextField1.setText("src/project2/data/");
		filePathTextField1.setEnabled(false);
		filePathTextField1.setBounds(135, 50, 225, 26);
		frmEncryptionV.getContentPane().add(filePathTextField1);
		filePathTextField1.setColumns(10);

		btnBrowse = new JButton("Browse");
		btnBrowse.setEnabled(false);
		btnBrowse.setBounds(243, 73, 117, 29);
		frmEncryptionV.getContentPane().add(btnBrowse);
		btnBrowse.addActionListener(this);

		fileChooser = new JFileChooser();
		//		fileChooser.setCurrentDirectory();

		encrytpedTextBox = new JTextArea();
		encrytpedTextBox.setBackground(SystemColor.window);
		encrytpedTextBox.setEditable(false);
		encrytpedTextBox.setLineWrap(true);
		encrytpedTextBox.setBounds(16, 160, 409, 289);
		frmEncryptionV.getContentPane().add(encrytpedTextBox);

		JMenuBar menuBar = new JMenuBar();
		JMenu mnFile = new JMenu();
		mnFile.setText("File");
		menuBar.add(mnFile);
		frmEncryptionV.setJMenuBar(menuBar);
		
		JMenuItem mntmImport = new JMenuItem("Import");
		mnFile.add(mntmImport);
		
		JMenuItem mntmSaveAs = new JMenuItem("Save as...");
		mnFile.add(mntmSaveAs);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mnFile.add(mntmSave);
		
		JMenuItem item = new JMenuItem("Exit");
		mnFile.add(item);

		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);

		JMenu mnEncryption = new JMenu("Encryption");
		menuBar.add(mnEncryption);

		JMenuItem mntmEncrypt = new JMenuItem("Encrypt");
		mnEncryption.add(mntmEncrypt);

		JMenuItem mntmResetKey = new JMenuItem("Regenerate Key");
		mnEncryption.add(mntmResetKey);
		mntmResetKey.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				randomGenerator.resetGenerator();
				frmRandomGen.setVisible(true);
			}});

		JMenu mnDecryption = new JMenu("Decryption");
		menuBar.add(mnDecryption);

	}
	/*
	 * Create tool bar
	 * have a reset key in the tool bar as an option
	 * open a bigger text field for multiple line encryption
	 * add support for multiple line encryption
	 * continue general development
	 * if the text box is empty, ask if user would like to import
	 * make sure key is long enough to encrypt
	 * 
	 * Make sure decryption saves with the char 10's
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "Encrypt") {
			encryptAction();
		}else if (e.getActionCommand() == "Save to File") {
			filePathTextField1.setEnabled(filePathTextField1.isEnabled() ? false:true);
			btnBrowse.setEnabled(btnBrowse.isEnabled() ? false:true);
		}
		else if(e.getActionCommand() == "Browse") {
			//fileChooser.showOpenDialog(frmEncryptionV);
			//filePathTextField1.setText(fileChooser.getSelectedFile().toString());
			//	fileChooser.showSaveDialog(frmEncryptionV);
		}
		else System.out.println(e.getActionCommand());

	}

	private void encryptAction() {	
		encrypt.setDecryptedText(decryptedTextUserInput.getText());
		if(decryptedTextUserInput.getText().length() <= 1)
			if(noTextImport()) {
				fileChooser.showOpenDialog(frmEncryptionV);
				if(fileChooser.getSelectedFile() == null)
					return;
				encrypt.setDecryptedText(importDecryptedText(fileChooser.getSelectedFile().toString()));
			} else return;
		encrypt.setKey(randomGenerator.getResults());
		if(encrypt.getKey().length <= 2)
			setDefaultKey(encrypt, defaultKeyFile);
		encrypt.encrypt();
		encrytpedTextBox.setText(encrypt.getEncryptedText());
	}

	private static boolean noTextImport() {
		int result = JOptionPane.showConfirmDialog((Component) null, "Do you wish to import text from file?",
				"No text detected", JOptionPane.YES_NO_OPTION);
		return result == 0 ? true:false;
	}
}

/* Simple way to display a message
 * JOptionPane.showMessageDialog(null, "My Goodness, this is so concise");*/