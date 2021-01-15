package com.bms.utility;

import com.bms.database.account.AccountRepository;
import com.bms.database.customer.Customer;
import com.bms.database.customer.CustomerRepository;
import com.bms.database.employee.EmployeeRepository;
import com.sdk.database.DBRepository;
import java.util.HashMap;
import java.util.Map;

import com.sdk.database.MySQLConnection;
import com.sdk.datatypes.Numbers;
import com.sdk.datatypes.Strings;
import com.sdk.environment.SwingUI;
import com.sdk.security.Security;
import java.awt.Color;
import java.sql.Connection;
import java.util.Objects;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class Utils {

    public static Map<String, String> envs;

    public static Connection connection;
    public static SwingUI swingUI;
    public static DBRepository dBRepository;

    public static String publicAskItem;
    public static Strings strings;
    public static Numbers numbers;
    public static Settings settings;

    public static boolean created;
    public static boolean login;

    public static final String[] CUSTOMER_COLUMNS = {"ID", "Name", "Mobile", "National code", "Date"};
    public static final String[] ACCOUNT_COLUMNS = {"ID", "Foreign ID", "Account number", "Money"};
    public static final String[] EMPLOYEE_COLUMNS = {"ID", "Name", "Mobile", "National code", "Date"};
    public static final String[] TRANSACTION_COLUMNS = {"ID", "Foreign ID", "Source account number", "Destination account number", "Date"};
    public static final String[] LOGS_COLUMNS = {"ID", "Foreign ID", "Enter date", "Exit date"};
    public static final String[] USERS_COLUMNS = {"ID", "Username", "Password", "Date"};
    public static final String[] LOANS_COLUMNS = {"ID", "Foreign ID", "Amount", "Start date", "End date"};

    private static CustomerRepository customerRepository;
    private static AccountRepository accountRepository;
    private static EmployeeRepository employeeRepository;

    static {
        envs = new HashMap<>();
        swingUI = new SwingUI();

        customerRepository = new CustomerRepository();
        accountRepository = new AccountRepository();
        employeeRepository = new EmployeeRepository();

        strings = new Strings();
        numbers = new Numbers();
    }

    public static String generateCustomerPassword(JLabel label) {
        try {
            String password = String.valueOf(numbers.generateRandom(10000000, 99000000));

            if (customerRepository.exist("pass", Security.encrypt(envs.get("encKey"), password), "") == 1) {
                while (customerRepository.exist("pass", Security.encrypt(envs.get("encKey"), password), "") != 0) {
                    password = String.valueOf(numbers.generateRandom(10000000, 99000000));
                }
            }

            if (!Objects.isNull(label)) {
                label.setText("Password: " + password);
            }

            return password;
        } catch (Exception e) {
            swingUI.showErrorDialog("Unable to generate new password.", "Password generation failed");
            return strings.getEmptyString();
        }
    }

    public static String generateEmployeePassword(JLabel label) {
        try {
            String password = String.valueOf(numbers.generateRandom(10000000, 99000000));

            if (employeeRepository.exist("pass", Security.encrypt(envs.get("encKey"), password), "") == 1) {
                while (employeeRepository.exist("pass", Security.encrypt(envs.get("encKey"), password), "") != 0) {
                    password = String.valueOf(numbers.generateRandom(10000000, 99000000));
                }
            }

            if (!Objects.isNull(label)) {
                label.setText("Password: " + password);
            }

            return password;
        } catch (Exception e) {
            swingUI.showErrorDialog("Unable to generate new password.", "Password generation failed");
            return strings.getEmptyString();
        }
    }

//    public static String generateUserID(JLabel label) {
//        try {
//            String id = String.valueOf(numbers.generateRandom(10000000, 99000000));
//
//            if (customerRepository.userIDExist(id) == 1 || employeeRepository.userIDExist(id) == 1) {
//                while (employeeRepository.userIDExist(id) != 0 && customerRepository.userIDExist(id) != 0) {
//                    id = String.valueOf(numbers.generateRandom(10000000, 99000000));
//                }
//            }
//
//            if (!Objects.isNull(label)) {
//                label.setText("User ID: " + id);
//            }
//
//            return id;
//        } catch (Exception e) {
//            swingUI.showErrorDialog("Unable to generate new user id.", "User ID generation failed");
//            return strings.getEmptyString();
//        }
//    }
    public static String generateAccountNumber(JLabel label) {
        try {
            String acn = String.valueOf(numbers.generateRandom(10000000000L, 99000000000L));

            if (accountRepository.exist("acn", acn, "") == 1) {
                while (accountRepository.exist("acn", acn, "") != 0) {
                    acn = String.valueOf(numbers.generateRandom(10000000000L, 99000000000L));
                }
            }

            if (!Objects.isNull(label)) {
                label.setText("Account number: " + acn);
            }

            return acn;
        } catch (Exception e) {
            swingUI.showErrorDialog("Unable to generate new account number.", "Account number generation failed");
            return strings.getEmptyString();
        }
    }
}
