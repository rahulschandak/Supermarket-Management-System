package view.guiscreens;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

import controller.Features;
import model.Product;

public class CustomerMainPage extends AbstractScreen {

  private final String username;
  private JLabel JLabelSpecificOrderID;
  private JLabel JLabelUpdateOrderID;
  private JComboBox<Integer> JTextSpecificOrderID;
  private JComboBox<Integer> JTextUpdateOrderID;
  private JTabbedPane customerTabs;
  private JButton jButtonAddToCart;
  private JButton jButtonCreateCart;
  private JButton jButtonClearCart;
  private JButton jButtonSpecificClear;
  private JButton jButtonSpecificSubmit;
  private JButton jButtonUpdateClear;
  private JButton jButtonUpdateSubmit;
  private JButton jButtonUpdateSave;

  private JLabel jLabelItemName;
  private JLabel jLabelNumOfItems;
  private JLabel jLabelTitle;
  private JScrollPane jScrollPane1;
  private JScrollPane jScrollPane2;
  private JScrollPane jScrollPane3;
  private JScrollPane jScrollPane4;
  private JScrollPane jScrollPane5;
  private JScrollPane jScrollPane6;
  private JScrollPane jScrollPane7;
  private JScrollPane jScrollPane8;
  private JScrollPane jScrollPane9;
  private JTable jTableCart;
  private JTable jTableItemList;
  private JComboBox<Integer> jTextItemName;
  private JSpinner jTextNumOfItems;
  private JPanel newOrder;
  private JTable orderDetailsTable;
  private JPanel orderHistory;
  private JTable orderHistoryTable;
  private JTable orderUpdateScreen;
  private JPanel specificOrder;
  private JPanel updateOrder;

  private List<Product> cartItems;

  public CustomerMainPage(String username) {
    super("Main Menu - Customer", "Logout");
    setSize(600, 600);
    this.username = username;
    this.cartItems = new ArrayList<>();
    init();
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setVisible(true);
//    UIManager.put("Button.font", new Font("Times New Roman", Font.PLAIN, 15));
//    UIManager.put("Label.font", new Font("Times New Roman", Font.PLAIN, 15));
  }

  private void init() {


    customerTabs = new JTabbedPane();
    jScrollPane6 = new JScrollPane();
    newOrder = new JPanel();
    jLabelItemName = new JLabel("Product ID");
    jTextItemName = new JComboBox<Integer>();
    jLabelNumOfItems = new JLabel("Enter quantity");
    jTextNumOfItems = new JSpinner();
    jButtonAddToCart = new JButton("Add");
    jScrollPane1 = new JScrollPane();
    jTableItemList = new JTable();
    jScrollPane5 = new JScrollPane();
    jTableCart = new JTable();
    jButtonCreateCart = new JButton("Place");
    jButtonClearCart = new JButton("Clear");
    jScrollPane7 = new JScrollPane();
    orderHistory = new JPanel();
    jScrollPane2 = new JScrollPane();
    orderHistoryTable = new JTable();
    jScrollPane8 = new JScrollPane();
    specificOrder = new JPanel();
    JTextSpecificOrderID = new JComboBox<Integer>();
    jButtonSpecificSubmit = new JButton("Submit");
    JLabelSpecificOrderID = new JLabel("Order ID");
    jButtonSpecificClear = new JButton("Clear");
    jScrollPane3 = new JScrollPane();
    orderDetailsTable = new JTable();
    jScrollPane9 = new JScrollPane();
    updateOrder = new JPanel();
    JLabelUpdateOrderID = new JLabel("Order ID");
    JTextUpdateOrderID = new JComboBox<Integer>();
    jButtonUpdateSubmit = new JButton("Submit");
    jButtonUpdateClear = new JButton("Clear");
    jScrollPane4 = new JScrollPane();
    jButtonUpdateSave = new JButton("Save");
    orderUpdateScreen = new JTable();
    jLabelTitle = new JLabel("Welcome");
    jLabelTitle.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

    jScrollPane1.setViewportView(jTableItemList);
    jScrollPane5.setViewportView(jTableCart);

    GroupLayout newOrderLayout = new GroupLayout(newOrder);
    newOrder.setLayout(newOrderLayout);
    newOrderLayout.setHorizontalGroup(
            newOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(newOrderLayout.createSequentialGroup()
                            .addGap(32, 32, 32)
                            .addGroup(newOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(newOrderLayout.createSequentialGroup()
                                            .addGroup(newOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addGroup(newOrderLayout.createSequentialGroup()
                                                            .addGroup(newOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                    .addComponent(jLabelNumOfItems, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addComponent(jLabelItemName, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                            .addGap(64, 64, 64))
                                                    .addGroup(newOrderLayout.createSequentialGroup()
                                                            .addGroup(newOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                    .addComponent(jTextNumOfItems, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addComponent(jTextItemName, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                            .addGap(15, 15, 15))
                                                    .addGroup(newOrderLayout.createSequentialGroup()
                                                            .addComponent(jButtonAddToCart, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addGap(18, 18, 18)))
                                            .addGroup(newOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jButtonClearCart, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addContainerGap(31, Short.MAX_VALUE))
                    .addGroup(newOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, newOrderLayout.createSequentialGroup()
                                    .addContainerGap(362, Short.MAX_VALUE)
                                    .addComponent(jButtonCreateCart, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(21, 21, 21)))
    );
    newOrderLayout.setVerticalGroup(
            newOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, newOrderLayout.createSequentialGroup()
                            .addGap(27, 27, 27)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addGroup(newOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(newOrderLayout.createSequentialGroup()
                                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(newOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jButtonClearCart)
                                                    .addComponent(jButtonAddToCart))
                                            .addContainerGap())
                                    .addGroup(newOrderLayout.createSequentialGroup()
                                            .addGap(0, 25, Short.MAX_VALUE)
                                            .addGroup(newOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jLabelItemName)
                                                    .addComponent(jTextItemName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(18, 18, 18)
                                            .addGroup(newOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jTextNumOfItems, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabelNumOfItems))
                                            .addGap(64, 64, 64))))
                    .addGroup(newOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, newOrderLayout.createSequentialGroup()
                                    .addContainerGap(389, Short.MAX_VALUE)
                                    .addComponent(jButtonCreateCart)
                                    .addGap(8, 8, 8)))
    );

    jScrollPane6.setViewportView(newOrder);
    customerTabs.addTab("Add Order", jScrollPane6);
    jScrollPane2.setViewportView(orderHistoryTable);
    orderHistoryTable.getAccessibleContext().setAccessibleName("");

    GroupLayout orderHistoryLayout = new GroupLayout(orderHistory);
    orderHistory.setLayout(orderHistoryLayout);
    orderHistoryLayout.setHorizontalGroup(
            orderHistoryLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, orderHistoryLayout.createSequentialGroup()
                            .addContainerGap(28, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 428, GroupLayout.PREFERRED_SIZE)
                            .addGap(26, 26, 26))
    );
    orderHistoryLayout.setVerticalGroup(
            orderHistoryLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(orderHistoryLayout.createSequentialGroup()
                            .addGap(28, 28, 28)
                            .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 307, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(85, Short.MAX_VALUE))
    );

    jScrollPane7.setViewportView(orderHistory);

    customerTabs.addTab("Order History", jScrollPane7);
    jScrollPane3.setViewportView(orderDetailsTable);

    GroupLayout specificOrderLayout = new GroupLayout(specificOrder);
    specificOrder.setLayout(specificOrderLayout);
    specificOrderLayout.setHorizontalGroup(
            specificOrderLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(specificOrderLayout.createSequentialGroup()
                            .addGroup(specificOrderLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(specificOrderLayout.createSequentialGroup()
                                            .addGap(103, 103, 103)
                                            .addComponent(JLabelSpecificOrderID, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(JTextSpecificOrderID, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(specificOrderLayout.createSequentialGroup()
                                            .addGap(137, 137, 137)
                                            .addComponent(jButtonSpecificSubmit)
                                            .addGap(18, 18, 18)
                                            .addComponent(jButtonSpecificClear))
                                    .addGroup(specificOrderLayout.createSequentialGroup()
                                            .addGap(43, 43, 43)
                                            .addComponent(jScrollPane3, GroupLayout.PREFERRED_SIZE, 393, GroupLayout.PREFERRED_SIZE)))
                            .addContainerGap(46, Short.MAX_VALUE))
    );
    specificOrderLayout.setVerticalGroup(
            specificOrderLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(specificOrderLayout.createSequentialGroup()
                            .addGap(46, 46, 46)
                            .addGroup(specificOrderLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(JLabelSpecificOrderID)
                                    .addComponent(JTextSpecificOrderID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(30, 30, 30)
                            .addGroup(specificOrderLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButtonSpecificSubmit)
                                    .addComponent(jButtonSpecificClear))
                            .addGap(43, 43, 43)
                            .addComponent(jScrollPane3, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(94, Short.MAX_VALUE))
    );

    jScrollPane8.setViewportView(specificOrder);

    customerTabs.addTab("Order Details", jScrollPane8);
    jScrollPane4.setViewportView(orderUpdateScreen);

    GroupLayout updateOrderLayout = new GroupLayout(updateOrder);
    updateOrder.setLayout(updateOrderLayout);
    updateOrderLayout.setHorizontalGroup(
            updateOrderLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(updateOrderLayout.createSequentialGroup()
                            .addGroup(updateOrderLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(updateOrderLayout.createSequentialGroup()
                                            .addGap(103, 103, 103)
                                            .addComponent(JLabelUpdateOrderID, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(JTextUpdateOrderID, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(updateOrderLayout.createSequentialGroup()
                                            .addGap(137, 137, 137)
                                            .addComponent(jButtonUpdateSubmit)
                                            .addGap(18, 18, 18)
                                            .addComponent(jButtonUpdateClear))
                                    .addGroup(updateOrderLayout.createSequentialGroup()
                                            .addGap(38, 38, 38)
                                            .addComponent(jScrollPane4, GroupLayout.PREFERRED_SIZE, 393, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(updateOrderLayout.createSequentialGroup()
                                            .addGap(182, 182, 182)
                                            .addComponent(jButtonUpdateSave)))
                            .addContainerGap(51, Short.MAX_VALUE))
    );
    updateOrderLayout.setVerticalGroup(
            updateOrderLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(updateOrderLayout.createSequentialGroup()
                            .addGap(43, 43, 43)
                            .addGroup(updateOrderLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(JLabelUpdateOrderID)
                                    .addComponent(JTextUpdateOrderID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(33, 33, 33)
                            .addGroup(updateOrderLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButtonUpdateSubmit)
                                    .addComponent(jButtonUpdateClear))
                            .addGap(29, 29, 29)
                            .addComponent(jScrollPane4, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jButtonUpdateSave)
                            .addContainerGap(108, Short.MAX_VALUE))
    );

    jScrollPane9.setViewportView(updateOrder);

    customerTabs.addTab("Order Update", jScrollPane9);
    GroupLayout layout = new GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                            .addComponent(jButtonBack, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                            .addGap(29, 29, 29)
                                            .addComponent(jLabelTitle, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                            .addContainerGap()
                                            .addComponent(customerTabs, GroupLayout.DEFAULT_SIZE, 482, Short.MAX_VALUE)))
                            .addContainerGap(21, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jButtonBack)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabelTitle, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(customerTabs, GroupLayout.PREFERRED_SIZE, 451, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(72, Short.MAX_VALUE))
    );
  }

  @Override
  public void addFeatures(Features features) {
    this.displayOrderHistory(features);
    this.displayAvailableProducts(features);
    jButtonUpdateSave.addActionListener((e) -> onOrderUpdate(features));
    customerTabs.addChangeListener(e -> {
      var selectedTab = customerTabs.getSelectedIndex();
      if (selectedTab == 0) {
        this.displayAvailableProducts(features);
      } else if (selectedTab == 1) {
        this.displayOrderHistory(features);
      }
      else {
        this.updateOrderDropDown(features);
      }
    });
    this.jButtonCreateCart.addActionListener((e) -> placeOrder(features));
    this.jButtonAddToCart.addActionListener((e) -> addToCart(features));
    this.jButtonBack.addActionListener((e) -> onBack(features, new CustomerLogin()));
    this.jButtonSpecificSubmit.addActionListener((e) -> this.displayOrderDetail(features));
    this.jButtonUpdateSubmit.addActionListener((e) -> this.displayOrderUpdate(features));
    this.jButtonSpecificClear.addActionListener((e) -> this.clearTable(this.orderDetailsTable));
    this.jButtonUpdateClear.addActionListener((e) -> this.clearTable(this.orderUpdateScreen));
    this.jButtonClearCart.addActionListener((e) -> {
      this.cartItems = new ArrayList<>();
      this.updateCartTable();
    });
  }

  private void updateOrderDropDown(Features features) {
    try{
      var orders = features.getOrderHistory(this.username);
      this.JTextSpecificOrderID.removeAllItems();
      this.JTextUpdateOrderID.removeAllItems();
      orders.forEach((f) -> {
        JTextSpecificOrderID.addItem(f.id());
        JTextUpdateOrderID.addItem(f.id());});

    }
    catch (Exception e) {

    }
  }
  private void displayAvailableProducts(Features features) {
    try {
      var all = features.getAllAvailableProducts();
      this.displayProducts(this.jTableItemList, all);
      jTextItemName.removeAllItems();
      all.forEach((e) -> this.jTextItemName.addItem(e.id()));
    } catch (Exception ex) {
      JOptionPane.showMessageDialog(this, "Unable to fetch available products");
    }

  }

  private void placeOrder(Features features) {
    try {
      features.createOrder(this.username, this.cartItems);
      JOptionPane.showMessageDialog(this, "Order created successfully!");
    } catch (Exception ex) {
      JOptionPane.showMessageDialog(this, "Order could not be created");
    }
    this.cartItems = new ArrayList<>();
    this.updateCartTable();
  }

  private void addToCart(Features features) {
    try {
      var products = features.getAllAvailableProducts();
      var itemID = Integer.parseInt(jTextItemName.getSelectedItem().toString());
      var product = products.stream().filter(f -> f.id() == itemID).collect(Collectors.toList());
      if (product.size() != 1) {
        return;
      }
      var particularProduct = product.get(0);
      Product item = new Product(particularProduct.id(), particularProduct.name(),
              Integer.parseInt(jTextNumOfItems.getValue().toString()));
      this.cartItems.add(item);
      this.updateCartTable();
    } catch (Exception ex) {
      JOptionPane.showMessageDialog(this, "Unable to add to cart");
    }
  }

  private void updateCartTable() {
    var objects = new Object[cartItems.size()][3];
    for (int i = 0; i < cartItems.size(); i++) {
      objects[i] = new Object[]{
              cartItems.get(i).name(),
              cartItems.get(i).quantity()
      };
    }
    jTableCart.setModel(new DefaultTableModel(
            objects,
            new String[]{
                    "Name", "# items "
            }
    ));
  }

  private void onOrderUpdate(Features features) {
    try {
      var order = Integer.parseInt(this.JTextUpdateOrderID.getSelectedItem().toString());
      var products = this.productsToUpdate();
      features.updateOrder(order, products);
      JOptionPane.showMessageDialog(this, "Order updated successfully");
      this.displayOrderUpdate(features);
    } catch (Exception ex) {
      JOptionPane.showMessageDialog(this, "Order update Failed");
    }

  }

  private List<Product> productsToUpdate() {
    var rows = orderUpdateScreen.getModel().getRowCount();
    var table = orderUpdateScreen.getModel();
    var products = new ArrayList<Product>();
    for (int i = 0; i < rows; i++) {
      var product = new Product(
              Integer.parseInt(table.getValueAt(i, 0) + ""),
              table.getValueAt(i, 1) + "",
              Integer.parseInt(table.getValueAt(i, 2) + ""));
      products.add(product);
    }
    return products;
  }

  private void displayOrderHistory(Features features) {
    try {
      var orders = features.getOrderHistory(this.username);
      var objects = new Object[orders.size()][3];
      for (int i = 0; i < orders.size(); i++) {
        var order = orders.get(i);
        var object = new Object[3];
        object[0] = order.id();
        object[1] = order.date();
        object[2] = order.amount();
        objects[i] = object;
      }
      var model = new DefaultTableModel(
              objects,
              new String[]{
                      "Order ID", "Order Date", "Order Amount"
              }
      ) {
        @Override
        public boolean isCellEditable(int row, int column) {
          //all cells false
          return false;
        }
      };
      this.setTable(this.orderHistoryTable, model);
    } catch (Exception ex) {
      JOptionPane.showMessageDialog(this, ex.getMessage());
    }
  }

  private void displayOrderDetail(Features features) {
    try {
      var order_id = Integer.parseInt(this.JTextSpecificOrderID.getSelectedItem().toString());
      var products = features.getOrderDetail(username, order_id);
      var objects = this.parseProducts(products);
      orderDetailsTable.setModel(new DefaultTableModel(
              objects,
              new String[]{
                      "ID", "Name", "Quantity", "Category", "Price"
              }
      ) {
        @Override
        public boolean isCellEditable(int row, int column) {
          //all cells false
          return false;
        }
      });
    } catch (Exception ex) {
      JOptionPane.showMessageDialog(this, ex.getMessage());
    }
  }

  private void displayOrderUpdate(Features features) {
    try {
      var order_id = Integer.parseInt(this.JTextUpdateOrderID.getSelectedItem().toString());
      var products = features.getOrderDetail(username, order_id);
      var objects = this.parseProducts(products);

      orderUpdateScreen.setModel(new DefaultTableModel(
              objects,
              new String[]{
                      "ID", "Name", "Quantity", "Category", "Price"
              }
      ) {
        @Override
        public boolean isCellEditable(int row, int column) {
          //all cells false
          return column == 2;
        }
      });
    } catch (Exception ex) {
      JOptionPane.showMessageDialog(this, ex.getMessage());
    }
  }

  private void clearTable(JTable table) {
    table.setModel(new DefaultTableModel(
            new Object[][]{},
            new String[]{
                    "ID", "Name", "Quantity", "Category", "Price"
            }
    ));
  }

}
