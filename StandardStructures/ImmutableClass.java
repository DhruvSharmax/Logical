package StandardStructures;

public final class ImmutableClass {
    private final int data1;
    private final String str;
    private final Student student;		// mutable object

    public ImmutableClass(int data1, String str, Student student) {
        this.data1 = data1;
        this.str = str;
        this.student = new Student(1,2);  // performed deep copy for mutable object
    }

    public int getData1() {
        return data1;
    }
    public String getStr() {
        return str;
    }
    public Student getStudent() {
        return student;
    }
}

// Mutable class
record Student ( int a, int b){}
