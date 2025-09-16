package takeyoufwd.basicmath;

import java.util.function.IntBinaryOperator;

public class FactorialAndSumOfN {
    static IntBinaryOperator op;

    void main() {
        op = (a, b) -> a * b;
        System.out.println(f(6)); // 4*3*2*1=24
        op = (a, b) -> a + b;
        System.out.println(f(6)-1); // 6+5+4+3+2+1
//        System.out.println(getFact(4));
//        System.out.println(getSum(4));
    }

    int f(int i) {
        if (i < 1) return 1;
        return op.applyAsInt(i, f(i-1));
    }

/*   int getFact(int i) {
        if(i<1) return 1;
        return i*getFact(i-1);
    }

    int getSum(int i) {
        if(i<1) return 0;
        return i+getSum(i-1);
    } */
}
