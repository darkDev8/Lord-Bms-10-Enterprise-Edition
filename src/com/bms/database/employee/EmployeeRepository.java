package com.bms.database.employee;

import com.bms.database.customer.Customer;
import com.bms.utility.Utils;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import javax.swing.JTable;

public class EmployeeRepository {

    public void loadEmployees(JTable table, String[] columns) {
        try {
            Utils.dBRepository.fillJTable("employees", columns, table);
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

    public int exist(String column, String value, String type) {
        try {
            if (Utils.dBRepository.isTableContains("employees", column, value, type)) {
                return 1;
            }

            return 0;
        } catch (SQLException e) {
            Utils.swingUI.showErrorDialog(e.getMessage(), "Checking employees failed.");
            return -1;
        }
    }

    public boolean addEmployee(Employee employee) {
        if (Objects.isNull(employee)) {
            return false;
        }

        String sql = "INSERT INTO employees(name,mobile,ncode,user,pass,hint,date)"
                + " VALUES(?,?,?,?,?,?,?)";

        try (PreparedStatement pstmt = Utils.connection.prepareStatement(sql)) {
            pstmt.setString(1, employee.getName());
            pstmt.setString(2, employee.getMobile());
            pstmt.setString(3, employee.getNcode());
            pstmt.setString(4, employee.getUser());
            pstmt.setString(5, employee.getPass());
            pstmt.setString(6, employee.getHint());
            pstmt.setString(7, employee.getDate());

            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            Utils.swingUI.showErrorDialog("Unable to create new employee in the databse.\n"
                    + e.getMessage(), "Employee registration failed.");
            return false;
        }
    }

    public Employee getEmployee(String column, String key) {
        String sql = "SELECT * FROM employees WHERE " + column + "= '" + key + "'";
        Employee employee = new Employee();

        try (PreparedStatement pstmt = Utils.connection.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                employee.setId(rs.getInt("id"));
                employee.setName(rs.getString("name"));
                employee.setMobile(rs.getString("mobile"));
                employee.setNcode(rs.getString("ncode"));
                employee.setUser(rs.getString("user"));
                employee.setPass(rs.getString("pass"));
                employee.setHint(rs.getString("hint"));
                employee.setDate(rs.getString("date"));
            }

            return employee;
        } catch (SQLException e) {
            Utils.swingUI.showErrorDialog("Unable to fetch employee data from database.\n" + e.getMessage(), "Fetch failed");
            return null;
        }
    }

    public boolean editEmployee(Employee employee) {
        String query = "UPDATE employees set name=?,mobile=?,ncode=?,user=?,pass=?,hint=?,date=? WHERE id=? ";

        if (Objects.isNull(employee)) {
            return false;
        }

        try (PreparedStatement ps = Utils.connection.prepareStatement(query)) {
            ps.setString(1, employee.getName());
            ps.setString(2, employee.getMobile());
            ps.setString(3, employee.getNcode());
            ps.setString(4, employee.getUser());
            ps.setString(5, employee.getPass());
            ps.setString(6, employee.getHint());
            ps.setString(7, employee.getDate());

            ps.setInt(8, employee.getId());
            ps.executeUpdate();     //executeUpdate returns 0 value if true
            return true;
        } catch (Exception e) {
            Utils.swingUI.showErrorDialog("Failed to update employee.\n" + e.getMessage(), "Employee update failed");
            return false;
        }
    }

}
