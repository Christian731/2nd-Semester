/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyUtil;

/**
 * To center a string
 * @author Christian Paul David
 */
public class CenterString {
    
    /**
     * Generate a string of blank characters of a given length.
     * @param n The length.
     * @return a string of blank characters of length n.
     */
    public static String spaces(int n)
    {
        String result = "";
        for (int i = 0; i < n; i++) {
            result += " ";
        } 
        return result;
    }
    /**
     * Centers text within a field of a given width.
     * @param text The supplied text to be centers.
     * @param width The desired length.
     * @return A string of length width with text centered in it.
     */
    public static String center(String text, int width)
    {
        int n = width - text.length();
        if( n <= 0)
        {
            return text;
        }
        String result =  spaces(n/2) + text + spaces(n/2);
        if(n%2 == 1)
        {
            result += " ";
        }
        return result;
    }
}
