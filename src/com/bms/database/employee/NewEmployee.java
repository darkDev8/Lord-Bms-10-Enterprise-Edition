package com.bms.database.employee;

import com.bms.database.customer.Customer;
import com.bms.database.employee.Employee;
import com.bms.database.employee.EmployeeRepository;
import com.bms.root.Boot;
import com.bms.utility.Utils;
import static com.bms.utility.Utils.envs;
import com.sdk.datatypes.Numbers;
import com.sdk.datatypes.Strings;
import com.sdk.security.Security;
import java.awt.Color;
import java.util.Arrays;
import javax.swing.JTextField;

public class NewEmployee extends javax.swing.JDialog {

    private EmployeeRepository employeeRepository;

    private String ncode;
    private String password;
    private String date;

    private int errors;

    public NewEmployee(java.awt.Frame parent, boolean modal, String ncode) {
        super(parent, modal);
        initComponents();

        employeeRepository = new EmployeeRepository();
        this.ncode = ncode;

        Utils.swingUI.setJDialogCenter(this);
        Utils.swingUI.setJDialogCloseESC(this);
        Utils.swingUI.makeJDialogMovable(this);

        Utils.swingUI.setJTextFieldInputType(txtMobile, "number");

        Utils.swingUI.setJTextFieldLimit(txtName, 100);
        Utils.swingUI.setJTextFieldLimit(txtMobile, 11);
        Utils.swingUI.setJTextFieldLimit(txtPasswordHint, 20);

        panelTitle.setBackground(Color.decode(Utils.settings.getColorCode()));
        btnRegister.setBackground(Color.decode(Utils.settings.getColorCode()));

        loadNationalCode();
        password = Utils.generateEmployeePassword(lblPassword);
        loadDate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        panelTitle = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtMobile = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        txtPasswordHint = new javax.swing.JTextField();
        lblPassword = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        btnRegister = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add new employee");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Name");

        txtName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        panelTitle.setBackground(new java.awt.Color(0, 0, 0));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Add new employee");

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

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Mobile");

        txtMobile.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Password hint");

        lblUsername.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblUsername.setText("Username");

        txtPasswordHint.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lblPassword.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblPassword.setText("Password");

        lblDate.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblDate.setText("Date");

        btnRegister.setBackground(new java.awt.Color(0, 0, 0));
        btnRegister.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnRegister.setForeground(new java.awt.Color(255, 255, 255));
        btnRegister.setText("Register");
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

        btnClear.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnClear.setText("Clear");
        btnClear.setFocusPainted(false);
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(txtMobile, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblUsername)
                            .addComponent(lblPassword)
                            .addComponent(lblDate))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnClear)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRegister))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 375, Short.MAX_VALUE))
                    .addComponent(txtPasswordHint))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMobile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPasswordHint, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblUsername)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPassword)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegister)
                    .addComponent(btnCancel)
                    .addComponent(btnClear))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        Utils.swingUI.clearComponents(this, "field", true);
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
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

        if (txtPasswordHint.getText().isEmpty()) {
            txtPasswordHint.setForeground(Color.RED);
            txtPasswordHint.setText("Password hint required");
            errors += 1;
        } else {
            txtPasswordHint.setForeground(Color.BLACK);
        }

        Employee employee = new Employee();

        if (errors == 0) {
            try {
                employee.setName(txtName.getText());
                employee.setMobile(txtMobile.getText());
                employee.setNcode(ncode);
                employee.setUser(Security.encrypt(Utils.envs.get("encKey"), ncode));
                employee.setPass(Security.encrypt(Utils.envs.get("encKey"), password));
                employee.setHint(txtPasswordHint.getText());
                employee.setDate(date);
            } catch (Exception e) {
                Utils.swingUI.showErrorDialog(e.getMessage(), "Employee values failed.");
            }

            if (employeeRepository.addEmployee(employee)) {
                Utils.envs.put("tableUpdate", "3");

                employee = employeeRepository.getEmployee("name", txtName.getText());
                Utils.swingUI.showInformationDialog("The new employee added to the database successfully.\n"
                        + "The employee id is " + employee.getId(), "Employee added successfully.");

                if (Utils.settings.getCloseRegister().equals("true")) {
                    this.dispose();
                } else {

                    btnClearActionPerformed(evt);
                    password = Utils.generateEmployeePassword(lblPassword);
                }
            }

        } else {
            errors = 0;
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
            java.util.logging.Logger.getLogger(NewEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                NewEmployee dialog = new NewEmployee(new javax.swing.JFrame(), true, "");
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

    private void loadNationalCode() {
        ncode = Utils.publicAskItem;
        lblUsername.setText("Username: " + ncode);
    }

    private void loadDate() {
        new Boot().loadSystemDate();
        lblDate.setText("Date: " + Utils.envs.get("date"));
        date = Utils.envs.get("date");
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnRegister;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JPanel panelTitle;
    private javax.swing.JTextField txtMobile;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPasswordHint;
    // End of variables declaration//GEN-END:variables
}
