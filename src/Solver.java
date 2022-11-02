import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;


public class Solver {
    public static String disemvowel(String str) {
        return str.replaceAll("[aeiouy]", "");
    }
    public static String toJadenCase(String phrase) {
        Objects.requireNonNull(phrase);
        if(phrase.equals("")){
            return null;
        }
        return Arrays.stream(phrase.split(" ")).map(s -> s.substring(0, 1).toUpperCase().concat(s.substring(1))).collect(Collectors.joining(" "));
    }
    public static int sortDesc(final int num) {
        var strnum = String.valueOf(num).toCharArray();
        Arrays.sort(strnum);
        System.out.println(strnum);
        return Integer.parseInt(new StringBuilder(new String(strnum)).reverse().toString());
    }
    static String toCamelCase(String s){
        Objects.requireNonNull(s);
        if(s.equals("")){
            return null;
        }
        var array = Arrays.stream(s.split("[-_]")).map(str -> str.substring(0, 1).toUpperCase().concat(str.substring(1))).collect(Collectors.joining());
        return (Character.isUpperCase(s.charAt(0))) ? array : array.substring(0, 1).toLowerCase() + array.substring(1);
    }
    public static boolean solution(String str, String ending) {
        return str.endsWith(ending);
    }
    public static int squareDigits(int n) {
        var toStr = String.valueOf(n);
        return Integer.parseInt(Arrays.stream(toStr.split(""))
                .map(p -> String.valueOf(Integer.parseInt(p) * Integer.parseInt(p)))
                .collect(Collectors.joining()));
    }
    public static void main(String[] args) {
        System.out.println(squareDigits(9119));
    }
}
