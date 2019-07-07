package hrishabh;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;

public class UpdateUnit extends JFrame {

	private JPanel contentPane;
	private JTextField unit;
	private JTextField cus_id;
	private JTextField eid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateUnit frame = new UpdateUnit();
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
	public UpdateUnit() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblUpdatebill = new JLabel("Usage Entry");

		JLabel lblReportUnits = new JLabel("Report Units");
		SpringLayout springLayout = new SpringLayout();
		springLayout.putConstraint(SpringLayout.WEST, lblReportUnits, 45, SpringLayout.WEST, contentPane);
		springLayout.putConstraint(SpringLayout.EAST, lblReportUnits, -285, SpringLayout.EAST, contentPane);
		springLayout.putConstraint(SpringLayout.NORTH, lblUpdatebill, 12, SpringLayout.NORTH, contentPane);
		springLayout.putConstraint(SpringLayout.WEST, lblUpdatebill, 166, SpringLayout.WEST, contentPane);
		springLayout.putConstraint(SpringLayout.SOUTH, lblUpdatebill, 47, SpringLayout.NORTH, contentPane);
		springLayout.putConstraint(SpringLayout.EAST, lblUpdatebill, 261, SpringLayout.WEST, contentPane);
		contentPane.setLayout(springLayout);
		contentPane.add(lblUpdatebill);
		contentPane.add(lblReportUnits);

		unit = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, unit, -2, SpringLayout.NORTH, lblReportUnits);
		contentPane.add(unit);
		unit.setColumns(10);

		cus_id = new JTextField();
		springLayout.putConstraint(SpringLayout.EAST, unit, 0, SpringLayout.EAST, cus_id);
		cus_id.setColumns(10);
		contentPane.add(cus_id);

		JLabel label = new JLabel("");
		springLayout.putConstraint(SpringLayout.WEST, label, 64, SpringLayout.WEST, contentPane);
		springLayout.putConstraint(SpringLayout.SOUTH, label, -93, SpringLayout.SOUTH, contentPane);
		contentPane.add(label);

		JLabel lblNewLabel = new JLabel("CustomerID");
		springLayout.putConstraint(SpringLayout.NORTH, cus_id, -2, SpringLayout.NORTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.WEST, cus_id, 48, SpringLayout.EAST, lblNewLabel);
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel, -112, SpringLayout.SOUTH, contentPane);
		springLayout.putConstraint(SpringLayout.SOUTH, lblReportUnits, -22, SpringLayout.NORTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 0, SpringLayout.WEST, lblReportUnits);
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel, -290, SpringLayout.EAST, contentPane);
		contentPane.add(lblNewLabel);

		eid = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, eid, 0, SpringLayout.WEST, unit);
		springLayout.putConstraint(SpringLayout.EAST, eid, -128, SpringLayout.EAST, contentPane);
		contentPane.add(eid);
		eid.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("UpdatedBy");
		springLayout.putConstraint(SpringLayout.NORTH, eid, -2, SpringLayout.NORTH, lblNewLabel_1);
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 3, SpringLayout.SOUTH, label);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_1, 0, SpringLayout.WEST, lblReportUnits);
		contentPane.add(lblNewLabel_1);

		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					String username = "harish";
					String password = "Hrish@123";
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/DatabaseProject",
							username, password);
					String sql = "insert into Electricity_usage values(?,?,?,?)";
					PreparedStatement stmt = con.prepareStatement(sql);
					stmt.setDate(1, new java.sql.Date(System.currentTimeMillis()));
					stmt.setString(2, unit.getText());
					stmt.setString(3, cus_id.getText());
					stmt.setString(4, eid.getText());
					boolean rs = stmt.execute();
			

					con.close();
					

				} catch (Exception e1) {
					System.out.println(e1);
				}

			}

		});
		springLayout.putConstraint(SpringLayout.NORTH, btnUpdate, -45, SpringLayout.SOUTH, contentPane);
		springLayout.putConstraint(SpringLayout.WEST, btnUpdate, 147, SpringLayout.WEST, contentPane);
		springLayout.putConstraint(SpringLayout.SOUTH, btnUpdate, -10, SpringLayout.SOUTH, contentPane);
		springLayout.putConstraint(SpringLayout.EAST, btnUpdate, 0, SpringLayout.EAST, lblUpdatebill);
		contentPane.add(btnUpdate);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmployeePage page = new EmployeePage();
				page.setVisible(true);
				close();
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnBack, 0, SpringLayout.NORTH, contentPane);
		springLayout.putConstraint(SpringLayout.WEST, btnBack, 10, SpringLayout.WEST, contentPane);
		contentPane.add(btnBack);
	}
}
