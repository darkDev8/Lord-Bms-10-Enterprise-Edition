package com.bms.database.customer;

import com.bms.database.account.Account;
import com.bms.utility.Utils;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import java.sql.PreparedStatement;
import java.util.Objects;
import java.sql.ResultSet;

public class CustomerRepository {

    public void loadCustomers(JTable table, String[] columns) {
        try {
            Utils.dBRepository.fillJTable("customers", columns, table);
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

    public int exist(String column, String value, String type) {
        try {
            if (Utils.dBRepository.isTableContains("customers", column, value, type)) {
                return 1;
            }

            return 0;
        } catch (SQLException e) {
            Utils.swingUI.showErrorDialog(e.getMessage(), "Checking customer failed.");
            return -1;
        }
    }

    public boolean addCustomer(Customer customer) {
        if (Objects.isNull(customer)) {
            return false;
        }

        String sql = "INSERT INTO customers(name,mobile,email,ncode,birth,gender,address,user,pass,hint,date)"
                + " VALUES(?,?,?,?,?,?,?,?,?,?,?)";

        try (PreparedStatement pstmt = Utils.connection.prepareStatement(sql)) {
            pstmt.setString(1, customer.getName());
            pstmt.setString(2, customer.getMobile());
            pstmt.setString(3, customer.getEmail());
            pstmt.setString(4, customer.getNcode());
            pstmt.setString(5, customer.getBirth());
            pstmt.setShort(6, customer.getGender());
            pstmt.setString(7, customer.getAddress());
            pstmt.setString(8, customer.getUser());
            pstmt.setString(9, customer.getPass());
            pstmt.setString(10, customer.getHint());
            pstmt.setString(11, customer.getDate());

            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            Utils.swingUI.showErrorDialog("Unable to create new customer in the databse.\n" + e.getMessage(),
                    "Customer registration failed.");
            return false;
        }
    }

    public Customer getCustomer(String column, String key) {
        String sql = "SELECT * FROM customers WHERE " + column + "= '" + key + "'";
        Customer customer = new Customer();

        try (PreparedStatement pstmt = Utils.connection.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                customer.setId(rs.getInt("id"));
                customer.setName(rs.getString("name"));
                customer.setMobile(rs.getString("mobile"));
                customer.setEmail(rs.getString("email"));
                customer.setNcode(rs.getString("ncode"));
                customer.setBirth(rs.getString("birth"));
                customer.setGender(rs.getShort("gender"));
                customer.setAddress(rs.getString("address"));
                customer.setUser(rs.getString("user"));
                customer.setPass(rs.getString("pass"));
                customer.setHint(rs.getString("hint"));
                customer.setDate(rs.getString("date"));
            }

            return customer;
        } catch (SQLException e) {
            Utils.swingUI.showErrorDialog("Unable to fetch customer data from database.\n" + e.getMessage(), "Fetch failed");
            return null;
        }
    }

    public boolean editCustomer(Customer customer) {
        String query = "UPDATE customers set name=?,mobile=?,email=?,ncode=?,birth=?,gender=?,address=?,user=?,pass=?,hint=?,date=?"
                + " WHERE id=? ";

        if (Objects.isNull(customer)) {
            return false;
        }

        try (PreparedStatement ps = Utils.connection.prepareStatement(query)) {
            ps.setString(1, customer.getName());
            ps.setString(2, customer.getMobile());
            ps.setString(3, customer.getEmail());
            ps.setString(4, customer.getNcode());
            ps.setString(5, customer.getBirth());
            ps.setShort(6, customer.getGender());
            ps.setString(7, customer.getAddress());
            ps.setString(8, customer.getUser());
            ps.setString(9, customer.getPass());
            ps.setString(10, customer.getHint());
            ps.setString(11, customer.getDate());

            ps.setInt(12, customer.getId());
            ps.executeUpdate();     //executeUpdate returns 0 value if true
            return true;
        } catch (Exception e) {
            Utils.swingUI.showErrorDialog("Failed to update customer.\n" + e.getMessage(), "Customer update failed");
            return false;
        }
    }

//    public Account getAccount(Customer customer, String column) {
//        if (exist("id", String.valueOf(customer.getId()), "int") == 0) {
//            return null;
//        }
//        
//        String sql = "SELECT * FROM accounts WHERE " + column + "= '" + key + "'";
//        Account account = new Account();
//
//        try (PreparedStatement pstmt = Utils.connection.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {
//
//            while (rs.next()) {
//                customer.setId(rs.getInt("id"));
//                customer.setName(rs.getString("name"));
//                customer.setMobile(rs.getString("mobile"));
//                customer.setEmail(rs.getString("email"));
//                customer.setNcode(rs.getString("ncode"));
//                customer.setBirth(rs.getString("birth"));
//                customer.setGender(rs.getShort("gender"));
//                customer.setAddress(rs.getString("address"));
//                customer.setUser(rs.getString("user"));
//                customer.setPass(rs.getString("pass"));
//                customer.setHint(rs.getString("hint"));
//                customer.setDate(rs.getString("date"));
//            }
//
//            return customer;
//        } catch (SQLException e) {
//            Utils.swingUI.showErrorDialog("Unable to fetch customer data from database.\n" + e.getMessage(), "Fetch failed");
//            return null;
//        }
//    }

}
