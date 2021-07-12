package presenter;
import model.Ear;
import model.Mouth;
import windows.MainWindow;

/**
 * EarAndMouth tool
 * Reads periodically out what is stored as a string in clipboard
 * @author Sören Reinecke alias Valor Naram
 */

public class Brain {
	
	private Mouth speaker;
	private Ear ear;
	private MainWindow window;
	
	public Brain() {
		this("bits3-hsmm");
	}
	
	public Brain(String voicename) {
		this.speaker = new Mouth(voicename);
		this.ear = new Ear(speaker);
		this.speaker.speak("Ohr und Mund gestartet!");
		this.ear.start();
		System.out.println("EarAndMouth initiated!");
	}
	
	public Ear getEar() {
		return this.ear;
	}
	
	public Mouth getMouth() {
		return this.speaker;
	}

}