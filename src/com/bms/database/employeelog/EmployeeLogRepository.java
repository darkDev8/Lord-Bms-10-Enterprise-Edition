package com.bms.database.employeelog;

import com.bms.database.customerlog.CustomerLog;
import com.bms.utility.Utils;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;
import javax.swing.JTable;

public class EmployeeLogRepository {

    public void loadEmployeeLogs(JTable table, String[] columns) {
        try {
            Utils.dBRepository.fillJTable("employeelogs", columns, table);
        } catch (SQLException e) {
            Utils.swingUI.showErrorDialog(e.getMessage(), "Loading employees logs failed.");
        }
    }

    public int count() {
        try {
            return Utils.dBRepository.countRecords("employeelogs");
        } catch (SQLException e) {
            Utils.swingUI.showErrorDialog(e.getMessage(), "Count employees logs failed.");
            return -1;
        }
    }

    public int exist(String column, String value, String type) {
        try {
            if (Utils.dBRepository.isTableContains("employeelogs", column, value, type)) {
                return 1;
            }

            return 0;
        } catch (SQLException e) {
            Utils.swingUI.showErrorDialog(e.getMessage(), "Checking employees log failed.");
            return -1;
        }
    }

    public boolean deleteLog(int id) {
        return false;
    }

    public boolean deleteAllLogs() {
        try (PreparedStatement pst = Utils.connection.prepareStatement("DELETE FROM employeelogs")) {
            pst.executeUpdate();
            return true;
        } catch (SQLException e) {
            Utils.swingUI.showErrorDialog("Unable to clear employeelogs table.\n" + e.getMessage(), "Delete failed");
            return false;
        }
    }

    public boolean addEmployeeLog(CustomerLog customerLog) {
        if (Objects.isNull(customerLog)) {
            return false;
        }

        try (PreparedStatement pstmt
                = Utils.connection.prepareStatement("INSERT INTO employeelogs(fid,enterdate,exitdate) VALUES(?,?,?)")) {

            pstmt.setInt(1, customerLog.getFid());
            pstmt.setString(2, customerLog.getEnterdate());
            pstmt.setString(3, customerLog.getExitdate());

            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            Utils.swingUI.showErrorDialog("Unable to create new employee log in the databse.\n" + e.getMessage(),
                    "Log add failed.");
            return false;
        }

    }

}
