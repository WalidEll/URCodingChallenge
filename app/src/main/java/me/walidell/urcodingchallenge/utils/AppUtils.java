package me.walidell.urcodingchallenge.utils;

public class AppUtils {
    public static final String THOUSAND_CH = "K";
    public static final String MILLION_CH = "M";
    public static final int THOUSAND_V = 1000;
    public static final int MILLION_V = THOUSAND_V * 1000;

    public static String formatStars(int stars) {
        String finalStars="";
        if (stars < THOUSAND_V) {
            finalStars = String.valueOf(stars);
        } else if (stars < MILLION_V) {
            finalStars = String.valueOf(stars / THOUSAND_V)+ THOUSAND_CH;
        } else {
            finalStars = String.valueOf(stars / MILLION_V )+ MILLION_CH;
        }

        return finalStars;
    }
}
