import controller.Controller;
import controller.Features;
import view.GUIView;
import view.View;

public class Main {
  public static void main(String[] args) throws Exception {
    View view = new GUIView();
    Features controller = new Controller(view);
    //new CustomerMainPage("userJohn");
  }


}