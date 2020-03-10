package concurrency.ProducerAndConsumer;


public class Producer extends Thread {

    private Cup cup;
    private int number;

    public Producer(Cup cup, int number) {
        this.cup = cup;
        this.number = number;
    }

    @Override
    public void run() {
        for(int i = 1; i<=20; i++){
            cup.putCup(i);
            System.out.println("Producer No:" + number + " put: " + i);

            try{
                Thread.sleep((long) (200* Math.random()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
