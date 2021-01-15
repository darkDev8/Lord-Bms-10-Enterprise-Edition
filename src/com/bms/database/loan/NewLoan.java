package com.bms.database.loan;

import com.bms.database.customer.Customer;
import com.bms.database.customer.CustomerRepository;
import com.bms.utility.Utils;
import java.awt.Color;
import java.util.Objects;

public class NewLoan extends javax.swing.JDialog {

    private CustomerRepository customerRepository;
    private LoanRepository loanRepository;
    private Customer customer;

    private int errors;

    public NewLoan(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        Utils.swingUI.setJDialogCenter(this);
        Utils.swingUI.setJDialogCloseESC(this);
        Utils.swingUI.makeJDialogMovable(this);

        Utils.swingUI.setTableNoneEditable(tableCustomers);

        panelTitle.setBackground(Color.decode(Utils.settings.getColorCode()));
        btnRegister.setBackground(Color.decode(Utils.settings.getColorCode()));
        tableCustomers.setSelectionBackground(Color.decode(Utils.settings.getColorCode()));

        customerRepository = new CustomerRepository();
        loanRepository = new LoanRepository();

        loadCustomers();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelTitle = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        panelRegister = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtMoneyAmount = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtEndDate = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtStartDate = new javax.swing.JFormattedTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtComment = new javax.swing.JTextArea();
        btnCancel = new javax.swing.JButton();
        btnRegister = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableCustomers = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add new loan");

        panelTitle.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Add new loan");

        javax.swing.GroupLayout panelTitleLayout = new javax.swing.GroupLayout(panelTitle);
        panelTitle.setLayout(panelTitleLayout);
        panelTitleLayout.setHorizontalGroup(
            panelTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTitleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelTitleLayout.setVerticalGroup(
            panelTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTitleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelRegister.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Register loan", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Money amount");

        txtMoneyAmount.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Start date");

        txtEndDate.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));
        txtEndDate.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("End date");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Comment");

        txtStartDate.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));
        txtStartDate.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txtComment.setColumns(20);
        txtComment.setRows(5);
        jScrollPane2.setViewportView(txtComment);

        btnCancel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnCancel.setText("Cancel");
        btnCancel.setFocusPainted(false);
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnRegister.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnRegister.setForeground(new java.awt.Color(255, 255, 255));
        btnRegister.setText("Register");
        btnRegister.setFocusPainted(false);
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });

        btnClear.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnClear.setText("Clear");
        btnClear.setFocusPainted(false);
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRegisterLayout = new javax.swing.GroupLayout(panelRegister);
        panelRegister.setLayout(panelRegisterLayout);
        panelRegisterLayout.setHorizontalGroup(
            panelRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRegisterLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtEndDate, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtMoneyAmount)
                    .addComponent(txtStartDate)
                    .addComponent(jScrollPane2)
                    .addGroup(panelRegisterLayout.createSequentialGroup()
                        .addGroup(panelRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelRegisterLayout.createSequentialGroup()
                        .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRegister)))
                .addContainerGap())
        );
        panelRegisterLayout.setVerticalGroup(
            panelRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRegisterLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMoneyAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(panelRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnClear)
                    .addComponent(btnRegister)
                    .addComponent(btnCancel))
                .addContainerGap())
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
        tableCustomers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableCustomersMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableCustomers);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelRegister, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(panelRegister, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        Utils.swingUI.clearComponents(panelRegister, "field", true);
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        if (!Objects.isNull(customer)) {
            if (txtMoneyAmount.getText().isEmpty()) {
                txtMoneyAmount.setForeground(Color.decode(Utils.settings.getColorCode()));
                txtMoneyAmount.setText("Moeny required");
                errors += 1;
            } else {
                txtMoneyAmount.setForeground(Color.BLACK);
            }

            if (txtStartDate.getText().isEmpty()) {
                txtStartDate.setForeground(Color.decode(Utils.settings.getColorCode()));
                txtStartDate.setText("Date required");
                errors += 1;
            } else {
                txtStartDate.setForeground(Color.BLACK);
            }

            if (txtEndDate.getText().isEmpty()) {
                txtEndDate.setForeground(Color.decode(Utils.settings.getColorCode()));
                txtEndDate.setText("Date required");
                errors += 1;
            } else {
                txtEndDate.setForeground(Color.BLACK);
            }

            if (errors == 0) {
                Loan loan = new Loan();

                int month = 100 / Integer.parseInt(Utils.settings.getPayment()), money = Integer.parseInt(txtMoneyAmount.getText());
                int payment = money / month;

                loan.setFid(customer.getId());
                loan.setAmount(txtMoneyAmount.getText());
                loan.setPayment(String.valueOf(payment));
                loan.setStartDate(txtStartDate.getText());
                loan.setEndDate(txtEndDate.getText());
                loan.setComment(txtComment.getText());

                if (loanRepository.addLoan(loan)) {
                    Utils.envs.put("tableUpdate", "5");

                    Utils.swingUI.showInformationDialog("The new loan added to the database successfully.",
                            "Loan added successfully.");

                    if (Utils.settings.getCloseRegister().equals("true")) {
                        this.dispose();
                    } else {
                        btnClearActionPerformed(evt);
                        customer = null;
                        tableCustomers.clearSelection();
                    }
                }
            } else {
                errors = 0;
            }
        } else {
            Utils.swingUI.showConfirmDialog("Please first select a customer.", "No customer selected", new Object[]{"Ok"});
        }
    }//GEN-LAST:event_btnRegisterActionPerformed

    private void tableCustomersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableCustomersMouseClicked
        customer = customerRepository.getCustomer("id", tableCustomers.getValueAt(tableCustomers.getSelectedRow(), 0).toString());
    }//GEN-LAST:event_tableCustomersMouseClicked

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
            java.util.logging.Logger.getLogger(NewLoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewLoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewLoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewLoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                NewLoan dialog = new NewLoan(new javax.swing.JFrame(), true);
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
        customerRepository.loadCustomers(tableCustomers, new String[]{"id", "name", "ncode", "date"});
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnRegister;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel panelRegister;
    private javax.swing.JPanel panelTitle;
    private javax.swing.JTable tableCustomers;
    private javax.swing.JTextArea txtComment;
    private javax.swing.JFormattedTextField txtEndDate;
    private javax.swing.JTextField txtMoneyAmount;
    private javax.swing.JFormattedTextField txtStartDate;
    // End of variables declaration//GEN-END:variables
}
