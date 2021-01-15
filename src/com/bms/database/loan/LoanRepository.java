package com.bms.database.loan;

import com.bms.database.customerlog.CustomerLog;
import com.bms.utility.Utils;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;
import javax.swing.JTable;

public class LoanRepository {

    public void loadLoans(JTable table, String[] columns) {
        try {
            Utils.dBRepository.fillJTable("loans", columns, table);
        } catch (SQLException e) {
            Utils.swingUI.showErrorDialog(e.getMessage(), "Loading loans failed.");
        }
    }

    public int count() {
        try {
            return Utils.dBRepository.countRecords("loans");
        } catch (SQLException e) {
            Utils.swingUI.showErrorDialog(e.getMessage(), "Count loans failed.");
            return -1;
        }
    }

    public int exist(String column, String value, String type) {
        try {
            if (Utils.dBRepository.isTableContains("loans", column, value, type)) {
                return 1;
            }

            return 0;
        } catch (SQLException e) {
            Utils.swingUI.showErrorDialog(e.getMessage(), "Checking loans failed.");
            return -1;
        }
    }

    public boolean addLoan(Loan loan) {
        if (Objects.isNull(loan)) {
            return false;
        }

        try (PreparedStatement pstmt
                = Utils.connection.prepareStatement("INSERT INTO loans(fid,amount,payment,startdate,enddate,comment) VALUES(?,?,?,?,?,?)")) {

            pstmt.setInt(1, loan.getFid());
            pstmt.setString(2, loan.getAmount());
            pstmt.setString(3, loan.getPayment());
            pstmt.setString(4, loan.getStartDate());
            pstmt.setString(5, loan.getEndDate());
            pstmt.setString(6, loan.getComment());
            
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            Utils.swingUI.showErrorDialog("Unable to create new loan in the databse.\n" + e.getMessage(),
                    "Loan add failed.");
            return false;
        }
    }
}
