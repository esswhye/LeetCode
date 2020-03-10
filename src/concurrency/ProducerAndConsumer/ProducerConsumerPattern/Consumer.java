package concurrency.ProducerAndConsumer.ProducerConsumerPattern;

public class Consumer implements Runnable {

    MyBlockingQueue<Integer> blockingQueue;

    String name;

    public Consumer(MyBlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    public Consumer(MyBlockingQueue<Integer> blockingQueue, String name) {
        this.blockingQueue = blockingQueue;
        this.name = name;
    }

    @Override
    public void run() {

        //while(!blockingQueue.message.equals("Finished"))

        int removed;
        while((removed= blockingQueue.take())!= blockingQueue.POISON_PILL)
        {
            try{
                Thread.sleep((long) (200* Math.random()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + " pop queue "+ removed);
        }
        blockingQueue.put(-1);
        System.out.println(name+ " Terminate Consumer...");
    }
}
