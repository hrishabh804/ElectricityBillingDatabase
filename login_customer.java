package hrishabh;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JPasswordField;

public class login_customer extends JFrame {

	private JPanel contentPane;
	private JTextField user;
	private JPasswordField pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login_customer frame = new login_customer();
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
	public login_customer() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("EMPLOYEE LOGIN");
		lblNewLabel.setBounds(196, 12, 141, 59);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("/home/hrishabh/Downloads/boss(1).png"));
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
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/DatabaseProject",
							username, password);

					Statement stmt = con.createStatement();
					String sql = "Select *from Employee where Name='" + user.getText() + "' and password='"
							+ pass.getText().toString() + "'";
					ResultSet rs = stmt.executeQuery(sql);

					if (rs.next()) {
						JOptionPane.showMessageDialog(null, "Login sucessfully");
						EmployeePage employee = new EmployeePage();
						employee.setVisible(true);

					} else
						JOptionPane.showMessageDialog(null, "Incorrect username or password");
					con.close();

				} catch (Exception e1) {
					System.out.println(e1);
				}

			}
		});
		btnNewButton.setBounds(226, 216, 117, 25);
		contentPane.add(btnNewButton);

		pass = new JPasswordField();
		pass.setBounds(291, 160, 114, 26);
		contentPane.add(pass);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("/home/hrishabh/Downloads/login-back.jpg"));
		lblNewLabel_2.setBounds(0, 0, 450, 270);
		contentPane.add(lblNewLabel_2);
	}
}
