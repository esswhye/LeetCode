package concurrency.ProducerAndConsumer;

public class Cup {
    private int numberTimes;
    private boolean available = false;

    public synchronized int getCup()  {

        while(!available)
        {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        available = false;
        notifyAll();
        return numberTimes;

    }

    public synchronized void putCup(int value)  {

        while(available)
        {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        available = true;
        numberTimes = value;
        notifyAll();
    }
}
