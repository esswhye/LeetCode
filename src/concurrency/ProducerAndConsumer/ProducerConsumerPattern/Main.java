package concurrency.ProducerAndConsumer.ProducerConsumerPattern;


public class Main {

    // Using Synchronized -> wait() and notifyAll()
    public static void main(String[] args) {

        MyBlockingQueue<Integer> myBlockingQueue = new MyBlockingQueue<>(10);

        Producer producer = new Producer(myBlockingQueue);

        Thread t1Producer = new Thread(producer);

        Consumer consumer = new Consumer(myBlockingQueue, "Consumer 1");
        Consumer consumer2 = new Consumer(myBlockingQueue, "Consumer 2");

        /*
        Consumer consumer = new Consumer(myBlockingQueue){
            @Override
            public void run() {
                while(t1Producer.isAlive())
                {
                    int removed = blockingQueue.take();
                    System.out.println(removed);
                }
                System.out.println("Terminating Consumer..");
            }
        };
         */
        Thread t2Consumer = new Thread(consumer);

        Thread t3Consumer = new Thread(consumer2);
        t1Producer.setPriority(10);

        t1Producer.start();
        t3Consumer.start();
        t2Consumer.start();



    }

}
