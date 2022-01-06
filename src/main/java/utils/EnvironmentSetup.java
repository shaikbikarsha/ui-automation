package utils;

import controllers.BaseController;
import org.testng.annotations.Test;


import java.io.File;
import java.io.FileOutputStream;
import java.net.InetAddress;
import java.util.Properties;

public class EnvironmentSetup extends BaseController {

    @Test
    public static void environmentSetup() {
        try {
            Properties properties = new Properties();
            properties.setProperty("Author", "Entrata");
            properties.setProperty("browser", browser);
            properties.setProperty("OS", osName);
            properties.setProperty("OS Version", osVersion);
            properties.setProperty("OS Architecture", osArchitecture);
            properties.setProperty("OS Bit", osBit);
            properties.setProperty("Host Name", InetAddress.getLocalHost().getHostName());
            properties.setProperty("Host IP Address", InetAddress.getLocalHost().getHostAddress());

            File file = new File("./src/main/resources/environment.properties");
            FileOutputStream fileOut = new FileOutputStream(file);
            properties.store(fileOut, "Environment Setup");
            fileOut.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
