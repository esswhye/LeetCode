package playground;

import java.util.Arrays;

public class MethodRefToAnInstanceMethodAbiObject {


    public static void main(String[] args) {
        String[] stringArray = {"Steve", "Rick", "Aditya", "Negan", "Lucy", "Sansa", "Jon"};
        /* Method reference to an instance method of an arbitrary
         * object of a particular type
         */

//        Arrays.sort(stringArray, (a, b) -> {
//            return a.compareToIgnoreCase(b);
//        });

        Arrays.sort(stringArray, String::compareToIgnoreCase);
    }

}
