package slot3reel;

import MyUtil.CenterString;
import MyUtil.RandomIntGenerator;

/**
 * Create a a class for the reels of a slot machine
 *
 * @author Christian Paul David
 */
public class Slot3Reel {

    private String[] symbolList = {"Banana", "Apricot", "Fig", "Mandarin", "Pear",
        "Tangerine", "Melon"};
    private String[] payline = new String[3];

    /**
     * Default constructor
     */
    public void fillPayline() {
        for (int i = 0; i < payline.length; i++) {
            int position = RandomIntGenerator.generate(0, symbolList.length - 1);
            payline[i] = symbolList[position];
        }
    }

    /**
     * A method that gets a number between 0 and 2 and then sends the string
     * from the array corresponding the number
     *
     * @param k a number
     * @return The string that is input in the array payline
     */
    public String get(int k) {
        if (k < 0 || k > payline.length) {
            throw new IllegalArgumentException("Slot3Reel:get: array index out of bounds");
        }
        return payline[k];
    }

    /**
     * Constructor for Slot3Reel
     */
    public Slot3Reel() {
        fillPayline();
    }

    /**
     * Simulates the spinning of the reel of a casino machine
     */
    public void spin() {
        int num = MyUtil.RandomIntGenerator.generate(2, 9);
        for (int i = 1; i <= num; i++) {
            fillPayline();
            System.out.println(toString());
        }
        System.out.println("****************************************");
        fillPayline();
        System.out.println(toString());
        System.out.println("****************************************");

    }

    /**
     * Generate a string of blank characters of a given length.
     *
     * @param n The length.
     * @return a string of blank characters of length n.
     */
    public static String spaces(int n) {
        String result = "";
        for (int i = 0; i < n; i++) {
            result += " ";
        }
        return result;
    }

    /**
     * Centers text within a field of a given width.
     *
     * @param text The supplied text to be centers.
     * @param width The desired length.
     * @return A string of length width with text centered in it.
     */
    public static String center(String text, int width) {
        int n = width - text.length();
        if (n <= 0) {
            return text;
        }
        String result = spaces(n / 2) + text + spaces(n / 2);
        if (n % 2 == 1) {
            result += " ";
        }
        return result;
    }

    /**
     * To string method
     *
     * @return the result of a spin
     */
    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < payline.length; i++) {
            result += "|  " + CenterString.center(payline[i], 10);
//            result += String.format("| %-10s", payline[i]);
        }
        result += "|";
        return result;
    }

    /**
     * Getter for symbollist
     *
     * @return The symbollist
     */
    public String[] getSymbolList() {
        return symbolList;
    }

    /**
     * setter for symbolist
     *
     * @param symbolList
     */
    public void setSymbolList(String[] symbolList) {
        this.symbolList = symbolList;
    }

    /**
     * getter for payline
     *
     * @return the payline
     */
    public String[] getPayline() {
        return payline;
    }

    /**
     * setter for payline
     *
     * @param payline
     */
    public void setPayline(String[] payline) {
        this.payline = payline;
    }

}
