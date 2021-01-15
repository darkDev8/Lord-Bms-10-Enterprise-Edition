package com.bms.database.account;

import com.bms.utility.Utils;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Objects;
import javax.swing.RowFilter;
import javax.swing.Timer;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class EditAccount extends javax.swing.JDialog {

    private AccountRepository accountRepository;
    private Account account;

    public EditAccount(java.awt.Frame parent, boolean modal, Account account) {
        super(parent, modal);
        initComponents();

        Utils.swingUI.setJDialogCenter(this);
        Utils.swingUI.setJDialogCloseESC(this);
        Utils.swingUI.makeJDialogMovable(this);

        Utils.swingUI.setTableNoneEditable(tableAccounts);
        Utils.swingUI.setJTextFieldLimit(txtDeWiMoney, 15);
        Utils.swingUI.setJTextFieldInputType(txtDeWiMoney, "number");
        
        panelTitle.setBackground(Color.decode(Utils.settings.getColorCode()));
        btnEditAccount.setBackground(Color.decode(Utils.settings.getColorCode()));
        btnDeWi.setBackground(Color.decode(Utils.settings.getColorCode()));
        btnTransfer.setBackground(Color.decode(Utils.settings.getColorCode()));
        tableAccounts.setSelectionBackground(Color.decode(Utils.settings.getColorCode()));

        if (Objects.isNull(account)) {
            Utils.swingUI.showErrorDialog("The account object instance is null.", "NullpointerException");
            this.dispose();
        } else {
            accountRepository = new AccountRepository();
            loadAccounts();

            this.account = accountRepository.getAccount("acn", account.getAcn());
            loadAccountInfo();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        panelTitle = new javax.swing.JPanel();
        lblTitleName = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cmbType = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cmbStatus = new javax.swing.JComboBox<>();
        btnEditAccount = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableAccounts = new javax.swing.JTable();
        txtSearch = new javax.swing.JTextField();
        btnRefresh = new javax.swing.JButton();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel7 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtDeWiMoney = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        radioDeposit = new javax.swing.JRadioButton();
        radioWithdraw = new javax.swing.JRadioButton();
        btnDeWi = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtDestinationAccount = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtTransferMoney = new javax.swing.JTextField();
        btnTransfer = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Edit account");

        panelTitle.setBackground(new java.awt.Color(0, 0, 0));

        lblTitleName.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblTitleName.setForeground(new java.awt.Color(255, 255, 255));
        lblTitleName.setText("Account number");

        javax.swing.GroupLayout panelTitleLayout = new javax.swing.GroupLayout(panelTitle);
        panelTitle.setLayout(panelTitleLayout);
        panelTitleLayout.setHorizontalGroup(
            panelTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTitleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitleName)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelTitleLayout.setVerticalGroup(
            panelTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTitleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitleName)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setText("Type");

        cmbType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setText("Status");

        cmbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Open", "Close" }));

        btnEditAccount.setBackground(new java.awt.Color(0, 0, 0));
        btnEditAccount.setForeground(new java.awt.Color(254, 254, 254));
        btnEditAccount.setText("Update");
        btnEditAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditAccountActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(cmbStatus, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbType, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEditAccount)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditAccount)
                .addContainerGap())
        );

        tableAccounts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tableAccounts.setSelectionBackground(new java.awt.Color(0, 0, 0));
        tableAccounts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableAccountsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableAccounts);

        txtSearch.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSearchKeyPressed(evt);
            }
        });

        btnRefresh.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnRefresh.setText("Refresh");
        btnRefresh.setFocusPainted(false);
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        jTabbedPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setText("Money");

        txtDeWiMoney.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDeWiMoneyKeyPressed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Operation"));

        buttonGroup1.add(radioDeposit);
        radioDeposit.setSelected(true);
        radioDeposit.setText("Deposit");

        buttonGroup1.add(radioWithdraw);
        radioWithdraw.setText("Withdaw");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(radioDeposit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(radioWithdraw, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(radioDeposit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(radioWithdraw)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnDeWi.setBackground(new java.awt.Color(0, 0, 0));
        btnDeWi.setForeground(new java.awt.Color(254, 254, 254));
        btnDeWi.setText("Apply");
        btnDeWi.setFocusPainted(false);
        btnDeWi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeWiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDeWiMoney)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnDeWi)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDeWiMoney, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(btnDeWi)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Deposit and withdraw", jPanel7);

        jLabel5.setText("Destination account number");

        jLabel6.setText("Money");

        btnTransfer.setBackground(new java.awt.Color(0, 0, 0));
        btnTransfer.setForeground(new java.awt.Color(254, 254, 254));
        btnTransfer.setText("Transfer");
        btnTransfer.setFocusPainted(false);
        btnTransfer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTransferActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDestinationAccount)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(0, 207, Short.MAX_VALUE))
                    .addComponent(txtTransferMoney)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnTransfer)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDestinationAccount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTransferMoney, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(btnTransfer)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Transfer money", jPanel8);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTabbedPane2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtSearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRefresh)
                        .addGap(8, 8, 8))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRefresh))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyPressed
        DefaultTableModel Model = (DefaultTableModel) tableAccounts.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(Model);
        tableAccounts.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(txtSearch.getText().trim()));
    }//GEN-LAST:event_txtSearchKeyPressed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        tableAccounts.setRowSorter(null);
        loadAccounts();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnEditAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditAccountActionPerformed
        if (Objects.isNull(account)) {
            Utils.swingUI.showConfirmDialog("Please select an account first", "No account selected", new Object[]{"Ok"});
        } else {
            account.setType((short) cmbType.getSelectedIndex());
            account.setStatus((short) cmbStatus.getSelectedIndex());

            if (accountRepository.editAccount(account)) {
                account = null;
                tableAccounts.clearSelection();

                Utils.swingUI.showInformationDialog("The account information in database updated successfully.",
                        "Account updated successfully.");

                Utils.envs.put("tableUpdate", "2");
            }
        }
    }//GEN-LAST:event_btnEditAccountActionPerformed

    private void tableAccountsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableAccountsMouseClicked
        if (tableAccounts.getSelectedRow() != -1) {
            if (evt.getClickCount() == 1) {
                this.account = accountRepository.getAccount("id",
                        tableAccounts.getValueAt(tableAccounts.getSelectedRow(), 0).toString());

                loadAccountInfo();
            }
        }
    }//GEN-LAST:event_tableAccountsMouseClicked

    private void btnDeWiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeWiActionPerformed
        withdrawDepositProcess();
    }//GEN-LAST:event_btnDeWiActionPerformed

    private void txtDeWiMoneyKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDeWiMoneyKeyPressed
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            withdrawDepositProcess();
        }
    }//GEN-LAST:event_txtDeWiMoneyKeyPressed

    private void btnTransferActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransferActionPerformed
        if (Objects.isNull(account)) {
            Utils.swingUI.showConfirmDialog("Please select an account first", "No account selected", new Object[]{"Ok"});
        } else {
            if (txtDestinationAccount.getText().isEmpty() || txtTransferMoney.getText().isEmpty()) {
                Utils.swingUI.showConfirmDialog("Please fill all information to begin transfer.", "Invalid information",
                        new Object[]{"Ok"});
            } else {
                if (cmbStatus.getSelectedIndex() == 1) {
                    showCloseAccountDialog(account, "The account status is closed.\n +"
                            + "No money operation is allowed, open the account to continue");
                } else {
                    if (accountRepository.exist("acn", txtDestinationAccount.getText(), "") == 1) {
                        Account destAccount = accountRepository.getAccount("acn", txtDestinationAccount.getText());

                        double transferMoney = Double.parseDouble(txtTransferMoney.getText()),
                                sourceAccountMoney = Double.parseDouble(account.getMoney()),
                                destAccountMoney = Double.parseDouble(destAccount.getMoney());

                        if ((sourceAccountMoney - transferMoney) < 10000) {
                            Utils.swingUI.showErrorDialog("There is not enough money in you're account to withdraw.",
                                    "No money");
                        } else {
                            if (destAccount.getStatus() == 1) {
                                showCloseAccountDialog(destAccount, "The destination account status is closed.\n +"
                                        + "No money operation is allowed, open the account to continue");
                            } else {
                                if (accountRepository.withdawMoney(account, sourceAccountMoney - transferMoney)) {
                                    if (accountRepository.depositMoney(destAccount, destAccountMoney + transferMoney)) {
                                        loadAccountInfo();
                                        loadAccounts();
                                        Utils.swingUI.showInformationDialog("The operation completed successfully.", "Operation successful");
                                        this.account = null;
                                    } else {
                                        accountRepository.depositMoney(account, sourceAccountMoney + transferMoney);
                                    }
                                } else {
                                    Utils.swingUI.showErrorDialog("Unable to transfer money/\n"
                                            + "Please contact application administrator", "Transfer failed");
                                }
                            }
                        }
                    } else {
                        Utils.swingUI.showErrorDialog("There is no account with \"" + txtDestinationAccount.getText()
                                + "\" account number.", "No account");
                    }
                }
            }
        }

    }//GEN-LAST:event_btnTransferActionPerformed

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
            java.util.logging.Logger.getLogger(EditAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                EditAccount dialog = new EditAccount(new javax.swing.JFrame(), true, new Account());
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

    private void loadAccounts() {
        accountRepository.loadAccounts(tableAccounts, new String[]{"id", "acn", "money"});
    }

    private void loadAccountInfo() {
        lblTitleName.setText("Account number (" + account.getAcn() + ")");

        cmbType.setSelectedIndex(account.getType());
        cmbStatus.setSelectedIndex(account.getStatus());
    }

    private void withdrawDepositProcess() {
        if (Objects.isNull(account)) {
            Utils.swingUI.showConfirmDialog("Please select an account first", "No account selected", new Object[]{"Ok"});
        } else {
            if (txtDeWiMoney.getText().isEmpty()) {
                Utils.swingUI.showConfirmDialog("Please enter money amount first.", "No money amount", new Object[]{"Ok"});
            } else {
                if (cmbStatus.getSelectedIndex() == 1) {
                    showCloseAccountDialog(account, "The account status is closed.\n +"
                            + "No money operation is allowed, open the account to continue");
                } else {
                    double acnMoney = Double.parseDouble(account.getMoney()),
                            newMoney = Double.parseDouble(txtDeWiMoney.getText());

                    if (newMoney == 0) {
                        Utils.swingUI.showConfirmDialog("The money amount is invalid.", "Money amount invalid",
                                new Object[]{"Ok"});
                    } else {
                        if (radioDeposit.isSelected()) {
                            if (accountRepository.depositMoney(account, acnMoney + newMoney)) {
                                loadAccountInfo();
                                loadAccounts();
                                Utils.swingUI.showInformationDialog("The operation completed successfully.", "Operation successful");
                                this.account = null;
                            }
                        } else {
                            if ((acnMoney - newMoney) < 10000) {
                                Utils.swingUI.showErrorDialog("There is not enough money in you're account to withdraw.", "No money");
                            } else {
                                if (accountRepository.withdawMoney(account, acnMoney - newMoney)) {
                                    loadAccountInfo();
                                    loadAccounts();
                                    Utils.swingUI.showInformationDialog("The operation completed successfully.", "Operation successful");
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private void showCloseAccountDialog(Account account, String message) {
        if (Utils.swingUI.showConfirmDialog(message, "Account closed", new Object[]{"Open account", "Ok"})) {
            account.setStatus((short) 0);
            accountRepository.editAccount(account);
            loadAccountInfo();
            loadAccounts();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeWi;
    private javax.swing.JButton btnEditAccount;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnTransfer;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cmbStatus;
    private javax.swing.JComboBox<String> cmbType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JLabel lblTitleName;
    private javax.swing.JPanel panelTitle;
    private javax.swing.JRadioButton radioDeposit;
    private javax.swing.JRadioButton radioWithdraw;
    private javax.swing.JTable tableAccounts;
    private javax.swing.JTextField txtDeWiMoney;
    private javax.swing.JTextField txtDestinationAccount;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTransferMoney;
    // End of variables declaration//GEN-END:variables
}
