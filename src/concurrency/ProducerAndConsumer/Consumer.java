package concurrency.ProducerAndConsumer;

public class Consumer extends Thread {
    private Cup cup;
    private int number;

    public Consumer(Cup cup, int number) {
        this.cup = cup;
        this.number = number;
    }

    @Override
    public void run() {

        int val;
        for(int i = 1; i<=10;i++) {
            try {
                Thread.sleep((long) (200 * Math.random()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            val = cup.getCup();
            System.out.println("Consumer No:" + number + " Get :" + val);

        }
    }
}
