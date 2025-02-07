package view.guiscreens;

import java.awt.event.ActionListener;

import controller.Features;

public interface Screen {

  void bindListener(ActionListener listener);

  void addFeatures(Features features);

  void disposeScreen();

}
