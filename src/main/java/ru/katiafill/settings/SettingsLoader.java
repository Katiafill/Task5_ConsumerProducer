package ru.katiafill.settings;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class SettingsLoader {
    private static final Logger logger = LoggerFactory.getLogger(SettingsLoader.class);

    private static final String STORE_SIZE = "storeSize";
    private static final String NUMBER_OF_PRODUCERS = "numberOfProducers";
    private static final String NUMBER_OF_CONSUMERS = "numberOfConsumers";
    private static final String TIMEOUT_PRODUCER = "timeoutProducer";
    private static final String TIMEOUT_CONSUMER = "timeoutConsumer";

    public static Settings load(String fileName) {
        try {
            Properties properties = new Properties();
            properties.load(new FileReader(fileName));
            return getSettings(properties);
        } catch (IOException ex) {
            logger.error("Exception occurred while loading " + fileName, ex);
            return null;
        }
    }

    private static Settings getSettings(Properties properties) {
        Settings settings = new Settings();

        settings.setStoreSize(getProperty(STORE_SIZE, properties));
        settings.setNumberOfConsumers(getProperty(NUMBER_OF_CONSUMERS, properties));
        settings.setNumberOfProducers(getProperty(NUMBER_OF_PRODUCERS, properties));
        settings.setTimeoutConsumer(getProperty(TIMEOUT_CONSUMER, properties));
        settings.setTimeoutProducer(getProperty(TIMEOUT_PRODUCER, properties));

        return settings;
    }

    private static int getProperty(String key, Properties properties) {
        return Integer.parseInt(properties.getProperty(key));
    }
}
