package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;

import controller.Features;
import view.guiscreens.ConnectToDB;
import view.guiscreens.CustomerLogin;
import view.guiscreens.Screen;

public class GUIView implements View, ActionListener {

  private Screen current;

  private final Map<String, Runnable> commands;
  private Features features;

  public GUIView() {
    this.commands = this.getCommands();
    this.current = new ConnectToDB();
    this.current.bindListener(this);
    setFont(new FontUIResource(new Font("Calibri", Font.PLAIN, 15)));

  }

  @Override
  public void addFeatures(Features features) {
    this.features = features;
    this.current.addFeatures(features);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    var actionCommand = e.getActionCommand();
    this.commands.get(actionCommand).run();
  }

  private Map<String, Runnable> getCommands() {
    var self = this;
    var commands = new HashMap<String, Runnable>();
    commands.put("Log out", () -> {
      this.current.disposeScreen();
      this.current = new CustomerLogin();
      this.current.addFeatures(self.features);
      this.current.bindListener(self);
    });
    commands.put("Connect to Database", () -> {
      this.current.disposeScreen();
      this.current = new ConnectToDB();
      this.current.addFeatures(self.features);
      this.current.bindListener(self);
    });
    return commands;
  }

  private void setFont(FontUIResource myFont) {
    UIManager.put("CheckBoxMenuItem.acceleratorFont", myFont);
    UIManager.put("Button.font", myFont);
    UIManager.put("ToggleButton.font", myFont);
    UIManager.put("RadioButton.font", myFont);
    UIManager.put("CheckBox.font", myFont);
    UIManager.put("ColorChooser.font", myFont);
    UIManager.put("ComboBox.font", myFont);
    UIManager.put("Label.font", myFont);
    UIManager.put("List.font", myFont);
    UIManager.put("MenuBar.font", myFont);
    UIManager.put("Menu.acceleratorFont", myFont);
    UIManager.put("RadioButtonMenuItem.acceleratorFont", myFont);
    UIManager.put("MenuItem.acceleratorFont", myFont);
    UIManager.put("MenuItem.font", myFont);
    UIManager.put("RadioButtonMenuItem.font", myFont);
    UIManager.put("CheckBoxMenuItem.font", myFont);
    UIManager.put("OptionPane.buttonFont", myFont);
    UIManager.put("OptionPane.messageFont", myFont);
    UIManager.put("Menu.font", myFont);
    UIManager.put("PopupMenu.font", myFont);
    UIManager.put("OptionPane.font", myFont);
    UIManager.put("Panel.font", myFont);
    UIManager.put("ProgressBar.font", myFont);
    UIManager.put("ScrollPane.font", myFont);
    UIManager.put("Viewport.font", myFont);
    UIManager.put("TabbedPane.font", myFont);
    UIManager.put("Slider.font", myFont);
    UIManager.put("Table.font", myFont);
    UIManager.put("TableHeader.font", myFont);
    UIManager.put("TextField.font", myFont);
    UIManager.put("Spinner.font", myFont);
    UIManager.put("PasswordField.font", myFont);
    UIManager.put("TextArea.font", myFont);
    UIManager.put("TextPane.font", myFont);
    UIManager.put("EditorPane.font", myFont);
    UIManager.put("TabbedPane.smallFont", myFont);
    UIManager.put("TitledBorder.font", myFont);
    UIManager.put("ToolBar.font", myFont);
    UIManager.put("ToolTip.font", myFont);
    UIManager.put("Tree.font", myFont);
    UIManager.put("FormattedTextField.font", myFont);
    UIManager.put("IconButton.font", myFont);
    UIManager.put("InternalFrame.optionDialogTitleFont", myFont);
    UIManager.put("InternalFrame.paletteTitleFont", myFont);
    UIManager.put("InternalFrame.titleFont", myFont);
  }

}