package com.alura.jdbc.View;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.alura.jdbc.Controller.CategoryController;

public class FrameReport extends JFrame {

    private static final long serialVersionUID = 1L;

    private JTable reportTable;
    private DefaultTableModel model;

    private CategoryController categoryController;

    public void FrameReport(StockControlFrame StockControlFrame) {
        System.out.println("Product stock report");

        this.categoryController = new CategoryController();

        Container container = getContentPane();
        setLayout(null);

        reportTable = new JTable();
        reportTable.setBounds(0, 0, 600, 400);
        container.add(reportTable);

        model = (DefaultTableModel) reportTable.getModel();
        model.addColumn("");
        model.addColumn("");
        model.addColumn("");
        model.addColumn("");

        loadReport();

        setSize(600, 400);
        setVisible(true);
        setLocationRelativeTo(StockControlFrame);
    }

    private void loadReport() {
        var content = categoryController.uploadReport();
        content.forEach(fila -> model
                .addRow(new Object[] {}));
    }

}
