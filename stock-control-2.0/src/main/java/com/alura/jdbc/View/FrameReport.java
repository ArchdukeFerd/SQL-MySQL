package com.alura.jdbc.view;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.alura.jdbc.controller.CategoryController;

public class FrameReport extends JFrame {

    private static final long serialVersionUID = 1L;

    private JTable reportTable;
    private DefaultTableModel model;

    private CategoryController categoriaController;

    public void Framereport(StockControlFrame StockControlFrame) {
        System.out.println("Product stock report");

        this.categoriaController = new CategoryController();

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
        var content = categoriaController.uploadReport();
        
        // TODO
        content.forEach(fila -> model
                .addRow(new Object[] {}));
    }

}
