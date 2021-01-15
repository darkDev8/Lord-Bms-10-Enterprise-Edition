package com.bms.dialogs;

import com.bms.database.customer.CustomerRepository;
import com.bms.database.customerlog.CustomerLog;
import com.bms.database.customerlog.CustomerLogRepository;
import com.bms.database.employee.EmployeeRepository;
import com.bms.utility.Utils;
import static com.bms.utility.Utils.envs;
import com.sdk.security.Security;
import java.awt.Color;
import java.awt.print.PrinterException;
import java.util.Objects;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;

public class ShowUsers extends javax.swing.JDialog {

    private CustomerRepository customerRepository;
    private EmployeeRepository employeeRepository;

    private JTableHeader th;

    public ShowUsers(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        Utils.swingUI.setJDialogCenter(this);
        Utils.swingUI.setJDialogCloseESC(this);
        Utils.swingUI.makeJDialogMovable(this);

        panelTitle.setBackground(Color.decode(Utils.settings.getColorCode()));
        btnClose.setBackground(Color.decode(Utils.settings.getColorCode()));
        tableUsers.setSelectionBackground(Color.decode(Utils.settings.getColorCode()));

        customerRepository = new CustomerRepository();
        employeeRepository = new EmployeeRepository();
        th = tableUsers.getTableHeader();

        comboBoxLoad();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelTitle = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        cmbSelectTable = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableUsers = new javax.swing.JTable();
        btnPrint = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        lblCount = new javax.swing.JLabel();
        btnRefresh = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Manage users");
        setResizable(false);

        panelTitle.setBackground(new java.awt.Color(0, 0, 0));

        lblTitle.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setText("Customers users");

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

        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSearchKeyPressed(evt);
            }
        });

        cmbSelectTable.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Customers", "Employees" }));
        cmbSelectTable.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbSelectTableItemStateChanged(evt);
            }
        });

        tableUsers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tableUsers.setSelectionBackground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(tableUsers);

        btnPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/bms/images/Print.png"))); // NOI18N
        btnPrint.setFocusPainted(false);
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });

        btnClose.setBackground(new java.awt.Color(159, 31, 84));
        btnClose.setForeground(new java.awt.Color(254, 254, 254));
        btnClose.setText("Close");
        btnClose.setFocusPainted(false);
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        lblCount.setFont(new java.awt.Font("Open Sans", 1, 12)); // NOI18N
        lblCount.setText("Number of users : 0");

        btnRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/bms/images/Refresh.png"))); // NOI18N
        btnRefresh.setFocusPainted(false);
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 732, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblCount)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnClose))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtSearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbSelectTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRefresh)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPrint)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPrint, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbSelectTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btnRefresh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnClose)
                    .addComponent(lblCount))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        new AskDialog(null, true, "pass", "").setVisible(true);
        if (!Objects.isNull(Utils.publicAskItem)) {
            if (Utils.publicAskItem.equals("ok")) {
                try {
                    encryptUsers();
                    String title = null;

                    if (cmbSelectTable.getSelectedIndex() == 0) {
                        title = "Customers";
                    } else {
                        title = "Employees";
                    }

                    Utils.swingUI.printTable(tableUsers, title, "Page{0,number,integer}");
                } catch (PrinterException e) {
                    Utils.swingUI.showErrorDialog("Unable to print the table.\n" + e.getMessage(), "Print failed");
                } finally {
                    decryptUsers();
                }
            }
        }
    }//GEN-LAST:event_btnPrintActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void cmbSelectTableItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbSelectTableItemStateChanged
        comboBoxLoad();
    }//GEN-LAST:event_cmbSelectTableItemStateChanged

    private void txtSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyPressed
        DefaultTableModel Model = (DefaultTableModel) tableUsers.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(Model);
        tableUsers.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(txtSearch.getText().trim()));
    }//GEN-LAST:event_txtSearchKeyPressed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        tableUsers.setRowSorter(null);
        comboBoxLoad();
    }//GEN-LAST:event_btnRefreshActionPerformed

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
            java.util.logging.Logger.getLogger(ShowUsers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ShowUsers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ShowUsers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ShowUsers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ShowUsers dialog = new ShowUsers(new javax.swing.JFrame(), true);
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

    private void loadCustomersUsers() {
        lblTitle.setText("Customers users");
        customerRepository.loadCustomers(tableUsers, new String[]{"id", "user", "pass", "date"});
        decryptUsers();
        lblCount.setText("Number of users : " + customerRepository.count());

        TableColumnModel tcm = th.getColumnModel();

        for (int i = 0; i < Utils.USERS_COLUMNS.length; i++) {
            TableColumn tc = tcm.getColumn(i);
            tc.setHeaderValue(Utils.USERS_COLUMNS[i]);
            th.repaint();
        }
    }

    private void loadEmployeesUsers() {
        lblTitle.setText("Employees users");
        employeeRepository.loadEmployees(tableUsers, new String[]{"id", "user", "pass", "date"});
        decryptUsers();
        lblCount.setText("Number of users : " + employeeRepository.count());

        TableColumnModel tcm = th.getColumnModel();

        for (int i = 0; i < Utils.USERS_COLUMNS.length; i++) {
            TableColumn tc = tcm.getColumn(i);
            tc.setHeaderValue(Utils.USERS_COLUMNS[i]);
            th.repaint();
        }
    }

    private void encryptUsers() {
        try {
            for (int i = 0; i < Utils.swingUI.countTableRows(tableUsers); i++) {
                for (int j = 1; j < 3; j++) {
                    tableUsers.setValueAt(Security.encrypt(Utils.envs.get("encKey"), tableUsers.getValueAt(i, j).toString()),
                            i, j);
                }
            }
        } catch (Exception e) {
            this.dispose();
        }
    }

    private void decryptUsers() {
        try {
            for (int i = 0; i < Utils.swingUI.countTableRows(tableUsers); i++) {
                for (int j = 1; j < 3; j++) {
                    tableUsers.setValueAt(Security.decrypt(Utils.envs.get("encKey"), tableUsers.getValueAt(i, j).toString()),
                            i, j);
                }
            }
        } catch (Exception e) {
            this.dispose();
        }
    }

    private void comboBoxLoad() {
        if (cmbSelectTable.getSelectedIndex() == 0) {
            loadCustomersUsers();
        } else {
            loadEmployeesUsers();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JComboBox<String> cmbSelectTable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCount;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel panelTitle;
    private javax.swing.JTable tableUsers;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
