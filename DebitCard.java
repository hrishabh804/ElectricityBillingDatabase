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
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class DebitCard extends JFrame {

	private JPanel contentPane;
	private JTextField txtXxxxxxxxxxxxxxxx;
	private JTextField txtMmyy;
	private JTextField amount;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DebitCard frame = new DebitCard();
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
	public DebitCard() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450,300 );
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCardNumber = new JLabel("CARD NUMBER");
		lblCardNumber.setBounds(12, 55, 116, 32);
		contentPane.add(lblCardNumber);
		
		txtXxxxxxxxxxxxxxxx = new JTextField();
		txtXxxxxxxxxxxxxxxx.setText("xxxx-xxxx-xxxx-xxxx");
		txtXxxxxxxxxxxxxxxx.setBounds(203, 59, 165, 25);
		contentPane.add(txtXxxxxxxxxxxxxxxx);
		txtXxxxxxxxxxxxxxxx.setColumns(10);
		
		JLabel lblCardType = new JLabel("CARD TYPE");
		lblCardType.setBounds(12, 17, 116, 32);
		contentPane.add(lblCardType);
		
		JList list = new JList();
		list.setBounds(283, 48, 1, 1);
		contentPane.add(list);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("VISA");
		comboBox.addItem("MasterCard");
		comboBox.addItem("RuPay");
		
		
		comboBox.setBounds(203, 21, 165, 24);
		contentPane.add(comboBox);
		
		JLabel lblValidThru = new JLabel("VALID THRU");
		lblValidThru.setBounds(12, 102, 116, 15);
		contentPane.add(lblValidThru);
		
		txtMmyy = new JTextField();
		txtMmyy.setText("MM/YY");
		txtMmyy.setBounds(203, 98, 166, 23);
		contentPane.add(txtMmyy);
		txtMmyy.setColumns(10);
		
		JLabel lblAmount = new JLabel("AMOUNT");
		lblAmount.setBounds(12, 176, 116, 15);
		contentPane.add(lblAmount);
		
		amount = new JTextField();
		amount.setColumns(10);
		amount.setBounds(203, 172, 166, 23);
		contentPane.add(amount);
		int sc = UserSession1.getActiveSession();
		String str = Integer.toString(sc);
		amount.setText(str);
		
		JButton btnPay = new JButton("PAY");
		btnPay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					String username = "harish";
					String password = "Hrish@123";
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/DatabaseProject", username, password);
					 UserSession cusid= UserSession.getActiveSession();
					 int userId = cusid.getUserId();
					
					String sql = "update Bills set status = 'PAID' where bill_id = '"+userId+"'";
					System.out.println("querying bills:" +  sql);
					PreparedStatement stmt = con.prepareStatement(sql);
					
					boolean rs = stmt.execute(sql);
					JOptionPane.showMessageDialog(null, "Payment Sucessful");
					close();
					
					
					
					
					
					con.close();
					
				
				
			}catch(Exception e1) {System.out.println(e1);}
			}
		});
		
		btnPay.setBounds(163, 233, 106, 25);
		contentPane.add(btnPay);
		
		JLabel lblPin = new JLabel("PIN");
		lblPin.setBounds(12, 139, 116, 15);
		contentPane.add(lblPin);
		
		passwordField = new JPasswordField();
		passwordField.setText("****");
		passwordField.setBounds(203, 133, 165, 24);
		contentPane.add(passwordField);
	}
}
