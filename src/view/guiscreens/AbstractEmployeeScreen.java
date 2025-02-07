package view.guiscreens;

import org.jdatepicker.impl.JDatePickerImpl;

import java.sql.Time;
import java.time.DayOfWeek;
import java.time.LocalDate;

import javax.swing.*;

import controller.Features;

public abstract class AbstractEmployeeScreen extends AbstractScreen {

  protected final String username;
  protected final JLabel JLabelDate;
  protected final JLabel JLabelLogInTime;
  protected final JLabel JLabelLogOutTime;
  protected final JDatePickerImpl JTextDate;
  protected final JButton logTime;
  protected final JSpinner jTextFieldLogInTime;
  protected final JSpinner jTextFieldLogOutTime;
  protected final JLabel screenTitle;

  protected AbstractEmployeeScreen(String username, String caption) {
    super(caption, "Logout");
    setSize(405,350);
    this.username = username;
    JLabelDate = new JLabel("Date");
    JTextDate = this.createDateField("Enter the date");
    JLabelLogInTime = new JLabel("Log in Time");
    jTextFieldLogInTime = this.createTimePicker();
    JLabelLogOutTime = new JLabel("Log out Time");
    jTextFieldLogOutTime = this.createTimePicker();
    logTime = new JButton("Submit");
    screenTitle = new JLabel("Welcome " + username );
//    screenTitle.setFont(new java.awt.Font("Calibri", 0, 15)); // NOI18N
    screenTitle.setBorder(BorderFactory.createCompoundBorder());
    this.renderFrame();
  }

  @Override
  public void addFeatures(Features features) {
    this.jButtonBack.addActionListener((e) -> onBack(features, new EmployeeLogin()));
    logTime.addActionListener((e) -> {
      if(!validateWorkLogDate(this.JTextDate)){
        JOptionPane.showMessageDialog(this, "Invalid date for logging hours");
        return;
      }
      try {
        var loginTime = new Time(((java.util.Date)jTextFieldLogInTime.getValue()).getTime());
        var logoutTime = new Time(((java.util.Date)jTextFieldLogOutTime.getValue()).getTime());
        features.logTime(this.username,
                this.getLocalDate(this.JTextDate),
                loginTime,
                logoutTime);
        JOptionPane.showMessageDialog(this, "Your working hours for the day has been logged!");

      }
      catch (Exception ex) {
        JOptionPane.showMessageDialog(this, "Your working hours could not be saved");
      }
    });
  }

  protected boolean validateWorkLogDate(JDatePickerImpl datePicker) {
    var date = this.getLocalDate(datePicker);
    var dayOfWeek = date.getDayOfWeek();
    if(date.isAfter(LocalDate.now())) {
      return false;
    }
    else if(dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY) {
      return false;
    }
    return true;
  }

}
