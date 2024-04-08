package ru.katiafill.settings;

public class Settings {
    private int storeSize;
    private int numberOfProducers;
    private int numberOfConsumers;
    private int timeoutProducer;
    private int timeoutConsumer;

    public int getStoreSize() {
        return storeSize;
    }

    public void setStoreSize(int storeSize) {
        this.storeSize = storeSize;
    }

    public int getNumberOfProducers() {
        return numberOfProducers;
    }

    public void setNumberOfProducers(int numberOfProducers) {
        this.numberOfProducers = numberOfProducers;
    }

    public int getNumberOfConsumers() {
        return numberOfConsumers;
    }

    public void setNumberOfConsumers(int numberOfConsumers) {
        this.numberOfConsumers = numberOfConsumers;
    }

    public int getTimeoutProducer() {
        return timeoutProducer;
    }

    public void setTimeoutProducer(int timeoutProducer) {
        this.timeoutProducer = timeoutProducer;
    }

    public int getTimeoutConsumer() {
        return timeoutConsumer;
    }

    public void setTimeoutConsumer(int timeoutConsumer) {
        this.timeoutConsumer = timeoutConsumer;
    }
}
