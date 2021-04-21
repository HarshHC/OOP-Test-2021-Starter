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

    public void draw(float verticalGap, int pos, int num) {
        int xGap = 100;
        float xPos = (0.1f * sc.width) + (pos * xGap);

        int straveNum = values.get(note) / 2;
        float distanceFromStrave = (straveNum % 2) == 0 ? (verticalGap / 2) : 0;
        float yPos = verticalGap + (straveNum * verticalGap) + distanceFromStrave;

        sc.ellipse(xPos, yPos, 50, 50);
    }
}