package ru.katiafill;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.katiafill.settings.Settings;
import ru.katiafill.settings.SettingsLoader;

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

        try (Scanner scanner = new Scanner(System.in)) {
            scanner.nextLine();
            runner.stop();
        }

    }
}