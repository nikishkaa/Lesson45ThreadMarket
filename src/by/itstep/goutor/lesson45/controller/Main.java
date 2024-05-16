package by.itstep.goutor.lesson45.controller;

import by.itstep.goutor.lesson45.model.data.Consumer;
import by.itstep.goutor.lesson45.model.data.Producer;
import by.itstep.goutor.lesson45.model.logic.Market;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Market market = new Market();
        Producer producer = new Producer(market, System.out);
        Consumer consumer1 = new Consumer(market, System.out, 1);
//        Consumer consumer2 = new Consumer(market, System.out, 2);
//        Consumer consumer3 = new Consumer(market, System.out, 3);
//        Consumer consumer4 = new Consumer(market, System.out, 4);
//        Consumer consumer5 = new Consumer(market, System.out, 5);
//        Consumer consumer6 = new Consumer(market, System.out, 6);


        TimeUnit.SECONDS.sleep(10);
        producer.stop();
        consumer1.stop();
//        consumer2.stop();
//        consumer3.stop();
//        consumer4.stop();
//        consumer5.stop();
//        consumer6.stop();

    }
}
