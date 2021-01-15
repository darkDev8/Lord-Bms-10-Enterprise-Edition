package com.bms.database.customer;

import com.bms.database.account.Account;
import com.bms.database.account.AccountRepository;
import com.bms.utility.Utils;
import static com.bms.utility.Utils.envs;
import com.sdk.security.Security;
import java.awt.Color;
import java.util.Objects;

public class EditCustomer extends javax.swing.JDialog {

    private CustomerRepository customerRepository;
    private AccountRepository accountRepository;
    private Customer customer;

    private int errors;

    public EditCustomer(java.awt.Frame parent, boolean modal, Customer customer) {
        super(parent, modal);
        initComponents();

        Utils.swingUI.setJDialogCenter(this);
        Utils.swingUI.setJDialogCloseESC(this);
        Utils.swingUI.makeJDialogMovable(this);

        Utils.swingUI.setJTextFieldInputType(txtMobile, "number");
        Utils.swingUI.setJTextFieldInputType(txtNcode, "number");

        Utils.swingUI.setJTextFieldLimit(txtName, 100);
        Utils.swingUI.setJTextFieldLimit(txtMobile, 11);
        Utils.swingUI.setJTextFieldLimit(txtEmail, 100);
        Utils.swingUI.setJTextFieldLimit(txtAddress, 150);
        Utils.swingUI.setJTextFieldLimit(txtPasswordHint, 20);
        Utils.swingUI.setJTextFieldLimit(txtNcode, 10);

        panelTitle.setBackground(Color.decode(Utils.settings.getColorCode()));
        btnUpdate.setBackground(Color.decode(Utils.settings.getColorCode()));

        this.customer = customer;
        customerRepository = new CustomerRepository();
        accountRepository = new AccountRepository();

        if (Objects.isNull(customer)) {
            Utils.swingUI.showErrorDialog("The customer object instance is null.", "NullpointerException");
            this.dispose();
        } else {
            if (this.customer.getName().length() > 44) {
                lblTitleName.setText(this.customer.getName().substring(0, 40) + "...");
            } else {
                lblTitleName.setText(this.customer.getName());

                txtName.setText(this.customer.getName());
                txtMobile.setText(this.customer.getMobile());
                txtNcode.setText(this.customer.getNcode());

                this.customer = customerRepository.getCustomer("ncode", this.customer.getNcode());
                txtEmail.setText(this.customer.getEmail());
                txtAddress.setText(this.customer.getAddress());
                txtPasswordHint.setText(this.customer.getHint());

                Account[] accounts = accountRepository.loadCustomerAccounts("fid", String.valueOf(this.customer.getId()));
                String[] acns = new String[accounts.length];

                for (int i = 0; i < accounts.length; i++) {
                    acns[i] = accounts[i].getAcn();
                }

                for (Account account : accounts) {
                    Utils.swingUI.addToJList(listAccounts, acns);
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtMobile = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtNcode = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtPasswordHint = new javax.swing.JTextField();
        btnCancel = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        panelTitle = new javax.swing.JPanel();
        lblTitleName = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listAccounts = new javax.swing.JList<>();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Edit customer");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Customer information"));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Name");

        txtName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Mobile");

        txtMobile.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Email");

        txtEmail.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("National code");

        txtNcode.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Address");

        txtAddress.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Password hint");

        btnCancel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnCancel.setText("Cancel");
        btnCancel.setFocusPainted(false);
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnUpdate.setBackground(new java.awt.Color(159, 31, 84));
        btnUpdate.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(254, 254, 254));
        btnUpdate.setText("Update");
        btnUpdate.setFocusPainted(false);
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtName)
                    .addComponent(txtMobile)
                    .addComponent(txtEmail)
                    .addComponent(txtNcode)
                    .addComponent(txtAddress)
                    .addComponent(txtPasswordHint)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 206, Short.MAX_VALUE)
                        .addComponent(btnCancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUpdate)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMobile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPasswordHint, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(56, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnUpdate)
                            .addComponent(btnCancel))
                        .addContainerGap())))
        );

        panelTitle.setBackground(new java.awt.Color(159, 31, 84));

        lblTitleName.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblTitleName.setForeground(new java.awt.Color(255, 255, 255));
        lblTitleName.setText("Name");

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

        listAccounts.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        listAccounts.setSelectionBackground(new java.awt.Color(159, 31, 84));
        jScrollPane1.setViewportView(listAccounts);

        jLabel7.setText("Accounts");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        if (txtName.getText().isEmpty()) {
            txtName.setForeground(Color.RED);
            txtName.setText("Name required");
            errors += 1;
        } else {
            txtName.setForeground(Color.BLACK);
        }

        if (txtMobile.getText().length() != 11 || !txtMobile.getText().startsWith("09")) {
            txtMobile.setForeground(Color.RED);
            txtMobile.setText("Mobile number is invalid");
            errors += 1;
        } else {
            txtMobile.setForeground(Color.BLACK);
        }

        if (txtEmail.getText().isEmpty()) {
            txtEmail.setForeground(Color.RED);
            txtEmail.setText("Email address required");
            errors += 1;
        } else {
            txtEmail.setForeground(Color.BLACK);
        }

        if (txtAddress.getText().isEmpty()) {
            txtAddress.setForeground(Color.RED);
            txtAddress.setText("Address required");
            errors += 1;
        } else {
            txtAddress.setForeground(Color.BLACK);
        }

        if (txtNcode.getText().length() != 10) {
            txtNcode.setForeground(Color.RED);
            txtNcode.setText("National code is invalid");
            errors += 1;
        } else {
            txtNcode.setForeground(Color.BLACK);
        }

        if (txtPasswordHint.getText().isEmpty()) {
            txtPasswordHint.setForeground(Color.RED);
            txtPasswordHint.setText("Password hint required");
            errors += 1;
        } else {
            txtPasswordHint.setForeground(Color.BLACK);
        }

        if (errors == 0) {
            customer.setName(txtName.getText());
            customer.setMobile(txtMobile.getText());
            customer.setEmail(txtEmail.getText());
            customer.setAddress(txtAddress.getText());
            customer.setNcode(txtNcode.getText());
            customer.setHint(txtPasswordHint.getText());

            try {
                customer.setUser(Security.encrypt(Utils.envs.get("encKey"), txtNcode.getText()));
            } catch (Exception e) {
                Utils.swingUI.showErrorDialog("Unable to encrypt username with the key.", "Encrypt username failed.");
                this.dispose();
            }

            if (customerRepository.editCustomer(customer)) {
                Utils.envs.put("tableUpdate", "1");

                Utils.swingUI.showInformationDialog("The customer information in database updated successfully.",
                        "Customer updated successfully.");
            }
        } else {
            errors = 0;
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

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
            java.util.logging.Logger.getLogger(EditCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                EditCustomer dialog = new EditCustomer(new javax.swing.JFrame(), true, new Customer());
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitleName;
    private javax.swing.JList<String> listAccounts;
    private javax.swing.JPanel panelTitle;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtMobile;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtNcode;
    private javax.swing.JTextField txtPasswordHint;
    // End of variables declaration//GEN-END:variables
}
