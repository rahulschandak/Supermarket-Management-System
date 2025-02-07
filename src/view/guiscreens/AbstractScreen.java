package view.guiscreens;

import org.jdatepicker.impl.DateComponentFormatter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import java.awt.*;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import controller.Features;
import model.EmployeeWorkingHours;
import model.Product;

public abstract class AbstractScreen extends JFrame implements Screen {

  protected JButton jButtonBack;

  protected AbstractScreen(String caption, String back) {
    super(caption);
    this.jButtonBack = new JButton(back);
  }

  protected AbstractScreen(String caption) {
    super(caption);
    this.jButtonBack = new JButton("Back");
  }

  @Override
  public void disposeScreen() {
    this.dispose();
  }


  @Override
  public void bindListener(ActionListener listener) {
  }

  protected void onBack(Features features, Screen screen) {
    this.disposeScreen();
    screen.addFeatures(features);
  }

  protected Object[][] parseProducts(List<Product> orders) {

    var objects = new Object[orders.size()][5];
    for (int i = 0; i < orders.size(); i++) {
      var order = orders.get(i);
      var object = new Object[5];
      object[0] = order.id();
      object[1] = order.name();
      object[2] = order.quantity();
      object[3] = order.category();
      object[4] = order.price();
      objects[i] = object;
    }
    return objects;
  }

  protected LocalDate getLocalDate(JDatePickerImpl date) {
    Date dateFromPicker = (Date) date.getModel().getValue();
    LocalDate localDate = dateFromPicker.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    return localDate;
  }

  protected JSpinner createTimePicker() {
    JSpinner timeSpinner = new JSpinner(new SpinnerDateModel());
    JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(timeSpinner, "HH:mm:ss");
    timeSpinner.setEditor(timeEditor);
    return timeSpinner;
  }

  protected JDatePickerImpl createDateField(String tooltip) {
    Properties p = new Properties();
    p.put("text.today", "Today");
    p.put("text.month", "Month");
    p.put("text.year", "Year");
    UtilDateModel dateModel = new UtilDateModel();
    dateModel.setSelected(true);
    JDatePanelImpl datePanel = new JDatePanelImpl(dateModel, p);
    var datePicker = new JDatePickerImpl(datePanel, new DateComponentFormatter());
    datePicker.setToolTipText(tooltip);
    return datePicker;
  }

  protected Object[][] parseEmployeeHours(List<EmployeeWorkingHours> hours) {

    var logged = new Object[hours.size()][5];
    for (int i = 0; i < hours.size(); i++) {
      var hour = hours.get(i);
      var obj = new Object[5];
      obj[0] = hour.getID();
      obj[1] = hour.getName();
      obj[2] = hour.getWorkingDate();
      obj[3] = hour.getStartTime();
      obj[4] = hour.getEndTime();
      logged[i] = obj;
    }
    return logged;
  }


  protected void renderFrame() {
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setVisible(true);
  }

  protected void displayProducts(JTable productList, List<Product> products) {
    try {
      var objects = this.parseProducts(products);
      var tableModel = new DefaultTableModel(
              objects,
              new String[]{
                      "ID", "Name", "Quantity", "Category", "Price"
              }
      ) {
        @Override
        public boolean isCellEditable(int row, int column) {
          return false;
        }
      };
      this.setTable(productList, tableModel);
    } catch (Exception ex) {
      JOptionPane.showMessageDialog(this, ex.getMessage());
    }
  }

  protected void displayHours(JTable table, List<EmployeeWorkingHours> hours) {

    var parsed = this.parseEmployeeHours(hours);
    var tableModel = new DefaultTableModel(
            parsed,
            new String[]{
                    "ID", "Name", "Start Date", "Start Time", "End Time"
            }
    ) {
      public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
      }
    };
    this.setTable(table, tableModel);
  }

  protected void setTable(JTable table, DefaultTableModel model) {
    table.setModel(model);
  }

  protected boolean validateDOB(JDatePickerImpl datePicker) {
    var date = this.getLocalDate(datePicker);
    if (date.isAfter(LocalDate.now())) {
      return false;
    }
    return true;
  }
}


