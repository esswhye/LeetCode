package playground;

public class MethodReferenceToAnInstanceMethod {
    public void myMethod() {
        System.out.println("Instance Method");
    }

    public static void main(String[] args) {
        MethodReferenceToAnInstanceMethod obj = new MethodReferenceToAnInstanceMethod();
        // Method reference using the object of the class
        MyInterface ref = obj::myMethod;
        // Calling the method of functional interface
        ref.display();
        ref = () -> {
            System.out.println("Tello");
        };


        ref.display();
        NewInterface t = new InterfaceTest();
        t.Hello();
        t = () -> {
            System.out.println("HELLOAAAAAA");
        };
        t.Hello();
        System.out.println(t.sum(1, 2));
    }

}

@FunctionalInterface
interface MyInterface {
    void display();
}

@FunctionalInterface
interface NewInterface {

    default int sum(int a, int b) {
        return a + b;
    }

    ;

    void Hello();

}

class InterfaceTest implements NewInterface {

    @Override
    public void Hello() {
        System.out.println("HELLLOOO");
    }
}

