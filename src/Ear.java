import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;

public class Ear {

	private Mouth speaker;
	private String clipText = "";

	public Ear() {
		speaker = new Mouth("bits3-hsmm");
		speaker.speak("Hallo");
		while (speaker.isPlaying()) {

		}
	}

	public void listen() {
		speaker.speak("Ohr gestartet!");
		while (speaker.isPlaying()) {

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

	public void decideToSpeak(String text) {
		System.out.println(clipText + " | " + text);
		if (!this.clipText.equals(text)) {
			this.clipText = text;
			speaker.speak(text);
		}
	}
}
