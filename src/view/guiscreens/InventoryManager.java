package view.guiscreens;

import java.awt.*;
import java.util.List;

import javax.swing.*;

import controller.Features;
import model.Category;
import model.Product;

public class InventoryManager extends AbstractEmployeeScreen {

  private final JLabel JLabelDeleteItemID;
  private final JLabel date;
  private final JLabel roleLabel;
  private final JLabel JLabelSpecificOrderID;
  private final JLabel JLabelUpdateCount;
  private final JSpinner JTextUpdateCount;
  private final JComboBox<Integer> JTextDeleteItemID;
  private final JTextField JTextFirstName;
  private final JTextField JTextGeneralRole;
  private final JComboBox<Integer> JTextUpdateStock;
  private final JTabbedPane employeeTabs;
  private final JPanel deleteItems;
  private final JPanel itemList;
  private final JButton jButtonAddProduct;
  private final JButton jButtonSpecificClear;
  private final JButton jButtonSpecificSubmit;
  private final JButton jButtonUpdateClear;
  private final JButton jButtonUpdateSubmit;
  private final JFrame jFrame1;
  private final JLabel jLabelInvManagerCategory;
  private final JLabel jLabelInvManagerItemName;
  private final JLabel jLabelInvManagerNumOfItems;
  private final JScrollPane jScrollPane2;
  private final JTable productList;
  private final JTextField jTextFieldLastName;
  private final JComboBox<String> jTextInvManagerCategory;
  private final JTextField jTextInvManagerItemName;
  private final JSpinner jTextInvManagerNumOfItems;
  private final JPanel logHours;
  private final JPanel newItems;
  private final JPanel specificOrder;
  private final JLabel jLabelInvManagerPrice;
  private final JSpinner jTextInvManagerPrice;


  public InventoryManager(String username) {
    super(username, "Inventory Manager - Main Page");
    setSize(521, 532);
    jFrame1 = new JFrame();
    date = new JLabel("Date");
    JTextFirstName = new JTextField();
    jTextFieldLastName = new JTextField();
    roleLabel = new JLabel();
    JTextGeneralRole = new JTextField();
    employeeTabs = new JTabbedPane();
    newItems = new JPanel();
    JLabelUpdateCount = new JLabel("Quantity");
    JTextUpdateCount = new JSpinner();
    jLabelInvManagerItemName = new JLabel("Enter item name");
    jTextInvManagerItemName = new JTextField();
    jLabelInvManagerNumOfItems = new JLabel("Enter quantity");
    jTextInvManagerNumOfItems = new JSpinner();
    jButtonAddProduct = new JButton("Add Product");
    jTextInvManagerCategory = new JComboBox<String>();
    jTextInvManagerCategory.addItem("Perishable");
    jTextInvManagerCategory.addItem("NonPerishable");
    jLabelInvManagerCategory = new JLabel("Select Category");
    itemList = new JPanel();
    jScrollPane2 = new JScrollPane();
    productList = new JTable();
    specificOrder = new JPanel();
    JTextUpdateStock = new JComboBox<>();
    jButtonSpecificSubmit = new JButton("Submit");
    JLabelSpecificOrderID = new JLabel("Product ID");
    jButtonSpecificClear = new JButton("Clear");
    deleteItems = new JPanel();
    JLabelDeleteItemID = new JLabel("Product ID");
    JTextDeleteItemID = new JComboBox<>();
    jButtonUpdateSubmit = new JButton("Submit");
    jButtonUpdateClear = new JButton("Clear");
    jLabelInvManagerPrice = new JLabel("Price");
    jTextInvManagerPrice = new JSpinner();
    logHours = new JPanel();
    init();
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setVisible(true);

  }

  private void init() {

    GroupLayout jFrame1Layout = new GroupLayout(jFrame1.getContentPane());
    jFrame1.getContentPane().setLayout(jFrame1Layout);
    jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jFrame1Layout.createSequentialGroup()
                            .addGap(44, 44, 44)
                            .addGroup(jFrame1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(jFrame1Layout.createSequentialGroup()
                                            .addComponent(screenTitle, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(GroupLayout.Alignment.TRAILING, jFrame1Layout.createSequentialGroup()
                                            .addGroup(jFrame1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                    .addComponent(jTextFieldLogOutTime, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(roleLabel, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(date, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(JLabelLogInTime, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                                            .addGroup(jFrame1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                    .addComponent(JTextGeneralRole, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jTextFieldLogOutTime, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jTextFieldLastName, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(JTextFirstName, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE))
                                            .addGap(25, 25, 25))))
    );
    jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, jFrame1Layout.createSequentialGroup()
                            .addComponent(screenTitle, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addGroup(jFrame1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(JTextGeneralRole, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(roleLabel))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jFrame1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(JTextFirstName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(date))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jFrame1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextFieldLastName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldLogInTime))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jFrame1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextFieldLogOutTime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldLogOutTime))
                            .addContainerGap(33, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout newItemsLayout = new javax.swing.GroupLayout(newItems);
    newItems.setLayout(newItemsLayout);
    newItemsLayout.setHorizontalGroup(
            newItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(newItemsLayout.createSequentialGroup()
                            .addGroup(newItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(newItemsLayout.createSequentialGroup()
                                            .addGroup(newItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(newItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addGroup(newItemsLayout.createSequentialGroup()
                                                                    .addGap(108, 108, 108)
                                                                    .addComponent(jLabelInvManagerItemName, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, newItemsLayout.createSequentialGroup()
                                                                    .addContainerGap()
                                                                    .addGroup(newItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                            .addComponent(jLabelInvManagerCategory, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                            .addComponent(jLabelInvManagerNumOfItems, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                    .addComponent(jLabelInvManagerPrice, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(18, 18, 18)
                                            .addGroup(newItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(jTextInvManagerCategory, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                                                    .addComponent(jTextInvManagerNumOfItems)
                                                    .addComponent(jTextInvManagerItemName)
                                                    .addComponent(jTextInvManagerPrice)))
                                    .addGroup(newItemsLayout.createSequentialGroup()
                                            .addGap(171, 171, 171)
                                            .addComponent(jButtonAddProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addContainerGap(107, Short.MAX_VALUE))
    );
    newItemsLayout.setVerticalGroup(
            newItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(newItemsLayout.createSequentialGroup()
                            .addGap(37, 37, 37)
                            .addGroup(newItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabelInvManagerItemName)
                                    .addComponent(jTextInvManagerItemName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(newItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextInvManagerNumOfItems, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelInvManagerNumOfItems))
                            .addGap(18, 18, 18)
                            .addGroup(newItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextInvManagerCategory)
                                    .addComponent(jLabelInvManagerCategory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(18, 18, 18)
                            .addGroup(newItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextInvManagerPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelInvManagerPrice))
                            .addGap(18, 18, 18)
                            .addComponent(jButtonAddProduct)
                            .addContainerGap(153, Short.MAX_VALUE))
    );
    employeeTabs.addTab("Add new items", newItems);

    jScrollPane2.setViewportView(productList);

    GroupLayout itemListLayout = new GroupLayout(itemList);
    itemList.setLayout(itemListLayout);
    itemListLayout.setHorizontalGroup(
            itemListLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, itemListLayout.createSequentialGroup()
                            .addContainerGap(28, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 428, GroupLayout.PREFERRED_SIZE)
                            .addGap(26, 26, 26))
    );
    itemListLayout.setVerticalGroup(
            itemListLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(itemListLayout.createSequentialGroup()
                            .addGap(28, 28, 28)
                            .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(189, Short.MAX_VALUE))
    );

    employeeTabs.addTab("Item list", itemList);
    GroupLayout specificOrderLayout = new GroupLayout(specificOrder);
    specificOrder.setLayout(specificOrderLayout);
    specificOrderLayout.setHorizontalGroup(
            specificOrderLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(specificOrderLayout.createSequentialGroup()
                            .addGroup(specificOrderLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(specificOrderLayout.createSequentialGroup()
                                            .addGap(135, 135, 135)
                                            .addComponent(jButtonSpecificSubmit)
                                            .addGap(18, 18, 18)
                                            .addComponent(jButtonSpecificClear))
                                    .addGroup(specificOrderLayout.createSequentialGroup()
                                            .addGap(103, 103, 103)
                                            .addGroup(specificOrderLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                    .addGroup(specificOrderLayout.createSequentialGroup()
                                                            .addComponent(JLabelUpdateCount, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
                                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                            .addComponent(JTextUpdateCount, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(specificOrderLayout.createSequentialGroup()
                                                            .addComponent(JLabelSpecificOrderID, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
                                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                            .addComponent(JTextUpdateStock, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)))))
                            .addContainerGap(152, Short.MAX_VALUE))
    );
    specificOrderLayout.setVerticalGroup(
            specificOrderLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(specificOrderLayout.createSequentialGroup()
                            .addGap(46, 46, 46)
                            .addGroup(specificOrderLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(JLabelSpecificOrderID)
                                    .addComponent(JTextUpdateStock, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(specificOrderLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(JLabelUpdateCount)
                                    .addComponent(JTextUpdateCount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(27, 27, 27)
                            .addGroup(specificOrderLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButtonSpecificSubmit)
                                    .addComponent(jButtonSpecificClear))
                            .addContainerGap(218, Short.MAX_VALUE))
    );

    employeeTabs.addTab("Update Product Stock", specificOrder);

    GroupLayout deleteItemsLayout = new GroupLayout(deleteItems);
    deleteItems.setLayout(deleteItemsLayout);
    deleteItemsLayout.setHorizontalGroup(
            deleteItemsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(deleteItemsLayout.createSequentialGroup()
                            .addGroup(deleteItemsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(deleteItemsLayout.createSequentialGroup()
                                            .addGap(103, 103, 103)
                                            .addComponent(JLabelDeleteItemID, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(JTextDeleteItemID, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(deleteItemsLayout.createSequentialGroup()
                                            .addGap(137, 137, 137)
                                            .addComponent(jButtonUpdateSubmit)
                                            .addGap(18, 18, 18)
                                            .addComponent(jButtonUpdateClear)))
                            .addContainerGap(51, Short.MAX_VALUE))
    );
    deleteItemsLayout.setVerticalGroup(
            deleteItemsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(deleteItemsLayout.createSequentialGroup()
                            .addGap(43, 43, 43)
                            .addGroup(deleteItemsLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(JLabelDeleteItemID)
                                    .addComponent(JTextDeleteItemID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(33, 33, 33)
                            .addGroup(deleteItemsLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButtonUpdateSubmit)
                                    .addComponent(jButtonUpdateClear))
                            .addGap(29, 29, 29)
                            .addContainerGap(65, Short.MAX_VALUE))
    );

    employeeTabs.addTab("Delete items", deleteItems);

    GroupLayout logHoursLayout = new GroupLayout(logHours);
    logHours.setLayout(logHoursLayout);
    logHoursLayout.setHorizontalGroup(
            logHoursLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(logHoursLayout.createSequentialGroup()
                            .addGap(68, 68, 68)
                            .addGroup(logHoursLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(JLabelLogOutTime, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JLabelDate, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JLabelLogInTime, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(logHoursLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(logTime)
                                    .addComponent(jTextFieldLogOutTime, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldLogInTime, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JTextDate, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE))
                            .addGap(83, 83, 83))
    );
    logHoursLayout.setVerticalGroup(
            logHoursLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(logHoursLayout.createSequentialGroup()
                            .addGap(26, 26, 26)
                            .addGroup(logHoursLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(JTextDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JLabelDate))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(logHoursLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextFieldLogInTime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JLabelLogInTime))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(logHoursLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextFieldLogOutTime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JLabelLogOutTime))
                            .addGap(18, 18, 18)
                            .addComponent(logTime)
                            .addContainerGap(185, Short.MAX_VALUE))
    );

    employeeTabs.addTab("Log hours", logHours);


    GroupLayout layout = new GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(employeeTabs, GroupLayout.PREFERRED_SIZE, 482, GroupLayout.PREFERRED_SIZE)
                            .addGap(21, 21, 21))
                    .addGroup(layout.createSequentialGroup()
                            .addComponent(jButtonBack, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addComponent(screenTitle, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jButtonBack)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(screenTitle, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(employeeTabs, GroupLayout.PREFERRED_SIZE, 407, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(52, Short.MAX_VALUE))
    );
  }

  @Override
  public void addFeatures(Features features) {
    super.addFeatures(features);
    var self = this;
    jButtonUpdateSubmit.addActionListener((e) -> deleteProduct(features));
    jButtonSpecificSubmit.addActionListener((e) -> updateProduct(features));
    jButtonAddProduct.addActionListener((e) -> addProduct(features));
    employeeTabs.addChangeListener(e -> onTabSwitch(features));
  }

  private void deleteProduct(Features features) {
    try {
      var itemToDelete = Integer.parseInt(this.JTextDeleteItemID.getSelectedItem().toString());
      features.deleteProduct(itemToDelete);
      JOptionPane.showMessageDialog(this, "Product deleted from the inventory");
    } catch (Exception ex) {
      JOptionPane.showMessageDialog(this, "The product could not be deleted");

    }
  }

  private void updateProduct(Features features) {
    try {
      var itemToUpdate = Integer.parseInt(JTextUpdateStock.getSelectedItem().toString());
      var quantity = Integer.parseInt(JTextUpdateCount.getValue().toString());
      if(!validateQuantity(quantity)) {
        JOptionPane.showMessageDialog(this, "Invalid Quantity for the Item");
        return;
      }
      features.updateProduct(itemToUpdate, quantity);
      JOptionPane.showMessageDialog(this, "Product availability updated in the inventory");

    } catch (Exception ex) {
      JOptionPane.showMessageDialog(this, "Could not update product availability");

    }
  }

  private void addProduct(Features features) {
    try {
      String name = jTextInvManagerItemName.getText();
      int quantity = Integer.parseInt(jTextInvManagerNumOfItems.getValue().toString());
      var categoryString = jTextInvManagerCategory.getSelectedItem().toString();
      int category = Category.value(categoryString);
      int price = Integer.parseInt(jTextInvManagerPrice.getValue().toString());
      if(!validatePrice(price)) {
        JOptionPane.showMessageDialog(this, "Invalid Price for the item");
        return;
      }
      else if(!validateQuantity(quantity)) {
        JOptionPane.showMessageDialog(this, "Invalid Quantity for the item");
        return;
      }
      features.addProduct(name, quantity, category, price);
      JOptionPane.showMessageDialog(this, "Product added to the inventory");
    } catch (Exception ex) {
      JOptionPane.showMessageDialog(this, "Could not add a new product");
    }
    this.clearAfterAdd();
  }

  private void onTabSwitch(Features features) {
    var selectedTab = employeeTabs.getSelectedIndex();
    try {
      var products = features.getProducts();
      if (selectedTab == 1) {
        this.displayAllProducts(products);
      }
      else if(selectedTab == 2) {
        this.JTextUpdateStock.removeAllItems();
        products.forEach((f) -> this.JTextUpdateStock.addItem(f.id()));
      }
      else if(selectedTab == 3) {
        this.JTextDeleteItemID.removeAllItems();
        products.forEach((f) -> this.JTextDeleteItemID.addItem(f.id()));
      }
    } catch (Exception ex) {
      JOptionPane.showMessageDialog(this, "Could not fetch the inventory");
    }
  }

  private void displayAllProducts(List<Product> products) {
    this.displayProducts(this.productList, products);
  }

  private boolean validatePrice(int price) {
    return price > 0;
  }

  private boolean validateQuantity(int quantity) {
    return quantity > 0;
  }

  private void clearAfterAdd() {
    this.jTextInvManagerItemName.setText("");
    this.jTextInvManagerPrice.setValue(0);
    this.jTextInvManagerNumOfItems.setValue(0);
  }

}
