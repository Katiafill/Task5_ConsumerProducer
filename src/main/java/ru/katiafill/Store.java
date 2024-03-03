package ru.katiafill;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Stack;

public class Store {
    private static final Logger logger = LoggerFactory.getLogger(Store.class);
    private final int size;
    private Stack<Product> products;

    public Store(int size) {
        this.size = size;
        this.products = new Stack<>();
    }

    public synchronized Product get() {
        while (products.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException ex) {
                logger.error("Exception occurred while wait getting product.", ex);
            }
        }

        Product product = products.pop();
        logger.info("Get product");
        logger.info("Store size: " + products.size());
        notifyAll();

        return product;
    }

    public synchronized void put(Product product) {
        while (products.size() >= size) {
            try {
                wait();
            } catch (InterruptedException ex) {
                logger.error("Exception occurred while wait putting product.", ex);
            }
        }
        products.add(product);
        notifyAll();
    }
}
