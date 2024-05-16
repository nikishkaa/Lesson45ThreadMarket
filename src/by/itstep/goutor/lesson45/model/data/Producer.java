package by.itstep.goutor.lesson45.model.data;

import by.itstep.goutor.lesson45.model.logic.Market;

import java.io.PrintStream;

public class Producer implements Runnable {
    private volatile boolean running;
    private Market market;
    private Thread thread;

    private PrintStream stream;

    public Producer(Market market, PrintStream stream) {
        this.market = market;
        this.stream = stream;
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        while (running) {

            try {
                    market.put(product);
                    stream.println("Producer put product" + product++);
                    market.setFlag(true);
                    market.notify();
                } else {
                    wait();
                }
            } catch (InterruptedException exception) {
                stream.println(exception);
            }

        }
    }

    public void stop() {
        running = false;
    }
}
