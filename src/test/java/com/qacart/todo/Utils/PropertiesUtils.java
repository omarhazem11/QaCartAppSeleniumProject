package com.qacart.todo.Utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtils {

    public static Properties loadproperties(String filePath){
        File file = new File(filePath);
        try {
            InputStream inputStream = new FileInputStream(file);
            Properties properties = new Properties();
            properties.load(inputStream);
            inputStream.close();
            return properties;
        } catch (FileNotFoundException e){
            throw new RuntimeException("File is not found.");
        } catch (IOException e){
            throw new RuntimeException("Error while loading the properties");
        }


    }
}
