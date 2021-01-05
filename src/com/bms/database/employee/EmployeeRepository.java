package com.bms.database.employee;

import com.bms.database.customer.Customer;
import com.bms.utility.Utils;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;
import javax.swing.JTable;

public class EmployeeRepository {

    public void loadEmployees(JTable table) {
        try {
            Utils.dBRepository.fillJTable("employees", new String[]{"id", "uid", "name", "mobile", "ncode", "date"}, table);
        } catch (SQLException e) {
            Utils.swingUI.showErrorDialog(e.getMessage(), "Loading employees failed.");
        }
    }

    public int count() {
        try {
            return Utils.dBRepository.countRecords("employees");
        } catch (SQLException e) {
            Utils.swingUI.showErrorDialog(e.getMessage(), "Count employees failed.");
            return -1;
        }
    }

    public int exist(String ncode) {
        try {
            if (Utils.dBRepository.isTableContains("employees", "ncode", ncode, "")) {
                return 1;
            }

            return 0;
        } catch (SQLException e) {
            Utils.swingUI.showErrorDialog(e.getMessage(), "Checking employee failed.");
            return -1;
        }
    }

    public int userIDExist(String userID) {
        try {
            if (Utils.dBRepository.isTableContains("employees", "uid", userID, "")) {
                return 1;
            }

            return 0;
        } catch (SQLException e) {
            Utils.swingUI.showErrorDialog(e.getMessage(), "Checking User ID failed.");
            return -1;
        }
    }

    public boolean addEmployee(Employee employee) {
        if (Objects.isNull(employee)) {
            return false;
        }

        String sql = "INSERT INTO employees(uid,name,mobile,ncode,user,pass,hint,father,date)"
                + " VALUES(?,?,?,?,?,?,?,?,?)";

        try (PreparedStatement pstmt = Utils.connection.prepareStatement(sql)) {
            pstmt.setInt(1, employee.getUid());
            pstmt.setString(2, employee.getName());
            pstmt.setString(3, employee.getMobile());
            pstmt.setString(4, employee.getNcode());
            pstmt.setString(5, employee.getUser());
            pstmt.setString(6, employee.getPass());
            pstmt.setString(7, employee.getHint());
            pstmt.setString(8, employee.getFather());
            pstmt.setString(9, employee.getDate());

            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            Utils.swingUI.showErrorDialog("Unable to create new employee in the databse.\n"
                    + e.getMessage(), "Employee registration failed.");
            return false;
        }
    }

    public int usernameExist(String username) {
        try {
            if (Utils.dBRepository.isTableContains("employees", "user", username, "")) {
                return 1;
            }

            return 0;
        } catch (SQLException e) {
            Utils.swingUI.showErrorDialog(e.getMessage(), "Checking username failed.");
            return -1;
        }
    }

    public int passwordExist(String password) {
        try {
            if (Utils.dBRepository.isTableContains("employees", "pass", password, "")) {
                return 1;
            }

            return 0;
        } catch (SQLException e) {
            Utils.swingUI.showErrorDialog(e.getMessage(), "Checking password failed.");
            return -1;
        }
    }

}
