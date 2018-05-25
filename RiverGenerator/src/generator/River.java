package generator;

import static java.lang.System.out;
import java.util.Random;

public class River{
	private int riverLength;
	private int riverWidth;
	private char riverSymbol;
	
	public River() {
		riverLength = 10;
		riverWidth = 5;
		riverSymbol = '|';
	}
	
	public River(int riverLength, int riverWidth, char riverSymbol) {
		this.riverLength = riverLength;
		this.riverWidth = riverWidth;
		this.riverSymbol = riverSymbol;
	}

	public int getRiverLength() {
		return riverLength;
	}

	public void setRiverLength(int riverLength) {
		this.riverLength = riverLength;
	}

	public int getRiverWidth() {
		return riverWidth;
	}

	public void setRiverWidth(int riverWidth) {
		this.riverWidth = riverWidth;
	}

	public char getRiverSymbol() {
		return riverSymbol;
	}

	public void setRiverSymbol(char riverSymbol) {
		this.riverSymbol = riverSymbol;
	}
	
	public void riverGenerate() {
		int min = -1;
		int max = 1;
		int randomShift = 0;
		int startSpace = 10;
		
		for (int riverLengthIndex = 0; riverLengthIndex < this.riverLength; riverLengthIndex++) {
			generateSide(randomShift, min, max, this.riverWidth, startSpace, false, true);
			//out.format("%" + this.riverWidth +"s", "");
			generateSide(randomShift, min, max, this.riverWidth, startSpace, true, false);
		}
	}
	
	public void generateSide(int randomShift, int min, int max, int riverWidth, int startSpace, boolean newLine, boolean addFrontSpace) {
		Random rand = new Random();
		randomShift = rand.nextInt((max - min) + 1) + min;
		int formatSpace = randomShift + riverWidth;
		String newLineText;
		if (newLine) {
			newLineText = "%n";
		} else {
			newLineText = "";
		}
		if (addFrontSpace) {
			formatSpace = randomShift + startSpace;
		}
		out.format("%" + formatSpace +"s" + newLineText, this.riverSymbol);
	}
	
	
}
