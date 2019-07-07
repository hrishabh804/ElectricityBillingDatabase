package hrishabh;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;


public class Customer_page extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Customer_page frame = new Customer_page();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void close() {
		WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
	}/**
	 * Create the frame.
	 */
	public Customer_page() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(250, 250, 550, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList list = new JList();
		list.setBounds(5, 5, 0, 260);
		contentPane.add(list);
		
		JList list_1 = new JList();
		list_1.setBounds(59, 206, 165, -103);
		contentPane.add(list_1);
		
		JButton btnNewButton = new JButton("View Bill");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					String username = "harish";
					String password = "Hrish@123";
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/DatabaseProject", username, password);
					 UserSession cusid= UserSession.getActiveSession();
					 int userId = cusid.getUserId();
					
					String sql = "select * from Bills where status = 'UNPAID' and cus_id = '"+userId+"'";
					System.out.println("querying bills:" +  sql);
					PreparedStatement stmt = con.prepareStatement(sql);
					
					ResultSet rs = stmt.executeQuery(sql);
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					
					con.close();
					
					
					
				}catch(Exception e1) {System.out.println(e1);}
			}
		});
		btnNewButton.setBounds(5, 1, 138, 25);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Pay Bill");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EnterId id = new EnterId();
				id.setVisible(true);
				
			
			}
		});
		btnNewButton_1.setBounds(123, 1, 151, 25);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Bill History");
		
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					String username = "harish";
					String password = "Hrish@123";
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/DatabaseProject", username, password);
					 UserSession cusid= UserSession.getActiveSession();
					 int userId = cusid.getUserId();
					
					String sql = "select * from Bills where cus_id = '"+userId+"'";
					System.out.println("querying bills:" +  sql);
					PreparedStatement stmt = con.prepareStatement(sql);
					
					ResultSet rs = stmt.executeQuery(sql);
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					
					con.close();
					
					
					
				}catch(Exception e1) {System.out.println(e1);}
			}
		});
		btnNewButton_2.setBounds(257, 1, 151, 25);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Complaint");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Complaint c = new Complaint();
				c.setVisible(true);
				
			}
		});
		btnNewButton_3.setBounds(379, 1, 159, 25);
		contentPane.add(btnNewButton_3);
		
		table = new JTable();
		table.setBounds(5, 115, 545, 254);
		contentPane.add(table);
		
		JLabel lblNewLabel = new JLabel("Bill_id");
		lblNewLabel.setBounds(5, 88, 70, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("bill_gen_date ");
		lblNewLabel_1.setBounds(82, 88, 97, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(" Due_date ");
		lblNewLabel_2.setBounds(191, 88, 75, 15);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Amount");
		lblNewLabel_3.setBounds(288, 88, 70, 15);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Status");
		lblNewLabel_4.setBounds(370, 88, 70, 15);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Cus_id");
		lblNewLabel_5.setBounds(441, 88, 70, 15);
		contentPane.add(lblNewLabel_5);
		
		JButton btnNewButton_4 = new JButton("New button");
		btnNewButton_4.setBounds(421, 433, -147, -2);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("LOG OUT");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main_page page = new Main_page();
				page.setVisible(true);
				close();
			}
		});
		btnNewButton_5.setBounds(421, 418, 117, 25);
		contentPane.add(btnNewButton_5);
	}
}
