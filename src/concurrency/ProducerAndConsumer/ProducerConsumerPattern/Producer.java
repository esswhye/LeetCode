package concurrency.ProducerAndConsumer.ProducerConsumerPattern;


public class Producer implements Runnable {

    MyBlockingQueue<Integer> blockingQueue;

    public Producer( MyBlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        for(int i=1; i<=10; i++)
        {
            blockingQueue.put(i);
            try{
                Thread.sleep((long) (200* Math.random()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        blockingQueue.put(-1);

        //blockingQueue.notify();
        blockingQueue.message = "Finished";
        System.out.println("Terminating Producer...");

    }
}
