package com.bms.database.account;

import com.bms.database.account.Account;
import com.bms.database.account.AccountRepository;
import com.bms.database.customer.CustomerRepository;
import com.bms.root.Boot;
import com.bms.utility.Utils;
import com.sdk.datatypes.Strings;
import java.awt.Color;
import javax.swing.RowFilter;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class NewAccount extends javax.swing.JDialog {

    private AccountRepository accountRepository;
    private CustomerRepository customerRepository;

    private int customerID;
    private int errors;

    private String acn;
    private String date;
    private String ncode;
    private String name;

    public NewAccount(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        Utils.swingUI.setJDialogCenter(this);
        Utils.swingUI.setJDialogCloseESC(this);
        Utils.swingUI.makeJDialogMovable(this);
        Utils.swingUI.setTableNoneEditable(tableCustomers);

        panelTitle.setBackground(Color.decode(Utils.settings.getColorCode()));
        btnRegister.setBackground(Color.decode(Utils.settings.getColorCode()));
        tableCustomers.setSelectionBackground(Color.decode(Utils.settings.getColorCode()));

        accountRepository = new AccountRepository();
        customerRepository = new CustomerRepository();

        loadCustomers();

        tableCustomers.getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {
            customerID = Integer.parseInt(tableCustomers.getValueAt(tableCustomers.getSelectedRow(), 0).toString());
            name = tableCustomers.getValueAt(tableCustomers.getSelectedRow(), 1).toString();
            ncode = tableCustomers.getValueAt(tableCustomers.getSelectedRow(), 2).toString();
        });

        acn = Utils.generateAccountNumber(lblAcn);
        loadDate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelTitle = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableCustomers = new javax.swing.JTable();
        btnRefresh = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtMoeny = new javax.swing.JTextField();
        chkDefaultMoney = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        cmbType = new javax.swing.JComboBox<>();
        cmbStatus = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        lblAcn = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        btnRegister = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add new account");
        setResizable(false);

        panelTitle.setBackground(new java.awt.Color(0, 0, 0));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Add new account");

        javax.swing.GroupLayout panelTitleLayout = new javax.swing.GroupLayout(panelTitle);
        panelTitle.setLayout(panelTitleLayout);
        panelTitleLayout.setHorizontalGroup(
            panelTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTitleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelTitleLayout.setVerticalGroup(
            panelTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTitleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tableCustomers.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tableCustomers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tableCustomers.setSelectionBackground(new java.awt.Color(0, 0, 0));
        tableCustomers.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tableCustomers.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tableCustomers);

        btnRefresh.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnRefresh.setText("Refresh");
        btnRefresh.setFocusPainted(false);
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        txtSearch.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSearchKeyPressed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Money");

        txtMoeny.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        chkDefaultMoney.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        chkDefaultMoney.setText("Default value");
        chkDefaultMoney.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkDefaultMoneyActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Type");

        cmbType.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cmbType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbStatus.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cmbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Open", "Close" }));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Status");

        lblAcn.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblAcn.setText("Account number");

        lblDate.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblDate.setText("Date");

        btnRegister.setBackground(new java.awt.Color(0, 0, 0));
        btnRegister.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnRegister.setForeground(new java.awt.Color(255, 255, 255));
        btnRegister.setText("Add account");
        btnRegister.setFocusPainted(false);
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });

        btnCancel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnCancel.setText("Cancel");
        btnCancel.setFocusPainted(false);
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(btnCancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRegister))
                    .addComponent(jLabel5)
                    .addComponent(chkDefaultMoney)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbType, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(cmbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(txtMoeny)
                    .addComponent(lblDate, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAcn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMoeny, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkDefaultMoney)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblAcn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegister)
                    .addComponent(btnCancel))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtSearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRefresh))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRefresh))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        tableCustomers.setRowSorter(null);
        loadCustomers();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void txtSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyPressed
        DefaultTableModel Model = (DefaultTableModel) tableCustomers.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(Model);
        tableCustomers.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(txtSearch.getText().trim()));
    }//GEN-LAST:event_txtSearchKeyPressed

    private void chkDefaultMoneyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkDefaultMoneyActionPerformed
        if (chkDefaultMoney.isSelected()) {
            txtMoeny.setText(Utils.settings.getDefaultMoney());
        } else {
            txtMoeny.setText(Utils.strings.getEmptyString());
        }

        txtMoeny.setEnabled(!chkDefaultMoney.isSelected());
    }//GEN-LAST:event_chkDefaultMoneyActionPerformed

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        if (tableCustomers.getSelectedRow() == -1) {
            Utils.swingUI.showConfirmDialog("Please select a customer first", "No customer selected", new Object[]{"Ok"});
        } else {
            if (txtMoeny.getText().isEmpty()) {
                txtMoeny.setForeground(Color.RED);
                txtMoeny.setText("Money amount is required");
                errors += 1;
            } else {
                txtMoeny.setForeground(Color.BLACK);
            }

            if (errors == 0) {
                Account account = new Account();

                account.setFid(customerID);
                account.setAcn(acn);
                account.setMoney(txtMoeny.getText());
                account.setType((short) cmbType.getSelectedIndex());
                account.setStatus((short) cmbStatus.getSelectedIndex());
                account.setDate(date);

                if (Utils.swingUI.showConfirmDialog("Are you sure you want create new account for \""
                        + name + "\" with national code \"" + ncode + "\"?\nThe changes can't be undo.", "Add new account",
                        new Object[]{"Yes", "Cancel"})) {
                    if (accountRepository.addAccount(account)) {
                        Utils.swingUI.showInformationDialog("The new account added successfully.", "Account added");
                        Utils.envs.put("tableUpdate", "2");
                        this.dispose();
                    }
                }
            } else {
                errors = 0;
            }
        }
    }//GEN-LAST:event_btnRegisterActionPerformed

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
            java.util.logging.Logger.getLogger(NewAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                NewAccount dialog = new NewAccount(new javax.swing.JFrame(), true);
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

    private void loadCustomers() {
        customerRepository.loadCustomers(tableCustomers, new String[]{"id", "name", "ncode"});
    }

    private void loadDate() {
        new Boot().loadSystemDate();
        lblDate.setText("Date: " + Utils.envs.get("date"));
        date = Utils.envs.get("date");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnRegister;
    private javax.swing.JCheckBox chkDefaultMoney;
    private javax.swing.JComboBox<String> cmbStatus;
    private javax.swing.JComboBox<String> cmbType;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAcn;
    private javax.swing.JLabel lblDate;
    private javax.swing.JPanel panelTitle;
    private javax.swing.JTable tableCustomers;
    private javax.swing.JTextField txtMoeny;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
