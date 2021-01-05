package com.bms.utility;

import com.bms.database.account.AccountRepository;
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
import java.sql.Connection;
import java.util.Objects;
import javax.swing.JLabel;

public class Utils {

    public static Map<String, String> envs;
    public static Connection connection;
    public static SwingUI swingUI;
    public static DBRepository dBRepository;
    public final static String ENCRYPT_KEY = "23549918?*";

    public static String publicAskItem;
    public static Strings strings;
    public static Numbers numbers;

    public static boolean created;
    public static boolean login;

    private static CustomerRepository customerRepository;
    private static AccountRepository accountRepository;
    private static EmployeeRepository employeeRepository;

    static {
        envs = new HashMap<String, String>();
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

            if (customerRepository.passwordExist(Security.encrypt(Utils.ENCRYPT_KEY, password)) == 1) {
                while (customerRepository.passwordExist(Security.encrypt(Utils.ENCRYPT_KEY, password)) != 0) {
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

            if (employeeRepository.passwordExist(Security.encrypt(Utils.ENCRYPT_KEY, password)) == 1) {
                while (employeeRepository.passwordExist(Security.encrypt(Utils.ENCRYPT_KEY, password)) != 0) {
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

    public static String generateUserID(JLabel label) {
        try {
            String id = String.valueOf(numbers.generateRandom(10000000, 99000000));

            if (customerRepository.userIDExist(id) == 1 || employeeRepository.userIDExist(id) == 1) {
                while (employeeRepository.userIDExist(id) != 0 && customerRepository.userIDExist(id) != 0) {
                    id = String.valueOf(numbers.generateRandom(10000000, 99000000));
                }
            }

            if (!Objects.isNull(label)) {
                label.setText("User ID: " + id);
            }

            return id;
        } catch (Exception e) {
            swingUI.showErrorDialog("Unable to generate new user id.", "User ID generation failed");
            return strings.getEmptyString();
        }
    }

    public static String generateAccountNumber(JLabel label) {
        try {
            String acn = String.valueOf(numbers.generateRandom(10000000000L, 99000000000L));

            if (accountRepository.accountExist(acn) == 1) {
                while (accountRepository.accountExist(acn) != 0) {
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
