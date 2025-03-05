package JavaSpecific.UdemyJavaFundamentalsTest;

public class ForLoopSyntax {
    public static void main(String[] args) {
        String[] characters = {
                "Miss Scarlet",
                "Professor Plum",
                "Mr. Green"
        };

        String[] weapns = {
                "candelisticks",
                "dagger",
                "revolver"
        };

        for (int j=0, k=0; j<1;j++, k++){
            System.out.println(characters[j] + " " + weapns[k]);
        }
    }
}
