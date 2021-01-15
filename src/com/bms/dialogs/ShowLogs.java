package com.bms.dialogs;

import com.bms.database.customerlog.CustomerLogRepository;
import com.bms.database.employeelog.EmployeeLogRepository;
import com.bms.utility.Utils;
import java.awt.Color;
import java.awt.print.PrinterException;
import java.util.Objects;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class ShowLogs extends javax.swing.JDialog {

    private CustomerLogRepository customerLogRepository;
    private EmployeeLogRepository employeeLogRepository;

    private JTableHeader th;

    public ShowLogs(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        Utils.swingUI.setJDialogCenter(this);
        Utils.swingUI.setJDialogCloseESC(this);
        Utils.swingUI.makeJDialogMovable(this);
        
        panelTitle.setBackground(Color.decode(Utils.settings.getColorCode()));
        btnClose.setBackground(Color.decode(Utils.settings.getColorCode()));
        tableLogs.setSelectionBackground(Color.decode(Utils.settings.getColorCode()));

        customerLogRepository = new CustomerLogRepository();
        employeeLogRepository = new EmployeeLogRepository();
        th = tableLogs.getTableHeader();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelTitle = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        txtSearach = new javax.swing.JTextField();
        cmbSelectTable = new javax.swing.JComboBox<>();
        btnRefresh = new javax.swing.JButton();
        btnPrint = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableLogs = new javax.swing.JTable();
        btnDeleteAllLogs = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        lblCount = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Show logs");

        panelTitle.setBackground(new java.awt.Color(0, 0, 0));

        lblTitle.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setText("Customer logs");

        javax.swing.GroupLayout panelTitleLayout = new javax.swing.GroupLayout(panelTitle);
        panelTitle.setLayout(panelTitleLayout);
        panelTitleLayout.setHorizontalGroup(
            panelTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTitleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelTitleLayout.setVerticalGroup(
            panelTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTitleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtSearach.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        cmbSelectTable.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cmbSelectTable.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Customers", "Employees" }));
        cmbSelectTable.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbSelectTableItemStateChanged(evt);
            }
        });

        btnRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/bms/images/Refresh.png"))); // NOI18N
        btnRefresh.setFocusPainted(false);
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        btnPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/bms/images/Print.png"))); // NOI18N
        btnPrint.setFocusPainted(false);
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });

        tableLogs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tableLogs.setSelectionBackground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(tableLogs);

        btnDeleteAllLogs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/bms/images/Delete.png"))); // NOI18N
        btnDeleteAllLogs.setFocusPainted(false);
        btnDeleteAllLogs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteAllLogsActionPerformed(evt);
            }
        });

        btnClose.setBackground(new java.awt.Color(0, 0, 0));
        btnClose.setForeground(new java.awt.Color(254, 254, 254));
        btnClose.setText("Close");
        btnClose.setFocusPainted(false);
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        lblCount.setFont(new java.awt.Font("Open Sans", 1, 12)); // NOI18N
        lblCount.setText("Number of logs : 0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 681, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtSearach)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbSelectTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDeleteAllLogs)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRefresh)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPrint))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblCount)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnClose)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnDeleteAllLogs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtSearach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmbSelectTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnPrint, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRefresh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnClose)
                    .addComponent(lblCount))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        if (cmbSelectTable.getSelectedIndex() == 0) {
            loadCustomersLogs();
        } else {
            loadEmployeesLogs();
        }
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        new AskDialog(null, true, "pass", "").setVisible(true);
        if (!Objects.isNull(Utils.publicAskItem)) {
            if (Utils.publicAskItem.equals("ok")) {
                try {
                    String title = null;

                    if (cmbSelectTable.getSelectedIndex() == 0) {
                        title = "Customers logs";
                    } else {
                        title = "Employees logs";
                    }

                    Utils.swingUI.printTable(tableLogs, title, "Page{0,number,integer}");
                } catch (PrinterException e) {
                    Utils.swingUI.showErrorDialog("Unable to print the table.\n" + e.getMessage(), "Print failed");
                }
            }
        }
    }//GEN-LAST:event_btnPrintActionPerformed

    private void btnDeleteAllLogsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteAllLogsActionPerformed
        if (Utils.swingUI.showConfirmDialog("Are you sure you want to delete all the logs", "Delete all logs",
                new Object[]{"Yes, delete all", "Cancel"})) {
            new AskDialog(null, true, "pass", "").setVisible(true);

            if (!Objects.isNull(Utils.publicAskItem)) {
                if (Utils.publicAskItem.equals("ok")) {
                    if (cmbSelectTable.getSelectedIndex() == 0) {
                        if (customerLogRepository.deleteAllLogs()) {
                            loadCustomersLogs();
                            Utils.swingUI.showInformationDialog("All the customer logs deleted successfully.",
                                    "Customer logs deleted");
                        }
                    } else {
                        if (employeeLogRepository.deleteAllLogs()) {
                            loadEmployeesLogs();
                            Utils.swingUI.showInformationDialog("All the employee logs deleted successfully.",
                                    "Employee logs deleted");
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_btnDeleteAllLogsActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void cmbSelectTableItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbSelectTableItemStateChanged
        if (cmbSelectTable.getSelectedIndex() == 0) {
            loadCustomersLogs();
        } else {
            loadEmployeesLogs();
        }
    }//GEN-LAST:event_cmbSelectTableItemStateChanged

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ShowLogs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ShowLogs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ShowLogs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ShowLogs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ShowLogs dialog = new ShowLogs(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    private void loadCustomersLogs() {
        customerLogRepository.loadCustomerLogs(tableLogs, new String[]{"id", "fid", "enterdate", "exitdate"});
        lblTitle.setText("Customer logs");

        TableColumnModel tcm = th.getColumnModel();

        for (int i = 0; i < Utils.LOGS_COLUMNS.length; i++) {
            TableColumn tc = tcm.getColumn(i);
            tc.setHeaderValue(Utils.LOGS_COLUMNS[i]);
            th.repaint();
        }
    }

    private void loadEmployeesLogs() {
        employeeLogRepository.loadEmployeeLogs(tableLogs, new String[]{"id", "fid", "enterdate", "exitdate"});
        lblTitle.setText("Employee logs");

        TableColumnModel tcm = th.getColumnModel();

        for (int i = 0; i < Utils.LOGS_COLUMNS.length; i++) {
            TableColumn tc = tcm.getColumn(i);
            tc.setHeaderValue(Utils.LOGS_COLUMNS[i]);
            th.repaint();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnDeleteAllLogs;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JComboBox<String> cmbSelectTable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCount;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel panelTitle;
    private javax.swing.JTable tableLogs;
    private javax.swing.JTextField txtSearach;
    // End of variables declaration//GEN-END:variables
}
