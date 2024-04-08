package ru.katiafill.models;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Consumer implements Runnable {
    private static int nextId = 0;
    private static final Logger logger = LoggerFactory.getLogger(Consumer.class);

    private final int id;
    private final Store store;
    private final int timeout;
    private boolean isActive = false;

    public Consumer(Store store, int timeout) {
        this.id = ++nextId;
        this.store = store;
        this.timeout = timeout;
    }

    public void stop() {
        isActive = false;
    }

    @Override
    public void run() {
        logger.info("Run " + this);
        isActive = true;

        while (isActive) {
            try {
                Thread.sleep(timeout);
            } catch (InterruptedException ex) {
                logger.error("Exception sleep " + this, ex);
            }

            Product product = store.get();
        }
    }

    @Override
    public String toString() {
        return "Consumer " + id;
    }
}
