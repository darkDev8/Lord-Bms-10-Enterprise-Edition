package com.bms.dialogs;

import com.bms.root.Boot;
import com.bms.utility.Utils;
import com.sdk.environment.OperatingSystem;
import com.sdk.security.Security;
import com.sdk.storage.files.TextFile;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.print.PrinterException;
import java.io.File;
import java.io.IOException;
import java.util.Objects;
import javax.print.PrintException;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import javax.swing.Timer;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.Document;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;

public class Notepad extends javax.swing.JDialog {

    private String path;

    private boolean save;
    private boolean open;

    private TextFile textFile;
    private OperatingSystem operatingSystem;
    private Timer timer;
    private File file;
    private UndoManager manager;

    public Notepad(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        Utils.swingUI.setJDialogCenter(this);
        Utils.swingUI.makeJDialogMovable(this);

        operatingSystem = new OperatingSystem();
        setComponentsOpenCloseFile(false);

        manager = new UndoManager();

        ActionListener taskPerformer = (ActionEvent evt) -> {
            if (manager.canUndo()) {
                menuItemUndo.setEnabled(true);
            } else {
                menuItemUndo.setEnabled(false);
            }

            if (manager.canRedo()) {
                menuItemRedo.setEnabled(true);
            } else {
                menuItemRedo.setEnabled(false);
            }

            if (!Objects.isNull(txtaNote.getSelectedText())) {
                if (txtaNote.getSelectedText().isEmpty()) {
                    setComponentsSelectText(false);
                } else {
                    setComponentsSelectText(true);
                }
            } else {
                setComponentsSelectText(false);
            }

            if (Utils.envs.containsKey("replace")) {
                txtaNote.setText(Utils.envs.get("replace"));
                Utils.envs.remove("replace");
            }

            if (Utils.envs.containsKey("remove")) {
                txtaNote.setText(Utils.envs.get("remove"));
                Utils.envs.remove("remove");
            }
        };

        Timer timer = new Timer(100, taskPerformer);
        timer.setRepeats(true);
        timer.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu4 = new javax.swing.JMenu();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtaNote = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        lblValidLength = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuOpen = new javax.swing.JMenu();
        menuItemNew = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        menuItemOpenFile = new javax.swing.JMenuItem();
        menuItemOpenDatabase = new javax.swing.JMenuItem();
        menuItemClose = new javax.swing.JMenuItem();
        menuSave = new javax.swing.JMenu();
        menuItemSaveFile = new javax.swing.JMenuItem();
        menuItemSaveDatabase = new javax.swing.JMenuItem();
        menuItemSaveAs = new javax.swing.JMenuItem();
        menuItemRename = new javax.swing.JMenuItem();
        menuItemEncryptText = new javax.swing.JMenuItem();
        menuItemDecryptText = new javax.swing.JMenuItem();
        menuItemShowFileDetails = new javax.swing.JMenuItem();
        menuItemShowInFolder = new javax.swing.JMenuItem();
        menuItemSettings = new javax.swing.JMenuItem();
        menuItemPrint = new javax.swing.JMenuItem();
        menuItemExit = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menuItemUndo = new javax.swing.JMenuItem();
        menuItemRedo = new javax.swing.JMenuItem();
        menuItemClear = new javax.swing.JMenuItem();
        MenuItemCut = new javax.swing.JMenuItem();
        menuItemCopy = new javax.swing.JMenuItem();
        menuItemPaste = new javax.swing.JMenuItem();
        menuItemDelete = new javax.swing.JMenuItem();
        menuItemSelectAll = new javax.swing.JMenuItem();
        menuItemDateTime = new javax.swing.JMenuItem();
        menSearch = new javax.swing.JMenu();
        jMenuItem21 = new javax.swing.JMenuItem();
        menuItemFindInFiles = new javax.swing.JMenuItem();
        menuItemReplace = new javax.swing.JMenuItem();
        menuItemCount = new javax.swing.JMenuItem();
        menuItemRemove = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        menuItemRTL = new javax.swing.JMenuItem();
        menuItemLTR = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jMenuItem28 = new javax.swing.JMenuItem();
        jMenuItem29 = new javax.swing.JMenuItem();

        jMenu4.setText("jMenu4");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        txtaNote.setEditable(false);
        txtaNote.setColumns(20);
        txtaNote.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtaNote.setRows(5);
        txtaNote.setSelectionColor(new java.awt.Color(0, 51, 255));
        txtaNote.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtaNoteKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(txtaNote);

        lblValidLength.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblValidLength.setText("Null");
        lblValidLength.setToolTipText(" ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblValidLength, javax.swing.GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblValidLength, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        menuOpen.setText("File");

        menuItemNew.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuItemNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/bms/images/New.png"))); // NOI18N
        menuItemNew.setText("New");
        menuOpen.add(menuItemNew);

        jMenu8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/bms/images/Open.png"))); // NOI18N
        jMenu8.setText("Open");

        menuItemOpenFile.setText("File");
        menuItemOpenFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemOpenFileActionPerformed(evt);
            }
        });
        jMenu8.add(menuItemOpenFile);

        menuItemOpenDatabase.setText("Database");
        jMenu8.add(menuItemOpenDatabase);

        menuOpen.add(jMenu8);

        menuItemClose.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
        menuItemClose.setText("Close");
        menuItemClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemCloseActionPerformed(evt);
            }
        });
        menuOpen.add(menuItemClose);

        menuSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/bms/images/Save.png"))); // NOI18N
        menuSave.setText("Save");

        menuItemSaveFile.setText("File");
        menuItemSaveFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemSaveFileActionPerformed(evt);
            }
        });
        menuSave.add(menuItemSaveFile);

        menuItemSaveDatabase.setText("Database");
        menuSave.add(menuItemSaveDatabase);

        menuOpen.add(menuSave);

        menuItemSaveAs.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuItemSaveAs.setText("Save as");
        menuOpen.add(menuItemSaveAs);

        menuItemRename.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuItemRename.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/bms/images/Rename.png"))); // NOI18N
        menuItemRename.setText("Rename");
        menuItemRename.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemRenameActionPerformed(evt);
            }
        });
        menuOpen.add(menuItemRename);

        menuItemEncryptText.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuItemEncryptText.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/bms/images/Encrypt.png"))); // NOI18N
        menuItemEncryptText.setText("Encrpt text");
        menuItemEncryptText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemEncryptTextActionPerformed(evt);
            }
        });
        menuOpen.add(menuItemEncryptText);

        menuItemDecryptText.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuItemDecryptText.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/bms/images/Decrypt.png"))); // NOI18N
        menuItemDecryptText.setText("Decrypt text");
        menuItemDecryptText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemDecryptTextActionPerformed(evt);
            }
        });
        menuOpen.add(menuItemDecryptText);

        menuItemShowFileDetails.setText("Show file details     ");
        menuItemShowFileDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemShowFileDetailsActionPerformed(evt);
            }
        });
        menuOpen.add(menuItemShowFileDetails);

        menuItemShowInFolder.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuItemShowInFolder.setText("Show in folder");
        menuItemShowInFolder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemShowInFolderActionPerformed(evt);
            }
        });
        menuOpen.add(menuItemShowInFolder);

        menuItemSettings.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        menuItemSettings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/bms/images/Settings.png"))); // NOI18N
        menuItemSettings.setText("Settings");
        menuOpen.add(menuItemSettings);

        menuItemPrint.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuItemPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/bms/images/Print.png"))); // NOI18N
        menuItemPrint.setText("Print");
        menuItemPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemPrintActionPerformed(evt);
            }
        });
        menuOpen.add(menuItemPrint);

        menuItemExit.setText("Exit");
        menuItemExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemExitActionPerformed(evt);
            }
        });
        menuOpen.add(menuItemExit);

        jMenuBar1.add(menuOpen);

        jMenu2.setText("Edit");

        menuItemUndo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuItemUndo.setText("Undo");
        menuItemUndo.setEnabled(false);
        menuItemUndo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemUndoActionPerformed(evt);
            }
        });
        jMenu2.add(menuItemUndo);

        menuItemRedo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Y, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuItemRedo.setText("Redo");
        menuItemRedo.setEnabled(false);
        menuItemRedo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemRedoActionPerformed(evt);
            }
        });
        jMenu2.add(menuItemRedo);

        menuItemClear.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuItemClear.setText("Clear");
        menuItemClear.setEnabled(false);
        menuItemClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemClearActionPerformed(evt);
            }
        });
        jMenu2.add(menuItemClear);

        MenuItemCut.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        MenuItemCut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/bms/images/Cut.png"))); // NOI18N
        MenuItemCut.setText("Cut");
        MenuItemCut.setEnabled(false);
        MenuItemCut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemCutActionPerformed(evt);
            }
        });
        jMenu2.add(MenuItemCut);

        menuItemCopy.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuItemCopy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/bms/images/Copy.png"))); // NOI18N
        menuItemCopy.setText("Copy");
        menuItemCopy.setEnabled(false);
        menuItemCopy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemCopyActionPerformed(evt);
            }
        });
        jMenu2.add(menuItemCopy);

        menuItemPaste.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuItemPaste.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/bms/images/Paste.png"))); // NOI18N
        menuItemPaste.setText("Paste");
        menuItemPaste.setEnabled(false);
        jMenu2.add(menuItemPaste);

        menuItemDelete.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_DELETE, 0));
        menuItemDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/bms/images/Delete.png"))); // NOI18N
        menuItemDelete.setText("Delete");
        menuItemDelete.setEnabled(false);
        menuItemDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemDeleteActionPerformed(evt);
            }
        });
        jMenu2.add(menuItemDelete);

        menuItemSelectAll.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuItemSelectAll.setText("Select all");
        menuItemSelectAll.setEnabled(false);
        menuItemSelectAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemSelectAllActionPerformed(evt);
            }
        });
        jMenu2.add(menuItemSelectAll);

        menuItemDateTime.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/bms/images/Date.png"))); // NOI18N
        menuItemDateTime.setText("Date / time     ");
        menuItemDateTime.setEnabled(false);
        menuItemDateTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemDateTimeActionPerformed(evt);
            }
        });
        jMenu2.add(menuItemDateTime);

        jMenuBar1.add(jMenu2);

        menSearch.setText("Search");

        jMenuItem21.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/bms/images/Find.png"))); // NOI18N
        jMenuItem21.setText("Find");
        menSearch.add(jMenuItem21);

        menuItemFindInFiles.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuItemFindInFiles.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/bms/images/FindInFiles.png"))); // NOI18N
        menuItemFindInFiles.setText("Find in files");
        menuItemFindInFiles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemFindInFilesActionPerformed(evt);
            }
        });
        menSearch.add(menuItemFindInFiles);

        menuItemReplace.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/bms/images/Replaec.png"))); // NOI18N
        menuItemReplace.setText("Replace");
        menuItemReplace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemReplaceActionPerformed(evt);
            }
        });
        menSearch.add(menuItemReplace);

        menuItemCount.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuItemCount.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/bms/images/Count.png"))); // NOI18N
        menuItemCount.setText("Count");
        menuItemCount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemCountActionPerformed(evt);
            }
        });
        menSearch.add(menuItemCount);

        menuItemRemove.setText("Remove");
        menuItemRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemRemoveActionPerformed(evt);
            }
        });
        menSearch.add(menuItemRemove);

        jMenuBar1.add(menSearch);

        jMenu6.setText("View");

        menuItemRTL.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuItemRTL.setText("Text direction RTL     ");
        menuItemRTL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemRTLActionPerformed(evt);
            }
        });
        jMenu6.add(menuItemRTL);

        menuItemLTR.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuItemLTR.setText("Text direction LTR");
        menuItemLTR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemLTRActionPerformed(evt);
            }
        });
        jMenu6.add(menuItemLTR);

        jMenuBar1.add(jMenu6);

        jMenu7.setText("Help");

        jMenuItem28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/bms/images/Help.png"))); // NOI18N
        jMenuItem28.setText("Help");
        jMenu7.add(jMenuItem28);

        jMenuItem29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/bms/images/About.png"))); // NOI18N
        jMenuItem29.setText("About");
        jMenu7.add(jMenuItem29);

        jMenuBar1.add(jMenu7);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtaNoteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtaNoteKeyPressed
        save = false;
    }//GEN-LAST:event_txtaNoteKeyPressed

    private void menuItemOpenFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemOpenFileActionPerformed
        try {
            openFileFromFileSystem();

            if (!Objects.isNull(file)) {
                path = file.getAbsolutePath();
                textFile = new TextFile(path);

                if (textFile.exist()) {
                    txtaNote.setText(Utils.strings.convertArrayToString(Utils.strings.objectArrayToStringArray(textFile.read().toArray()), "\n"));
                    lblValidLength.setText("Valid length : infinite");

                    setComponentsOpenCloseFile(true);
                    loadUndoRedo();

                    save = true;
                    open = true;

                } else {
                    if (Utils.swingUI.showConfirmDialog("The file doesn't exist in file system.\nPlease check the path and try again.",
                            "File doesn't exist", new Object[]{"Try again", "Cancel"})) {
                        menuItemOpenFileActionPerformed(evt);
                    }

                    open = false;
                }
            }
        } catch (IOException e) {
            Utils.swingUI.showErrorDialog("Unable to open the selected file.\n" + e.getMessage(), "Open failed");
        }
    }//GEN-LAST:event_menuItemOpenFileActionPerformed

    private void menuItemRenameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemRenameActionPerformed
        try {
            new AskDialog(null, true, "fname", "").setVisible(true);

            if (!Objects.isNull(Utils.publicAskItem)) {
                String tmp = textFile.getParentFilePath();

                if (textFile.rename(Utils.publicAskItem)) {
                    Utils.swingUI.showInformationDialog("The file name changed successfully.", "File name changed");

                    if (Utils.envs.get("os").equals("Microsoft Windows")) {
                        tmp += "\\" + Utils.publicAskItem + "." + textFile.getExtension();
                    } else {
                        tmp += "/" + Utils.publicAskItem + "." + textFile.getExtension();
                    }

                    textFile = new TextFile(tmp);
                    file = textFile.getFile();
                    path = file.getAbsolutePath();
                }
            }
        } catch (IOException e) {
            Utils.swingUI.showErrorDialog("Unable to change the file name.\n" + e.getMessage(), "Operaion failed");
        } finally {
            Utils.publicAskItem = null;
        }
    }//GEN-LAST:event_menuItemRenameActionPerformed

    private void menuItemShowInFolderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemShowInFolderActionPerformed
        if (!operatingSystem.openFileExplorer(textFile.getPath())) {
            Utils.swingUI.showConfirmDialog("This operation is not supported by you're operaint system or the application doesn't have access to path.",
                    "Open failed", new Object[]{"Ok"});
        }
    }//GEN-LAST:event_menuItemShowInFolderActionPerformed

    private void menuItemSaveFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemSaveFileActionPerformed
        try {
            if (textFile.write(txtaNote.getText())) {
                save = true;
            } else {
                Utils.swingUI.showErrorDialog("Unable to save the file.", "Save failed");
            }
        } catch (IOException e) {
            Utils.swingUI.showErrorDialog(e.getMessage(), "Save failed");
        }
    }//GEN-LAST:event_menuItemSaveFileActionPerformed

    private void menuItemCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemCloseActionPerformed
        if (save) {
            textFile = null;
            txtaNote.setText(Utils.strings.getEmptyString());

            setComponentsOpenCloseFile(false);
        } else {
            int rs = Utils.swingUI.showQuestionDialog("The file content has changed and not been saved yet.\nDo you want to close the file "
                    + "before saving", "Save file", new Object[]{"Yes", "No", "Cancel"}, "warn");

            if (rs == 0) {
                menuItemSaveFileActionPerformed(evt);
                textFile = null;
                txtaNote.setText(Utils.strings.getEmptyString());

                setComponentsOpenCloseFile(false);
            } else if (rs == 1) {
                textFile = null;
                txtaNote.setText(Utils.strings.getEmptyString());

                setComponentsOpenCloseFile(false);
            }
        }
    }//GEN-LAST:event_menuItemCloseActionPerformed

    private void menuItemExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemExitActionPerformed
        if (open) {
            if (save) {
                this.dispose();
            } else {
                int rs = Utils.swingUI.showQuestionDialog("The file content has changed and not been saved yet.\nDo you want to close the file "
                        + "before saving", "Save file", new Object[]{"Yes", "No", "Cancel"}, "warn");

                if (rs == 0) {
                    menuItemSaveFileActionPerformed(evt);
                    this.dispose();
                } else if (rs == 1) {
                    this.dispose();
                }
            }
        } else {
            this.dispose();
        }
    }//GEN-LAST:event_menuItemExitActionPerformed

    private void menuItemPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemPrintActionPerformed
        try {
            if (!Utils.swingUI.printTextArea(txtaNote)) {
                Utils.swingUI.showErrorDialog("Unable to print the file.", "Print failed.");
            }
        } catch (PrinterException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_menuItemPrintActionPerformed

    private void menuItemShowFileDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemShowFileDetailsActionPerformed
        new ShowFileDetails(null, true, textFile).setVisible(true);
    }//GEN-LAST:event_menuItemShowFileDetailsActionPerformed

    private void menuItemEncryptTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemEncryptTextActionPerformed
        try {
            txtaNote.setText(Security.encrypt(Utils.ENCRYPT_KEY, txtaNote.getText()));
            save = false;
        } catch (Exception e) {
            Utils.swingUI.showErrorDialog("Unable to encrypt this file", "Encryption failed");
        }
    }//GEN-LAST:event_menuItemEncryptTextActionPerformed

    private void menuItemDecryptTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemDecryptTextActionPerformed
        try {
            txtaNote.setText(Security.decrypt(Utils.ENCRYPT_KEY, txtaNote.getText()));
            save = false;
        } catch (Exception e) {
            Utils.swingUI.showErrorDialog("Unable to decrypt this file", "Decryption failed");
        }
    }//GEN-LAST:event_menuItemDecryptTextActionPerformed

    private void menuItemSelectAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemSelectAllActionPerformed
        txtaNote.selectAll();
    }//GEN-LAST:event_menuItemSelectAllActionPerformed

    private void menuItemDateTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemDateTimeActionPerformed
        new Boot().loadSystemTime().loadSystemDate();
        txtaNote.setText(txtaNote.getText().concat(" " + Utils.envs.get("date") + " " + Utils.envs.get("time")));
    }//GEN-LAST:event_menuItemDateTimeActionPerformed

    private void menuItemClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemClearActionPerformed
        txtaNote.setText(Utils.strings.getEmptyString());
        save = false;
    }//GEN-LAST:event_menuItemClearActionPerformed

    private void menuItemUndoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemUndoActionPerformed
        manager.undo();
    }//GEN-LAST:event_menuItemUndoActionPerformed

    private void menuItemRedoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemRedoActionPerformed
        manager.redo();
    }//GEN-LAST:event_menuItemRedoActionPerformed

    private void menuItemDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemDeleteActionPerformed
        txtaNote.setText(txtaNote.getText().replace(txtaNote.getSelectedText(), Utils.strings.getEmptyString()));
        save = false;
    }//GEN-LAST:event_menuItemDeleteActionPerformed

    private void menuItemCopyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemCopyActionPerformed
        operatingSystem.copyTextToClipboard(txtaNote.getSelectedText());
    }//GEN-LAST:event_menuItemCopyActionPerformed

    private void MenuItemCutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemCutActionPerformed
        menuItemCopyActionPerformed(evt);
        menuItemDeleteActionPerformed(evt);
    }//GEN-LAST:event_MenuItemCutActionPerformed

    private void menuItemRTLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemRTLActionPerformed
        txtaNote.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
    }//GEN-LAST:event_menuItemRTLActionPerformed

    private void menuItemLTRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemLTRActionPerformed
        txtaNote.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
    }//GEN-LAST:event_menuItemLTRActionPerformed

    private void menuItemReplaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemReplaceActionPerformed
        new ReplaceText(null, true, txtaNote.getText()).setVisible(true);
    }//GEN-LAST:event_menuItemReplaceActionPerformed

    private void menuItemCountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemCountActionPerformed
        new AskDialog(null, true, "count", txtaNote.getText()).setVisible(true);
    }//GEN-LAST:event_menuItemCountActionPerformed

    private void menuItemRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemRemoveActionPerformed
        new AskDialog(null, true, "remove", txtaNote.getText()).setVisible(true);
    }//GEN-LAST:event_menuItemRemoveActionPerformed

    private void menuItemFindInFilesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemFindInFilesActionPerformed
        new FindInFiles(null, true).setVisible(true);
    }//GEN-LAST:event_menuItemFindInFilesActionPerformed

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
            java.util.logging.Logger.getLogger(Notepad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Notepad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Notepad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Notepad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Notepad dialog = new Notepad(new javax.swing.JFrame(), true);
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

    private void openFileFromFileSystem() {
        file = Utils.swingUI.showOpenDialog("Open file", Utils.envs.get("home"), new FileNameExtensionFilter[]{
            new FileNameExtensionFilter("Text files", "txt"),
            new FileNameExtensionFilter("Xml files", "xml"),
            new FileNameExtensionFilter("Fxml files", "fxml"),
            new FileNameExtensionFilter("Xmlns files", "xmlns"),
            new FileNameExtensionFilter("Iml configuration files", "iml"),
            new FileNameExtensionFilter("Html document", "html"),
            new FileNameExtensionFilter("Html document (old)", "htm"),
            new FileNameExtensionFilter("Java source files", "java"),
            new FileNameExtensionFilter("C# source files", "cs"),
            new FileNameExtensionFilter("C source files", "c"),
            new FileNameExtensionFilter("C++ source files", "cpp"),
            new FileNameExtensionFilter("Javascript source files", "js"),
            new FileNameExtensionFilter("Php source files", "php"),
            new FileNameExtensionFilter("Golang source files", "go")});
    }

    private void setComponentsOpenCloseFile(boolean status) {
        menuItemSaveFile.setEnabled(status);
        menuItemSaveAs.setEnabled(status);
        menuItemSaveDatabase.setEnabled(status);
        menuSave.setEnabled(status);
        menuItemRename.setEnabled(status);
        menuItemShowInFolder.setEnabled(status);
        menuItemClose.setEnabled(status);
        menuItemPrint.setEnabled(status);
        menuItemShowFileDetails.setEnabled(status);
        menuItemEncryptText.setEnabled(status);
        menuItemDecryptText.setEnabled(status);

        menuItemClear.setEnabled(status);
        menuItemDateTime.setEnabled(status);
        menuItemSelectAll.setEnabled(status);

        menuItemReplace.setEnabled(status);
        menuItemCount.setEnabled(status);
        menuItemRemove.setEnabled(status);

        menuItemRTL.setEnabled(status);
        menuItemLTR.setEnabled(status);

        txtaNote.setEditable(status);
        lblValidLength.setVisible(status);
    }

    private void setComponentsSelectText(boolean status) {
        MenuItemCut.setEnabled(status);
        menuItemCopy.setEnabled(status);
        menuItemDelete.setEnabled(status);
    }

    private void loadUndoRedo() {
        KeyStroke undoKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_Z, Event.CTRL_MASK);
        KeyStroke redoKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_Y, Event.CTRL_MASK);

        Document document = txtaNote.getDocument();
        document.addUndoableEditListener(new UndoableEditListener() {
            @Override
            public void undoableEditHappened(UndoableEditEvent e) {
                manager.addEdit(e.getEdit());
            }
        });

        txtaNote.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(undoKeyStroke, "undoKeyStroke");
        txtaNote.getActionMap().put("undoKeyStroke", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    manager.undo();
                } catch (CannotUndoException cue) {
                }
            }
        });

        txtaNote.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(redoKeyStroke, "redoKeyStroke");
        txtaNote.getActionMap().put("redoKeyStroke", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    manager.redo();
                } catch (CannotRedoException cre) {
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem MenuItemCut;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem21;
    private javax.swing.JMenuItem jMenuItem28;
    private javax.swing.JMenuItem jMenuItem29;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblValidLength;
    private javax.swing.JMenu menSearch;
    private javax.swing.JMenuItem menuItemClear;
    private javax.swing.JMenuItem menuItemClose;
    private javax.swing.JMenuItem menuItemCopy;
    private javax.swing.JMenuItem menuItemCount;
    private javax.swing.JMenuItem menuItemDateTime;
    private javax.swing.JMenuItem menuItemDecryptText;
    private javax.swing.JMenuItem menuItemDelete;
    private javax.swing.JMenuItem menuItemEncryptText;
    private javax.swing.JMenuItem menuItemExit;
    private javax.swing.JMenuItem menuItemFindInFiles;
    private javax.swing.JMenuItem menuItemLTR;
    private javax.swing.JMenuItem menuItemNew;
    private javax.swing.JMenuItem menuItemOpenDatabase;
    private javax.swing.JMenuItem menuItemOpenFile;
    private javax.swing.JMenuItem menuItemPaste;
    private javax.swing.JMenuItem menuItemPrint;
    private javax.swing.JMenuItem menuItemRTL;
    private javax.swing.JMenuItem menuItemRedo;
    private javax.swing.JMenuItem menuItemRemove;
    private javax.swing.JMenuItem menuItemRename;
    private javax.swing.JMenuItem menuItemReplace;
    private javax.swing.JMenuItem menuItemSaveAs;
    private javax.swing.JMenuItem menuItemSaveDatabase;
    private javax.swing.JMenuItem menuItemSaveFile;
    private javax.swing.JMenuItem menuItemSelectAll;
    private javax.swing.JMenuItem menuItemSettings;
    private javax.swing.JMenuItem menuItemShowFileDetails;
    private javax.swing.JMenuItem menuItemShowInFolder;
    private javax.swing.JMenuItem menuItemUndo;
    private javax.swing.JMenu menuOpen;
    private javax.swing.JMenu menuSave;
    private javax.swing.JTextArea txtaNote;
    // End of variables declaration//GEN-END:variables
}
