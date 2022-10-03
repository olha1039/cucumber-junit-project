package com.cydeo.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    // we make it private to be inaccessible from outside
    // static block is to run first
    //we can not use a non static obj in a static area. that is why we need to make the obj static.
    //if u make the properties obj instance, you will see that it will be red in the static block.
    private static Properties properties = new Properties();
    // having static block because static runs first, because in this class we dont have Main method or TestNg to run the class so we will need a "Static block" (which will run one time when we call the class no matter what )

    // try and catch will handle it but throws will just ignore it so it might be better just to handle it , Remember Saim said if you just throw you need to keep doing that everytime you need
    static {
        FileInputStream file = null;
        try {
            file = new FileInputStream("configuration.properties");
            properties.load(file);
           // file.close();
        } catch (IOException e) {
            System.out.println("Error occurred while reading configuration file");
            e.printStackTrace(); // giving a message here, we have it above
        }
    }

    public static String getProperty(String key){
        return properties.getProperty(key);
    }

}
