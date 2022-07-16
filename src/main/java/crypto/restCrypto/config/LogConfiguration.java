package crypto.restCrypto.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class LogConfiguration {
    private static final LogManager logManager = LogManager.getLogManager();
    private static final Logger logger = Logger.getLogger(LogConfiguration.class.getName());
    public static void initialize() {
        try {
            logManager.readConfiguration(new FileInputStream("src/main/resources/logging.properties"));
        } catch (IOException exception) {
            logger.log(Level.SEVERE, "Error in loading configuration.", exception);
        }
    }
}
