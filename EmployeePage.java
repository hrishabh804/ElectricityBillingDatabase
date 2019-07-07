package hrishabh;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.ScrollPane;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class EmployeePage extends JFrame {

	private JPanel contentPane;
	private JTable table;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeePage frame = new EmployeePage();
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
	}


	/**
	 * Create the frame.
	 */
	public EmployeePage() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(200, 200, 550, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("CustomerInfo");
		btnNewButton.setBackground(UIManager.getColor("Button.select"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					String username = "harish";
					String password = "Hrish@123";
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/DatabaseProject",
							username, password);
					String sql = "select C.cus_id,F_Name,L_Name,Bill_gen_date,Due_date,amount,status from Customer C,Bills B where C.cus_id = B.cus_id ORDER BY Due_date desc";
					PreparedStatement stmt = con.prepareStatement(sql);
					ResultSet rs = stmt.executeQuery(sql);
					table.setModel(DbUtils.resultSetToTableModel(rs));
					con.close();
				} catch (Exception e1) {
					System.out.println(e1);
				}
				
				
			}
		});
		
		
		
		btnNewButton.setBounds(0, 0, 133, 25);
		
		contentPane.add(btnNewButton);
		
		
		
		
		
		
		
		JButton btnNewButton_1 = new JButton("UpdateBills");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateUnit update = new UpdateUnit();
				update.setVisible(true);
				close();
				
			}
		});
		btnNewButton_1.setBounds(131, 0, 133, 25);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("ViewComplain");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResolveComplain rc = new ResolveComplain();
				rc.setVisible(true);
				close();
			
			}
		});
		btnNewButton_2.setBounds(392, 0, 158, 25);
		contentPane.add(btnNewButton_2);
		
		table = new JTable();
		//table.setBounds(0, 69, 538, 241);
		//contentPane.add(table);
		JScrollPane sc = new JScrollPane();
		sc.setBounds(0, 37, 538, 284);
		contentPane.add(sc);
		sc.setViewportView(table);
		
		JLabel label = new JLabel("");
		label.setBounds(75, 37, 0, 0);
		contentPane.add(label);
		
		JButton btnNewButton_3 = new JButton("     ViewUpdate");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ShowUpdate update = new ShowUpdate();
				update.setVisible(true);
				close();
			}
		});
		btnNewButton_3.setBounds(247, 0, 146, 25);
		contentPane.add(btnNewButton_3);
		
		JButton btnBack = new JButton("LOGOUT");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main_page page = new Main_page();
				page.setVisible(true);
				close();
				
			}
		});
		btnBack.setBounds(451, 333, 99, 25);
		contentPane.add(btnBack);
		
		
		
		
		
	}
}
