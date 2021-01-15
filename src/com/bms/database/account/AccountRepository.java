package com.bms.database.account;

import com.bms.database.customer.Customer;
import com.bms.database.employee.Employee;
import com.bms.utility.Utils;
import com.sdk.database.DBRepository;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.swing.JTable;

public class AccountRepository {

    public void loadAccounts(JTable table, String[] columns) {
        try {
            Utils.dBRepository.fillJTable("accounts", columns, table);
        } catch (SQLException e) {
            Utils.swingUI.showErrorDialog(e.getMessage(), "Loading accounts failed.");
        }
    }

    public int count() {
        try {
            return Utils.dBRepository.countRecords("accounts");
        } catch (SQLException e) {
            Utils.swingUI.showErrorDialog(e.getMessage(), "Count accounts failed.");
            return -1;
        }
    }

    public int exist(String column, String value, String type) {
        try {
            if (Utils.dBRepository.isTableContains("accounts", column, value, type)) {
                return 1;
            }

            return 0;
        } catch (SQLException e) {
            Utils.swingUI.showErrorDialog(e.getMessage(), "Checking account failed.");
            return -1;
        }
    }

    public boolean addAccount(Account account) {
        if (Objects.isNull(account)) {
            return false;
        }

        String sql = "INSERT INTO accounts(fid,acn,money,type,status,date)"
                + " VALUES(?,?,?,?,?,?)";

        try ( PreparedStatement pstmt = Utils.connection.prepareStatement(sql)) {
            pstmt.setInt(1, account.getFid());
            pstmt.setString(2, account.getAcn());
            pstmt.setString(3, account.getMoney());
            pstmt.setShort(4, account.getType());
            pstmt.setShort(5, account.getStatus());
            pstmt.setString(6, account.getDate());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            Utils.swingUI.showErrorDialog("Unable to create new account in the databse.\n"
                    + e.getMessage(), "Account registration failed.");
            return false;
        }
    }

    public Account[] loadCustomerAccounts(String column, String key) {
        String sql = "SELECT * FROM accounts WHERE " + column + "= '" + key + "'";
        List<Account> list = new ArrayList<>();

        try ( PreparedStatement pstmt = Utils.connection.prepareStatement(sql);  ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Account account = new Account();

                account.setId(rs.getInt("id"));
                account.setFid(rs.getInt("fid"));
                account.setAcn(rs.getString("acn"));
                account.setMoney(rs.getString("money"));
                account.setType(rs.getShort("type"));
                account.setStatus(rs.getShort("status"));
                account.setDate("date");

                list.add(account);
            }

            return list.toArray(new Account[0]);
        } catch (SQLException e) {
            Utils.swingUI.showErrorDialog("Unable to fetch customer date from database.\n" + e.getMessage(), "Fetch failed");
            return null;
        }
    }

    public Account getAccount(String column, String key) {
        String sql = "SELECT * FROM accounts WHERE " + column + "= '" + key + "'";
        Account account = new Account();

        try ( PreparedStatement pstmt = Utils.connection.prepareStatement(sql);  ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                account.setId(rs.getInt("id"));
                account.setFid(rs.getInt("fid"));
                account.setAcn(rs.getString("acn"));
                account.setMoney(rs.getString("money"));
                account.setType(rs.getShort("type"));
                account.setStatus(rs.getShort("status"));
                account.setDate(rs.getString("date"));
            }

            return account;
        } catch (SQLException e) {
            Utils.swingUI.showErrorDialog("Unable to fetch account data from database.\n" + e.getMessage(), "Fetch failed");
            return null;
        }
    }

    public boolean editAccount(Account account) {
        String query = "UPDATE accounts set fid=?,acn=?,money=?,type=?,status=?,date=? WHERE id=? ";

        if (Objects.isNull(account)) {
            return false;
        }

        try ( PreparedStatement ps = Utils.connection.prepareStatement(query)) {
            ps.setInt(1, account.getFid());
            ps.setString(2, account.getAcn());
            ps.setString(3, account.getMoney());
            ps.setShort(4, account.getType());
            ps.setShort(5, account.getStatus());
            ps.setString(6, account.getDate());

            ps.setInt(7, account.getId());
            ps.executeUpdate();     //executeUpdate returns 0 value if true
            return true;
        } catch (Exception e) {
            Utils.swingUI.showErrorDialog("Failed to update account.\n" + e.getMessage(), "Account update failed");
            return false;
        }
    }

    public synchronized boolean depositMoney(Account account, double money) {
        account.setMoney(String.valueOf(money));
        return editAccount(account);
    }

    public synchronized boolean withdawMoney(Account account, double money) {
        account.setMoney(String.valueOf(money));
        return editAccount(account);
    }
}
