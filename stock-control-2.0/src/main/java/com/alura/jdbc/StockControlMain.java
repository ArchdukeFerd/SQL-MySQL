package src.main.java.com.alura.jdbc;

import javax.swing.JFrame;

import src.main.java.com.alura.jdbc.View.StockControlFrame;

public class StockControlMain {

	public static void main(String[] args) {
		StockControlFrame categoryProductFrame = new StockControlFrame();
		categoryProductFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
