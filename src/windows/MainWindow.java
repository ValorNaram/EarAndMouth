package windows;

import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.text.BadLocationException;

import presenter.Brain;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

public class MainWindow extends JFrame {
	private JTextArea writeInHere;
	private JPanel wrapper;
	private Brain brain;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		this.brain = new Brain();
		Container cpane = this.getContentPane();
		this.setBounds(900, 500, 450, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.wrapper = new JPanel();
		getContentPane().setLayout(new BorderLayout());
		cpane.add(this.wrapper);
		
		
		this.writeInHere = new JTextArea();
		this.writeInHere.setLineWrap(true);
		this.wrapper.add(this.writeInHere);
		this.writeInHere.setPreferredSize(new Dimension(300, 255));
		this.writeInHere.addKeyListener(new KeyAdapter() {
			
			public String sliceArray(String[] array, int startindex, int endindex) {
				String[] text = new String[endindex-startindex];
				for (int i = 0; i < text.length; i++) {
					text[i] = array[startindex+i];
				}
				String result = "";
				for (String i : text) {
					result += i;
				}
				return result;
			}
			
			public void speakWord() {
				int cursor = writeInHere.getCaretPosition();
				String[] textAsPiece = writeInHere.getText().split("");
				int startOfText = 0;
				for (int i = cursor-1; i >= 0; i--) {
					if (textAsPiece[i].equals(" ") || i == 0 || textAsPiece[i].equals(System.lineSeparator())) {
						startOfText = i;
						break;
					}
				}
					brain.getMouth().speak(sliceArray(textAsPiece, startOfText, cursor));
			}
			
			public void _keyTyped(KeyEvent e) {
				if (e.getKeyChar() == ' ' || e.getKeyCode() == 10) {
					this.speakWord();
				} else {
					brain.getMouth().speak(String.valueOf(e.getKeyChar()) + ".");
				}
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == 10) { // Enter
					this.speakWord();
				} else {
					this._keyTyped(e);
				}
			}
		});
		
		writeInHere.addCaretListener(new CaretListener() {
			@Override
			public void caretUpdate(CaretEvent e) {
				try {
					String txt = writeInHere.getText(e.getDot(), 1);
					if (!txt.isBlank()) {
						brain.getMouth().speak(txt);
					}
				} catch (BadLocationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
		});
	}
}
