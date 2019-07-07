package hrishabh;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class SignUp extends JFrame {

	private JPanel contentPane;
	private JTextField CUSID;
	private JTextField FNAME;
	private JTextField LNAME;
	private JTextField PHONE;
	private JTextField ADDRESS;
	private JTextField BRANCH;
	private JTextField PASSWORD;
	private JButton btnSubmit;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp frame = new SignUp();
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
	public SignUp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 365, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSignUp = new JLabel("SIGN UP");
		lblSignUp.setBounds(177, 12, 70, 25);
		contentPane.add(lblSignUp);
		
		JLabel lblName = new JLabel("CUSTOMER ID");
		lblName.setBounds(61, 71, 94, 15);
		contentPane.add(lblName);
		
		CUSID = new JTextField();
		CUSID.setBounds(234, 69, 114, 19);
		contentPane.add(CUSID);
		CUSID.setColumns(10);
		
		JLabel lblFname = new JLabel("FNAME");
		lblFname.setBounds(61, 98, 70, 15);
		contentPane.add(lblFname);
		
		JLabel lblNewLabel = new JLabel("LNAME");
		lblNewLabel.setBounds(61, 125, 70, 15);
		contentPane.add(lblNewLabel);
		
		FNAME = new JTextField();
		FNAME.setBounds(234, 96, 114, 19);
		contentPane.add(FNAME);
		FNAME.setColumns(10);
		
		LNAME = new JTextField();
		LNAME.setBounds(234, 123, 114, 19);
		contentPane.add(LNAME);
		LNAME.setColumns(10);
		
		JLabel lblAddress = new JLabel("ADDRESS");
		lblAddress.setBounds(61, 149, 70, 15);
		contentPane.add(lblAddress);
		
		JLabel lblPhoneNumber = new JLabel("PHONE NUMBER");
		lblPhoneNumber.setBounds(61, 174, 110, 15);
		contentPane.add(lblPhoneNumber);
		
		JLabel lblBranchId = new JLabel("BRANCH ID");
		lblBranchId.setBounds(61, 201, 74, 15);
		contentPane.add(lblBranchId);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setBounds(61, 229, 80, 15);
		contentPane.add(lblPassword);
		
		PHONE = new JTextField();
		PHONE.setBounds(234, 172, 114, 19);
		contentPane.add(PHONE);
		PHONE.setColumns(10);
		
		ADDRESS = new JTextField();
		ADDRESS.setBounds(234, 147, 114, 19);
		contentPane.add(ADDRESS);
		ADDRESS.setColumns(10);
		
		BRANCH = new JTextField();
		BRANCH.setBounds(234, 199, 114, 19);
		contentPane.add(BRANCH);
		BRANCH.setColumns(10);
		
		PASSWORD = new JTextField();
		PASSWORD.setBounds(234, 227, 114, 19);
		contentPane.add(PASSWORD);
		PASSWORD.setColumns(10);
		
		btnSubmit = new JButton("SUBMIT");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					String username = "harish";
					String password = "Hrish@123";
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/DatabaseProject",
							username, password);

					
					String sql = "call Insert_Customer (?,?,?,?,?,?,?)";
					PreparedStatement stmt = con.prepareStatement(sql);
					stmt.setString(1, CUSID.getText());
					stmt.setString(2, FNAME.getText());
					stmt.setString(3, LNAME.getText());
					stmt.setString(4, ADDRESS.getText());
					stmt.setString(5, PHONE.getText());
					stmt.setString(6, BRANCH.getText());
					stmt.setString(7, PASSWORD.getText());
					
					boolean rs = stmt.execute();
					if (rs==false) {
						JOptionPane.showMessageDialog(null,"welcome to electricity board");
						login_admin page = new login_admin();
						page.setVisible(true);
					}
					else {
						JOptionPane.showMessageDialog(null, "failed");
					}
			
					con.close();
				} catch (Exception e1) {
					System.out.println(e1);
				}
				
			}
		});
		btnSubmit.setBounds(177, 270, 117, 25);
		contentPane.add(btnSubmit);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("/home/hrishabh/Downloads/1*O9BLNSbcsfcMSvzERd9frA.png"));
		lblNewLabel_1.setBounds(0, -4, 368, 320);
		contentPane.add(lblNewLabel_1);
	}
}
