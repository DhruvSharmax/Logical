package challenges.stringPlay;

public class PatternMatcher {
    public static void main(String[] args) {
        String str = "xabcdey";
        String pattern = "ab*de";
        System.out.println(patternMatch(str, pattern)); // prints 1
    }

    private static int patternMatch(String str, String pattern) {
        String regex = "^"+ pattern.replace("*",".*") +".*$";
        int n = str.length()-pattern.replace("*","").length();

        for(int i=0; i<n; i++)
            if(str.substring(i).matches(regex))
                return i;
        return -1;
    }
}
