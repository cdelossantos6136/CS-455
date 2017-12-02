package d8bodega.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import d8bodega.database.Database;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import d8bodega.model.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.CompoundBorder;
import javax.swing.JTextField;


public class Update_Stock_Window extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private Database db; 
	private JTextField textFieldMoreStock;
	private JTextField textFieldUpdatePNumber;

	/**
	 * Launch the application.
	 */

		
			public void run(String stockName) {
				try {
					Update_Stock_Window frame = new Update_Stock_Window(stockName);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			
		
	}
	
   
					 				
			public Update_Stock_Window(){}
	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public Update_Stock_Window(final String stockName) throws Exception {
		try {
			db = new Database();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		table = show_stock(db.getStockByName(stockName));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 869, 502);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 153, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton goBack = new JButton("GO BACK");
		goBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			 try {
				Select_Window goback = new Select_Window();
				goback.run();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		   dispose();
			}
		
		});
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblDisplayingStock = new JLabel("UPDATING STOCK");
		lblDisplayingStock.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblDisplayingStock.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblDisplayingStock.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNumberAvailable = new JLabel("Add More Stock: ");
		lblNumberAvailable.setBorder(new CompoundBorder());
		lblNumberAvailable.setBackground(Color.WHITE);
		
		JLabel lblAddMoreStock = new JLabel("Update Preferred Number:");
		
		textFieldMoreStock = new JTextField();
		textFieldMoreStock.setColumns(10);
		
		textFieldUpdatePNumber = new JTextField();
		textFieldUpdatePNumber.setColumns(10);
		
		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int stockID = 0;
				try {
					stockID = db.getStockID(stockName);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				if(textFieldMoreStock.getText().equals("")) {
					System.out.println("Empty Available");
				}
				else {
				int noAvailable = Integer.parseInt(textFieldMoreStock.getText());
				
				try {
					db.addStock(stockID, noAvailable);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
				
				if(textFieldUpdatePNumber.getText().equals("")) {
					System.out.println("Empty Preferred");
				}
				else {
				int noPreferred = Integer.parseInt(textFieldUpdatePNumber.getText());
				
				try {
					db.updateNoPreferred(stockID, noPreferred);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
				
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(goBack)
					.addContainerGap(766, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(331)
					.addComponent(lblDisplayingStock, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(320))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(88)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNumberAvailable)
								.addComponent(lblAddMoreStock))
							.addGap(24)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(textFieldMoreStock, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textFieldUpdatePNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnSubmit, Alignment.TRAILING))))
					.addGap(55))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(40)
					.addComponent(lblDisplayingStock)
					.addGap(53)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addGap(77)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNumberAvailable)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblAddMoreStock)
								.addComponent(textFieldUpdatePNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textFieldMoreStock, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addComponent(btnSubmit)
					.addPreferredGap(ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
					.addComponent(goBack))
		);
		
		scrollPane.setViewportView(table);
		
		contentPane.setLayout(gl_contentPane);
	}
	
	
	
	
	public JTable show_stock(Stock stock) throws Exception{
		String column[]= {"Stock Name","Number available","Number Missing","Preferred Number","Last Updated"};
		Object data2[][] = new Object[1][5];
		data2[0][0] = stock.getStockName();
		data2[0][1] = stock.getNoAvailable();
		data2[0][2] = stock.getNoMissing();
		data2[0][3] = stock.getNoPreferred();
		data2[0][4] = stock.getLastUpdated();
		
		JTable  stockTable = new JTable(data2, column);
		stockTable.setBackground(new Color(51, 255, 255));
		
		return stockTable;
		
	}
}
