package hrishabh;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JInternalFrame;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JMenuBar;

public class demo extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					demo frame = new demo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public demo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(1300, 1300, 1450, 1300);
		contentPane = new JPanel();
		contentPane.setForeground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Add customer");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(25, 24, 131, 25);
		contentPane.add(btnNewButton);
		
		JButton btnDetails = new JButton("DETAILS");
		btnDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String sql = "Select cus_id from Customer where Name='devendra'";
				DatabaseConnection.execute(sql);
				
				
				
				
				
			}
		});
		btnDetails.setBounds(168, 24, 117, 25);
		contentPane.add(btnDetails);
		
		table = new JTable();
		table.setBounds(336, 185, -225, -45);
		contentPane.add(table);
		
		JList list = new JList();
		list.setBounds(178, 180, -48, -18);
		contentPane.add(list);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 94, 392, 164);
		contentPane.add(scrollPane);
		
		table_1 = new JTable();
		scrollPane.setViewportView(table_1);
		
		textField = new JTextField();
		textField.setBounds(297, 27, 114, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("enter dept number");
		lblNewLabel.setBounds(280, 0, 134, 15);
		contentPane.add(lblNewLabel);
		JButton btn = new JButton("hello");
		btn.setBounds(100,50,249,34);
		contentPane.add(btn);
		
		textField_1 = new JTextField();
		textField_1.setBounds(171, 338, 114, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JRadioButtonMenuItem rdbtnmntmNewRadioItem = new JRadioButtonMenuItem("New radio item");
		rdbtnmntmNewRadioItem.setBounds(460, 50, 141, 19);
		contentPane.add(rdbtnmntmNewRadioItem);
		
		JRadioButtonMenuItem rdbtnmntmNewRadioItem_1 = new JRadioButtonMenuItem("New radio item");
		rdbtnmntmNewRadioItem_1.setBounds(447, 78, 141, 19);
		contentPane.add(rdbtnmntmNewRadioItem_1);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(460, 165, 129, 21);
		contentPane.add(menuBar);
		
		JMenuBar menuBar_1 = new JMenuBar();
		menuBar_1.setToolTipText("hello");
		menuBar_1.setBounds(336, 254, 129, 21);
		contentPane.add(menuBar_1);
	}
}
