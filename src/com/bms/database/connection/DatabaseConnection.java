package com.bms.database.connection;

import com.sdk.database.MySQLConnection;
import com.sdk.database.DBRepository;
import java.sql.Connection;

public class DatabaseConnection {
    private MySQLConnection sQLConnection;
    
    public DatabaseConnection() {
        sQLConnection = new MySQLConnection("localhost", "3306", "root", "", "lord");
    }
    
    public boolean connect() {
        return sQLConnection.connect();
    }
    
    public Connection getConnection() {
        return sQLConnection.getConnection();
    }
    
    public String getConnectionString() {
        return sQLConnection.getConnectionStr();
    }
}
