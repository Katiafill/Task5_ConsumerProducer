package ru.katiafill;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Producer implements Runnable {
    private static int nextId = 0;
    private static final Logger logger = LoggerFactory.getLogger(Producer.class);

    private final int id;
    private final Store store;
    private final int timeout;
    private boolean isActive = false;

    public Producer(Store store, int timeout) {
        this.id = ++nextId;
        this.store = store;
        this.timeout = timeout;
    }

    public void stop(){
        isActive = false;
    }

    @Override
    public void run() {
        logger.info("Run " + this);
        isActive = true;

        while (isActive) {
            try {
                logger.info(this + "start create product.");
                Thread.sleep(timeout);
            } catch (InterruptedException ex) {
                logger.error("Exception sleep " + this, ex);
            }

            store.put(new Product());
            logger.info(this + " put 1 product into store");
        }
    }

    @Override
    public String toString() {
        return "Producer " + id;
    }
}