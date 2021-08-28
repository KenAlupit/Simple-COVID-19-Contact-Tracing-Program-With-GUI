package com.ciit.Alupit;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminLogin {

	public JFrame frmAdminLogin;
	private JTextField textFieldUsername;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLogin window = new AdminLogin();
					window.frmAdminLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdminLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAdminLogin = new JFrame();
		frmAdminLogin.setResizable(false);
		frmAdminLogin.setTitle("Admin Login");
		frmAdminLogin.setBounds(100, 100, 450, 300);
		frmAdminLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblAdminPanel = new JLabel("Admin Login");
		lblAdminPanel.setBounds(168, 28, 108, 23);
		lblAdminPanel.setFont(new Font("Bahnschrift", Font.BOLD, 18));
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(124, 69, 54, 15);
		lblUsername.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		
		textFieldUsername = new JTextField();
		textFieldUsername.setBounds(123, 90, 197, 20);
		textFieldUsername.setFont(new Font("Bahnschrift", Font.PLAIN, 11));
		textFieldUsername.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(124, 130, 54, 15);
		lblPassword.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		
		passwordField = new JPasswordField();
		passwordField.setBounds(124, 151, 197, 20);
		passwordField.setFont(new Font("Bahnschrift", Font.PLAIN, 11));
		passwordField.setEchoChar('*');
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Username = textFieldUsername.getText();
				String Password = String.valueOf(passwordField.getPassword());
				if(Username.length() <= 0) {
					JOptionPane.showMessageDialog(frmAdminLogin, "Username required");
					return;
				}
				if(Password.length() <=0) {
					JOptionPane.showMessageDialog(frmAdminLogin, "Password required");
					return;
				}
				if(Username.equals("admin") && Password.equals("admin")) {
					AdminPanel newAdminPanel = new AdminPanel();
					newAdminPanel.frmAdminPanel.setVisible(true);
					
					frmAdminLogin.setVisible(false);
				}
				else{
					JOptionPane.showMessageDialog(frmAdminLogin, "Incorrect password or username please try again");
					textFieldUsername.setText("");
					passwordField.setText("");
				}
			}
		});
		
		btnLogin.setBounds(187, 189, 70, 23);
		btnLogin.setFont(new Font("Bahnschrift", Font.PLAIN, 11));
		frmAdminLogin.getContentPane().setLayout(null);
		
		JLabel lblBackToHome = new JLabel("Back to home");
		lblBackToHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Home newHome = new Home();
				newHome.homeframe.setVisible(true);
				
				frmAdminLogin.setVisible(false);
				
			}
		});
		lblBackToHome.setBounds(10, 11, 70, 14);
		lblBackToHome.setFont(new Font("Bahnschrift", Font.BOLD, 11));
		frmAdminLogin.getContentPane().add(lblBackToHome);
		frmAdminLogin.getContentPane().add(lblUsername);
		frmAdminLogin.getContentPane().add(textFieldUsername);
		frmAdminLogin.getContentPane().add(lblPassword);
		frmAdminLogin.getContentPane().add(passwordField);
		frmAdminLogin.getContentPane().add(lblAdminPanel);
		frmAdminLogin.getContentPane().add(btnLogin);
	}
}
