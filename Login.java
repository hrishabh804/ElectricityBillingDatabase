package hrishabh;

import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

public class Login {

	private JFrame frame;
	private JTextField user;
	private JTextField pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 653, 366);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnLogin = new JButton("login");
		btnLogin.setBackground(Color.LIGHT_GRAY);
		btnLogin.setForeground(Color.BLACK);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					String username ="harish";
					String password ="Hrish@123";
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login",username,password);
					
					Statement stmt = con.createStatement();
					String sql = "Select *from login where name='"+user.getText()+"' and passward='"+pass.getText().toString()+"'";
					ResultSet rs = stmt.executeQuery(sql);
					
					
					if(rs.next()) {
						JOptionPane.showMessageDialog(null, "Login sucessfully");
						frame.dispose();
						Second page = new Second();
						page.setVisible(true);
						
					
					}
					else
						JOptionPane.showMessageDialog(null, "Incorrect username or password");
					con.close();

					
					
				}catch(Exception e1) {System.out.println(e1);}
			}
		});
		btnLogin.setBounds(439, 268, 117, 25);
		frame.getContentPane().add(btnLogin);
		
		JLabel lblNewLabel = new JLabel("LOGIN PAGE");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 17));
		lblNewLabel.setBounds(228, 12, 148, 41);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblUsername = new JLabel("USERNAME");
		lblUsername.setBounds(300, 150, 130, 30);
		frame.getContentPane().add(lblUsername);
		
		user = new JTextField();
		user.setBounds(426, 150, 130, 30);
		frame.getContentPane().add(user);
		user.setColumns(10);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setBounds(300, 215, 70, -50);
		frame.getContentPane().add(lblPassword);
		
		JLabel lblPassword_1 = new JLabel("PASSWORD");
		lblPassword_1.setBounds(300, 206, 92, 25);
		frame.getContentPane().add(lblPassword_1);
		
		pass = new JTextField();
		pass.setBounds(426, 204, 130, 30);
		frame.getContentPane().add(pass);
		pass.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("/home/hrishabh/Downloads/26404245.jpg"));
		lblNewLabel_1.setBounds(0, 0, 643, 324);
		frame.getContentPane().add(lblNewLabel_1);
		
	}
}
