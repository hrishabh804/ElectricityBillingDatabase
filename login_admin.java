package hrishabh;

import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class login_admin extends JFrame {

	private JPanel contentPane;
	private JTextField user;
	private JPasswordField pass;
	private int cusId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						login_admin frame = new login_admin();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}finally {
						//DatabaseConnection.close();
					}
				}
			});
		 

	}

	/**
	 * Create the frame.
	 */
	public login_admin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("CUSTOMER LOGIN");
		lblNewLabel.setBounds(184, 12, 141, 59);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("/home/hrishabh/Downloads/boy.png"));
		lblNewLabel_1.setBounds(101, 0, 71, 71);
		contentPane.add(lblNewLabel_1);

		JLabel lblUsername = new JLabel("USERNAME");
		lblUsername.setBounds(184, 122, 89, 26);
		contentPane.add(lblUsername);

		user = new JTextField();
		user.setBounds(291, 123, 114, 26);
		contentPane.add(user);
		user.setColumns(10);

		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setBounds(184, 160, 99, 26);
		contentPane.add(lblPassword);

		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					String username = "harish";
					String password = "Hrish@123";
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/DatabaseProject", username, password);

					String sql = "Select cus_id from Customer where F_name='" + user.getText() + "' and password='"+ pass.getText().toString() + "'";
					PreparedStatement stmt = con.prepareStatement(sql);
					ResultSet rs = stmt.executeQuery(sql);
				

				try {
					if (rs.next()) {

						cusId = rs.getInt(1);
						UserSession.setActiveSession(new UserSession(cusId, new Date()));

						System.out.println("the result is: " + sql + ":" + cusId);
						Customer_page customer = new Customer_page();
						customer.setVisible(true);

					} else {
						JOptionPane.showMessageDialog(null, "Incorrect username or password");
					}
				} catch (HeadlessException | SQLException e1) {
					e1.printStackTrace();
				}
				} catch (Exception e1) {
					System.out.println(e1);
				}
			}
		}

		);
		btnNewButton.setBounds(288, 216, 117, 25);
		contentPane.add(btnNewButton);

		pass = new JPasswordField();
		pass.setBounds(291, 161, 114, 25);
		contentPane.add(pass);
		
		JButton btnSignU = new JButton("SIGN UP");
		btnSignU.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignUp sign = new SignUp();
				sign.setVisible(true);
			}
			
		});
		btnSignU.setBounds(59, 216, 117, 25);
		contentPane.add(btnSignU);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("/home/hrishabh/Downloads/login-back.jpg"));
		lblNewLabel_2.setBounds(0, -27, 450, 297);
		contentPane.add(lblNewLabel_2);

	}
}