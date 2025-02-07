package view.guiscreens;

import java.awt.*;

import javax.swing.*;

import controller.Features;
import model.EmployeeRole;

public class EmployeeLogin extends AbstractScreen {

  private JLabel JLabelEmployeeLoginPassword;
  private JLabel JLabelEmployeeLoginUsername;
  private JTextField JTextEmployeeLoginText;
  private JLabel employeeLoginPageTitle;
  private JButton jButtonEmployeeLoginClear;
  private JButton jButtonEmployeeLoginSubmit;
  private JPasswordField jTextFieldEmployeeLoginPassword;

  public EmployeeLogin() {
    super("Employee Login Page");
    setSize(400,400);
    employeeLoginPageTitle = new JLabel("Employee Login Page");
//    employeeLoginPageTitle.setFont(new java.awt.Font("Times New Roman", 0, 16));
    JLabelEmployeeLoginUsername = new JLabel("Username");
    JTextEmployeeLoginText = new JTextField();
    JLabelEmployeeLoginPassword = new JLabel("Password");
    jTextFieldEmployeeLoginPassword = new JPasswordField();
    jButtonEmployeeLoginSubmit = new JButton("Submit");
    jButtonEmployeeLoginClear = new JButton("Clear");
//    UIManager.put("Button.font", new Font("Times New Roman", Font.PLAIN, 15));
//    UIManager.put("Label.font", new Font("Times New Roman", Font.PLAIN, 15));
    init();
    this.renderFrame();
  }

  private void init() {
    employeeLoginPageTitle.setBorder(BorderFactory.createCompoundBorder());
    GroupLayout layout = new GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                            .addContainerGap(44, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(JLabelEmployeeLoginUsername, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JLabelEmployeeLoginPassword, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonEmployeeLoginSubmit))
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                            .addGap(45, 45, 45)
                                            .addComponent(jButtonEmployeeLoginClear))
                                    .addGroup(layout.createSequentialGroup()
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                    .addComponent(JTextEmployeeLoginText, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jTextFieldEmployeeLoginPassword, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE))))
                            .addGap(38, 38, 38))
                    .addGroup(layout.createSequentialGroup()
                            .addComponent(jButtonBack, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(employeeLoginPageTitle, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                            .addGap(12, 12, 12)
                                            .addComponent(employeeLoginPageTitle, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jButtonBack))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(JTextEmployeeLoginText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JLabelEmployeeLoginUsername))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextFieldEmployeeLoginPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JLabelEmployeeLoginPassword))
                            .addGap(28, 28, 28)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButtonEmployeeLoginClear)
                                    .addComponent(jButtonEmployeeLoginSubmit))
                            .addContainerGap(114, Short.MAX_VALUE))
    );
  }

  @Override
  public void addFeatures(Features features) {
    var self = this;
    jButtonEmployeeLoginSubmit.addActionListener((e) -> onLogin(features));
    this.jButtonBack.addActionListener((e) -> onBack(features, new LoginAsOption()));
  }

  private void onLogin(Features features) {
    try{
      var username = JTextEmployeeLoginText.getText();
      var password = String.valueOf(jTextFieldEmployeeLoginPassword.getPassword());
      var isValidEmployee = features.authenticateEmployee(username, password);
      if(!isValidEmployee) {
        JOptionPane.showMessageDialog(this,
                "You have entered invalid username/password.\nPlease try again");
        return;
      }
      JOptionPane.showMessageDialog(this, "Employee logged in!");
      var employeeRole = features.getEmployeeRole(username);
      Screen frame = this.getEmployeeScreen(employeeRole, username);
      frame.addFeatures(features);
      this.disposeScreen();

    }
    catch (Exception e) {
      JOptionPane.showMessageDialog(this,
              "Employee login failed!");
    }

  }

  private Screen getEmployeeScreen(EmployeeRole role, String username) {
    switch (role) {
      case Regular :
        return new RegularEmployee(username);
      case InventoryManager :
        return new InventoryManager(username);
      case Admin :
        return new AdminStaff(username);
    }
    return null;
  }
}
