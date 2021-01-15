package com.bms.database.transaction;

import com.bms.utility.Utils;
import java.sql.SQLException;
import javax.swing.JTable;
import java.sql.PreparedStatement;

public class TransactionRepository {

    public void loadTransactions(JTable table, String[] columns) {
        try {
            Utils.dBRepository.fillJTable("transactions", columns, table);
        } catch (SQLException e) {
            Utils.swingUI.showErrorDialog(e.getMessage(), "Loading transactions failed.");
        }
    }

    public int count() {
        try {
            return Utils.dBRepository.countRecords("transactions");
        } catch (SQLException e) {
            Utils.swingUI.showErrorDialog(e.getMessage(), "Count transactions failed.");
            return -1;
        }
    }

    public int exist(String column, String value, String type) {
        try {
            if (Utils.dBRepository.isTableContains("transactions", column, value, type)) {
                return 1;
            }

            return 0;
        } catch (SQLException e) {
            Utils.swingUI.showErrorDialog(e.getMessage(), "Checking transaction failed.");
            return -1;
        }
    }
    
    public boolean deleteAll() {
        try (PreparedStatement pst = Utils.connection.prepareStatement("DELETE FROM transactions")) {
            pst.executeUpdate();
            return true;
        } catch(SQLException e) {
            Utils.swingUI.showErrorDialog("Unable to clear transaction table.\n" + e.getMessage(), "Delete failed");
            return false;
        }
    }
    
    /*
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
            Utils.swingUI.showErrorDialog("Unable to fetch customer date from database.\n" + e.getMessage(), "Fetch failed");
            return null;
        }
    }
    */
}
