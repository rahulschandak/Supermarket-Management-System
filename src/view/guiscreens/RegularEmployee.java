package view.guiscreens;

import java.awt.*;

import javax.swing.*;

public class RegularEmployee extends AbstractEmployeeScreen {

  public RegularEmployee(String username) {
    super(username, "Employee - Main Page");
    init();
    this.renderFrame();
  }

  private void init() {
    GroupLayout layout = new GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                            .addGap(44, 44, 44)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(JLabelLogOutTime, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                            .addGap(151, 284, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                    .addComponent(screenTitle, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(layout.createSequentialGroup()
                                                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                    .addComponent(JLabelDate, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
                                                                    .addComponent(JLabelLogInTime, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
                                                            .addGap(61, 61, 61)
                                                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                    .addComponent(jTextFieldLogInTime, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                                                    .addComponent(JTextDate, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
                                                                    .addComponent(jTextFieldLogOutTime, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE))))
                                            .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(jButtonBack, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                            .addGap(148, 148, 148)
                                            .addComponent(logTime)))
                            .addGap(0, 0, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jButtonBack)
                            .addGap(18, 18, 18)
                            .addComponent(screenTitle, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                            .addComponent(JLabelDate)
                                            .addGap(30, 30, 30)
                                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                    .addComponent(JLabelLogInTime)
                                                    .addComponent(jTextFieldLogInTime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                            .addGap(24, 24, 24)
                                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                    .addComponent(JLabelLogOutTime)
                                                    .addComponent(jTextFieldLogOutTime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(JTextDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                            .addComponent(logTime)
                            .addGap(30, 30, 30))
    );
  }


}
