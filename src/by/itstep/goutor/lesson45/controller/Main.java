package by.itstep.goutor.lesson45.controller;

import by.itstep.goutor.lesson45.model.data.Consumer;
import by.itstep.goutor.lesson45.model.data.Producer;
import by.itstep.goutor.lesson45.model.logic.Market;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Market market = new Market();
        Producer producer = new Producer(market, System.out);
        Consumer consumer = new Consumer(market, System.out, 1);


        TimeUnit.SECONDS.sleep(10);
        producer.stop();
        consumer.stop();
    }
}
