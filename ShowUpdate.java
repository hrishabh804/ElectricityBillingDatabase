package hrishabh;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class ShowUpdate extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private JLabel lblBillid;
	private JLabel lblName;
	private JLabel lblUpdatedamount;
	private JLabel lblStatus;
	private JButton btnSummit;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowUpdate frame = new ShowUpdate();
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

	
	
	public ShowUpdate() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(200, 200, 550, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnterCustumerid = new JLabel("Enter CustumerID");
		lblEnterCustumerid.setBounds(20, 29, 124, 32);
		contentPane.add(lblEnterCustumerid);
		
		textField = new JTextField();
		textField.setBounds(166, 32, 124, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		table = new JTable();
		table.setBounds(12, 134, 518, 165);
		contentPane.add(table);
		
		lblBillid = new JLabel("Bill_id");
		lblBillid.setBounds(43, 95, 70, 27);
		contentPane.add(lblBillid);
		
		lblName = new JLabel("Name");
		lblName.setBounds(167, 95, 70, 27);
		contentPane.add(lblName);
		
		lblUpdatedamount = new JLabel("UpdatedAmount");
		lblUpdatedamount.setBounds(272, 101, 115, 15);
		contentPane.add(lblUpdatedamount);
		
		lblStatus = new JLabel("Status");
		lblStatus.setBounds(418, 95, 70, 27);
		contentPane.add(lblStatus);
		
		btnSummit = new JButton("SUBMIT");
		btnSummit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					String username = "harish";
					String password = "Hrish@123";
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/DatabaseProject",
							username, password);

					Statement stmt = con.createStatement();
					String sql = "select C. cus_id,F_name,amount,status from Customer C,Bills B where C.cus_id = B.cus_id and C.cus_id='"+textField.getText()+"'";
					
			
					ResultSet rs = stmt.executeQuery(sql);
					table.setModel(DbUtils.resultSetToTableModel(rs));
					con.close();
				} catch (Exception e1) {
					System.out.println(e1);
				}
			}
		});
		btnSummit.setBounds(329, 33, 117, 25);
		contentPane.add(btnSummit);
		
		btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmployeePage page = new EmployeePage();
				page.setVisible(true);
				close();
				
				
			}
		});
		btnBack.setBounds(413, 333, 117, 25);
		contentPane.add(btnBack);
	}
}
