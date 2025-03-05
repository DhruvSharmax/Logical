package JavaSpecific.UdemyJavaFundamentalsTest;

class Applicant {
    private String name;
    public Applicant(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }

    public Applicant() {            // thats mind boggeling !!
        this("");             // I didnt use super() in child class and with just default constructr addition it worked
    }
}
public class InheritanceConstructors extends Applicant {
    public void process(){}
    public void remove(){}
}
