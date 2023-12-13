import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    public double[] tribonacci(double[] s, int n) {
        var newArray = Arrays.copyOf(s, n);
        IntStream.range(3, n).forEach(i -> {
            newArray[i] = newArray[i-1] + newArray[i - 2] + newArray[i - 3];
        });
        return newArray;
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
    public static double findUniq(double arr[]) {
        double first = arr[0], second = arr[1], third = arr[2];
        double duplicatedValue = (Math.ulp(first) == Math.ulp(second)) ? first : (Math.ulp(first) == Math.ulp(third)) ? third : second;
        var distincts = Arrays.stream(arr).distinct().toArray();
        return (distincts[0] == duplicatedValue) ? distincts[1] : distincts[0];
    }
    public static boolean check(String sentence){
        var uppercase = sentence.toUpperCase();
        HashSet<String> set = new HashSet<>();
        Arrays.stream(uppercase.split("")).forEach(s -> {
            if(s.matches("[A-Z]")){
                set.add(s);
            }
        });
        System.out.println(set);
        return set.size() == 26;
    }
    private static boolean isValidateEntry(int n){
        return n >= 0;
    }
    public int solution(int number) {
        var set = new HashSet<Integer>();
        return IntStream.range(0, number).map(i -> {
            if((i % 3 == 0 || i % 5 == 0) && !set.contains(i)){
                set.add(i);
                return i;
            } else {
                return 0;
            }
        }).sum();
    }

    //    private static int maxSequence(int[] arr, int index, int res){
////        if(index == 0){
////            return arr[0];
////        }
//        return Math.max(arr[index], arr[index] + maxSequence(arr, index - 1));
//    }
//    public static int sequence(int[] arr) {
//        return maxSequence(arr, arr.length - 1);
//    }
    /**
     * Complete the solution so that it strips all text that follows any of a set of comment markers passed in.
     * Any whitespace at the end of the line should also be stripped out.
     * @param text
     * @param commentSymbols
     * @return
     */
    public static String stripComments(String text, String[] commentSymbols) {
        var res = text;
        var metas = Map.of(
                "\\", "\\",
                "^", "\\^",
                "$", "\\$"
        );
        for(var s : commentSymbols) {
            res = res.replaceAll(" *" + (metas.getOrDefault(s, s)) + ".*", "");
        }
        return res;
    }

    public static String pigIt(String str) {
        Objects.requireNonNull(str);
        return Arrays.stream(str.split(" "))
                .map(wd -> {
                    if(!Character.isLetterOrDigit(wd.charAt(0))) return wd;
                    return wd.substring(1).concat(wd.charAt(0) + "ay");
                })
                .collect(Collectors.joining(" "));
    }

    public static long ipsBetween(String start, String end) {
        var resultStart = start.split("\\.");
        var resultEnd = end.split("\\.");
        Arrays.stream(resultStart).forEach(System.out::println);

        var resStart = Integer.parseInt(resultStart[3]) + Integer.parseInt(resultStart[2]) * 256 + Integer.parseInt(resultStart[1]) * 65536 + Integer.parseInt(resultStart[0]) * 16777216;
        var resEnd   = Integer.parseInt(resultEnd[3])   + Integer.parseInt(resultEnd[2])   * 256   + Integer.parseInt(resultEnd[1]) * 65536 + Integer.parseInt(resultEnd[0]) * 16777216;
        System.out.println(resEnd + " -> " + resStart);
        return resEnd - resStart;
    }

    public static void main(String[] args) {
        System.out.println(stripComments("a #b\nc\nd e f g$ ", new String[] { "#", "$" }));

    }
}
