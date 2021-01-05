package com.bms.root;

import java.io.IOException;
import java.net.SocketException;

import com.bms.database.connection.DatabaseConnection;
import com.bms.utility.Utils;
import com.sdk.database.DBRepository;
import com.sdk.environment.OperatingSystem;
import com.sdk.storage.Internet;
import com.sdk.storage.files.TextFile;

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
}
