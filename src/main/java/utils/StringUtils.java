package utils;

public class StringUtils {
    public static boolean isEmpty(String string) {
        return "".equals(string) || string == null;
    }

    public static boolean isNotEmpty(String string) {
        return !isEmpty(string);
    }
}
