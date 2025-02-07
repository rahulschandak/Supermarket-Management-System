package view.guiscreens;

import java.awt.*;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;

import controller.Features;

public class LoginAsOption extends AbstractScreen {

  private ButtonGroup buttonGroup1;
  private final JButton jButtonType;
  private final JLabel jLabelCustomerOrEmp;
  private final JRadioButton jRadioButtonCustomer;
  private final JRadioButton jRadioButtonEmployee;
  private javax.swing.JComboBox<String> jComboBox1;
  private javax.swing.JLabel supermarketLabel;

  public LoginAsOption() {
    super("Supermarket System - Login/Sign up Options");
    setSize(340,401);

    buttonGroup1 = new ButtonGroup();
    jButtonType = new JButton("Submit");
    jRadioButtonCustomer = new JRadioButton("Customer");
    jRadioButtonEmployee = new JRadioButton("Employee");
    jLabelCustomerOrEmp = new JLabel("Select the login option");
    jButtonBack = new JButton("Back");
    jComboBox1 = new javax.swing.JComboBox<>();
    jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Supermarket1" }));
    supermarketLabel = new javax.swing.JLabel("Select the supermarket to order from");
    buttonGroup1.add(jRadioButtonCustomer);
    buttonGroup1.add(jRadioButtonEmployee);

    init();
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setVisible(true);

  }

  private void init() {


    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButtonBack, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                            .addGap(123, 123, 123)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jRadioButtonEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jButtonType, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jRadioButtonCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                            .addGap(41, 41, 41)
                                            .addComponent(supermarketLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                            .addGap(98, 98, 98)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabelCustomerOrEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addContainerGap(60, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jButtonBack)
                            .addGap(20, 20, 20)
                            .addComponent(supermarketLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                            .addComponent(jLabelCustomerOrEmp)
                            .addGap(18, 18, 18)
                            .addComponent(jRadioButtonCustomer)
                            .addGap(18, 18, 18)
                            .addComponent(jRadioButtonEmployee)
                            .addGap(18, 18, 18)
                            .addComponent(jButtonType)
                            .addGap(40, 40, 40))
    );
  }


  @Override
  public void addFeatures(Features features) {
    var self = this;
    this.jButtonBack.addActionListener((e) -> onBack(features, new ConnectToDB()));
    this.jButtonType.addActionListener((e) -> {
      if(this.jRadioButtonCustomer.isSelected()) {
        onBack(features, new CustomerLogin());
      }
      else if(this.jRadioButtonEmployee.isSelected()) {
        onBack(features, new EmployeeLogin());
      }
    });
  }

}
