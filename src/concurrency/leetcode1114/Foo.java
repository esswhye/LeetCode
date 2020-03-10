package concurrency.leetcode1114;

class Foo {
    int counter = 1;
    public Foo() {


    }

    public synchronized void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        while(counter!=1)
        {
         wait();
        }
        printFirst.run();
        counter++;
        notifyAll();
    }

    public synchronized void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        while(counter!=2)
        {
            wait();
        }
        printSecond.run();
        counter++;
        notifyAll();

    }

    public synchronized void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        while(counter!=3)
        {
            wait();
        }
        printThird.run();
        counter++;
        notifyAll();
    }
}