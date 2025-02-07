package view.guiscreens;

import java.awt.*;

import javax.swing.*;

import controller.Features;

public class ConnectToDB extends AbstractScreen {

  private final JButton connect;
  private final JTextField username;
  private final JPasswordField password;
  public ConnectToDB() {
    super("Connect to Database");
    setSize(400,400);
    this.username = new JTextField();
    this.connect = new JButton("Connect to Database");
    this.password = new JPasswordField();

//    UIManager.put("Button.font", new Font("Times New Roman", Font.PLAIN, 15));
//    UIManager.put("Label.font", new Font("Times New Roman", Font.PLAIN, 15));
    this.init();
    this.renderFrame();

  }

  private void init() {
    var mainPageTitle = new JLabel("Supermarket Management System");
//    mainPageTitle.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N

    var jLabelDatabaseUsername = new JLabel("Database username");
    var jLabelDatabasePassword = new JLabel("Database password");

    GroupLayout layout = new GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                            .addGap(54, 54, 54)
                                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabelDatabaseUsername, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabelDatabasePassword, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE))
                                            .addGap(45, 45, 45)
                                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(this.username, GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                                                    .addComponent(this.password)))
                                    .addGroup(layout.createSequentialGroup()
                                            .addGap(108, 108, 108)
                                            .addComponent(this.connect))
                                    .addGroup(layout.createSequentialGroup()
                                            .addGap(42, 42, 42)
                                            .addComponent(mainPageTitle)))
                            .addContainerGap(76, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                            .addGap(43, 43, 43)
                            .addComponent(mainPageTitle)
                            .addGap(27, 27, 27)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabelDatabaseUsername)
                                    .addComponent(this.username, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabelDatabasePassword)
                                    .addComponent(this.password, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(30, 30, 30)
                            .addComponent(this.connect)
                            .addContainerGap(90, Short.MAX_VALUE))
    );

  }

  @Override
  public void addFeatures(Features features) {
    this.connect.addActionListener((e) -> this.run(features));
  }

  private void run(Features features) {
    try {
      features.connect(this.username.getText(), String.valueOf(password.getPassword()));
      JOptionPane.showMessageDialog(this, "Connected");
      this.disposeScreen();
      var frame = new LoginAsOption();
      frame.addFeatures(features);
    }
    catch (Exception ex) {
      JOptionPane.showMessageDialog(this, "Failed");
    }
  }

}
