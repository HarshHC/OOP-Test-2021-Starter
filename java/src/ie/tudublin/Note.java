package ie.tudublin;

import java.util.HashMap;

import processing.core.PApplet;

public class Note {
    private ScoreDisplay sc;
    private char note;
    private int duration;
    private Scores scores;
    private HashMap<Character, Integer> values;

    public Note(ScoreDisplay sc, char note, int duration) {
        this.sc = sc;
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
        int size = 30;
        float xGap = sc.width / (length * 0.8f);
        float xPos = (0.1f * sc.width) + xGap / 2 + (pos * xGap);
        // float xPos = PApplet.map(pos, 0, length, (0.1f * sc.width), (0.9f *
        // sc.width));

        int straveNum = values.get(note) / 2;
        float distanceFromStrave = (values.get(note) % 2) == 0 ? -16 : (verticalGap / 2);
        float yPos = verticalGap + (straveNum * verticalGap) + distanceFromStrave;

        sc.fill(0);
        sc.ellipse(xPos, yPos, size, size);
        sc.line(xPos + size / 2, yPos, xPos + size / 2, yPos - 2 * size);

        if (duration == 2) {
            sc.line(xPos + size / 2, yPos - 2 * size, xPos + size, yPos - size + (size / 2));

        }
    }
}