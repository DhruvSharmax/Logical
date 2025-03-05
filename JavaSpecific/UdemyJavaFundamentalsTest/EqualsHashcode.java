package JavaSpecific.UdemyJavaFundamentalsTest;

public class EqualsHashcode {
    private int VIN;
    private String model,brand;
    private int year;

    public int hashCode(){
        return (model+brand).hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return
                obj instanceof EqualsHashcode
                        && this.VIN == ((EqualsHashcode) obj).VIN;
    }
}
