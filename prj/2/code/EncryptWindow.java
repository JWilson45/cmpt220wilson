import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Component;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import java.io.File;

import javax.swing.JFileChooser;

import java.awt.SystemColor;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

public class EncryptWindow implements ActionListener{

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
	private JTextArea decryptedTextBox;
	private JFileChooser fileChooser;
	private JFileChooser directoryChooser;
	private JFileChooser fileChooserEncryptedText;
	private JFileChooser fileChooserKey;
	private JFileChooser saveAs;
	private JFileChooser importTextToEncrypt;
	private JFileChooser saveAsDecrypt;
	private String defaultKeyFile;
	private JCheckBox chckbxAdvancedFileChoosing;
	private JRadioButton rdbtnDecryptFromFile;
	private JRadioButton rdbtnDecryptFromEncrypted;
	private JCheckBox autoSave;
	private JCheckBoxMenuItem chckbxmntmSaveToFile;

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
		defaultKeyFile = Save.getDefaultFilePath();

		frmEncryptionV = new JFrame("Encryption v1.0");
		frmEncryptionV.getContentPane().setEnabled(false);
		frmEncryptionV.setResizable(false);
		frmEncryptionV.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEncryptionV.getContentPane().setLayout(null);
		frmEncryptionV.setSize(892, 532);

		frmRandomGen = new JFrame("Random Number Generator");
		frmRandomGen.setAlwaysOnTop(true);
		frmRandomGen.setResizable(false);
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
			public void actionPerformed(ActionEvent e) {frmRandomGen.dispose();}});

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
		lblEncryptedText.setBounds(6, 117, 107, 16);
		frmEncryptionV.getContentPane().add(lblEncryptedText);

		autoSave = new JCheckBox("Save to File");
		autoSave.setBounds(16, 51, 107, 23);
		frmEncryptionV.getContentPane().add(autoSave);
		autoSave.setToolTipText("Automatically saves when encryption occures");
		autoSave.addActionListener(this);

		btnSave = new JButton("Save as...");
		btnSave.setBounds(6, 455, 117, 29);
		frmEncryptionV.getContentPane().add(btnSave);
		btnSave.addActionListener(this);

		filePathTextField1 = new JTextField();
		filePathTextField1.setToolTipText(System.getProperty("user.dir"));
		filePathTextField1.setText(System.getProperty("user.dir"));
		filePathTextField1.setEnabled(false);
		filePathTextField1.setBounds(135, 50, 225, 26);
		frmEncryptionV.getContentPane().add(filePathTextField1);
		filePathTextField1.setColumns(10);
		filePathTextField1.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {}public void keyPressed(KeyEvent e){}
			public void keyReleased(KeyEvent e){filePathTextField1.setToolTipText(filePathTextField1.getText());}});

		btnBrowse = new JButton("Browse");
		btnBrowse.setEnabled(false);
		btnBrowse.setBounds(243, 73, 117, 29);
		frmEncryptionV.getContentPane().add(btnBrowse);
		btnBrowse.addActionListener(this);

		fileChooser = new JFileChooser();
		fileChooserEncryptedText = new JFileChooser();
		fileChooserKey = new JFileChooser();

		saveAsDecrypt = new JFileChooser();
		saveAsDecrypt.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

		importTextToEncrypt = new JFileChooser();
		importTextToEncrypt.setDialogTitle("Save to Directory");
		importTextToEncrypt.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

		directoryChooser = new JFileChooser();
		directoryChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

		JLabel lblDecryption = new JLabel("Decryption:");
		lblDecryption.setBounds(426, 6, 79, 16);
		frmEncryptionV.getContentPane().add(lblDecryption);

		rdbtnDecryptFromFile = new JRadioButton("Decrypt from file");
		rdbtnDecryptFromEncrypted = new JRadioButton("Decrypt from Encrypted Text box");
		chckbxAdvancedFileChoosing = new JCheckBox("Advanced File Choosing Options");
		JButton btnSetDecryptDirectory = new JButton("Set Directory");
		JButton btnSetKeyFile = new JButton("Set key");
		JButton btnSetEncrTextFile = new JButton("Set encrypted text");

		rdbtnDecryptFromFile.setSelected(true);
		rdbtnDecryptFromFile.setBounds(502, 2, 141, 23);
		frmEncryptionV.getContentPane().add(rdbtnDecryptFromFile);
		rdbtnDecryptFromFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnDecryptFromFile.isSelected()) {
					rdbtnDecryptFromEncrypted.setSelected(false);
					btnSetDecryptDirectory.setEnabled(true);
					chckbxAdvancedFileChoosing.setEnabled(true);
				}}});

		rdbtnDecryptFromEncrypted.setBounds(643, 2, 249, 23);
		frmEncryptionV.getContentPane().add(rdbtnDecryptFromEncrypted);
		rdbtnDecryptFromEncrypted.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnDecryptFromEncrypted.isSelected()) {
					rdbtnDecryptFromFile.setSelected(false);
					chckbxAdvancedFileChoosing.setSelected(false);
					btnSetDecryptDirectory.setEnabled(false);
					btnSetKeyFile.setEnabled(false);
					btnSetEncrTextFile.setEnabled(false);
					chckbxAdvancedFileChoosing.setEnabled(false);
				}}});

		JLabel lblDecryptedText = new JLabel("Decrypted Text:");
		lblDecryptedText.setBounds(426, 117, 107, 16);
		frmEncryptionV.getContentPane().add(lblDecryptedText);

		JButton btnDecrypt = new JButton("Decrypt");
		btnDecrypt.setBounds(754, 86, 117, 29);
		frmEncryptionV.getContentPane().add(btnDecrypt);
		btnDecrypt.addActionListener(this);

		btnSetEncrTextFile.setEnabled(false);
		btnSetEncrTextFile.setToolTipText("Set encrypted text file from file system");
		btnSetEncrTextFile.setBounds(536, 51, 141, 29);
		frmEncryptionV.getContentPane().add(btnSetEncrTextFile);
		btnSetEncrTextFile.addActionListener(this);

		btnSetKeyFile.setEnabled(false);
		btnSetKeyFile.setToolTipText("set key text file from file system");
		btnSetKeyFile.setBounds(672, 51, 70, 29);
		frmEncryptionV.getContentPane().add(btnSetKeyFile);
		btnSetKeyFile.addActionListener(this);

		btnSetDecryptDirectory.setToolTipText("Set directory that contains both EncryptedText.txt and key.txt");
		btnSetDecryptDirectory.setBounds(426, 50, 117, 29);
		frmEncryptionV.getContentPane().add(btnSetDecryptDirectory);
		btnSetDecryptDirectory.addActionListener(this);

		chckbxAdvancedFileChoosing.setBounds(426, 26, 237, 23);
		frmEncryptionV.getContentPane().add(chckbxAdvancedFileChoosing);
		chckbxAdvancedFileChoosing.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxAdvancedFileChoosing.isSelected()) {
					btnSetDecryptDirectory.setEnabled(false);
					btnSetEncrTextFile.setEnabled(true);
					btnSetKeyFile.setEnabled(true);
				} else {
					btnSetDecryptDirectory.setEnabled(true);
					btnSetEncrTextFile.setEnabled(false);
					btnSetKeyFile.setEnabled(false);
				}}});

		JButton btnSaveAs = new JButton("Save as... ");
		btnSaveAs.setBounds(426, 455, 117, 29);
		frmEncryptionV.getContentPane().add(btnSaveAs);
		btnSaveAs.addActionListener(this);

		JScrollPane scrollPaneEncryptedText = new JScrollPane();
		scrollPaneEncryptedText.setBounds(16, 137, 409, 314);
		frmEncryptionV.getContentPane().add(scrollPaneEncryptedText);

		encrytpedTextBox = new JTextArea();
		scrollPaneEncryptedText.setViewportView(encrytpedTextBox);
		encrytpedTextBox.setBackground(SystemColor.window);
		encrytpedTextBox.setEditable(false);
		encrytpedTextBox.setLineWrap(true);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(436, 137, 435, 314);
		frmEncryptionV.getContentPane().add(scrollPane_1);

		decryptedTextBox = new JTextArea();
		scrollPane_1.setViewportView(decryptedTextBox);
		decryptedTextBox.setLineWrap(true);
		decryptedTextBox.setEditable(false);
		decryptedTextBox.setBackground(SystemColor.window);

		JButton btnImportText = new JButton("Import Text");
		btnImportText.setBounds(305, 1, 117, 29);
		frmEncryptionV.getContentPane().add(btnImportText);
		btnImportText.addActionListener(this);

		JMenuBar menuBar = new JMenuBar();
		frmEncryptionV.setJMenuBar(menuBar);

		JMenu mnEncryption = new JMenu("Encryption");
		menuBar.add(mnEncryption);

		JMenuItem mntmEncrypt = new JMenuItem("Encrypt");
		mnEncryption.add(mntmEncrypt);
		mntmEncrypt.addActionListener(this);

		JMenuItem mntmImportText = new JMenuItem("Import Text");
		mnEncryption.add(mntmImportText);
		mntmImportText.addActionListener(this);

		JMenuItem mntmSave = new JMenuItem("Save");
		mnEncryption.add(mntmSave);
		mntmSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(encrypt.getEncryptedText() == null) {
					displayWarning("Encrypt something to save");
					return;
				}
				Save.setFileLocation(defaultKeyFile);
				Save.save(encrypt);
			}});

		saveAs = new JFileChooser();
		saveAs.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		saveAs.setDialogTitle("Save to Folder");

		JMenuItem mntmSaveAs = new JMenuItem("Save as...");
		mnEncryption.add(mntmSaveAs);
		mntmSaveAs.addActionListener(this);

		chckbxmntmSaveToFile = new JCheckBoxMenuItem("Save to File");
		mnEncryption.add(chckbxmntmSaveToFile);
		chckbxmntmSaveToFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filePathTextField1.setEnabled(filePathTextField1.isEnabled() ? false:true);
				btnBrowse.setEnabled(btnBrowse.isEnabled() ? false:true);
				autoSave.setSelected(autoSave.isSelected() ? false:true);
			}});

		JMenuItem mntmResetKey = new JMenuItem("Regenerate Key");
		mnEncryption.add(mntmResetKey);
		mntmResetKey.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				randomGenerator.resetGenerator();
				frmRandomGen.setVisible(true);
			}});

		JMenu mnDecryption = new JMenu("Decryption");
		menuBar.add(mnDecryption);

		JMenuItem mntmDecrypt = new JMenuItem("Decrypt");
		mnDecryption.add(mntmDecrypt);
		mntmDecrypt.addActionListener(this);

		JMenuItem mntmSaveAsDecrypt = new JMenuItem("Save as... ");
		mnDecryption.add(mntmSaveAsDecrypt);
		mntmSaveAsDecrypt.addActionListener(this);
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
	 * 
	 * Add to tab "Set default save folder"?
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "Encrypt") {
			encryptAction();
		}else if (e.getActionCommand() == "Save to File") {
			filePathTextField1.setEnabled(filePathTextField1.isEnabled() ? false:true);
			btnBrowse.setEnabled(btnBrowse.isEnabled() ? false:true);
			chckbxmntmSaveToFile.setSelected(chckbxmntmSaveToFile.isSelected() ? false:true);
		}else if(e.getActionCommand() == "Browse") {
			if(importTextToEncrypt.showOpenDialog(frmEncryptionV) == 1)
				return;
			filePathTextField1.setText(importTextToEncrypt.getSelectedFile().toString());
		}else if(e.getActionCommand() == "Set Directory") {
			directoryChooser.showOpenDialog(frmEncryptionV);
		}else if(e.getActionCommand() == "Decrypt") {
			decryptAction();
		}else if(e.getActionCommand() == "Set encrypted text") {
			fileChooserEncryptedText.showOpenDialog(frmEncryptionV);
		}else if(e.getActionCommand() == "Set key") {
			fileChooserKey.showOpenDialog(frmEncryptionV);
		}else if(e.getActionCommand() == "Save as...") {
			saveAsEncryptAction();
		}else if(e.getActionCommand() == "Save as... ") {
			saveAsDecryptAction();
		}else if(e.getActionCommand() == "Import Text") {
			importEncryptAction();
		}else System.out.println(e.getActionCommand());

	}

	private void encryptAction() {	
		if(decryptedTextUserInput.getText().length() <= 1)
			if(noTextImport()) {
				if(importTextToEncryptor() == 1)
					return;
				encrypt.setDecryptedText(Save.importDecryptedText(fileChooser.getSelectedFile().toString()));
			} else return;
		else encrypt.setDecryptedText(decryptedTextUserInput.getText());
		encrypt.setKey(randomGenerator.getResults());
		if(encrypt.getKey().length <= 2)
			Save.setDefaultKey(encrypt, defaultKeyFile);
		encrypt.resetKey2();
		encrypt.encrypt();
		encrytpedTextBox.setText(encrypt.getEncryptedText());
		if(autoSave.isSelected())
			autoSave();
	}

	private void importEncryptAction(){
		if(importTextToEncryptor() == 1)
			return;
		encrypt.setDecryptedText(Save.importDecryptedText(fileChooser.getSelectedFile().toString()));
		encrypt.setKey(randomGenerator.getResults());
		if(encrypt.getKey().length <= 2)
			Save.setDefaultKey(encrypt, defaultKeyFile);
		encrypt.resetKey2();
		encrypt.encrypt();
		encrytpedTextBox.setText(encrypt.getEncryptedText());
		if(autoSave.isSelected())
			autoSave();
	}

	private int importTextToEncryptor() {
		if(fileChooser.showOpenDialog(frmEncryptionV) == 1)
			return 1;
		return 0;
	}

	private void decryptAction() {
		if(rdbtnDecryptFromFile.isSelected()) {
			if(!chckbxAdvancedFileChoosing.isSelected()) {
				if(directoryChooser.getSelectedFile() == null) {
					displayWarning("Choose a directory containing files to decrypt");
					directoryChooser.showOpenDialog(frmEncryptionV);
					if(directoryChooser.getSelectedFile() == null) {
						displayWarning("Decryption canceled. No Directory Selected.");
						return;
					}
				}
				Save.setFileLocation(directoryChooser.getSelectedFile().toString() + System.getProperty("file.separator"));
				Save.setAllEncryptedDataFromFile(decrypt);
			} else {
				if(fileChooserEncryptedText.getSelectedFile() == null || fileChooserKey.getSelectedFile() == null) {
					if (fileChooserEncryptedText.getSelectedFile() == null && fileChooserKey.getSelectedFile() == null)
						displayWarning("Decryption canceled. Encrypted text file and key file are not set.");
					else if(fileChooserEncryptedText.getSelectedFile() == null)
						displayWarning("Decryption canceled. Encrypted text file is not set.");
					else displayWarning("Decryption canceled. Key file is not set.");
					return;
				}
				Save.setEncryptedTextFromFile(decrypt, fileChooserEncryptedText.getSelectedFile().toString());
				Save.setKeysFromFile(decrypt, fileChooserKey.getSelectedFile().toString());
			}
		}else if(rdbtnDecryptFromEncrypted.isSelected()) {
			if(encrypt.getEncryptedText() == null) {
				displayWarning("Must encrypt something before using this decryption method.");
				return;
			}
			decrypt.setEncryptedText(encrypt.getEncryptedText());
			decrypt.setKey(encrypt.getKey());
			decrypt.setKey2(encrypt.getKey2());
		}else {
			displayWarning("Please select a decryption method.");
			return;
		}
		decrypt.decrypt();
		decryptedTextBox.setText(decrypt.getDecryptedText());
	}

	protected static void displayWarning(String message) {
		JOptionPane.showMessageDialog(null, message, "Warning", JOptionPane.WARNING_MESSAGE);
	}

	private static boolean noTextImport() {
		int result = JOptionPane.showConfirmDialog((Component) null, "Do you wish to import text from file?",
				"No text detected", JOptionPane.YES_NO_OPTION);
		return result == 0 ? true:false;
	}

	private void saveAsEncryptAction() {
		if(encrypt.getEncryptedText() == null) {
			displayWarning("Encrypt something to save");
			return;
		}
		if(saveAs.showOpenDialog(frmEncryptionV) == 1)
			return;
		Save.setFileLocation(saveAs.getSelectedFile().toString() + System.getProperty("file.separator"));
		Save.save(encrypt);
	}

	private void saveAsDecryptAction() {
		if(decrypt.getDecryptedText() == null) {
			displayWarning("Decrypt something to save");
			return;
		}
		if(saveAsDecrypt.showSaveDialog(frmEncryptionV) == 1)
			return;
		Save.setFileLocation(saveAsDecrypt.getSelectedFile().toString());
		Save.saveText(decrypt.getDecryptedText());
	}

	private void autoSave() {
		File autoSaveFile = new File(filePathTextField1.getText());
		if(!autoSaveFile.exists()) {
			displayWarning("File does not exist");
			return;
		}
		Save.setFileLocation(filePathTextField1.getText() + System.getProperty("file.separator"));
		Save.save(encrypt);
	}
}

/* Simple way to display a message
 * JOptionPane.showMessageDialog(null, "My Goodness, this is so concise");*/