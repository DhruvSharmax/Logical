package JavaSpecific.UdemyJavaFundamentalsTest;

public class LegacyArray {
    public static void main(String[] args) {
        String[] planets = new String[] {"Earth", "Jupiter", "Saturn", "Mercury", "Mars", "Venus", "Neptune", "Uranus"};
        for(int i=0;i<planets.length;i++){
            System.out.println(planets[i]);
            if(planets[i].length()<5)
                System.out.println(planets[i]);
        }
    }
}
