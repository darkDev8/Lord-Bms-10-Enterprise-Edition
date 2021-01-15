package com.bms.dialogs;

import com.bms.database.customer.CustomerRepository;
import com.bms.database.employee.EmployeeRepository;
import com.bms.utility.Utils;
import static com.bms.utility.Utils.envs;
import com.sdk.datatypes.Characters;
import com.sdk.datatypes.Strings;
import com.sdk.security.Security;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;

public class Login extends javax.swing.JDialog {

    private EmployeeRepository employeeRepository;
    private Characters characters;

    public Login(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        employeeRepository = new EmployeeRepository();
        characters = new Characters();

        Utils.swingUI.setJDialogCenter(this);
        Utils.swingUI.setJDialogCloseESC(this);
        Utils.swingUI.makeJDialogMovable(this);
        
        btnLogin.setBackground(Color.decode(Utils.settings.getColorCode()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        chkShiowPassword = new javax.swing.JCheckBox();
        btnExit = new javax.swing.JButton();
        btnLogin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Login");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Username");

        txtUsername.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Password");

        txtPassword.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPasswordKeyPressed(evt);
            }
        });

        chkShiowPassword.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        chkShiowPassword.setText("Show password");
        chkShiowPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkShiowPasswordActionPerformed(evt);
            }
        });

        btnExit.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnExit.setText("Exit");
        btnExit.setFocusPainted(false);
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        btnLogin.setBackground(new java.awt.Color(0, 0, 0));
        btnLogin.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setText("Login");
        btnLogin.setFocusPainted(false);
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtUsername)
                    .addComponent(txtPassword)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(chkShiowPassword))
                        .addGap(0, 275, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnExit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLogin)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkShiowPassword)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExit)
                    .addComponent(btnLogin))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        System.exit(1);
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        login();
    }//GEN-LAST:event_btnLoginActionPerformed

    private void chkShiowPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkShiowPasswordActionPerformed
        if (chkShiowPassword.isSelected()) {
            txtPassword.setEchoChar((char) 0);
            txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
        } else {
            txtPassword.setEchoChar('*');
            txtPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
        }
    }//GEN-LAST:event_chkShiowPasswordActionPerformed

    private void txtPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyPressed
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            login();
        }
    }//GEN-LAST:event_txtPasswordKeyPressed

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
            java.util.logging.Logger.getLogger(Login.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Login dialog = new Login(new javax.swing.JFrame(), true);
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

    private void login() {
//        if (!txtUsername.getText().isEmpty() && !characters.convertCharArrayToString(txtPassword.getPassword()).isEmpty()) {
//            try {
//                if (employeeRepository.usernameExist(Security.encrypt(Utils.envs.get("encKey"), txtUsername.getText())) == 1
//                        && employeeRepository.passwordExist(Security.encrypt(Utils.envs.get("encKey"), characters.convertCharArrayToString(txtPassword.getPassword()))) == 1) {
//
//                    Utils.login = true;
//                    this.dispose();
//                } else {
//                    System.out.println(Security.decrypt(Utils.envs.get("encKey"), txtUsername.getText()));
//                    System.out.println(Security.decrypt(Utils.envs.get("encKey"), characters.convertCharArrayToString(txtPassword.getPassword())));
//
//                    Utils.swingUI.showErrorDialog("The username or password is incorrect.", "Incorrect username or password.");
//
//                }
//            } catch (Exception e) {
//                Utils.swingUI.showErrorDialog("Unalbe to fetch data from database.\n" + e.getMessage(), "Fetching information failed");
//            }
//        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnLogin;
    private javax.swing.JCheckBox chkShiowPassword;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
