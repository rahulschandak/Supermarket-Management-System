package view.guiscreens;

import org.jdatepicker.impl.JDatePickerImpl;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

import controller.Features;
import model.EmployeeRole;

public class AdminStaff extends AbstractEmployeeScreen {

  private JLabel JLabelNewHireDate;
  private JLabel JLabelNewStaffName;
  private JLabel JLabelNewStaffPassword;
  private JLabel JLabelNewStaffRole;
  private JLabel JLabelNewStaffUsername;
  private JTextField newEmployeeUsername;
  private JButton jButtonAddMember;
  private JPanel jPanel1;
  private JPanel jPanel2;
  private JPanel jPanel3;
  private JPasswordField jPasswordField;
  private JComboBox<String> jRoleList;
  private JScrollPane jScrollPane1;
  private JScrollPane jScrollPane2;
  private JScrollPane jScrollPane3;
  private JScrollPane jScrollPane4;
  private JTable loggedHoursList;
  private JTextField newEmployeeName;
  private JDatePickerImpl newEmployeeHireDate;
  private JTabbedPane normalAdminTab;

  public AdminStaff(String username) {
    super(username, "Admin Employee Main Page");
    setSize(421, 518);
    normalAdminTab = new JTabbedPane();
    jScrollPane1 = new JScrollPane();
    jPanel1 = new JPanel();
    newEmployeeUsername = new JTextField();
    JLabelNewStaffName = new JLabel("Name");
    JLabelNewStaffRole = new JLabel("Role");
    newEmployeeHireDate = this.createDateField("Hire Date");
    newEmployeeName = new JTextField();
    JLabelNewHireDate = new JLabel("Hire Date");
    JLabelNewStaffUsername = new JLabel("Username");
    JLabelNewStaffPassword = new JLabel("Password");
    jButtonAddMember = new JButton("Add Staff");
    jRoleList = new JComboBox<>();
    jPasswordField = new JPasswordField();
    jScrollPane3 = new JScrollPane();
    jPanel3 = new JPanel();
    jScrollPane4 = new JScrollPane();
    loggedHoursList = new JTable();
    jScrollPane2 = new JScrollPane();
    jPanel2 = new JPanel();
    init();
    renderFrame();

  }

  private void init() {

    jRoleList.setModel(new DefaultComboBoxModel<>(new String[]{
            EmployeeRole.Regular.toString(), EmployeeRole.Admin.toString(),
            EmployeeRole.InventoryManager.toString()}));


    GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(27, 27, 27)
                            .addGroup(jPanel1Layout.createParallelGroup(
                                            GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(JLabelNewStaffName,
                                                    GroupLayout.PREFERRED_SIZE,
                                                    72, GroupLayout.PREFERRED_SIZE)
                                            .addGap(31, 31, 31)
                                            .addComponent(newEmployeeName,
                                                    GroupLayout.PREFERRED_SIZE,
                                                    198,
                                                    GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                    .addComponent(JLabelNewStaffUsername, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(JLabelNewStaffRole, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(JLabelNewHireDate, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE))
                                            .addGap(31, 31, 31)
                                            .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                    .addComponent(newEmployeeUsername, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(newEmployeeHireDate, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jRoleList, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(JLabelNewStaffPassword, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
                                            .addGap(31, 31, 31)
                                            .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                    .addComponent(jButtonAddMember, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jPasswordField))))
                            .addContainerGap(78, Short.MAX_VALUE))
    );
    jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(40, 40, 40)
                            .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(newEmployeeUsername, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JLabelNewStaffUsername))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(newEmployeeName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                    .addComponent(newEmployeeHireDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(JLabelNewHireDate))
                                            .addGap(18, 18, 18)
                                            .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                    .addComponent(JLabelNewStaffRole)
                                                    .addComponent(jRoleList, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                            .addGap(18, 18, 18)
                                            .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                    .addComponent(JLabelNewStaffPassword)
                                                    .addComponent(jPasswordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                            .addGap(18, 18, 18)
                                            .addComponent(jButtonAddMember))
                                    .addComponent(JLabelNewStaffName))
                            .addContainerGap(33, Short.MAX_VALUE))
    );

    jScrollPane1.setViewportView(jPanel1);
    normalAdminTab.addTab("Add Staff", jScrollPane1);
    jScrollPane4.setViewportView(loggedHoursList);

    GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
    jPanel3.setLayout(jPanel3Layout);
    jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addComponent(jScrollPane4, GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE))
    );
    jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jScrollPane4, GroupLayout.PREFERRED_SIZE, 402, GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, Short.MAX_VALUE))
    );

    jScrollPane3.setViewportView(jPanel3);

    normalAdminTab.addTab("Employee Working Hours", jScrollPane3);

    GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(47, 47, 47)
                            .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(JLabelDate, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JLabelLogInTime, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JLabelLogOutTime, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(logTime)
                                    .addComponent(jTextFieldLogOutTime, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldLogInTime, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JTextDate, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE))
                            .addGap(83, 83, 83))
    );
    jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(JTextDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JLabelDate))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextFieldLogInTime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JLabelLogInTime))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextFieldLogOutTime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JLabelLogOutTime))
                            .addGap(18, 18, 18)
                            .addComponent(logTime)
                            .addContainerGap(137, Short.MAX_VALUE))
    );

    jScrollPane2.setViewportView(jPanel2);

    normalAdminTab.addTab("Log Hours", jScrollPane2);


    GroupLayout layout = new GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                            .addComponent(jButtonBack, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 333, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(normalAdminTab, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                            .addComponent(screenTitle, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, Short.MAX_VALUE)))
                            .addContainerGap())
    );
    layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                            .addComponent(jButtonBack)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(screenTitle, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(normalAdminTab, GroupLayout.PREFERRED_SIZE, 334, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(33, Short.MAX_VALUE))
    );
  }

  @Override
  public void addFeatures(Features features) {
    super.addFeatures(features);
    var self = this;
    jButtonAddMember.addActionListener((e) -> addEmployee(features));
    normalAdminTab.addChangeListener(e ->displayHours(features));
  }

  private void addEmployee(Features features) {
    try {
      if(!validateWorkLogDate(this.newEmployeeHireDate)){
        JOptionPane.showMessageDialog(this, "Invalid Hire Date");
        return;
      }
      var username = newEmployeeUsername.getText();
      var name = newEmployeeName.getText();
      var hireDate = this.getLocalDate(this.newEmployeeHireDate);
      EmployeeRole role = EmployeeRole.valueOf(jRoleList.getSelectedItem().toString());
      String password = String.valueOf(jPasswordField.getPassword());
      features.addEmployee(username, name, hireDate, role, password);
      JOptionPane.showMessageDialog(this, "New employee has been added!");
    } catch (Exception ex) {
      JOptionPane.showMessageDialog(this, "Failed to add the new employee");
    }
    this.clearAfterAdd();
  }

  private void displayHours(Features features) {
    var selectedTab = normalAdminTab.getSelectedIndex();
    if (selectedTab != 1) {
      return;
    }
    try {
      var hours = features.loggedHours();
      this.displayHours(this.loggedHoursList, hours);
    } catch (Exception ex) {
      JOptionPane.showMessageDialog(this, "Failed to fetch the employee hours");
    }
  }

  private void clearAfterAdd() {
    this.newEmployeeUsername.setText("");
    this.newEmployeeName.setText("");
    this.jPasswordField.setText("");
  }

}
