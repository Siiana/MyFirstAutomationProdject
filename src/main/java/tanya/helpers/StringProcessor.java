package tanya.helpers;

public class StringProcessor {

    public static Double stringToDouble(String s) {
        return Double.valueOf(s.replaceAll("[ $a-z,]", ""));    //removes all non-digit symbols, convert to Double
    }

    public static String removeNonDigit(String s) {
        return s.replaceAll("[^0-9]", "");
    }

}
