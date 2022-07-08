package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtil {

    public static String getSubString(String string, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);
        return matcher.find() ? matcher.group() : "";
    }
}
