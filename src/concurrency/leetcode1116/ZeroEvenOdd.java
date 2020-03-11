package concurrency.leetcode1116;

import java.util.function.IntConsumer;

class ZeroEvenOdd {
    private int n;
    boolean zero,even, odd;

    public ZeroEvenOdd(int n) {
        this.n = n;
        this.zero = true;
    }


    // printNumber.accept(x) outputs "x", where x is an integer.
    public synchronized void zero(IntConsumer printNumber) throws InterruptedException {
        for(int i = 1; i<=n; i++)
        {
            while(!zero){
                wait();
            }
            printNumber.accept(0);
            even  =  (n%2==0);
            odd = (n%2!= 0);
            zero = false;
            notifyAll();
        }

    }

    public synchronized void even(IntConsumer printNumber) throws InterruptedException {
        for(int i = 2; i<=n; i+=2)
        {
            while(!even){
                wait();
            }
            printNumber.accept(i);
            zero = true;
            even = false;
            notifyAll();
        }
    }

    public synchronized void odd(IntConsumer printNumber) throws InterruptedException {
        for(int i = 1; i<=n; i+=2)
        {
            while(!odd){
                wait();
            }
            printNumber.accept(i);
            zero = true;
            odd = false;
            notifyAll();
        }
    }
}