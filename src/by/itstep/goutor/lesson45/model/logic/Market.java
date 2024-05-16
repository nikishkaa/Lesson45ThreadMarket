package by.itstep.goutor.lesson45.model.logic;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;

public class Market {
    private BlockingDeque<Integer> blockingDeque;
    private volatile boolean flag;


    public Market() {
        blockingDeque = new ArrayBlockingQueue<>(1);
    }

    public Market(int product) {
        try {
            blockingDeque = new ArrayBlockingQueue<>(1);
            blockingDeque.put(product);
        } catch (InterruptedException exception) {
            System.out.println(exception);
        }
    }


    public synchronized int get() {
        return blockingDeque.take();
    }

    public synchronized void put(int product) {
        blockingDeque.take();

    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}