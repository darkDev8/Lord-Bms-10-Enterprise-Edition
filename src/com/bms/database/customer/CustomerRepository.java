package com.bms.database.customer;

import com.bms.utility.Utils;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import java.sql.PreparedStatement;
import java.util.Objects;
import java.sql.ResultSet;

public class CustomerRepository {

    public void loadCustomers(JTable table) {
        try {
            Utils.dBRepository.fillJTable("customers", new String[]{"id", "uid", "name", "mobile", "ncode", "date"}, table);
        } catch (SQLException e) {
            Utils.swingUI.showErrorDialog(e.getMessage(), "Loading customers failed.");
        }
    }

    public void loadCustomersForAccounts(JTable table) {
        try {
            Utils.dBRepository.fillJTable("customers", new String[]{"id", "name", "ncode"}, table);
        } catch (SQLException e) {
            Utils.swingUI.showErrorDialog(e.getMessage(), "Loading customers failed.");
        }
    }

    public int count() {
        try {
            return Utils.dBRepository.countRecords("customers");
        } catch (SQLException e) {
            Utils.swingUI.showErrorDialog(e.getMessage(), "Count customers failed.");
            return -1;
        }
    }

    public int exist(String ncode) {
        try {
            if (Utils.dBRepository.isTableContains("customers", "ncode", ncode, "")) {
                return 1;
            }

            return 0;
        } catch (SQLException e) {
            Utils.swingUI.showErrorDialog(e.getMessage(), "Checking customer failed.");
            return -1;
        }
    }

    public int userIDExist(String userID) {
        try {
            if (Utils.dBRepository.isTableContains("customers", "uid", userID, "")) {
                return 1;
            }

            return 0;
        } catch (SQLException e) {
            Utils.swingUI.showErrorDialog(e.getMessage(), "Checking User ID failed.");
            return -1;
        }
    }

    public boolean addCustomer(Customer customer) {
        if (Objects.isNull(customer)) {
            return false;
        }

        String sql = "INSERT INTO customers(uid,name,mobile,email,ncode,birth,gender,address,user,pass,hint,date)"
                + " VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";

        try (PreparedStatement pstmt = Utils.connection.prepareStatement(sql)) {
            pstmt.setInt(1, customer.getUid());
            pstmt.setString(2, customer.getName());
            pstmt.setString(3, customer.getMobile());
            pstmt.setString(4, customer.getEmail());
            pstmt.setString(5, customer.getNcode());
            pstmt.setString(6, customer.getBirth());
            pstmt.setShort(7, customer.getGender());
            pstmt.setString(8, customer.getAddress());
            pstmt.setString(9, customer.getUser());
            pstmt.setString(10, customer.getPass());
            pstmt.setString(11, customer.getHint());
            pstmt.setString(12, customer.getDate());

            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            Utils.swingUI.showErrorDialog("Unable to create new customer in the databse.\n"
                    + e.getMessage(), "Customer registration failed.");
            return false;
        }
    }

    public int usernameExist(String username) {
        try {
            if (Utils.dBRepository.isTableContains("customers", "user", username, "")) {
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
            if (Utils.dBRepository.isTableContains("customers", "pass", password, "")) {
                return 1;
            }

            return 0;
        } catch (SQLException e) {
            Utils.swingUI.showErrorDialog(e.getMessage(), "Checking password failed.");
            return -1;
        }
    }

    public Customer getCustomer(String input, String mode) {
        String sql = null;
        Customer customer = new Customer();

        switch (mode) {
            case "ncode":
            case "id":
            case "uid":
            case "user":
                sql = "SELECT * FROM customers WHERE " + mode + "=?";
                break;

            default:
                return null;

        }

        try (PreparedStatement pstmt = Utils.connection.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                customer.setId(rs.getInt("id"));
                customer.setId(rs.getInt("uid"));
                customer.setName(rs.getString("name"));
                customer.setMobile(rs.getString("mobile"));
                customer.setEmail(rs.getString("email"));
                customer.setNcode(rs.getString("ncode"));
                customer.setBirth(rs.getString("birth"));
                customer.setGender(rs.getShort("gender"));
                customer.setAddress(rs.getString("adress"));
                customer.setUser(rs.getString("user"));
                customer.setPass(rs.getString("pass"));
                customer.setHint(rs.getString("hint"));
                customer.setDate(rs.getString("date"));
            }

            return customer;
        } catch (SQLException e) {
            Utils.swingUI.showErrorDialog("Unable to fetch customer date from database.\n"
                    + e.getMessage(), "Fetch failed");
            return null;
        }

    }

}
