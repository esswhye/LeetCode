class Parent {
    public static void foo() {
        System.out.println("Parent");
    }
}


public class Child extends Parent {
    public static void foo() {
        System.out.println("Child");
    }

    public static void main(String[] args) {
        Parent par = new Child();
        Child child = new Child();

        par.foo();
        child.foo();

        X x = new X();


    }
}

class X {
    X() {
        System.out.println("Hi");
    }

    X(int x) {
        System.out.println("How are you");
    }

    X(int x, int y) {
        System.out.println("Hello");
    }
}
