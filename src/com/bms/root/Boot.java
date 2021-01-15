package com.bms.root;

import java.io.IOException;
import java.net.SocketException;

import com.bms.database.connection.DatabaseConnection;
import com.bms.utility.Settings;
import com.bms.utility.Utils;
import com.sdk.database.DBRepository;
import com.sdk.environment.Console;
import com.sdk.environment.OperatingSystem;
import com.sdk.security.Security;
import com.sdk.storage.Internet;
import com.sdk.storage.files.TextFile;
import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.util.Properties;
import java.util.function.Consumer;

public class Boot {

    private TextFile file;
    private OperatingSystem os;
    private Internet internet;
    private DatabaseConnection databaseConnection;

    public Boot() {
        file = new TextFile("build.txt");
        os = new OperatingSystem();
        internet = new Internet("http://www.google.com");
        databaseConnection = new DatabaseConnection();
    }

    public Boot loadBuildNumber() {
        try {
            if (file.exist() && !file.isEmpty()) {
                int number = Integer.parseInt(file.readFirstLine()) + 1;
                if (file.write(String.valueOf(number))) {
                    Utils.envs.put("build", String.valueOf(number));
                } else {
                    Utils.envs.put("build", "ERROR");
                }
            } else {
                Utils.envs.put("build", "1");
                file.write("1");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return this;
    }

    public Boot loadSystemUser() {
        Utils.envs.put("sysUser", os.getUsername());
        return this;
    }

    public Boot loadSystemUserHomeDirectory() {
        Utils.envs.put("home", os.getHomeUser());
        return this;
    }

    public Boot loadSystemTime() {
        Utils.envs.put("time", os.getSystemTime());
        return this;
    }

    public Boot loadSystemDate() {
        Utils.envs.put("date", os.getSystemDate());
        return this;
    }

    public Boot loadCurrentOS() {
        Utils.envs.put("os", os.getOSName());
        return this;
    }

    public Boot loadDatabaseConnection() {
        Utils.envs.put("database", String.valueOf(databaseConnection.connect()));
        Utils.connection = databaseConnection.getConnection();
        return this;
    }

    public Boot loadInternetConnection() {
        Utils.envs.put("internet", String.valueOf(internet.isInternetConnected()));
        return this;
    }

    public Boot loadDatabase() {
        Utils.dBRepository = new DBRepository(databaseConnection.getConnection());
        return this;
    }

    public Boot loadEncryptionKey() {
        Utils.envs.put("encKey", "23549918?*");
        return this;
    }

    public Boot loadManagerPassword() {
        Utils.envs.put("manager", "mnl23549918?*");
        return this;
    }

    public Boot loadSettings() {
        Settings settings = new Settings();
        TextFile file = new TextFile("config.xml");

        try {
            if (file.exist()) {
                InputStream inputStream = new FileInputStream(new File("config.xml"));
                Properties props = new Properties();
                props.loadFromXML(inputStream);
                inputStream.close();

                settings.setCloseRegister(props.getProperty("closeRegister"));
                settings.setTableRecords(props.getProperty("tableRecords"));
                settings.setDialogPath(props.getProperty("dialogPath"));
                settings.setColorCode(props.getProperty("appColor"));
                settings.setPayment(props.getProperty("payment"));
                settings.setDefaultMoney(props.getProperty("defaultMoney"));
            } else {
                Properties props = new Properties();

                props.setProperty("tableRecords", "20");
                props.setProperty("dialogPath", Utils.envs.get("home"));
                props.setProperty("closeRegister", String.valueOf(true));
                props.setProperty("appColor", "#131a4a");
                props.setProperty("payment", "5");
                props.setProperty("defaultMoney", "10000");

                OutputStream outputStream = new FileOutputStream(new File("config.xml"));
                props.storeToXML(outputStream, "Settings values");
                outputStream.close();

                settings.setCloseRegister("true");
                settings.setDialogPath(Utils.envs.get("home"));
                settings.setTableRecords("20");
                settings.setColorCode("#131a4a");
                settings.setPayment("5");
                settings.setDefaultMoney("10000");
            }

            Utils.settings = settings;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return this;
        }
    }
}
