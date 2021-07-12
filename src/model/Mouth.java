package model;
/**
 * Kudos to Luke Alderton for providing an example code to MaryTTS which shows actually the usage because MaryTTS doc was not helpful
 * --> https://lukealderton.com/blog/posts/2013/december/using-marytts-or-openmary-in-java/
 */

import javax.sound.sampled.AudioInputStream;

import marytts.LocalMaryInterface;
import marytts.MaryInterface;
import marytts.exceptions.MaryConfigurationException;
import marytts.exceptions.SynthesisException;
import marytts.util.data.audio.AudioPlayer;


public class Mouth {

	private MaryInterface mary;
	private AudioPlayer ap;
	private AudioInputStream audio;

	public Mouth (String voice)  {
		try {
			this.mary = new LocalMaryInterface();
			this.mary.setVoice(voice);
		} catch (MaryConfigurationException e) {
			System.err.println("A mouth needs a voice. A mouth cannot speak without voice. This mouth has no voice.");
			// e.printStackTrace();
			System.exit(1);
		}
		
	}

	public void speak(String text) {
		try {
			this.audio = this.mary.generateAudio(text.replace(". ", ".").replace(".", ". ").trim());
			
			this.stopSpeaking(this.ap);
			this.ap = new AudioPlayer();
			this.ap.setAudio(this.audio);
			this.ap.start();
		} catch (SynthesisException e) {
			System.out.println("Mouth couldn't speak but speaking is usually something a mouth should do.");
			// e.printStackTrace();
		}
	}

	public void stopSpeaking(AudioPlayer ap) {
		if (this.ap != null) {
			this.ap.cancel();
		}
	}

	public boolean isPlaying() {
		if (this.ap != null) {
			return this.ap.isAlive();
		}
		return false;
	}

}