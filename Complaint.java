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
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;

public class Complaint extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField cus_id;
	private JTextField textField_2;
	private JTextField issue;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Complaint frame = new Complaint();
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
	public Complaint() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 550, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblComplaintForm = new JLabel("COMPLAINT FORM");
		lblComplaintForm.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 19));
		lblComplaintForm.setBounds(212, -1, 196, 23);
		contentPane.add(lblComplaintForm);
		
		JLabel lblName = new JLabel("NAME");
		lblName.setFont(new Font("Dialog", Font.BOLD, 14));
		lblName.setBounds(54, 84, 100, 29);
		contentPane.add(lblName);
		
		textField = new JTextField();
		textField.setBounds(229, 87, 156, 23);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblCustomerid = new JLabel("CUSTOMER ID");
		lblCustomerid.setFont(new Font("Dialog", Font.BOLD, 14));
		lblCustomerid.setBounds(54, 139, 106, 17);
		contentPane.add(lblCustomerid);
		
		cus_id = new JTextField();
		cus_id.setColumns(10);
		cus_id.setBounds(229, 136, 156, 23);
		contentPane.add(cus_id);
		
		JLabel lblEmail = new JLabel("EMAIL");
		lblEmail.setFont(new Font("Dialog", Font.BOLD, 14));
		lblEmail.setBounds(54, 241, 100, 29);
		contentPane.add(lblEmail);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(229, 258, 156, 23);
		contentPane.add(textField_2);
		
		JLabel lblIssue = new JLabel("ISSUE");
		lblIssue.setFont(new Font("Dialog", Font.BOLD, 14));
		lblIssue.setBounds(54, 180, 100, 29);
		contentPane.add(lblIssue);
		
		issue = new JTextField();
		issue.setColumns(10);
		issue.setBounds(229, 171, 156, 71);
		contentPane.add(issue);
		
		JLabel lblBranch = new JLabel("BRANCH ");
		lblBranch.setFont(new Font("Dialog", Font.BOLD, 14));
		lblBranch.setBounds(54, 308, 100, 29);
		contentPane.add(lblBranch);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(229, 310, 166, 23);
		contentPane.add(comboBox);
		comboBox.addItem("MG road");
		comboBox.addItem("Shyam Nagar");
		comboBox.addItem("Jayanagar");
		
		JButton btnNewButton = new JButton("REPORT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					String username = "harish";
					String password = "Hrish@123";
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/DatabaseProject",
							username, password);
						
					int str;
					
						
					
					
						String PENDING ="PENDING";
						
						
						
						
						if(comboBox.getSelectedItem().toString() == "MG road") {
							str = 1;
							String sql = "insert into Complain values (null,'"+issue.getText()+"','"+PENDING +"','"+cus_id.getText()+"','"+str+"') "; 
							PreparedStatement stmt = con.prepareStatement(sql);
							boolean rs = stmt.execute(sql);
							if(rs == false)
								JOptionPane.showMessageDialog(null,"inconvenience caused is regretted We will get to you as soon as possible ");
							
							
							

						}
	
					
						else if(comboBox.getSelectedItem().toString() == "Shyam Nagar") {
						str = 2;
						String sql = "insert into Complain values (null,'"+issue.getText()+"','"+PENDING +"','"+cus_id.getText()+"','"+str+"') "; 
						PreparedStatement stmt = con.prepareStatement(sql);
						boolean rs = stmt.execute(sql);
						if(rs == false)
							JOptionPane.showMessageDialog(null,"inconvenience caused is regretted We will get to you as soon as possible ");
						
						
						

					}
						else{
						str= 3;
						String sql = "insert into Complain values (null,'"+issue.getText()+"','"+PENDING +"','"+cus_id.getText()+"','"+str+"') "; 
						PreparedStatement stmt = con.prepareStatement(sql);
						boolean rs = stmt.execute(sql);
						if(rs == false)
							JOptionPane.showMessageDialog(null,"inconvenience caused is regretted We will get to you as soon as possible ");
						
						
						
					}
					
										
							con.close();
				} catch (Exception e1) {
					System.out.println(e1);
				}
				
				
			}
		});
		btnNewButton.setBounds(256, 383, 117, 25);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
								close();
			}
		});
		btnNewButton_1.setBounds(12, 0, 70, 25);
		contentPane.add(btnNewButton_1);
	}
}
