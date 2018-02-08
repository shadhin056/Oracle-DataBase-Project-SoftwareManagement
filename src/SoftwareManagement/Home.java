package SoftwareManagement;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class Home extends JFrame {

	private JPanel contentPane;
	private JTextField tfUser;
	private JPasswordField pfPass;

	String adminPass = "admin";
	String userPass = "user";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 754, 454);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		tfUser = new JTextField();
		tfUser.setBounds(171, 75, 86, 20);
		contentPane.add(tfUser);
		tfUser.setColumns(10);

		pfPass = new JPasswordField();
		pfPass.setBounds(171, 117, 86, 20);
		contentPane.add(pfPass);

		JLabel lblUser = new JLabel("User");
		lblUser.setBounds(115, 78, 46, 14);
		contentPane.add(lblUser);

		JLabel lblPass = new JLabel("Pass");
		lblPass.setBounds(115, 120, 46, 14);
		contentPane.add(lblPass);

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String user, pass;

				user = tfUser.getText();
				pass = pfPass.getText();

				String tempPass;
				if (user.equals("user")) {
					tempPass = userPass;

					if (pass.equals(userPass)) {
						User frame = new User();
						frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						frame.setVisible(true);
						
					}else{
						JOptionPane.showMessageDialog(null, user+ "Pass wrong");
					}
					

				} else if (user.equals("admin")) {
					tempPass = adminPass;
					if (pass.equals(adminPass)) {
						Admin frame = new Admin();
						frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						frame.setVisible(true);
					}else{
						JOptionPane.showMessageDialog(null, user+ "Pass wrong");
					}
				}

			}
		});
		btnLogin.setBounds(142, 166, 89, 23);
		contentPane.add(btnLogin);
	}
}
