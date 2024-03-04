package ru.katiafill;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        Settings settings = SettingsLoader.load("src/main/resources/settings.properties");
        if (settings == null) {
            logger.info("Did not load settings.");
            return;
        }

        StoreRunner runner = new StoreRunner(settings);
        runner.run();
        new Scanner(System.in).nextLine();
        runner.stop();

    }
}