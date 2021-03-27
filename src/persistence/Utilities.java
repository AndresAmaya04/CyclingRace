package persistence;

import java.io.*;
import java.util.Properties;

public class Utilities {

    public static Properties generateLanguageProperties(String fileOfLanguage) throws IOException {
        Properties properties = new Properties();
        InputStream input  = new FileInputStream(fileOfLanguage);
        properties.load(input);
        return properties;
    }

    public static void saveLanguageProperties(Properties properties, String fileLanguage) throws IOException {
        FileOutputStream output = new FileOutputStream(fileLanguage);
        properties.store(output, null);
        output.close();
    }

    public static String[] splitLine(String string){
        return string.split("\\?+");
    }
}