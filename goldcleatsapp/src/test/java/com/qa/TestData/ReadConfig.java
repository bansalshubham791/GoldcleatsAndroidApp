package com.qa.TestData;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {


    private Properties prop;

    /**
     * @return
     */
    public Properties getProp() {
        return prop;
    }

    /**
     * ReadConfig function is used for exracting value from the config.properties file.
     */
    public ReadConfig(){
        File file = new File("C:\\Users\\Shubham Bansal\\IdeaProjects\\goldcleatsapp\\src\\test\\resources\\config.prop");
        try {
            FileInputStream fileInput = new FileInputStream(file);
            prop = new java.util.Properties();;
            prop.load(fileInput);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public String getPropertyValue(String key){
        return this.prop.getProperty(key);
    }
}
