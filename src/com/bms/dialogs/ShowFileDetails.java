package com.bms.dialogs;

import com.bms.utility.Utils;
import com.sdk.environment.OperatingSystem;
import com.sdk.storage.files.TextFile;
import java.awt.Color;
import java.io.IOException;
import java.util.Objects;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;

public class ShowFileDetails extends javax.swing.JDialog {

    private OperatingSystem operatingSystem;
    private TextFile textFile;

    public ShowFileDetails(java.awt.Frame parent, boolean modal, TextFile textFile) {
        super(parent, modal);
        initComponents();

        if (Objects.isNull(textFile)) {
            this.dispose();
        } else {
            this.textFile = textFile;
        }

        Utils.swingUI.setJDialogCenter(this);
        Utils.swingUI.setJDialogCloseESC(this);
        Utils.swingUI.makeJDialogMovable(this);
        
        panelTitle.setBackground(Color.decode(Utils.settings.getColorCode()));
        btnCopy.setBackground(Color.decode(Utils.settings.getColorCode()));
        tableInformation.setSelectionBackground(Color.decode(Utils.settings.getColorCode()));
        
        Utils.swingUI.setTableNoneEditable(tableInformation);
        tableInformation.getColumnModel().getColumn(0).setMaxWidth(150);
        tableInformation.getColumnModel().getColumn(0).setPreferredWidth(120);
        this.setTitle(textFile.getName());

        try {

            DefaultTableModel model = (DefaultTableModel) tableInformation.getModel();
            model.addRow(new Object[]{"Name", textFile.getName()});
            model.addRow(new Object[]{"Size", Utils.strings.getReadableSize(textFile.getSize())});
            model.addRow(new Object[]{"Create time", textFile.getCreateTime()});
            model.addRow(new Object[]{"Owner", textFile.getOwner()});
            model.addRow(new Object[]{"Directory path", textFile.getParentDirectoryPath()});
            model.addRow(new Object[]{"Access time", textFile.getAccessTime()});
            model.addRow(new Object[]{"Access date", textFile.getAccessDate()});
            model.addRow(new Object[]{"Base name", textFile.getBaseName()});
            model.addRow(new Object[]{"Extension", textFile.getExtension()});
            model.addRow(new Object[]{"Type", textFile.getType()});
            model.addRow(new Object[]{"Path", textFile.getPath()});
            model.addRow(new Object[]{"Directory name", textFile.getParentDirectoryName()});
            model.addRow(new Object[]{"Modify time", textFile.getModifyTime()});
            model.addRow(new Object[]{"Modify date", textFile.getModifyDate()});
            model.addRow(new Object[]{"Characters", textFile.countTrueCharacters()});
            model.addRow(new Object[]{"All characters", textFile.countAllCharacters()});
            model.addRow(new Object[]{"Words", textFile.countWords()});
            model.addRow(new Object[]{"Lines", textFile.countLines()});
            model.addRow(new Object[]{"Empty lines", textFile.countEmptyLines()});
        } catch (IOException e) {
            Utils.swingUI.showErrorDialog("Unable to fetch file information.\n" + e.getMessage(), "Fetch failed");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelTitle = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnCopy = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableInformation = new javax.swing.JTable();
        btnClose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("File information");
        setResizable(false);

        panelTitle.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("File information");

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

        btnCopy.setBackground(new java.awt.Color(0, 0, 0));
        btnCopy.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnCopy.setForeground(new java.awt.Color(255, 255, 255));
        btnCopy.setText("Copy");
        btnCopy.setFocusPainted(false);
        btnCopy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCopyActionPerformed(evt);
            }
        });

        tableInformation.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tableInformation.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Value"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableInformation.setSelectionBackground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(tableInformation);

        btnClose.setText("Close");
        btnClose.setFocusPainted(false);
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
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
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnClose)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCopy)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCopy)
                    .addComponent(btnClose))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCopyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCopyActionPerformed
        try {
            operatingSystem = new OperatingSystem();

            operatingSystem.copyTextToClipboard("Name: " + textFile.getName() + "\n"
                    + "Size: " + Utils.strings.getReadableSize(textFile.getSize()) + "\n"
                    + "Create time: " + textFile.getCreateTime() + "\n"
                    + "Owner: " + textFile.getOwner() + "\n"
                    + "Directory path: " + textFile.getParentDirectoryPath() + "\n"
                    + "Access time: " + textFile.getAccessTime() + "\n"
                    + "Access date: " + textFile.getAccessDate() + "\n"
                    + "Base name: " + textFile.getBaseName() + "\n"
                    + "Extension: " + textFile.getExtension() + "\n"
                    + "Type: " + textFile.getType() + "\n"
                    + "Path: " + textFile.getPath() + "\n"
                    + "Directory name: " + textFile.getParentDirectoryName() + "\n"
                    + "Modify time: " + textFile.getModifyTime() + "\n"
                    + "Modify date: " + textFile.getModifyDate() + "\n"
                    + "Chracters: " + textFile.countTrueCharacters() + "\n"
                    + "All characters: " + textFile.countAllCharacters() + "\n"
                    + "Words: " + textFile.countWords() + "\n"
                    + "Line: " + textFile.countLines() + "\n"
                    + "Empty lines: " + textFile.countEmptyLines() + "\n");

        } catch (Exception e) {
            Utils.swingUI.showErrorDialog("Unable to copy the details to clipboard.\n" + e.getMessage(), "Copy failed");
        }
    }//GEN-LAST:event_btnCopyActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

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
            java.util.logging.Logger.getLogger(ShowFileDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ShowFileDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ShowFileDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ShowFileDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ShowFileDetails dialog = new ShowFileDetails(new javax.swing.JFrame(), true, null);
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
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnCopy;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelTitle;
    private javax.swing.JTable tableInformation;
    // End of variables declaration//GEN-END:variables
}
