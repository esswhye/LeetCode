package playground;

import java.util.function.BiFunction;

public class MethodReferenceToAStaticMethod {
    public static void main(String[] args) {

        BiFunction<Integer, Integer, Integer> product = Multiplication::multiply;

        System.out.println(product.apply(5, 5));

    }

}

class Multiplication {
    public static int multiply(int a, int b) {
        return a * b;
    }
}
