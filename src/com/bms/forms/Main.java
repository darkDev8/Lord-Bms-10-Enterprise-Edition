package com.bms.forms;

import com.bms.database.account.AccountRepository;
import com.sdk.environment.SwingUI;
import com.bms.database.connection.DatabaseConnection;
import com.bms.database.customer.Customer;
import com.bms.database.customer.CustomerRepository;
import com.bms.database.employee.EmployeeRepository;
import com.bms.dialogs.AskDialog;
import com.bms.dialogs.Login;
import com.bms.dialogs.NewAccount;
import com.bms.dialogs.NewEmployee;
import com.bms.dialogs.Notepad;
import com.bms.dialogs.TextEncryptor;
import com.bms.root.Boot;
import com.bms.utility.NewJFrame;
import com.bms.utility.Utils;
import com.sdk.datatypes.Numbers;
import com.sdk.datatypes.Strings;
import com.sdk.environment.OperatingSystem;
import com.sdk.security.Security;
import com.sdk.storage.Internet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.io.File;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.Timer;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;
import javax.swing.filechooser.FileView;
import java.util.List;

public class Main extends javax.swing.JFrame {
    
    private Internet internet;
    private Boot boot;
    
    private CustomerRepository customerRepository;
    private AccountRepository accountRepository;
    private EmployeeRepository employeeRepository;
    
    private JTableHeader th;
    private final String[] CUSTOMER_COLUMNS = {"ID", "User ID", "Name", "Mobile", "National code", "Date"};
    private final String[] ACCOUNT_COLUMNS = {"ID", "Foreign ID", "Account number", "Money", "Type"};
    private final String[] EMPLOYEE_COLUMNS = {"ID", "User ID", "Name", "Mobile", "National code", "Date"};
    
    private int errors;
    private String ncode;
    private String password;
    private String username;
    private String userID;
    private String date;
    
    public Main() {
        initComponents();
        
        boot = new Boot();
        boot.loadBuildNumber()
                .loadCurrentOS()
                .loadDatabaseConnection()
                .loadInternetConnection()
                .loadDatabase()
                .loadSystemTime()
                .loadSystemDate()
                .loadSystemUser()
                .loadSystemUserHomeDirectory();
        
        loadFrameContent();
        loadDatabaseConnection();
        loadCustomers();
        
        password = Utils.generateCustomerPassword(lblPassword);
        userID = Utils.generateUserID(null);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblTime = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        lblBuild = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        cmbSelectTable = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableMain = new javax.swing.JTable();
        panelRegisterCustomer = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        cmbGender = new javax.swing.JComboBox<>();
        btnRegister = new javax.swing.JButton();
        txtAddress = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtMobile = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtBirth = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtPasswordHint = new javax.swing.JTextField();
        txtNcode = new javax.swing.JTextField();
        lblGender = new javax.swing.JLabel();
        btnClear = new javax.swing.JButton();
        lblRegisterUsername = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        btnGeneratePassword = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuAddNew = new javax.swing.JMenu();
        menuItemAccount = new javax.swing.JMenuItem();
        menuItemEmployee = new javax.swing.JMenuItem();
        menuItemLoan = new javax.swing.JMenuItem();
        menuShow = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        menuItemPrint = new javax.swing.JMenuItem();
        menuItemCountTable = new javax.swing.JMenuItem();
        menuItemRefresh = new javax.swing.JMenuItem();
        menuItemLogout = new javax.swing.JMenuItem();
        menuItemExit = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menuItemSettings = new javax.swing.JMenuItem();
        menuItemExportExcel = new javax.swing.JMenuItem();
        menuItemNotepad = new javax.swing.JMenuItem();
        menuItemTextEncryptor = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        menuItemHelp = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        menuItemTest = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Lord Bms 10 Enterprise Edition");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(51, 51, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Lord Bms 10 Enterprise Edition");

        lblTime.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTime.setForeground(new java.awt.Color(255, 255, 255));
        lblTime.setText("00 : 00 : 00");

        lblUsername.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblUsername.setForeground(new java.awt.Color(255, 255, 255));
        lblUsername.setText("Username : mahdi");

        lblBuild.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblBuild.setForeground(new java.awt.Color(255, 255, 255));
        lblBuild.setText("Build 1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblBuild))
                    .addComponent(lblUsername)
                    .addComponent(lblTime))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(lblBuild))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblUsername)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTime)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtSearch.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSearchKeyPressed(evt);
            }
        });

        cmbSelectTable.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cmbSelectTable.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Customers", "Accounts", "Employees", "Transactions", "Loans" }));
        cmbSelectTable.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbSelectTableItemStateChanged(evt);
            }
        });

        tableMain.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tableMain.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tableMain.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tableMain.setSelectionBackground(new java.awt.Color(51, 51, 255));
        tableMain.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tableMain.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tableMain.setShowGrid(false);
        jScrollPane1.setViewportView(tableMain);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Name");

        txtName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        cmbGender.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cmbGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Female", "Male" }));

        btnRegister.setBackground(new java.awt.Color(0, 51, 255));
        btnRegister.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnRegister.setForeground(new java.awt.Color(255, 255, 255));
        btnRegister.setText("Register");
        btnRegister.setFocusPainted(false);
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });

        txtAddress.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Address");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Mobile");

        txtMobile.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Birth date");

        txtBirth.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));
        txtBirth.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Password hint");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Email");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("National code");

        txtEmail.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txtPasswordHint.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txtNcode.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtNcode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNcodeKeyPressed(evt);
            }
        });

        lblGender.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblGender.setText("Gender");

        btnClear.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnClear.setText("Clear");
        btnClear.setFocusPainted(false);
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        lblRegisterUsername.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblRegisterUsername.setText("Username");

        lblPassword.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblPassword.setText("Password");

        lblDate.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblDate.setText("Date");

        btnGeneratePassword.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnGeneratePassword.setText("Generate password");
        btnGeneratePassword.setFocusPainted(false);
        btnGeneratePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGeneratePasswordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRegisterCustomerLayout = new javax.swing.GroupLayout(panelRegisterCustomer);
        panelRegisterCustomer.setLayout(panelRegisterCustomerLayout);
        panelRegisterCustomerLayout.setHorizontalGroup(
            panelRegisterCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRegisterCustomerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRegisterCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRegisterCustomerLayout.createSequentialGroup()
                        .addGroup(panelRegisterCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7)
                            .addComponent(jLabel5)
                            .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                            .addComponent(txtBirth))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelRegisterCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPasswordHint, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelRegisterCustomerLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtAddress, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(panelRegisterCustomerLayout.createSequentialGroup()
                        .addGroup(panelRegisterCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addGroup(panelRegisterCustomerLayout.createSequentialGroup()
                                .addGroup(panelRegisterCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(panelRegisterCustomerLayout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(149, 149, 149))
                                    .addGroup(panelRegisterCustomerLayout.createSequentialGroup()
                                        .addComponent(txtName)
                                        .addGap(6, 6, 6)))
                                .addGroup(panelRegisterCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMobile, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelRegisterCustomerLayout.createSequentialGroup()
                        .addGroup(panelRegisterCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelRegisterCustomerLayout.createSequentialGroup()
                                .addComponent(btnClear)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnGeneratePassword)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnRegister))
                            .addGroup(panelRegisterCustomerLayout.createSequentialGroup()
                                .addGroup(panelRegisterCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblDate, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblGender)
                                    .addComponent(cmbGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(panelRegisterCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblPassword, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblRegisterUsername, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap())
                    .addComponent(txtNcode)))
        );
        panelRegisterCustomerLayout.setVerticalGroup(
            panelRegisterCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRegisterCustomerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRegisterCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRegisterCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMobile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRegisterCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRegisterCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRegisterCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRegisterCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBirth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPasswordHint, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRegisterCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGender)
                    .addComponent(lblPassword))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRegisterCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRegisterUsername))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelRegisterCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegister)
                    .addComponent(btnClear)
                    .addComponent(btnGeneratePassword)))
        );

        jMenu1.setText("File");

        menuAddNew.setText("Add new");

        menuItemAccount.setText("Account");
        menuItemAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemAccountActionPerformed(evt);
            }
        });
        menuAddNew.add(menuItemAccount);

        menuItemEmployee.setText("Employee");
        menuItemEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemEmployeeActionPerformed(evt);
            }
        });
        menuAddNew.add(menuItemEmployee);

        menuItemLoan.setText("Loan");
        menuItemLoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemLoanActionPerformed(evt);
            }
        });
        menuAddNew.add(menuItemLoan);

        jMenu1.add(menuAddNew);

        menuShow.setText("Show");

        jMenuItem4.setText("Users");
        menuShow.add(jMenuItem4);

        jMenuItem5.setText("Logs");
        menuShow.add(jMenuItem5);

        jMenu1.add(menuShow);

        menuItemPrint.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuItemPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/bms/images/Print.png"))); // NOI18N
        menuItemPrint.setText("Print");
        menuItemPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemPrintActionPerformed(evt);
            }
        });
        jMenu1.add(menuItemPrint);

        menuItemCountTable.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuItemCountTable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/bms/images/Counter.png"))); // NOI18N
        menuItemCountTable.setText("Count records     ");
        menuItemCountTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemCountTableActionPerformed(evt);
            }
        });
        jMenu1.add(menuItemCountTable);

        menuItemRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/bms/images/Refresh.png"))); // NOI18N
        menuItemRefresh.setText("Refresh");
        menuItemRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemRefreshActionPerformed(evt);
            }
        });
        jMenu1.add(menuItemRefresh);

        menuItemLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/bms/images/Logout.png"))); // NOI18N
        menuItemLogout.setText("Logout");
        menuItemLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemLogoutActionPerformed(evt);
            }
        });
        jMenu1.add(menuItemLogout);

        menuItemExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuItemExit.setText("Exit");
        menuItemExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemExitActionPerformed(evt);
            }
        });
        jMenu1.add(menuItemExit);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Tools");

        menuItemSettings.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuItemSettings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/bms/images/Settings.png"))); // NOI18N
        menuItemSettings.setText("Settings");
        jMenu2.add(menuItemSettings);

        menuItemExportExcel.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuItemExportExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/bms/images/Excel.png"))); // NOI18N
        menuItemExportExcel.setText("Export to excel file     ");
        menuItemExportExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemExportExcelActionPerformed(evt);
            }
        });
        jMenu2.add(menuItemExportExcel);

        menuItemNotepad.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuItemNotepad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/bms/images/Notepad.png"))); // NOI18N
        menuItemNotepad.setText("Notepad");
        menuItemNotepad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemNotepadActionPerformed(evt);
            }
        });
        jMenu2.add(menuItemNotepad);

        menuItemTextEncryptor.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuItemTextEncryptor.setText("Text encryptor");
        menuItemTextEncryptor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemTextEncryptorActionPerformed(evt);
            }
        });
        jMenu2.add(menuItemTextEncryptor);

        jMenuBar1.add(jMenu2);

        jMenu5.setText("Help");
        jMenu5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        menuItemHelp.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuItemHelp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/bms/images/Help.png"))); // NOI18N
        menuItemHelp.setText("Help");
        jMenu5.add(menuItemHelp);

        jMenuItem13.setText("Send feedback     ");
        jMenu5.add(jMenuItem13);

        jMenuItem14.setText("Report bug");
        jMenu5.add(jMenuItem14);

        jMenuItem15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/bms/images/About.png"))); // NOI18N
        jMenuItem15.setText("About");
        jMenu5.add(jMenuItem15);

        menuItemTest.setText("Test");
        menuItemTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemTestActionPerformed(evt);
            }
        });
        jMenu5.add(menuItemTest);

        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtSearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbSelectTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelRegisterCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbSelectTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelRegisterCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuItemExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemExitActionPerformed
        System.exit(1);
    }//GEN-LAST:event_menuItemExitActionPerformed

    private void txtSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyPressed
        DefaultTableModel Model = (DefaultTableModel) tableMain.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(Model);
        tableMain.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(txtSearch.getText().trim()));
    }//GEN-LAST:event_txtSearchKeyPressed

    private void cmbSelectTableItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbSelectTableItemStateChanged
        loadAll();
    }//GEN-LAST:event_cmbSelectTableItemStateChanged

    private void menuItemCountTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemCountTableActionPerformed
        int count = 0;
        
        switch (cmbSelectTable.getSelectedIndex()) {
            case 0:
                count = customerRepository.count();
                break;
            
            case 1:
                count = accountRepository.count();
                break;
            
            case 2:
                count = employeeRepository.count();
        }
        
        if (count != -1) {
            if (count == 0) {
                Utils.swingUI.showInformationDialog("There are no records in the table.", "Number of records");
            } else {
                Utils.swingUI.showInformationDialog("There are " + count + " records in the table.", "Number of records");
            }
        }
    }//GEN-LAST:event_menuItemCountTableActionPerformed

    private void menuItemTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemTestActionPerformed
        new NewJFrame().setVisible(true);
    }//GEN-LAST:event_menuItemTestActionPerformed

    private void menuItemRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemRefreshActionPerformed
        tableMain.setRowSorter(null);
        loadAll();
    }//GEN-LAST:event_menuItemRefreshActionPerformed

    private void menuItemAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemAccountActionPerformed
        new NewAccount(this, true).setVisible(true);
    }//GEN-LAST:event_menuItemAccountActionPerformed

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
        
        Customer customer = new Customer();
        
        if (errors == 0) {
            if (customerRepository.exist(ncode) == 0) {
                try {
                    customer.setUid(Integer.parseInt(userID));
                    customer.setName(txtName.getText());
                    customer.setMobile(txtMobile.getText());
                    customer.setEmail(txtEmail.getText());
                    customer.setNcode(ncode);
                    customer.setBirth(txtBirth.getText());
                    customer.setAddress(txtAddress.getText());
                    customer.setUser(Security.encrypt(Utils.ENCRYPT_KEY, username));
                    customer.setPass(Security.encrypt(Utils.ENCRYPT_KEY, password));
                    customer.setHint(txtPasswordHint.getText());
                    customer.setDate(date);
                    customer.setGender((short) cmbGender.getSelectedIndex());
                } catch (Exception e) {
                    Utils.swingUI.showErrorDialog(e.getMessage(), "Customer values failed.");
                }
                
                if (customerRepository.addCustomer(customer)) {
                    Utils.swingUI.showInformationDialog("The new customer added to the database successfully.\n"
                            + "The customer user id is " + userID, "Customer added successfully.");
                    
                    Utils.envs.put("created", "1");
                    btnClearActionPerformed(evt);
                    
                    password = Utils.generateCustomerPassword(lblPassword);
                    userID = Utils.generateUserID(null);
                    cmbSelectTable.setSelectedIndex(0);
                }
            } else {
                Utils.swingUI.showConfirmDialog("The customer already exist in the database.", "Customer exist",
                        new Object[]{"Ok"});
            }
            
        } else {
            errors = 0;
        }
    }//GEN-LAST:event_btnRegisterActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        Utils.swingUI.clearComponents(panelRegisterCustomer, "field", true);
        Utils.swingUI.clearComponents(this, "combo", true);
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnGeneratePasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGeneratePasswordActionPerformed
        password = Utils.generateCustomerPassword(lblPassword);
    }//GEN-LAST:event_btnGeneratePasswordActionPerformed

    private void txtNcodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNcodeKeyPressed
        checkUsernameLabel();
    }//GEN-LAST:event_txtNcodeKeyPressed

    private void menuItemExportExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemExportExcelActionPerformed
        try {
            File file = Utils.swingUI.showSaveDialog("Select file location", Utils.envs.get("home"),
                    new FileNameExtensionFilter[]{new FileNameExtensionFilter("Microsoft excel files", "xlsx")});
            
            if (!Objects.isNull(file)) {
                Utils.dBRepository.exportTableToExcelFile(tableMain, 5, file.getAbsolutePath());
                Utils.swingUI.showInformationDialog("The table exported successfully.", "Table exported");
            }
        } catch (IOException e) {
            Utils.swingUI.showErrorDialog("Failed to export table to excel file.\n" + e.getMessage(), "Export failed");
        }
    }//GEN-LAST:event_menuItemExportExcelActionPerformed

    private void menuItemLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemLogoutActionPerformed
        if (Utils.swingUI.showConfirmDialog("Are you srue you want to logout from system?", "Logout system",
                new Object[]{"Yes", "No"})) {
            login();
        }

    }//GEN-LAST:event_menuItemLogoutActionPerformed

    private void menuItemEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemEmployeeActionPerformed
        new AskDialog(this, true, "ncode", "employee").setVisible(true);
        if (!Objects.isNull(Utils.publicAskItem)) {
            if (!Utils.strings.isEmpty(Utils.publicAskItem)) {
                new NewEmployee(this, true, Utils.publicAskItem).setVisible(true);
            }
        }
    }//GEN-LAST:event_menuItemEmployeeActionPerformed

    private void menuItemTextEncryptorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemTextEncryptorActionPerformed
        new TextEncryptor(this, true).setVisible(true);
    }//GEN-LAST:event_menuItemTextEncryptorActionPerformed

    private void menuItemPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemPrintActionPerformed
        try {
            String title = null;
            
            switch (cmbSelectTable.getSelectedIndex()) {
                case 0:
                    title = "Customers";
                    break;
                
                case 1:
                    title = "Accounts";
                    break;
                
                case 2:
                    title = "Employees";
                    break;
            }
            
            Utils.swingUI.printTable(tableMain, title, "Page{0,number,integer}");
        } catch (PrinterException e) {
            Utils.swingUI.showErrorDialog("Unable to print the table.\n" + e.getMessage(), "Print failed");
        }
    }//GEN-LAST:event_menuItemPrintActionPerformed

    private void menuItemNotepadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemNotepadActionPerformed
        new Notepad(this, true).setVisible(true);
    }//GEN-LAST:event_menuItemNotepadActionPerformed

    private void menuItemLoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemLoanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuItemLoanActionPerformed
    
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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }
    
    private void checkUsernameLabel() {
        if (txtNcode.getText().isEmpty()) {
            lblRegisterUsername.setVisible(false);
        } else {
            lblRegisterUsername.setText("Username: " + txtNcode.getText());
            lblRegisterUsername.setVisible(true);
            username = txtNcode.getText();
            ncode = txtNcode.getText();
        }
    }
    
    private void loadFrameContent() {
        Utils.swingUI.setJFrameCenter(this);
        Utils.swingUI.makeJFrameMovable(this);
        
        lblBuild.setText("Build " + Utils.envs.get("build"));
        lblTime.setText("Up time : " + Utils.envs.get("time"));
        
        ActionListener taskPerformer = (ActionEvent evt) -> {
            boot.loadSystemTime().loadSystemDate().loadSystemUserHomeDirectory();
            lblTime.setText("Up time : " + Utils.envs.get("time"));
            lblDate.setText("Date: " + Utils.envs.get("date"));
            date = Utils.envs.get("date");
            
            checkUsernameLabel();
            
            if (Utils.envs.containsKey("created")) {
                switch (Utils.envs.get("created")) {
                    case "1":
                        cmbSelectTable.setSelectedIndex(0);
                        loadCustomers();
                        Utils.envs.remove("created", "1");
                        break;
                    
                    case "2":
                        break;
                    
                    case "3":
                        cmbSelectTable.setSelectedIndex(2);
                        loadEmployess();
                        Utils.envs.remove("created", "3");
                        break;
                }
                
            }
        };
        
        Timer timer = new Timer(500, taskPerformer);
        timer.setRepeats(true);
        timer.start();
        
        th = tableMain.getTableHeader();
        Utils.swingUI.setTableNoneEditable(tableMain);
        tableMain.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblRegisterUsername.setVisible(false);
        
        Utils.swingUI.setJTextFieldLimit(txtName, 100);
        Utils.swingUI.setJTextFieldLimit(txtMobile, 11);
        Utils.swingUI.setJTextFieldLimit(txtEmail, 100);
        Utils.swingUI.setJTextFieldLimit(txtBirth, 10);
        Utils.swingUI.setJTextFieldLimit(txtAddress, 150);
        Utils.swingUI.setJTextFieldLimit(txtPasswordHint, 20);
        Utils.swingUI.setJTextFieldLimit(txtNcode, 10);
        
        Utils.swingUI.setJTextFieldInputType(txtMobile, "number");
        Utils.swingUI.setJTextFieldInputType(txtNcode, "number");
    }
    
    private void login() {
        while (true) {
            this.setVisible(false);
            new Login(this, true).setVisible(true);
            if (!Utils.login) {
                new Login(this, true).setVisible(true);
            } else {
                break;
            }
        }
        
        this.setVisible(true);
    }
    
    private void loadDatabaseConnection() {
        internet = new Internet("http://www.google.com");
        
        if (Objects.isNull(Utils.connection)) {
            String message = "Unable to connect to the database.\n";
            
            if (internet.isInternetConnected()) {
                message += "Please contact the manager to solve problem.";
            } else {
                message += "The internet is not connected.";
            }
            
            Utils.swingUI.showErrorDialog(message, "Database connection failed");
            System.exit(1);
        }
    }
    
    private void loadCustomers() {
        customerRepository = new CustomerRepository();
        customerRepository.loadCustomers(tableMain);
        List<Object> items = new ArrayList<>();
        
        TableColumnModel tcm = th.getColumnModel();
        
        for (int i = 0; i < CUSTOMER_COLUMNS.length; i++) {
            TableColumn tc = tcm.getColumn(i);
            tc.setHeaderValue(CUSTOMER_COLUMNS[i]);
            th.repaint();
        }

//        for (int j = 0; j < Utils.swingUI.countTableColumns(tableMain); j++) {
//            for (int i = 0; i < Utils.swingUI.countTableRows(tableMain); i++) {
//                items.add(tableMain.getValueAt(i, j));
//            }
//
//            int biggest = Utils.strings.findBiggestItem(Utils.strings.objectArrayToStringArray(items.toArray())).length();
//            items.clear();
//            
//            tableMain.getColumnModel().getColumn(j).setPreferredWidth(biggest);
//            System.out.println(biggest);
//        }
        tableMain.getColumnModel().getColumn(0).setPreferredWidth(25);
        tableMain.getColumnModel().getColumn(1).setPreferredWidth(45);
        tableMain.getColumnModel().getColumn(2).setPreferredWidth(50);
        tableMain.getColumnModel().getColumn(3).setPreferredWidth(70);
        tableMain.getColumnModel().getColumn(4).setPreferredWidth(65);
        tableMain.getColumnModel().getColumn(5).setPreferredWidth(65);
    }
    
    private void loadAccounts() {
        accountRepository = new AccountRepository();
        accountRepository.loadAccounts(tableMain);
        
        TableColumnModel tcm = th.getColumnModel();
        
        for (int i = 0; i < ACCOUNT_COLUMNS.length; i++) {
            TableColumn tc = tcm.getColumn(i);
            tc.setHeaderValue(ACCOUNT_COLUMNS[i]);
            th.repaint();
        }
    }
    
    private void loadEmployess() {
        employeeRepository = new EmployeeRepository();
        employeeRepository.loadEmployees(tableMain);
        
        TableColumnModel tcm = th.getColumnModel();
        
        for (int i = 0; i < EMPLOYEE_COLUMNS.length; i++) {
            TableColumn tc = tcm.getColumn(i);
            tc.setHeaderValue(EMPLOYEE_COLUMNS[i]);
            th.repaint();
        }
    }
    
    private void loadTransactions() {
    }
    
    private void loadLogs() {
    }
    
    private void loadAll() {
        switch (cmbSelectTable.getSelectedIndex()) {
            case 0:
                loadCustomers();
                break;
            
            case 1:
                loadAccounts();
                break;
            
            case 2:
                loadEmployess();
                break;
            
            case 3:
                break;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnGeneratePassword;
    private javax.swing.JButton btnRegister;
    private javax.swing.JComboBox<String> cmbGender;
    private javax.swing.JComboBox<String> cmbSelectTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBuild;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblGender;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblRegisterUsername;
    private javax.swing.JLabel lblTime;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JMenu menuAddNew;
    private javax.swing.JMenuItem menuItemAccount;
    private javax.swing.JMenuItem menuItemCountTable;
    private javax.swing.JMenuItem menuItemEmployee;
    private javax.swing.JMenuItem menuItemExit;
    private javax.swing.JMenuItem menuItemExportExcel;
    private javax.swing.JMenuItem menuItemHelp;
    private javax.swing.JMenuItem menuItemLoan;
    private javax.swing.JMenuItem menuItemLogout;
    private javax.swing.JMenuItem menuItemNotepad;
    private javax.swing.JMenuItem menuItemPrint;
    private javax.swing.JMenuItem menuItemRefresh;
    private javax.swing.JMenuItem menuItemSettings;
    private javax.swing.JMenuItem menuItemTest;
    private javax.swing.JMenuItem menuItemTextEncryptor;
    private javax.swing.JMenu menuShow;
    private javax.swing.JPanel panelRegisterCustomer;
    private javax.swing.JTable tableMain;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JFormattedTextField txtBirth;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtMobile;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtNcode;
    private javax.swing.JTextField txtPasswordHint;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
