package hrishabh;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;

public class Main_page {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_page window = new Main_page();
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
	public Main_page() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("  WELCOME TO ELECTRICITY BOARD");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 22));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(Color.RED);
		lblNewLabel.setBounds(0, 12, 594, 27);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
			frame.dispose();
			login_admin page = new login_admin();
			page.setVisible(true);

			}
		});
		lblNewLabel_2.setBackground(Color.GREEN);
		lblNewLabel_2.setIcon(new ImageIcon("/home/hrishabh/Downloads/boy.png"));
		lblNewLabel_2.setBounds(272, 81, 86, 90);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				login_customer page = new login_customer();
				page.setVisible(true);
			}
		});
		lblNewLabel_3.setIcon(new ImageIcon("/home/hrishabh/Downloads/boss(1).png"));
		lblNewLabel_3.setBounds(92, 81, 86, 90);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("ADMIN LOGIN");
		lblNewLabel_4.setForeground(Color.BLACK);
		lblNewLabel_4.setBounds(81, 183, 92, 15);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("CUSTOMER LOGIN");
		lblNewLabel_5.setForeground(Color.BLACK);
		lblNewLabel_5.setBounds(245, 183, 124, 15);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("/home/hrishabh/Downloads/istockphoto-461972130-640x640.jpg"));
		lblNewLabel_1.setBounds(-17, -27, 510, 308);
		frame.getContentPane().add(lblNewLabel_1);
	}

	public void setVisible(boolean b) {
		Main_page window = new Main_page();
		window.frame.setVisible(true);
		
		// TODO Auto-generated method stub
		
	}
}
