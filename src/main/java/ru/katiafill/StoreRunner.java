package ru.katiafill;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StoreRunner {
    private Store store;
    private List<Producer> producers;
    private List<Consumer> consumers;

    StoreRunner(Settings settings) {
        store = new Store(settings.getStoreSize());
        producers = new ArrayList<>(settings.getNumberOfProducers());
        consumers = new ArrayList<>(settings.getNumberOfConsumers());

        for (int i = 0; i < settings.getNumberOfProducers(); i++) {
            producers.add(new Producer(store, settings.getTimeoutProducer()));
        }

        for (int i = 0; i < settings.getNumberOfConsumers(); i++) {
            consumers.add(new Consumer(store, settings.getTimeoutConsumer()));
        }
    }


    public void run() {
        producers.forEach(p -> new Thread(p).start());
        consumers.forEach(c -> new Thread(c).start());
    }

    public void stop() {
        producers.forEach(Producer::stop);
        consumers.forEach(Consumer::stop);
    }
}
