package hrishabh;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.awt.event.ActionEvent;

public class EnterId extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EnterId frame = new EnterId();
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
	public EnterId() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnterBillId = new JLabel("ENTER BILL ID");
		lblEnterBillId.setFont(new Font("Dialog", Font.BOLD, 16));
		lblEnterBillId.setBounds(43, 99, 125, 19);
		contentPane.add(lblEnterBillId);
		
		textField = new JTextField();
		textField.setBounds(215, 96, 143, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnPayBill = new JButton("PAY BILL");
		btnPayBill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PaymentPage page = new PaymentPage();
				page.setVisible(true);
				int cusId = Integer.parseInt(textField.getText());
				UserSession.setActiveSession(new UserSession(cusId, new Date()));
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					String username = "harish";
					String password = "Hrish@123";
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/DatabaseProject", username, password);
					
					String sql = "select amount from Bills where bill_id = '"+textField.getText()+"'";
					PreparedStatement stmt = con.prepareStatement(sql);
					
					ResultSet rs = stmt.executeQuery(sql);
					if(rs.next()) {
						int amount = rs.getInt(1);
						UserSession1.setActiveSession(amount);
						close();
						
					}
					
					
					
					
					con.close();
					
				
				
			}catch(Exception e1) {System.out.println(e1);}
				
				
				
			 
				
			
				
			}
		});
		btnPayBill.setBounds(157, 200, 117, 25);
		contentPane.add(btnPayBill);
	}

}
