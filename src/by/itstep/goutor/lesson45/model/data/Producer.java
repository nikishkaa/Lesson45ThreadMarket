package by.itstep.goutor.lesson45.model.data;

import by.itstep.goutor.lesson45.model.logic.Market;

import java.io.PrintStream;
import java.util.concurrent.TimeUnit;

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
        int product = 1;
        while (running) {
            try {
                if (!market.isFlag()) {
                    stream.println("Producer put product" + product);
                    market.put(product);
                    market.setFlag(true);
                }
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException exception) {
                stream.println(exception);
            }

        }
    }

    public void stop() {
        running = false;
    }
}
