package DS100_Genpact;

public class CountACharOcuuranceInString {
    public static void main(String[] args) {
        var s = "counting number of occurrence in this string";
        var target = 's';
        long result = s.chars().filter(x->x==target).count();
        System.out.println(result);
    }
}
