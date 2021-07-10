/**
 * EarAndMouth tool
 * Reads periodically out what is stored as a string in clipboard
 * @author Sören Reinecke alias Valor Naram
 */

public class Brain {
	
	public static void main(String[] args) {
		System.out.println("Initializing EarAndMouth");
		Ear ear = new Ear();
		ear.listen();
	}

}