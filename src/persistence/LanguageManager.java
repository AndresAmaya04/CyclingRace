package persistence;

import java.io.IOException;
import java.util.Properties;

public class LanguageManager {

    public String fileName;
    public static String language = "undefined";
    public static Properties propertiesLanguage;

    public LanguageManager(String fileName) {
        this.fileName=fileName;
    }

    public void loadLanguage() throws IOException {
        Properties handlerProperties = Utilities.generateLanguageProperties(fileName);
        language = handlerProperties.getProperty("Language");
        propertiesLanguage = Utilities.generateLanguageProperties(language);
    }

    public void saveLanguage() throws IOException {
        Properties handlerProperties = Utilities.generateLanguageProperties(fileName);
        handlerProperties.setProperty("Language", language);
        Utilities.saveLanguageProperties(handlerProperties, fileName);
    }
}
