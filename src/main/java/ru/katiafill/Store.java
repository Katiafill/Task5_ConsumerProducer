package ru.katiafill;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Store {
    private static final Logger logger = LoggerFactory.getLogger(Store.class);
    private final int size;
    private Deque<Product> products;

    public Store(int size) {
        this.size = size;
        this.products = new ArrayDeque<>();
    }

    public synchronized Product get() {
        while (products.isEmpty()) {
            try {
                logger.info("Wait while product will be created.");
                wait();
                logger.info("Return to getting product.");
            } catch (InterruptedException ex) {
                logger.error("Exception occurred while wait getting product.", ex);
            }
        }

        Product product = products.pop();
        logger.info("Getting " + product + " from store.");
        logger.info("Store size: " + products.size());
        notifyAll();

        return product;
    }

    public synchronized void put(Product product) {
        while (products.size() >= size) {
            try {
                logger.info("Wait while store will be empty.");
                wait();
                logger.info("Return to putting product.");
            } catch (InterruptedException ex) {
                logger.error("Exception occurred while wait putting product.", ex);
            }
        }
        products.add(product);
        logger.info("Putting " +  product + " into store.");
        logger.info("Store size: " + products.size());
        notifyAll();
    }
}
