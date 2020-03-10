package concurrency.ProducerAndConsumer.ProducerConsumerPattern;


import java.util.LinkedList;
import java.util.Queue;

public class MyBlockingQueue<E> {
    private int max;
    private Queue<E> queue;
    public static String message = "";
    public static final int POISON_PILL = -1;

    public MyBlockingQueue(int max) {
        this.max = max;
        this.queue = new LinkedList<>();
    }

    public synchronized void put(E e)
    {
        while(queue.size() == max)
            {
                try {
                    this.wait();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
            queue.add(e);
            notifyAll();

    }

    public synchronized E peek()
    {
        return queue.peek();
    }

    public synchronized E take()
    {

            while(queue.size()==0)
            {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            E item = queue.remove();
            notifyAll();
            return item;
    }

    public boolean isEmpty()
    {
        return queue.isEmpty();
    }
}
