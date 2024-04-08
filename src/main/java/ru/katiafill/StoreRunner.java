package ru.katiafill;

import ru.katiafill.models.Consumer;
import ru.katiafill.models.Producer;
import ru.katiafill.models.Store;
import ru.katiafill.settings.Settings;

import java.util.ArrayList;
import java.util.List;

public class StoreRunner {
    private final Store store;
    private final List<Producer> producers;
    private final List<Consumer> consumers;

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
