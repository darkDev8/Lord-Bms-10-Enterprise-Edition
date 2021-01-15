package com.bms.forms;

import com.bms.database.account.Account;
import com.bms.database.account.AccountRepository;
import com.bms.database.account.EditAccount;
import com.sdk.environment.SwingUI;
import com.bms.database.connection.DatabaseConnection;
import com.bms.database.customer.Customer;
import com.bms.database.customer.CustomerRepository;
import com.bms.database.employee.EmployeeRepository;
import com.bms.database.transaction.TransactionRepository;
import com.bms.dialogs.AskDialog;
import com.bms.dialogs.Login;
import com.bms.database.account.NewAccount;
import com.bms.database.customer.EditCustomer;
import com.bms.database.customerlog.CustomerLogRepository;
import com.bms.database.employee.EditEmployee;
import com.bms.database.employee.Employee;
import com.bms.database.employee.NewEmployee;
import com.bms.database.employeelog.EmployeeLogRepository;
import com.bms.database.loan.LoanRepository;
import com.bms.database.loan.NewLoan;
import com.bms.database.transaction.Transaction;
import com.bms.dialogs.About;
import com.bms.dialogs.Settings;
import com.bms.dialogs.ShowLogs;
import com.bms.dialogs.ShowUsers;
import com.bms.dialogs.TextEncryptor;
import com.bms.root.Boot;
import com.bms.utility.NewJFrame;
import com.bms.utility.Utils;
import static com.bms.utility.Utils.envs;
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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import javax.swing.event.ListSelectionEvent;

public class Main extends javax.swing.JFrame {

    private Internet internet;
    private Boot boot;

    private CustomerRepository customerRepository;
    private AccountRepository accountRepository;
    private EmployeeRepository employeeRepository;
    private TransactionRepository transactionRepository;
    private CustomerLogRepository customerLogRepository;
    private EmployeeLogRepository employeeLogRepository;
    private LoanRepository loanRepository;

    private Customer customer;
    private Account account;
    private Employee employee;
    private Transaction transaction;

    private JTableHeader th;

    private int errors;
    private String ncode;
    private String password;
    private String username;
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
                .loadSystemUserHomeDirectory()
                .loadEncryptionKey()
                .loadManagerPassword()
                .loadSettings();

        customer = new Customer();
        account = new Account();
        employee = new Employee();
        transaction = new Transaction();

        customerRepository = new CustomerRepository();
        accountRepository = new AccountRepository();
        employeeRepository = new EmployeeRepository();
        transactionRepository = new TransactionRepository();
        customerLogRepository = new CustomerLogRepository();
        employeeLogRepository = new EmployeeLogRepository();
        loanRepository = new LoanRepository();

        loadFrameContent();
        loadDatabaseConnection();
        loadAll();

        password = Utils.generateCustomerPassword(lblPassword);
        Utils.envs.put("emp", "1");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelTitle = new javax.swing.JPanel();
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
        menuItemShowUsers = new javax.swing.JMenuItem();
        menuItemShowLogs = new javax.swing.JMenuItem();
        menuItemDeleteTransactions = new javax.swing.JMenuItem();
        menuItemPrint = new javax.swing.JMenuItem();
        menuItemCountTable = new javax.swing.JMenuItem();
        menuItemRefresh = new javax.swing.JMenuItem();
        menuItemLogout = new javax.swing.JMenuItem();
        menuItemExit = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menuItemSettings = new javax.swing.JMenuItem();
        menuItemExportExcel = new javax.swing.JMenuItem();
        menuItemTextEncryptor = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        menuItemHelp = new javax.swing.JMenuItem();
        menuItemSendFeedback = new javax.swing.JMenuItem();
        menuItemReportBug = new javax.swing.JMenuItem();
        menuItemAbout = new javax.swing.JMenuItem();
        menuItemTest = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Lord Bms 10 Enterprise Edition");
        setResizable(false);

        panelTitle.setBackground(new java.awt.Color(0, 0, 0));

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

        javax.swing.GroupLayout panelTitleLayout = new javax.swing.GroupLayout(panelTitle);
        panelTitle.setLayout(panelTitleLayout);
        panelTitleLayout.setHorizontalGroup(
            panelTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTitleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelTitleLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblBuild))
                    .addComponent(lblUsername)
                    .addComponent(lblTime))
                .addContainerGap(472, Short.MAX_VALUE))
        );
        panelTitleLayout.setVerticalGroup(
            panelTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTitleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
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
        tableMain.setSelectionBackground(new java.awt.Color(0, 0, 0));
        tableMain.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tableMain.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tableMain.setShowGrid(false);
        tableMain.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMainMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableMain);

        panelRegisterCustomer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Name");

        txtName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        cmbGender.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cmbGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Female", "Male" }));

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
        jLabel7.setText("Emaill");

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
                            .addGroup(panelRegisterCustomerLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRegisterCustomerLayout.createSequentialGroup()
                                .addGroup(panelRegisterCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtPasswordHint, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtAddress))
                                .addContainerGap())))
                    .addGroup(panelRegisterCustomerLayout.createSequentialGroup()
                        .addGroup(panelRegisterCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNcode)
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
                                    .addComponent(txtMobile)
                                    .addGroup(panelRegisterCustomerLayout.createSequentialGroup()
                                        .addGroup(panelRegisterCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel3))
                                        .addGap(0, 0, Short.MAX_VALUE))))
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
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                                .addGroup(panelRegisterCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblPassword, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblRegisterUsername, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap())))
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
                .addGroup(panelRegisterCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRegisterCustomerLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblDate)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRegisterCustomerLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                        .addGroup(panelRegisterCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnRegister)
                            .addComponent(btnGeneratePassword)
                            .addComponent(btnClear))
                        .addContainerGap())))
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

        menuItemShowUsers.setText("Users");
        menuItemShowUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemShowUsersActionPerformed(evt);
            }
        });
        menuShow.add(menuItemShowUsers);

        menuItemShowLogs.setText("Logs");
        menuItemShowLogs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemShowLogsActionPerformed(evt);
            }
        });
        menuShow.add(menuItemShowLogs);

        jMenu1.add(menuShow);

        menuItemDeleteTransactions.setText("Delete transactions");
        menuItemDeleteTransactions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemDeleteTransactionsActionPerformed(evt);
            }
        });
        jMenu1.add(menuItemDeleteTransactions);

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
        menuItemSettings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemSettingsActionPerformed(evt);
            }
        });
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

        menuItemTextEncryptor.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuItemTextEncryptor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/bms/images/Encrypt.png"))); // NOI18N
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

        menuItemSendFeedback.setText("Send feedback     ");
        jMenu5.add(menuItemSendFeedback);

        menuItemReportBug.setText("Report bug");
        jMenu5.add(menuItemReportBug);

        menuItemAbout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/bms/images/About.png"))); // NOI18N
        menuItemAbout.setText("About");
        menuItemAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemAboutActionPerformed(evt);
            }
        });
        jMenu5.add(menuItemAbout);

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
            .addComponent(panelTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(panelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbSelectTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelRegisterCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
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
                break;

            case 3:
                count = transactionRepository.count();
                break;

            case 4:
                count = employeeLogRepository.count();
                break;
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
            txtName.setForeground(Color.decode(Utils.settings.getColorCode()));
            txtName.setText("Name required");
            errors += 1;
        } else {
            txtName.setForeground(Color.BLACK);
        }

        if (txtMobile.getText().length() != 11 || !txtMobile.getText().startsWith("09")) {
            txtMobile.setForeground(Color.decode(Utils.settings.getColorCode()));
            txtMobile.setText("Mobile number is invalid");
            errors += 1;
        } else {
            txtMobile.setForeground(Color.BLACK);
        }

        if (txtEmail.getText().isEmpty()) {
            txtEmail.setForeground(Color.decode(Utils.settings.getColorCode()));
            txtEmail.setText("Email address required");
            errors += 1;
        } else {
            txtEmail.setForeground(Color.BLACK);
        }

        if (txtAddress.getText().isEmpty()) {
            txtAddress.setForeground(Color.decode(Utils.settings.getColorCode()));
            txtAddress.setText("Address required");
            errors += 1;
        } else {
            txtAddress.setForeground(Color.BLACK);
        }

        if (txtNcode.getText().length() != 10) {
            txtNcode.setForeground(Color.decode(Utils.settings.getColorCode()));
            txtNcode.setText("National code is invalid");
            errors += 1;
        } else {
            txtNcode.setForeground(Color.BLACK);
        }

        if (txtPasswordHint.getText().isEmpty()) {
            txtPasswordHint.setForeground(Color.decode(Utils.settings.getColorCode()));
            txtPasswordHint.setText("Password hint required");
            errors += 1;
        } else {
            txtPasswordHint.setForeground(Color.BLACK);
        }

        Customer customer = new Customer();

        if (errors == 0) {
            if (customerRepository.exist("ncode", ncode, "") == 0) {
                try {
                    customer.setName(txtName.getText());
                    customer.setMobile(txtMobile.getText());
                    customer.setEmail(txtEmail.getText());
                    customer.setNcode(ncode);
                    customer.setBirth(txtBirth.getText());
                    customer.setAddress(txtAddress.getText());
                    customer.setUser(Security.encrypt(Utils.envs.get("encKey"), username));
                    customer.setPass(Security.encrypt(Utils.envs.get("encKey"), password));
                    customer.setHint(txtPasswordHint.getText());
                    customer.setDate(date);
                    customer.setGender((short) cmbGender.getSelectedIndex());
                } catch (Exception e) {
                    Utils.swingUI.showErrorDialog(e.getMessage(), "Customer values failed.");
                }

                if (customerRepository.addCustomer(customer)) {
                    Customer c = customerRepository.getCustomer("ncode", ncode);

                    Utils.swingUI.showInformationDialog("The new customer added to the database successfully.\n"
                            + "The customer id is " + c.getId() + ".", "Customer added successfully.");

                    Utils.envs.put("created", "1");
                    btnClearActionPerformed(evt);

                    password = Utils.generateCustomerPassword(lblPassword);
                    Utils.envs.put("tableUpdate", "1");
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
            File file = Utils.swingUI.showSaveDialog("Select file location", Utils.settings.getDialogPath(),
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

                case 3:
                    title = "Transactions";
                    break;

                case 4:
                    title = "Loans";
                    break;
            }

            Utils.swingUI.printTable(tableMain, title, "Page{0,number,integer}");
        } catch (PrinterException e) {
            Utils.swingUI.showErrorDialog("Unable to print the table.\n" + e.getMessage(), "Print failed");
        }
    }//GEN-LAST:event_menuItemPrintActionPerformed

    private void menuItemLoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemLoanActionPerformed
        new NewLoan(this, true).setVisible(true);
    }//GEN-LAST:event_menuItemLoanActionPerformed

    private void tableMainMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMainMouseClicked
        if (tableMain.getSelectedRow() != -1) {
            if (evt.getClickCount() == 1) {
                switch (cmbSelectTable.getSelectedIndex()) {
                    case 0:
                        customer.setId(Integer.parseInt(tableMain.getValueAt(tableMain.getSelectedRow(), 0).toString()));
                        customer.setName(tableMain.getValueAt(tableMain.getSelectedRow(), 1).toString());
                        customer.setMobile(tableMain.getValueAt(tableMain.getSelectedRow(), 2).toString());
                        customer.setNcode(tableMain.getValueAt(tableMain.getSelectedRow(), 3).toString());
                        customer.setDate(tableMain.getValueAt(tableMain.getSelectedRow(), 4).toString());
                        break;

                    case 1:
                        account.setId(Integer.parseInt(tableMain.getValueAt(tableMain.getSelectedRow(), 0).toString()));
                        account.setFid(Integer.parseInt(tableMain.getValueAt(tableMain.getSelectedRow(), 1).toString()));
                        account.setAcn(tableMain.getValueAt(tableMain.getSelectedRow(), 2).toString());
                        account.setMoney(tableMain.getValueAt(tableMain.getSelectedRow(), 3).toString());
                        break;

                    case 2:
                        employee.setId(Integer.parseInt(tableMain.getValueAt(tableMain.getSelectedRow(), 0).toString()));
                        employee.setName(tableMain.getValueAt(tableMain.getSelectedRow(), 1).toString());
                        employee.setMobile(tableMain.getValueAt(tableMain.getSelectedRow(), 2).toString());
                        employee.setNcode(tableMain.getValueAt(tableMain.getSelectedRow(), 3).toString());
                        break;
                }
            } else if (evt.getClickCount() == 2) {
                switch (cmbSelectTable.getSelectedIndex()) {
                    case 0:
                        new EditCustomer(Main.this, true, customer).setVisible(true);
                        break;

                    case 1:
                        new EditAccount(this, true, account).setVisible(true);
                        break;

                    case 2:
                        new EditEmployee(this, true, employee).setVisible(true);
                }
            }
        }
    }//GEN-LAST:event_tableMainMouseClicked

    private void menuItemShowUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemShowUsersActionPerformed
        if (customerLogRepository.count() == 0 && employeeRepository.count() == 0) {
            Utils.swingUI.showInformationDialog("There is no user to display.", "No user");
        } else {
            new ShowUsers(this, true).setVisible(true);
        }
    }//GEN-LAST:event_menuItemShowUsersActionPerformed

    private void menuItemDeleteTransactionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemDeleteTransactionsActionPerformed
        new AskDialog(this, true, "pass", "").setVisible(true);
        if (!Objects.isNull(Utils.publicAskItem)) {
            if (Utils.publicAskItem.equals("ok")) {
                if (Utils.swingUI.showConfirmDialog("Are you sure you want to delete all accounts transaction?\n"
                        + "Changes can't be undo", "Delete all transactions", new Object[]{"Delete all", "Cancel"})) {

                    if (transactionRepository.deleteAll()) {
                        Utils.envs.put("tableUpdate", "4");
                        Utils.swingUI.showInformationDialog("All the transactions deleted successfully.", "Transactions delete.");
                    }
                }
            }
        }
    }//GEN-LAST:event_menuItemDeleteTransactionsActionPerformed

    private void menuItemShowLogsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemShowLogsActionPerformed
        if (customerLogRepository.count() == 0 && employeeLogRepository.count() == 0) {
            Utils.swingUI.showInformationDialog("There is no new log to display", "No log");
        } else {
            new ShowLogs(this, true).setVisible(true);
        }
    }//GEN-LAST:event_menuItemShowLogsActionPerformed

    private void menuItemSettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemSettingsActionPerformed
        new Settings(this, true).setVisible(true);
    }//GEN-LAST:event_menuItemSettingsActionPerformed

    private void menuItemAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemAboutActionPerformed
        new About(this, true).setVisible(true);
    }//GEN-LAST:event_menuItemAboutActionPerformed

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

        menuItemSendFeedback.setVisible(false);
        menuItemReportBug.setVisible(false);
        menuItemTest.setVisible(false);

        lblBuild.setText("Build " + Utils.envs.get("build"));
        lblTime.setText("Up time : " + Utils.envs.get("time"));

        ActionListener taskPerformer = (ActionEvent evt) -> {
            boot.loadSystemTime().loadSystemDate().loadSystemUserHomeDirectory();
            lblTime.setText("Up time : " + Utils.envs.get("time"));
            lblDate.setText("Date: " + Utils.envs.get("date"));
            date = Utils.envs.get("date");

            panelTitle.setBackground(Color.decode(Utils.settings.getColorCode()));
            btnRegister.setBackground(Color.decode(Utils.settings.getColorCode()));
            tableMain.setSelectionBackground(Color.decode(Utils.settings.getColorCode()));

            checkUsernameLabel();

            if (Utils.envs.containsKey("tableUpdate")) {
                int index = Integer.parseInt(Utils.envs.get("tableUpdate"));

                switch (index) {
                    case 1:
                        loadCustomers();
                        break;

                    case 2:
                        loadAccounts();
                        break;

                    case 3:
                        loadEmployess();
                        break;

                    case 4:
                        loadTransactions();
                        break;

                    case 5:
                        loadLoans();
                        break;
                }

                cmbSelectTable.setSelectedIndex(index - 1);
                Utils.envs.remove("tableUpdate");
            }

            if (Utils.envs.containsKey("tableRecordUpdate")) {
                loadAll();

                if (!Utils.settings.getTableRecords().equals("-1")) {
                    correctTableRows();
                }

                Utils.envs.remove("tableRecordUpdate");
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
        customerRepository.loadCustomers(tableMain, new String[]{"id", "name", "mobile", "ncode", "date"});
        List<Object> items = new ArrayList<>();

        TableColumnModel tcm = th.getColumnModel();

        for (int i = 0; i < Utils.CUSTOMER_COLUMNS.length; i++) {
            TableColumn tc = tcm.getColumn(i);
            tc.setHeaderValue(Utils.CUSTOMER_COLUMNS[i]);
            th.repaint();
        }

        tableMain.getColumnModel().getColumn(0).setPreferredWidth(25);
        tableMain.getColumnModel().getColumn(1).setPreferredWidth(45);
        tableMain.getColumnModel().getColumn(2).setPreferredWidth(50);
        tableMain.getColumnModel().getColumn(3).setPreferredWidth(70);
        tableMain.getColumnModel().getColumn(4).setPreferredWidth(65);
    }

    private void loadAccounts() {
        accountRepository.loadAccounts(tableMain, new String[]{"id", "fid", "acn", "money"});

        TableColumnModel tcm = th.getColumnModel();

        for (int i = 0; i < Utils.ACCOUNT_COLUMNS.length; i++) {
            TableColumn tc = tcm.getColumn(i);
            tc.setHeaderValue(Utils.ACCOUNT_COLUMNS[i]);
            th.repaint();
        }
    }

    private void loadEmployess() {
        employeeRepository.loadEmployees(tableMain, new String[]{"id", "name", "mobile", "ncode", "date"});

        TableColumnModel tcm = th.getColumnModel();

        for (int i = 0; i < Utils.EMPLOYEE_COLUMNS.length; i++) {
            TableColumn tc = tcm.getColumn(i);
            tc.setHeaderValue(Utils.EMPLOYEE_COLUMNS[i]);
            th.repaint();
        }
    }

    private void loadTransactions() {
        transactionRepository.loadTransactions(tableMain, new String[]{"id", "fid", "sourceacn", "destacn", "date"});

        TableColumnModel tcm = th.getColumnModel();

        for (int i = 0; i < Utils.TRANSACTION_COLUMNS.length; i++) {
            TableColumn tc = tcm.getColumn(i);
            tc.setHeaderValue(Utils.TRANSACTION_COLUMNS[i]);
            th.repaint();
        }
    }

    private void loadLoans() {
        loanRepository.loadLoans(tableMain, new String[]{"id", "fid", "amount", "startdate", "enddate"});

        TableColumnModel tcm = th.getColumnModel();

        for (int i = 0; i < Utils.LOANS_COLUMNS.length; i++) {
            TableColumn tc = tcm.getColumn(i);
            tc.setHeaderValue(Utils.LOANS_COLUMNS[i]);
            th.repaint();
        }
    }

    private void loadAll() {
        tableMain.setRowSorter(null);
        
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
                loadTransactions();
                break;

            case 4:
                loadLoans();
                break;
        }
    }

    private void correctTableRows() {
        int number = Integer.parseInt(Utils.settings.getTableRecords()),
                rows = (int) Utils.swingUI.countTableRows(tableMain);

        if (rows > number) {
            DefaultTableModel dtm = (DefaultTableModel) tableMain.getModel();

            for (int i = rows - 1; i > number - 1; i--) {
                dtm.removeRow(i);
            }

            tableMain.setModel(dtm);
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBuild;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblGender;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblRegisterUsername;
    private javax.swing.JLabel lblTime;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JMenu menuAddNew;
    private javax.swing.JMenuItem menuItemAbout;
    private javax.swing.JMenuItem menuItemAccount;
    private javax.swing.JMenuItem menuItemCountTable;
    private javax.swing.JMenuItem menuItemDeleteTransactions;
    private javax.swing.JMenuItem menuItemEmployee;
    private javax.swing.JMenuItem menuItemExit;
    private javax.swing.JMenuItem menuItemExportExcel;
    private javax.swing.JMenuItem menuItemHelp;
    private javax.swing.JMenuItem menuItemLoan;
    private javax.swing.JMenuItem menuItemLogout;
    private javax.swing.JMenuItem menuItemPrint;
    private javax.swing.JMenuItem menuItemRefresh;
    private javax.swing.JMenuItem menuItemReportBug;
    private javax.swing.JMenuItem menuItemSendFeedback;
    private javax.swing.JMenuItem menuItemSettings;
    private javax.swing.JMenuItem menuItemShowLogs;
    private javax.swing.JMenuItem menuItemShowUsers;
    private javax.swing.JMenuItem menuItemTest;
    private javax.swing.JMenuItem menuItemTextEncryptor;
    private javax.swing.JMenu menuShow;
    private javax.swing.JPanel panelRegisterCustomer;
    private javax.swing.JPanel panelTitle;
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
