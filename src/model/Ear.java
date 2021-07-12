package model;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import model.Mouth;

public class Ear extends Thread {

	private Mouth speaker;
	private String clipText = "";

	public Ear(Mouth speaker) {
		this.speaker = speaker;
		while (this.speaker.isPlaying()) {

		}
	}

	public void listen() {
		while (this.speaker.isPlaying()) {

		}
		while (true) {
			try {
				Toolkit toolkit = Toolkit.getDefaultToolkit();
				Clipboard clipboard = toolkit.getSystemClipboard();
				String text = (String) clipboard.getData(DataFlavor.stringFlavor);
				decideToSpeak(text);
			} catch (Exception ex) {
				System.out.println("Unsupported clipboard operation!");
//				ex.printStackTrace();

			}

			try {
				Thread.sleep(1000);
			} catch (InterruptedException ex) {
				Thread.currentThread().interrupt();
			}
		}
	}

	public void run() {
		this.listen();
	}
	public void decideToSpeak(String text) {
		if (!this.clipText.equals(text)) {
			this.clipText = text;
			this.speaker.speak(text);
		}
	}
}
