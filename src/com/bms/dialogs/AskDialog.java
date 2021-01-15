package com.bms.dialogs;

import com.bms.database.account.AccountRepository;
import com.bms.database.customer.CustomerRepository;
import com.bms.database.employee.EmployeeRepository;
import com.bms.utility.Utils;
import com.sdk.datatypes.Characters;
import java.awt.Color;
import java.awt.event.KeyEvent;

public class AskDialog extends javax.swing.JDialog {

    private AccountRepository accountRepository;
    private EmployeeRepository employeeRepository;

    private String mode;
    private String object;

    public AskDialog(java.awt.Frame parent, boolean modal, String mode, String object) {
        super(parent, modal);
        initComponents();

        Utils.publicAskItem = null;
        this.mode = mode;
        this.object = object;

        Utils.swingUI.setJDialogCenter(this);
        Utils.swingUI.setJDialogCloseESC(this);
        Utils.swingUI.makeJDialogMovable(this);

        btnOk.setBackground(Color.decode(Utils.settings.getColorCode()));

        accountRepository = new AccountRepository();
        employeeRepository = new EmployeeRepository();

        switch (mode) {
            case "ncode":
                lblAskMessage.setText("National code");
                Utils.swingUI.setJTextFieldLimit(txtItem, 10);
                Utils.swingUI.setJTextFieldInputType(txtItem, "number");
                txtItem.setEchoChar((char) 0);
                this.setTitle("National code");
                break;

            case "fname":
                lblAskMessage.setText("File name");
                txtItem.setEchoChar((char) 0);
                this.setTitle("File name");
                break;

            case "count":
            case "text":
                txtItem.setText(this.object);
            case "remove":
                lblAskMessage.setText("Input text");
                txtItem.setEchoChar((char) 0);
                this.setTitle("Input text");
                break;

            case "pass":
                lblAskMessage.setText("Password");
                txtItem.setEchoChar('*');
                this.setTitle("Manager password");
                break;

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblAskMessage = new javax.swing.JLabel();
        btnOk = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        txtItem = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Title");
        setResizable(false);

        lblAskMessage.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblAskMessage.setText("Message");

        btnOk.setBackground(new java.awt.Color(0, 0, 0));
        btnOk.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnOk.setForeground(java.awt.Color.white);
        btnOk.setText("Ok");
        btnOk.setFocusPainted(false);
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
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

        txtItem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtItemKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtItem)
                    .addComponent(lblAskMessage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnOk)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAskMessage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOk)
                    .addComponent(btnCancel))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        beginProcess();
    }//GEN-LAST:event_btnOkActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void txtItemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtItemKeyPressed
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            beginProcess();
        }
    }//GEN-LAST:event_txtItemKeyPressed

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
            java.util.logging.Logger.getLogger(AskDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AskDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AskDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AskDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AskDialog dialog = new AskDialog(new javax.swing.JFrame(), true, "", "");
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

    private void beginProcess() {
        String text = new Characters().convertCharArrayToString(txtItem.getPassword());

        switch (mode) {
            case "ncode": {
                if (text.length() != 10) {
                    Utils.swingUI.showErrorDialog("The national is invalid.\nNational code must be 10 digits.", "Invalid national code");
                } else {
                    switch (object) {
                        case "employee":
                            if (employeeRepository.exist("ncode", txtItem.getText(), "") == 1) {
                                Utils.swingUI.showConfirmDialog("The employee already exist in the database.", "Employee exist",
                                        new Object[]{"Ok"});
                            } else {
                                Utils.publicAskItem = text;
                                this.dispose();
                            }
                            break;

                        case "account":
                            break;
                    }

                }
                break;
            }

            case "fname": {
                if (text.isEmpty()) {
                    Utils.swingUI.showConfirmDialog("The file name can't be empty.", "Enter file name", new Object[]{"Ok"});
                } else {
                    Utils.publicAskItem = text;
                    this.dispose();
                }

                break;
            }

            case "count": {
                if (text.isEmpty()) {
                    Utils.swingUI.showConfirmDialog("Please enter the specified text.", "No input", new Object[]{"Ok"});
                } else {
                    int count = Utils.strings.repeatWords(object, text);

                    if (count == 0) {
                        Utils.swingUI.showInformationDialog("No matches found", "No matches");
                    } else {
                        Utils.swingUI.showInformationDialog("There are " + count + " Matches found", "Number of matches");
                    }

                    this.dispose();
                }

                break;
            }

            case "remove": {
                if (text.isEmpty()) {
                    Utils.swingUI.showConfirmDialog("Please enter the specified text.", "No input", new Object[]{"Ok"});
                } else {
                    Utils.envs.put("remove", object.replace(text, Utils.strings.getEmptyString()));
                    this.dispose();
                }

                break;
            }

            case "pass": {
                if (text.isEmpty()) {
                    Utils.swingUI.showConfirmDialog("Enter the manager password.", "No password", new Object[]{"Ok"});
                } else {
                    if (text.equals(Utils.envs.get("manager"))) {
                        Utils.publicAskItem = "ok";
                        this.dispose();
                    } else {
                        Utils.swingUI.showErrorDialog("The password is incorrect.", "Incorrect password");
                        Utils.publicAskItem = null;
                    }
                }
                break;
            }

            case "text": {
                if (text.isEmpty()) {
                    Utils.swingUI.showConfirmDialog("Please enter the specified text.", "No input", new Object[]{"Ok"});
                } else {
                    Utils.publicAskItem = "ok";
                    Utils.envs.put("sampleText", txtItem.getText());
                    this.dispose();
                }
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnOk;
    private javax.swing.JLabel lblAskMessage;
    private javax.swing.JPasswordField txtItem;
    // End of variables declaration//GEN-END:variables
}
