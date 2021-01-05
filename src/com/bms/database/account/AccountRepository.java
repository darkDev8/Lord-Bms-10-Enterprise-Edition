package com.bms.database.account;

import com.bms.database.employee.Employee;
import com.bms.utility.Utils;
import com.sdk.database.DBRepository;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;
import javax.swing.JTable;

public class AccountRepository {

    public void loadAccounts(JTable table) {
        try {
            Utils.dBRepository.fillJTable("accounts", new String[]{"id", "fid", "acn", "money", "type"}, table);
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

    public int accountExist(String acn) {
        try {
            if (Utils.dBRepository.isTableContains("accounts", "acn", acn, "")) {
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

        try (PreparedStatement pstmt = Utils.connection.prepareStatement(sql)) {
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
}
