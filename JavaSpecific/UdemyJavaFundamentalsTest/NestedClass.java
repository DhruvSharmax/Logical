package JavaSpecific.UdemyJavaFundamentalsTest;

final public class NestedClass {
    final private int population = 250;
    final protected class City {
        private final int population = 100000;
        public final int getPopulation(){
            return NestedClass.this.population;
            // thats the line for fill in the blank. ps: we wanted to access top class variable population
        }
    }
    final City city = new City();
    final public static void main(String[] args) {
        System.out.println(new NestedClass().city.getPopulation());
    }
}
