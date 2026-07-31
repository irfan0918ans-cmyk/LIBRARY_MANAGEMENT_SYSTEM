package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbConnection {
    public static Connection getConnection() throws SQLException{
        Properties properties = new Properties();
        String configFile = "config.properties";

        try(FileInputStream inputStream = new FileInputStream(configFile)){
            properties.load(inputStream);

        }catch (IOException e){
            throw new RuntimeException("config.properties file not found !",e);
        }
        String URL = properties.getProperty("db.url");
        String USERNAME = properties.getProperty("db.username");
        String PassWord = properties.getProperty("db.password");

        return DriverManager.getConnection(URL,USERNAME,PassWord );
    }
}
