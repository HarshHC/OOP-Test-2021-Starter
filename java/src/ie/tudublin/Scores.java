package ie.tudublin;

import java.util.HashMap;

public class Scores {
    private HashMap<Character, Integer> values = new HashMap<Character, Integer>();

    public Scores() {
        values.put('D', 10);
        values.put('E', 9);
        values.put('F', 8);
        values.put('G', 7);
        values.put('A', 6);
        values.put('B', 5);
        values.put('c', 4);
        values.put('d', 3);
    }

    public HashMap<Character, Integer> getValues() {
        return values;
    }

    public void setValues(HashMap<Character, Integer> values) {
        this.values = values;
    }

}
