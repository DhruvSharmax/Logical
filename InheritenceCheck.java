public class InheritenceCheck implements A,B{

    @Override
    public void print() {
        A.super.print();      // try removing overriden method
    }
}

interface A{
   default /*static*/ void print(){
       System.out.print("A");
    }
}

interface B{
    default void print(){
        System.out.print("B");
    }
}