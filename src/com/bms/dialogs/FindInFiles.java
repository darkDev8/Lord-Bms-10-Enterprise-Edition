package com.bms.dialogs;

import com.bms.utility.Utils;
import com.sdk.storage.DirectorySystem;
import com.sdk.storage.FileSystem;
import com.sdk.storage.files.TextFile;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.Timer;

public class FindInFiles extends javax.swing.JDialog {

    private File file;
    private DirectorySystem system;
    private String[] items;

    private boolean match;

    public FindInFiles(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        Utils.swingUI.setJDialogCenter(this);
        Utils.swingUI.setJDialogCloseESC(this);
        Utils.swingUI.makeJDialogMovable(this);

        ActionListener taskPerformer = (ActionEvent evt) -> {
            if (!txtPath.getText().isEmpty() && !txtText.getText().isEmpty()) {
                btnSearchFiles.setEnabled(true);
            } else {
                btnSearchFiles.setEnabled(false);
            }
        };

        Timer timer = new Timer(500, taskPerformer);
        timer.setRepeats(true);
        timer.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jLabel1 = new javax.swing.JLabel();
        txtPath = new javax.swing.JTextField();
        btnBrowse = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtText = new javax.swing.JTextField();
        chkMatch = new javax.swing.JCheckBox();
        cmbType = new javax.swing.JComboBox<>();
        jInternalFrame2 = new javax.swing.JInternalFrame();
        lblFiles = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listFIles = new javax.swing.JList<>();
        btnClose = new javax.swing.JButton();
        btnSearchFiles = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Search in files");
        setMinimumSize(new java.awt.Dimension(567, 583));

        jInternalFrame1.setTitle("Select options");
        jInternalFrame1.setVisible(true);

        jLabel1.setText("Directory");

        txtPath.setEditable(false);

        btnBrowse.setText("Browse");
        btnBrowse.setFocusPainted(false);
        btnBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowseActionPerformed(evt);
            }
        });

        jLabel2.setText("Text");

        chkMatch.setSelected(true);
        chkMatch.setText("Match");
        chkMatch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkMatchActionPerformed(evt);
            }
        });

        cmbType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Default", "Uppercase", "Lowercase" }));

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPath)
                            .addComponent(txtText))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBrowse))
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addComponent(chkMatch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 350, Short.MAX_VALUE)
                        .addComponent(cmbType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBrowse))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkMatch)
                    .addComponent(cmbType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jInternalFrame2.setTitle("List files");
        jInternalFrame2.setVisible(true);

        lblFiles.setText("Files");

        listFIles.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listFIlesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listFIles);

        javax.swing.GroupLayout jInternalFrame2Layout = new javax.swing.GroupLayout(jInternalFrame2.getContentPane());
        jInternalFrame2.getContentPane().setLayout(jInternalFrame2Layout);
        jInternalFrame2Layout.setHorizontalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 508, Short.MAX_VALUE)
                    .addGroup(jInternalFrame2Layout.createSequentialGroup()
                        .addComponent(lblFiles)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jInternalFrame2Layout.setVerticalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblFiles)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        btnSearchFiles.setBackground(new java.awt.Color(51, 51, 255));
        btnSearchFiles.setForeground(new java.awt.Color(254, 254, 254));
        btnSearchFiles.setText("Search files");
        btnSearchFiles.setEnabled(false);
        btnSearchFiles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchFilesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jInternalFrame1)
                    .addComponent(jInternalFrame2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnClose)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearchFiles)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jInternalFrame2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSearchFiles)
                    .addComponent(btnClose))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowseActionPerformed
        file = Utils.swingUI.selectDirectory("Select directory", Utils.envs.get("home"));
        if (!Objects.isNull(file)) {
            txtPath.setText(file.getAbsolutePath());
            system = new DirectorySystem(txtPath.getText());

            if (system.exist()) {
                try {
                    List<File> files = system.getFiles();
                    List<String> listItems = new ArrayList<>();
                    FileSystem fs = new FileSystem(Utils.strings.getEmptyString());

                    items = new String[files.size()];

                    String[] extensions = {fs.getCplusplusHeader(), fs.getCplusplusSource(), fs.getGoLangSource(), fs.getJavaSource(),
                        fs.getJavascriptSource(), fs.getPhpSource(), fs.getPythonSource(), fs.getRubySource(),
                        fs.getcHeader(), fs.getcSharpSource(), fs.getcSource()};

                    for (int i = 0; i < files.size(); i++) {
                        items[i] = files.get(i).getAbsolutePath();
                    }

                    for (int i = 0; i < items.length; i++) {
                        for (int j = 0; j < extensions.length; j++) {
                            if (new FileSystem(items[i]).getExtension().equals(extensions[j])) {
                                listItems.add(items[i]);
                            } else {
                                if (Utils.strings.contains(fs.getText(), new FileSystem(items[i]).getExtension())) {
                                    if (!listItems.contains(items[i])) {
                                        listItems.add(items[i]);
                                    }
                                }
                            }
                        }
                    }

                    items = Utils.strings.listToArray(listItems);
                    Utils.swingUI.clearJList(listFIles);
                    Utils.swingUI.addToJList(listFIles, items);
                    lblFiles.setText("Files: " + items.length);
                } catch (IOException e) {
                    Utils.swingUI.showErrorDialog("Unable to fetch the files.\n" + e.getMessage(), "Fetch failed");
                }
            }

        }
    }//GEN-LAST:event_btnBrowseActionPerformed

    private void btnSearchFilesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchFilesActionPerformed
        try {
            if (txtText.getText().isEmpty()) {
                Utils.swingUI.showConfirmDialog("Select a text to search in files.", "No text", new Object[]{"Ok"});
            } else {
                Map<String, String[]> contents = new HashMap<>();
                List<String> founds = new ArrayList<>();
                String find = txtText.getText();

                switch (cmbType.getSelectedIndex()) {
                    case 1:
                        find = find.toUpperCase();
                        break;

                    case 2:
                        find = find.toLowerCase();
                        break;
                }

                for (int i = 0; i < items.length; i++) {
                    TextFile txt = new TextFile(items[i]);

                    if (txt.exist()) {
                        contents.put(items[i], Utils.strings.listToArray(txt.read()));
                    }
                }

                for (Map.Entry<String, String[]> entry : contents.entrySet()) {

                    if (chkMatch.isSelected()) {
                        Pattern p = Pattern.compile("\\b" + find + "\\b");
                        Matcher m = p.matcher(Utils.strings.convertArrayToString(entry.getValue(), " "));

                        if (m.find()) {
                            founds.add(entry.getKey());
                        }
                    } else {
                        if (Utils.strings.convertArrayToString(entry.getValue()).contains(find)) {
                            founds.add(entry.getKey());
                        }
                    }
                }

                Utils.swingUI.clearJList(listFIles);
                Utils.swingUI.addToJList(listFIles, Utils.strings.listToArray(founds));
                lblFiles.setText("Files: " + founds.size());
            }
        } catch (IOException e) {
            Utils.swingUI.showErrorDialog("Failed to search files.\n" + e.getMessage(), "Search failed");
        }
    }//GEN-LAST:event_btnSearchFilesActionPerformed

    private void chkMatchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkMatchActionPerformed
        match = chkMatch.isSelected();
    }//GEN-LAST:event_chkMatchActionPerformed

    private void listFIlesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listFIlesMouseClicked
        if (evt.getClickCount() == 2) {
            TextFile txtFile = new TextFile(listFIles.getSelectedValue());
            new ShowFileDetails(null, true, txtFile).setVisible(true);
        }
    }//GEN-LAST:event_listFIlesMouseClicked

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
            java.util.logging.Logger.getLogger(FindInFiles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FindInFiles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FindInFiles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FindInFiles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FindInFiles dialog = new FindInFiles(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnBrowse;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnSearchFiles;
    private javax.swing.JCheckBox chkMatch;
    private javax.swing.JComboBox<String> cmbType;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JInternalFrame jInternalFrame2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblFiles;
    private javax.swing.JList<String> listFIles;
    private javax.swing.JTextField txtPath;
    private javax.swing.JTextField txtText;
    // End of variables declaration//GEN-END:variables
}
