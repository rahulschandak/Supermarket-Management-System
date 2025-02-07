package view.guiscreens;

import org.jdatepicker.impl.JDatePickerImpl;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

import controller.Features;

public class CustomerLogin extends AbstractScreen {



  // Sign in
  private final JButton signInSubmit;
  private final JButton signInClear;
  private final JTextField signInUsername;
  private final JPasswordField signInPassword;

  // Sign up
  private final JButton signUpSubmit;
  private final JButton signUpClear;
  private final JTextField firstName;
  private final JTextField lastName;
  private final JDatePickerImpl dob;
  private final JTextField signUpUsername;
  private final JPasswordField signUpPassword;


  private ActionListener back;

  public CustomerLogin() {
    super("Customer Login/Sign Up Page");
    setSize(390,574);
    // sign in
    this.signInUsername = new JTextField();
    this.signInPassword = new JPasswordField();
    this.signInSubmit = new JButton("Log in");
    this.signInClear = new JButton("Clear");
    // sign up
    this.signUpUsername = new JTextField();
    this.firstName = new JTextField();
    this.lastName = new JTextField();
    this.dob = this.createDateField("");
    this.signUpPassword = new JPasswordField();
    this.signUpSubmit = new JButton("Submit");
    this.signUpClear = new JButton("Clear");

    init();
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setVisible(true);
  }

  private void init() {

    var customerTabs = new javax.swing.JTabbedPane();
    var signUpScroll = new javax.swing.JScrollPane();
    var paneSignUp = new javax.swing.JPanel();
    var firstNameLabel = new JLabel("First Name");
    var lastNameLabel = new JLabel("Last Name");
    var jLabelDOB = new javax.swing.JLabel("Date of Birth");
    var jLabelUsername = new javax.swing.JLabel("Username");
    var jLabelPassword = new javax.swing.JLabel("Password");
    var jScrollPane2 = new javax.swing.JScrollPane();
    var panelLogin = new javax.swing.JPanel();
    var JLabelCustomerLoginUsername = new javax.swing.JLabel("Username");
    var JLabelCustomerLoginPassword = new javax.swing.JLabel("Password");
    var customerLoginPageTitle = new javax.swing.JLabel("Customer Login Page");
//    customerLoginPageTitle.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
    customerLoginPageTitle.setBorder(BorderFactory.createCompoundBorder());
    javax.swing.GroupLayout paneSignUpLayout = new javax.swing.GroupLayout(paneSignUp);
    paneSignUp.setLayout(paneSignUpLayout);
    paneSignUpLayout.setHorizontalGroup(
            paneSignUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneSignUpLayout.createSequentialGroup()
                            .addGap(13, 13, 13)
                            .addGroup(paneSignUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(paneSignUpLayout.createSequentialGroup()
                                            .addGroup(paneSignUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jLabelDOB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabelUsername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabelPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(paneSignUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(this.signUpPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(paneSignUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                            .addComponent(this.dob, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(this.signUpUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneSignUpLayout.createSequentialGroup()
                                            .addGroup(paneSignUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(firstNameLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(lastNameLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGap(0, 60, Short.MAX_VALUE)
                                            .addGroup(paneSignUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(this.lastName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(this.firstName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(68, 68, 68))
                                    .addGroup(paneSignUpLayout.createSequentialGroup()
                                            .addGap(49, 49, 49)
                                            .addComponent(this.signUpSubmit)
                                            .addGap(45, 45, 45)
                                            .addComponent(this.signUpClear)
                                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
    );
    paneSignUpLayout.setVerticalGroup(
            paneSignUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneSignUpLayout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addGroup(paneSignUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabelUsername)
                                    .addComponent(this.signUpUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(paneSignUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(firstNameLabel)
                                    .addComponent(this.firstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(paneSignUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lastNameLabel)
                                    .addComponent(this.lastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(paneSignUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabelDOB)
                                    .addComponent(this.dob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(paneSignUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabelPassword)
                                    .addComponent(this.signUpPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(21, 21, 21)
                            .addGroup(paneSignUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(this.signUpClear)
                                    .addComponent(this.signUpSubmit))
                            .addContainerGap(28, Short.MAX_VALUE))
    );
    signUpScroll.setViewportView(paneSignUp);
    customerTabs.addTab("Sign up", signUpScroll);

    javax.swing.GroupLayout panelLoginLayout = new javax.swing.GroupLayout(panelLogin);
    panelLogin.setLayout(panelLoginLayout);
    panelLoginLayout.setHorizontalGroup(
            panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLoginLayout.createSequentialGroup()
                            .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelLoginLayout.createSequentialGroup()
                                            .addGap(28, 28, 28)
                                            .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(JLabelCustomerLoginUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(JLabelCustomerLoginPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(this.signInUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(this.signInPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(panelLoginLayout.createSequentialGroup()
                                            .addGap(85, 85, 85)
                                            .addComponent(signInSubmit)
                                            .addGap(58, 58, 58)
                                            .addComponent(signInClear)))
                            .addContainerGap())
    );
    panelLoginLayout.setVerticalGroup(
            panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLoginLayout.createSequentialGroup()
                            .addGap(26, 26, 26)
                            .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(this.signInUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JLabelCustomerLoginUsername))
                            .addGap(26, 26, 26)
                            .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(JLabelCustomerLoginPassword)
                                    .addComponent(this.signInPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(30, 30, 30)
                            .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(signInSubmit)
                                    .addComponent(signInClear))
                            .addGap(0, 233, Short.MAX_VALUE))
    );

    jScrollPane2.setViewportView(panelLogin);

    customerTabs.addTab("Login Form", jScrollPane2);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                            .addComponent(jButtonBack, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                            .addGap(164, 164, 164)
                            .addComponent(customerLoginPageTitle,
                                    javax.swing.GroupLayout.PREFERRED_SIZE, 188,
                                    javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                            layout.createSequentialGroup()
                            .addContainerGap(64, Short.MAX_VALUE)
                            .addComponent(customerTabs, javax.swing.GroupLayout.PREFERRED_SIZE,
                                    383, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, Short.MAX_VALUE))

    );
    layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(this.jButtonBack)
                            .addContainerGap(104, Short.MAX_VALUE)
                            .addComponent(customerLoginPageTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(customerTabs, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(24, Short.MAX_VALUE))

    );

  }

  @Override
  public void bindListener(ActionListener listener) {
    this.back = listener;
  }

  @Override
  public void addFeatures(Features features) {
    var self = this;
    this.jButtonBack.addActionListener((e) -> onBack(features, new LoginAsOption()));
    this.signUpSubmit.addActionListener((e) -> register(features));
    this.signUpClear.addActionListener((e) -> clear());
    this.signInSubmit.addActionListener((e) -> signIn(features));
    this.signInClear.addActionListener((e) -> clear());
  }





  private void register(Features features) {
    try {
      var username = this.signUpUsername.getText();
      var firstName = this.firstName.getText();
      var lastName = this.lastName.getText();
      var date = this.getLocalDate(this.dob);
      var password = String.valueOf(this.signUpPassword.getPassword());
      if(!validateDOB(this.dob)) {
        JOptionPane.showMessageDialog(this, "Invalid Date of Birth\n");
        return;
      }
      features.register(username,firstName, lastName, date, password);
      this.clear();
      JOptionPane.showMessageDialog(this, "User registered successfully!\n" +
              "You may login now to place new orders");

    }
    catch (Exception ex) {
      JOptionPane.showMessageDialog(this, "User registration failed!");
      clear();
    }
  }

  private void signIn(Features features) {
    try {
      var username = this.signInUsername.getText();
      var password = String.valueOf(this.signInPassword.getPassword());
      var isValid = features.authenticateCustomer(username, password);
      if(!isValid) {
        JOptionPane.showMessageDialog(this, "You have entered an incorrect username/password.\nPlease try again");
        clear();
        return;
      }
      JOptionPane.showMessageDialog(this, "User logged in!");
      this.onBack(features, new CustomerMainPage(username));
    }
    catch (Exception ex) {
      JOptionPane.showMessageDialog(this, "User logged in failed!");
      clear();
    }
  }

  private void clear() {
    this.firstName.setText("");
    this.lastName.setText("");
    this.signUpUsername.setText("");
    this.signUpPassword.setText("");

    this.signInUsername.setText("");
    this.signInPassword.setText("");
  }
}
