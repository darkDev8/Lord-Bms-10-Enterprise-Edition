package com.bms.dialogs;

import com.bms.root.Boot;
import com.bms.utility.Utils;
import com.sdk.environment.ConsoleForeground;
import com.sdk.security.Security;
import com.sdk.storage.files.TextFile;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Objects;
import java.util.Properties;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class Settings extends javax.swing.JDialog {

    private com.bms.utility.Settings settings;
    private TextFile textFile;

    private String tmp;

    public Settings(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        Utils.swingUI.setJDialogCenter(this);
        Utils.swingUI.setJDialogCloseESC(this);
        Utils.swingUI.makeJDialogMovable(this);

        Utils.swingUI.setJTextFieldInputType(txtTableRecrods, "number");
        Utils.swingUI.setJTextFieldLimit(txtTableRecrods, 6);

        Utils.swingUI.setJTextFieldInputType(txtPaymentPercent, "number");
        Utils.swingUI.setJTextFieldLimit(txtPaymentPercent, 2);

        settings = new com.bms.utility.Settings();
        textFile = new TextFile("config.xml");
        tmp = "10";

        panelTitle.setBackground(Color.decode(Utils.settings.getColorCode()));
        btnOk.setBackground(Color.decode(Utils.settings.getColorCode()));

        loadSettings();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelTitle = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnOk = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        chkInfinite = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        btnBrowsePath = new javax.swing.JButton();
        txtPath = new javax.swing.JTextField();
        chkCloseRegister = new javax.swing.JCheckBox();
        jPanel3 = new javax.swing.JPanel();
        lblSampleColor = new javax.swing.JLabel();
        btnBrowseColor = new javax.swing.JButton();
        lblColor = new javax.swing.JLabel();
        btnPreviewColor = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtTableRecrods = new javax.swing.JTextField();
        txtDefaultMoney = new javax.swing.JTextField();
        txtPaymentPercent = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Settings");

        panelTitle.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Application settings");

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

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Settings", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        btnOk.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnOk.setForeground(new java.awt.Color(255, 255, 255));
        btnOk.setText("Ok");
        btnOk.setFocusPainted(false);
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Number of items in main table");

        chkInfinite.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        chkInfinite.setText("Infinite");
        chkInfinite.setFocusPainted(false);
        chkInfinite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkInfiniteActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Dialogs path");

        btnBrowsePath.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnBrowsePath.setText("Browse");
        btnBrowsePath.setFocusPainted(false);
        btnBrowsePath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowsePathActionPerformed(evt);
            }
        });

        txtPath.setEditable(false);
        txtPath.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        chkCloseRegister.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        chkCloseRegister.setText("Close forms after registration");
        chkCloseRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkCloseRegisterActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Colors", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        lblSampleColor.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblSampleColor.setText("Sample color");
        lblSampleColor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSampleColorMouseClicked(evt);
            }
        });

        btnBrowseColor.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnBrowseColor.setText("Choose color");
        btnBrowseColor.setFocusPainted(false);
        btnBrowseColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowseColorActionPerformed(evt);
            }
        });

        lblColor.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblColor.setText("Color : #FF007C");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSampleColor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblColor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnBrowseColor)
                        .addGap(0, 249, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(lblSampleColor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblColor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBrowseColor)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnPreviewColor.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnPreviewColor.setText("Preview");
        btnPreviewColor.setFocusPainted(false);
        btnPreviewColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreviewColorActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Payment percent for loans");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Accounts Default Money");

        txtTableRecrods.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtTableRecrods.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTableRecrodsKeyPressed(evt);
            }
        });

        txtDefaultMoney.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtDefaultMoney.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTableRecrodsKeyPressed(evt);
            }
        });

        txtPaymentPercent.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtPaymentPercent.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTableRecrodsKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(btnPreviewColor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnOk, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtPath, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBrowsePath, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3)
                            .addComponent(chkCloseRegister)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addGap(39, 39, 39)
                                    .addComponent(txtDefaultMoney, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4)
                                        .addComponent(chkInfinite))
                                    .addGap(29, 29, 29)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtTableRecrods, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtPaymentPercent, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkInfinite)
                    .addComponent(txtTableRecrods, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtPaymentPercent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtDefaultMoney, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBrowsePath))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chkCloseRegister)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOk)
                    .addComponent(btnPreviewColor))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        btnOkActionPerformed();
    }//GEN-LAST:event_btnOkActionPerformed

    private void btnOkActionPerformed() {
        settings.setDefaultMoney(txtDefaultMoney.getText());
        settings.setPayment(txtPaymentPercent.getText());
        settings.setTableRecords(txtTableRecrods.getText());

        Utils.envs.put("tableRecordUpdate", "");

        saveSettings();
        this.dispose();
    }

    private void btnBrowseColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowseColorActionPerformed
        Color color = Utils.swingUI.showColorDialog(this, "Select color", Color.decode(Utils.settings.getColorCode()));
        if (!Objects.isNull(color)) {
            settings.setColorCode(ConsoleForeground.convertRGBToHex(color.getRed(), color.getGreen(), color.getBlue()));

            lblColor.setText("Color code: " + settings.getColorCode());
            lblSampleColor.setForeground(color);

            panelTitle.setBackground(Color.decode(Utils.settings.getColorCode()));
            btnOk.setBackground(Color.decode(Utils.settings.getColorCode()));
        }
    }//GEN-LAST:event_btnBrowseColorActionPerformed

    private void btnPreviewColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviewColorActionPerformed
        new ColorPreview(null, true, Color.decode(Utils.settings.getColorCode())).setVisible(true);
    }//GEN-LAST:event_btnPreviewColorActionPerformed

    private void btnBrowsePathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowsePathActionPerformed
        File file = Utils.swingUI.selectDirectory("Select directory", Utils.envs.get("home"));
        if (!Objects.isNull(file)) {
            settings.setDialogPath(file.getAbsolutePath());
            txtPath.setText(settings.getDialogPath());
        }
    }//GEN-LAST:event_btnBrowsePathActionPerformed

    private void chkCloseRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkCloseRegisterActionPerformed
        settings.setCloseRegister(String.valueOf(chkCloseRegister.isSelected()));
    }//GEN-LAST:event_chkCloseRegisterActionPerformed

    private void lblSampleColorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSampleColorMouseClicked
        if (evt.getClickCount() == 2) {
            new AskDialog(null, true, "text", lblSampleColor.getText()).setVisible(true);

            if (!Objects.isNull(Utils.publicAskItem)) {
                if (Utils.publicAskItem.equals("ok")) {
                    if (Utils.envs.containsKey("sampleText")) {
                        String text = Utils.envs.get("sampleText");

                        if (text.length() > 65) {
                            lblSampleColor.setText(text.substring(0, 52));
                            lblSampleColor.setText(lblSampleColor.getText() + "...");
                        } else {
                            lblSampleColor.setText(text);
                        }

                        Utils.envs.remove("sampleText");
                    }
                }
            }
        }
    }//GEN-LAST:event_lblSampleColorMouseClicked

    private void txtTableRecrodsKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTableRecrodsKeyPressed
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            btnOkActionPerformed();
        }
    }//GEN-LAST:event_txtTableRecrodsKeyPressed

    private void chkInfiniteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkInfiniteActionPerformed
        if (chkInfinite.isSelected()) {
            txtTableRecrods.setEnabled(false);
            settings.setTableRecords("-1");

            tmp = txtTableRecrods.getText();
            txtTableRecrods.setText("-1");
        } else {
            txtTableRecrods.setEnabled(true);
            txtTableRecrods.setText(tmp);
            
            settings.setTableRecords(txtTableRecrods.getText());
        }
    }//GEN-LAST:event_chkInfiniteActionPerformed

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
            java.util.logging.Logger.getLogger(Settings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Settings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Settings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Settings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Settings dialog = new Settings(new javax.swing.JFrame(), true);
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

    private void saveSettings() {
        try {
            if (!textFile.exist()) {
                textFile.create();
            }

            Properties props = new Properties();

            props.setProperty("tableRecords", settings.getTableRecords());
            props.setProperty("dialogPath", settings.getDialogPath());
            props.setProperty("closeRegister", settings.getCloseRegister());
            props.setProperty("appColor", settings.getColorCode());
            props.setProperty("payment", settings.getPayment());
            props.setProperty("defaultMoney", settings.getDefaultMoney());

            OutputStream outputStream = new FileOutputStream(new File("config.xml"));
            props.storeToXML(outputStream, "Settings values");
            outputStream.close();

            new Boot().loadSettings();
        } catch (Exception e) {
            Utils.swingUI.showErrorDialog("Unable to save settings in the file.\n" + e.getMessage(), "Save failed");
        }
    }

    private void loadSettings() {
        settings = Utils.settings;

        chkCloseRegister.setSelected(Boolean.parseBoolean(settings.getCloseRegister()));

        if (settings.getTableRecords().equals("-1")) {
            chkInfinite.setSelected(true);
        } else {
            chkInfinite.setSelected(false);
        }

        txtPath.setText(settings.getDialogPath());
        lblColor.setText("Color code: " + settings.getColorCode());
        lblSampleColor.setForeground(Color.decode(settings.getColorCode()));

        txtTableRecrods.setText(settings.getTableRecords());
        
        if (txtTableRecrods.getText().equals("-1")) {
            txtTableRecrods.setEnabled(false);
        } else {
            txtTableRecrods.setEnabled(true);
        }
        
        txtPaymentPercent.setText(settings.getPayment());
        txtDefaultMoney.setText(settings.getDefaultMoney());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBrowseColor;
    private javax.swing.JButton btnBrowsePath;
    private javax.swing.JButton btnOk;
    private javax.swing.JButton btnPreviewColor;
    private javax.swing.JCheckBox chkCloseRegister;
    private javax.swing.JCheckBox chkInfinite;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblColor;
    private javax.swing.JLabel lblSampleColor;
    private javax.swing.JPanel panelTitle;
    private javax.swing.JTextField txtDefaultMoney;
    private javax.swing.JTextField txtPath;
    private javax.swing.JTextField txtPaymentPercent;
    private javax.swing.JTextField txtTableRecrods;
    // End of variables declaration//GEN-END:variables
}
