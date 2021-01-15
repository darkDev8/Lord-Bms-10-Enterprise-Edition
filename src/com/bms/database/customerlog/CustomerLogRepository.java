package com.bms.database.customerlog;

import com.bms.database.customer.Customer;
import com.bms.utility.Utils;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;
import javax.swing.JTable;

public class CustomerLogRepository {

    public void loadCustomerLogs(JTable table, String[] columns) {
        try {
            Utils.dBRepository.fillJTable("customerlogs", columns, table);
        } catch (SQLException e) {
            Utils.swingUI.showErrorDialog(e.getMessage(), "Loading customers logs failed.");
        }
    }

    public int count() {
        try {
            return Utils.dBRepository.countRecords("customerlogs");
        } catch (SQLException e) {
            Utils.swingUI.showErrorDialog(e.getMessage(), "Count customer logs failed.");
            return -1;
        }
    }

    public int exist(String column, String value, String type) {
        try {
            if (Utils.dBRepository.isTableContains("customerlogs", column, value, type)) {
                return 1;
            }

            return 0;
        } catch (SQLException e) {
            Utils.swingUI.showErrorDialog(e.getMessage(), "Checking customer log failed.");
            return -1;
        }
    }

    public boolean deleteLog(int id) {
        return false;
    }

    public boolean deleteAllLogs() {
        try (PreparedStatement pst = Utils.connection.prepareStatement("DELETE FROM customerlogs")) {
            pst.executeUpdate();
            return true;
        } catch (SQLException e) {
            Utils.swingUI.showErrorDialog("Unable to clear customerlogs table.\n" + e.getMessage(), "Delete failed");
            return false;
        }
    }

    public boolean addCustomerLog(CustomerLog customerLog) {
        if (Objects.isNull(customerLog)) {
            return false;
        }

        try (PreparedStatement pstmt
                = Utils.connection.prepareStatement("INSERT INTO customerlogs(fid,enterdate,exitdate) VALUES(?,?,?)")) {

            pstmt.setInt(1, customerLog.getFid());
            pstmt.setString(2, customerLog.getEnterdate());
            pstmt.setString(3, customerLog.getExitdate());

            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            Utils.swingUI.showErrorDialog("Unable to create new customer log in the databse.\n" + e.getMessage(),
                    "Log add failed.");
            return false;
        }
    }
}
