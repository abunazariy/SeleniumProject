package test.day09_Testbase_Properties_DriverUtil;

import Utilities.Configuration_Reader;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadingFromProperties {

    @Test
    public void reading_properties_file()throws  Exception{
        Properties properties = new Properties();
        String path = "configuration.properties";

        FileInputStream file = new FileInputStream(path);
        properties.load(file);
        System.out.println("properties.getProperty(\"browser\") = " + properties.getProperty("browser"));
        System.out.println("properties.getProperty(\"username\") = " + properties.getProperty("username"));
        System.out.println("properties.getProperty(\"password\") = " + properties.getProperty("password"));
        System.out.println("properties.getProperty(\"address\") = " + properties.getProperty("address"));

    }

    @Test
    public void configuration_reader_utility(){
        System.out.println("Configuration_Reader.getProperty(\"browser\") = " + Configuration_Reader.getProperty("browser"));
        System.out.println("Configuration_Reader.getProperty(\"username\") = " + Configuration_Reader.getProperty("username"));
        System.out.println("Configuration_Reader.getProperty(\"password\") = " + Configuration_Reader.getProperty("password"));
        System.out.println("Configuration_Reader.getProperty(\"address\") = " + Configuration_Reader.getProperty("address"));

    }
}
