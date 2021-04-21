package ie.tudublin;

import java.util.HashMap;

import processing.core.PApplet;

public class Note {
    private ScoreDisplay sd;
    private char note;
    private int duration;
    private Scores scores;
    private float size, xPos, yPos;
    private HashMap<Character, Integer> values;

    public Note(ScoreDisplay sd, char note, int duration) {
        this.sd = sd;
        this.note = note;
        this.duration = duration;

        this.scores = new Scores();
        this.values = scores.getValues();
    }

    public char getNote() {
        return note;
    }

    public void setNote(char note) {
        this.note = note;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void draw(float verticalGap, int pos, int num, int length) {
        size = (0.7f * sd.height - 0.3f * sd.height) / 5;
        float xGap = 45;
        // float xPos = (0.1f * sd.width) + xGap / 2 + (pos * xGap);
        xPos = PApplet.map(pos, 0, length, 0.15f * sd.width, 0.9f * sd.width);

        int straveNum = (values.get(note) / 2) - 1;
        float distanceFromStrave = (values.get(note) % 2) == 0 ? 0 : (size / 2);

        yPos = PApplet.map(straveNum, 0, 5, 0.3f * sd.height, 0.7f * sd.height) + distanceFromStrave + size / 2;

        sd.ellipse(xPos, yPos, size, size);
        sd.fill(0);
        sd.textSize(20);
        sd.text(note, xPos, 0.2f * sd.height);
        sd.line(xPos + size / 2, yPos, xPos + size / 2, yPos - 2 * size);

        if (duration == 2) {
            sd.line(xPos + size / 2, yPos - 2 * size, xPos + size, yPos - size);

        }
    }

    public void highlightOnHover() {
        if (sd.mouseX > xPos - (size / 2) && sd.mouseX < xPos + (size / 2)) {
            sd.fill(255, 0, 0);

        }
    }

}