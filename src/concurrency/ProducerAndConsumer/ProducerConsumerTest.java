package concurrency.ProducerAndConsumer;

//https://javaconceptoftheday.com/difference-between-blocked-vs-waiting-states-in-java/
public class ProducerConsumerTest {

    public static void main(String[] args) {

        Cup cup = new Cup();

        Runnable consumer = new Consumer(cup,1);
        Runnable consumer2 = new Consumer(cup,2);
        Runnable producer = new Producer(cup, 1);

        new Thread(consumer).start();
        new Thread(producer).start();
        new Thread(consumer2).start();

//        Thread t1 = new Consumer(cup,1);
//        Thread t2 = new Producer(cup,1);
//        Thread t3 = new Consumer(cup,2);
//
//        t1.start();
//        t2.start();
//        t3.start();
    }
}
