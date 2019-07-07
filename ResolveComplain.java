package hrishabh;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class ResolveComplain extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ResolveComplain frame = new ResolveComplain();
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
	public ResolveComplain() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCustomerComplains = new JLabel("CUSTOMER COMPLAINTS");
		lblCustomerComplains.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 15));
		lblCustomerComplains.setBounds(141, 12, 211, 19);
		contentPane.add(lblCustomerComplains);
		
		JLabel lblEnterYourId = new JLabel("ENTER YOUR ID");
		lblEnterYourId.setBounds(12, 56, 103, 15);
		contentPane.add(lblEnterYourId);
		
		textField = new JTextField();
		textField.setBounds(140, 53, 114, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		table = new JTable();
		table.setBounds(12, 158, 476, 162);
		contentPane.add(table);
		
		JLabel lblComid = new JLabel("COM_ID");
		lblComid.setBounds(27, 129, 70, 15);
		contentPane.add(lblComid);
		
		JLabel lblComtype = new JLabel("COM_TYPE");
		lblComtype.setBounds(109, 129, 71, 15);
		contentPane.add(lblComtype);
		
		JLabel lblStatus = new JLabel("STATUS");
		lblStatus.setBounds(206, 129, 70, 15);
		contentPane.add(lblStatus);
		
		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					String username = "harish";
					String password = "Hrish@123";
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/DatabaseProject",
							username, password);

					Statement stmt = con.createStatement();
					String PENDING = "PENDING";
					String sql = "select * from Complain where status = '"+PENDING +"' and EID = '"+textField.getText()+"'";
					
			
					ResultSet rs = stmt.executeQuery(sql);
					table.setModel(DbUtils.resultSetToTableModel(rs));
					con.close();
				} catch (Exception e1) {
					System.out.println(e1);
				}
			}
		});
		btnSubmit.setBounds(150, 80, 86, 25);
		contentPane.add(btnSubmit);
		
		JLabel lblCusid = new JLabel("CUS_ID");
		lblCusid.setBounds(311, 129, 70, 15);
		contentPane.add(lblCusid);
		
		JLabel lblEmpid = new JLabel("EMP_ID");
		lblEmpid.setBounds(393, 129, 70, 15);
		contentPane.add(lblEmpid);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmployeePage page = new EmployeePage();
				page.setVisible(true);
				close();
			}
		});
		btnBack.setBounds(371, 333, 117, 25);
		contentPane.add(btnBack);
	}
}
