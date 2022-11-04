import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


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
    public static int duplicateCount(String text) {
        var res = new ArrayList<String>();

        IntStream.range(0, text.length()).forEach(c -> {
            if(c < text.length() - 1){
                String tmp = text.substring(c, c + 1);
                if(text.substring(c + 1).toUpperCase().contains(tmp.toUpperCase()) && !res.contains(tmp.toUpperCase())){
                    res.add(tmp.toUpperCase());
                }
            }
        });
        return res.size();
    }
    public static String encode(String word){
        var toLower = word.toLowerCase();
        return Arrays.stream(toLower.split(""))
                .map(p -> {
                  if(toLower.substring(0, toLower.indexOf(p)).concat(toLower.substring(toLower.indexOf(p) + 1)).contains(p)){
                      return ")";
                  } else {
                      return "(";
                  }
                }).collect(Collectors.joining());
    }

    public static String order(String words) {
        return Arrays.stream(words.split(" "))
                .sorted(Comparator.comparing(s -> Integer.parseInt(s.replaceAll("\\D", ""))))
                .collect(Collectors.joining(" "));

    }
    public static void main(String[] args) {
        System.out.println(encode("Prespecialized"));
        System.out.println("Prespecialized".substring(0, 3).concat("Prespecialized".substring(4)));
    }
}
