package com.alura.jdbc.View;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Optional;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.alura.jdbc.Controller.CategoryController;
import com.alura.jdbc.Controller.ProductController;

public class StockControlFrame extends JFrame {

private static final long serialVersionUID = 1L;

private JLabel nameLabel, descriptionLabel, quantityLabel, categoryLabel;
private JTextField nameText, descriptionText, quantityText;
private JComboBox<Object> categoryCombo;
private JButton saveButton, modifyButton, clearButton, deleteButton, reportButton;
private JTable table;
private DefaultTableModel model;
private ProductController productController;
private CategoryController categoryController;

public StockControlFrame() {
    super("Products");

    this.categoryController = new CategoryController();
    this.productController = new ProductController();

    Container container = getContentPane();
    setLayout(null);

    configureFormFields(container);

    configureContentsTable(container);

    configureFormActions();
}

private void configureContentsTable(Container container) {
    table = new JTable();

    model = (DefaultTableModel) table.getModel();
    model.addColumn("Product Id");
    model.addColumn("Product Name");
    model.addColumn("Product Description");
    model.addColumn("Quantity");

    loadTable();

    table.setBounds(10, 205, 760, 280);

    deleteButton = new JButton("Delete");
    modifyButton = new JButton("Modify");
    reportButton = new JButton("Get Report");
    deleteButton.setBounds(10, 500, 80, 20);
    modifyButton.setBounds(100, 500, 80, 20);
    reportButton.setBounds(190, 500, 80, 20);

    container.add(table);
    container.add(deleteButton);
    container.add(modifyButton);
    container.add(reportButton);

    setSize(800, 600);
    setVisible(true);
    setLocationRelativeTo(null);
}

private void configureFormFields(Container container) {
    nameLabel = new JLabel("Product Name");
    descriptionLabel = new JLabel("Product Description");
    quantityLabel = new JLabel("Quantity");
    categoryLabel = new JLabel("Product Category");

    nameLabel.setBounds(10, 10, 240, 15);
    descriptionLabel.setBounds(10, 50, 240, 15);
    quantityLabel.setBounds(10, 90, 240, 15);
    categoryLabel.setBounds(10, 130, 240, 15);

    nameLabel.setForeground(Color.BLACK);
    descriptionLabel.setForeground(Color.BLACK);
    categoryLabel.setForeground(Color.BLACK);

    nameText = new JTextField();
    descriptionText = new JTextField();
    quantityText = new JTextField();
    categoryCombo = new JComboBox<>();
    categoryCombo.addItem("Pick a Category");

    var categories = this.categoryController.list();

    nameText.setBounds(10, 25, 265, 20);
    descriptionText.setBounds(10, 65, 265, 20);
    quantityText.setBounds(10, 105, 265, 20);
    categoryCombo.setBounds(10, 145, 265, 20);

    saveButton = new JButton("Save");
    clearButton = new JButton("Clear");
    saveButton.setBounds(10, 175, 80, 20);
    clearButton.setBounds(100, 175, 80, 20);

    container.add(nameLabel);
    container.add(descriptionLabel);
    container.add(quantityLabel);
    container.add(categoryLabel);
    container.add(nameText);
    container.add(descriptionText);
    container.add(quantityText);
    container.add(categoryCombo);
    container.add(saveButton);
    container.add(clearButton);
}

private void configureFormActions() {
    saveButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            save();
            clearTable();
            loadTable();
        }
    });

    clearButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            clearForm();
        }
    });

    deleteButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            delete();
            clearTable();
            loadTable();
        }
    });

    modifyButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            try {
                modify();
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            clearTable();
            loadTable();
        }
    });

    reportButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            getReport();
        }
    });
}

private void getReport() {
    new FrameReport();
}

private void clearTable() {
    model.getDataVector().clear();
}

private boolean selectedRow() {
    return table.getSelectedRowCount() == 0 || table.getSelectedColumnCount() == 0;
}

private void modify() throws SQLException {
    if (selectedRow()) {
        JOptionPane.showMessageDialog(this, "Please choose an item");
        return;
    }

    Optional.ofNullable(model.getValueAt(table.getSelectedRow(), table.getSelectedColumn()))
            .ifPresentOrElse(row -> {
                Integer Id = Integer.valueOf(model.getValueAt(table.getSelectedRow(), 0).toString());
                String Name = (String) model.getValueAt(table.getSelectedRow(), 1);
                String Description = (String) model.getValueAt(table.getSelectedRow(), 2);
                Integer Quantity = Integer.valueOf(model.getValueAt(table.getSelectedRow(), 3).toString());

                int modifiedRows;
                modifiedRows = this.productController.modify(Name, Description, Quantity, Id);

                JOptionPane.showMessageDialog(this, String.format("%d success when modifying the item!", modifiedRows));
            }, () -> JOptionPane.showMessageDialog(this, "Please choose an item"));
}

private void delete() {
    if (selectedRow()) {
        JOptionPane.showMessageDialog(this, "Please choose an item");
        return;
    }

    Optional.ofNullable(model.getValueAt(table.getSelectedRow(), table.getSelectedColumn()))
            .ifPresentOrElse(row -> {
                Integer Id = Integer.valueOf(model.getValueAt(table.getSelectedRow(), 0).toString());

                this.productController.delete(Id);

                model.removeRow(table.getSelectedRow());

                JOptionPane.showMessageDialog(this, "Item successfully deleted!");
            }, () -> JOptionPane.showMessageDialog(this, "Please choose an item"));
}

private void loadTable() {
    try{
    var products = this.productController.list();
    try {
        products.forEach(product -> model.addRow(new Object[] {product.get("Id"), product.get("Name"), product.get("Description"), product.get("Quantity")}));
    } catch (Exception e) {
        throw e;
    }
    } catch (SQLException e){
        throw new RuntimeException(e);
    }
}

private void save() {
    if (nameText.getText().isBlank() || descriptionText.getText().isBlank()) {
        JOptionPane.showMessageDialog(this, "Required Name and Description fields");
        return;
    }

    Integer QuanInt;

    try {
        QuanInt = Integer.parseInt(quantityText.getText());
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, String
                .format("The -Quantity- field must be numerical in the range between %d and %d", 0, Integer.MAX_VALUE));
        return;
    }

    var product = new HashMap<String, String>(); 
    product.put("Name", nameText.getText());
    product.put("Description", descriptionText.getText());
    product.put("Quantity", String.valueOf(QuanInt));
    var category = categoryCombo.getSelectedItem();

    try {
        this.productController.save(product);
    } catch (SQLException e) {
        throw new RuntimeException();
    }


    JOptionPane.showMessageDialog(this, "Successfully registered");

    this.clearForm();
}

private void clearForm() {
    this.nameText.setText("");
    this.descriptionText.setText("");
    this.quantityText.setText("");
    this.categoryCombo.setSelectedIndex(0);
}

}
