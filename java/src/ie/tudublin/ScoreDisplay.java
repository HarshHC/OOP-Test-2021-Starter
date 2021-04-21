package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;

public class ScoreDisplay extends PApplet {
	String score = "DEFGABcd";
	ArrayList<Note> notes;
	// String score = "D2E2F2G2A2B2c2d2";
	// String score = "DEF2F2F2EFA2A2B2AFD2E2D2D2D2";

	public void settings() {
		size(1000, 500);

		// How to convert a character to a number
		char c = '7'; // c holds the character 7 (55)
		int i = c - '0'; // i holds the number 7 (55 - 48)
		println(i);
	}

	public void setup() {
		notes = new ArrayList<Note>();
		loadNotes();
		printScores();
	}

	public void draw() {
		background(255);
		drawStaveLines(5);

	}

	void loadNotes() {

		for (int i = 0; i < score.length(); i++) {
			char currentNote = score.charAt(i);
			int currentDuration = 1;

			if (i + 1 != score.length()) {
				char nextChar = score.charAt(i + 1);
				if (Character.isDigit(nextChar)) {
					currentDuration = nextChar - '0';
					i++;
				}
			}

			Note note = new Note(currentNote, currentDuration);
			notes.add(note);
		}
	}

	void printScores() {
		for (Note note : notes) {
			println(note.getNote() + "\t" + note.getDuration() + "\t"
					+ (note.getDuration() == 1 ? "Quaver" : "Crotchet"));
		}
	}

	void drawStaveLines(int num) {
		strokeWeight(5);
		int verticalGap = height / (num + 2);
		for (int i = 0; i < num; i++) {
			float yPos = (float) (i * verticalGap) + verticalGap;
			line(0.2f * width, yPos + verticalGap / 2, 0.8f * width, yPos + verticalGap / 2);
		}
	}

	void drawNotes() {

	}

}
