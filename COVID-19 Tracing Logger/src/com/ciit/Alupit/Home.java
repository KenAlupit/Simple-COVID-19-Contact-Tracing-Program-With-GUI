package com.ciit.Alupit;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import com.github.lgooddatepicker.components.DatePicker;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Home {

	public JFrame homeframe;
	private JLabel lblMiddleName;
	private JLabel lblFirstName_2;
	private JTextField textFieldLastName;
	private JLabel lblPhoneNumber;
	private JTextField textFieldMiddleName;
	private JTextField textFieldFirstName;
	private JTextField textFieldPhoneNumber;
	private JLabel lblBirthDate;
	private DatePicker datePicker;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
					window.homeframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Home() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		homeframe = new JFrame();
		homeframe.setResizable(false);
		homeframe.setTitle("COVID 19 Store Tracker");
		homeframe.setBounds(100, 100, 450, 300);
		homeframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JLabel lblLabel = new JLabel("COVID-19 Store Logger");
		lblLabel.setBounds(52, 22, 339, 25);
		lblLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblLabel.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		JLabel lblLiveDateTime = new JLabel("September 88 8888 88:88:88 am");
		lblLiveDateTime.setBounds(73, 53, 296, 15);
		lblLiveDateTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblLiveDateTime.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		LiveDateTime(lblLiveDateTime);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(53, 91, 106, 14);
		lblFirstName.setFont(new Font("Bahnschrift", Font.PLAIN, 11));
		lblFirstName.setHorizontalAlignment(SwingConstants.LEFT);
		lblFirstName.setVerticalAlignment(SwingConstants.TOP);
		
		lblMiddleName = new JLabel("Middle Name");
		lblMiddleName.setBounds(169, 91, 106, 14);
		lblMiddleName.setFont(new Font("Bahnschrift", Font.PLAIN, 11));
		lblMiddleName.setHorizontalAlignment(SwingConstants.LEFT);
		
		lblFirstName_2 = new JLabel("Last Name");
		lblFirstName_2.setBounds(285, 91, 65, 14);
		lblFirstName_2.setFont(new Font("Bahnschrift", Font.PLAIN, 11));
		lblFirstName_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblFirstName_2.setVerticalAlignment(SwingConstants.TOP);
		
		textFieldLastName = new JTextField();
		textFieldLastName.setBounds(285, 111, 106, 25);
		textFieldLastName.setFont(new Font("Bahnschrift", Font.PLAIN, 11));
		textFieldLastName.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldLastName.setColumns(10);
		
		lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setBounds(53, 142, 103, 14);
		lblPhoneNumber.setFont(new Font("Bahnschrift", Font.PLAIN, 11));
		lblPhoneNumber.setVerticalAlignment(SwingConstants.TOP);
		lblPhoneNumber.setHorizontalAlignment(SwingConstants.LEFT);
		
		datePicker = new DatePicker();
		datePicker.setBounds(169, 160, 163, 25);
		datePicker.getComponentDateTextField().setFont(new Font("Bahnschrift", Font.PLAIN, 11));
		datePicker.getComponentToggleCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		textFieldMiddleName = new JTextField();
		textFieldMiddleName.setBounds(169, 111, 106, 25);
		textFieldMiddleName.setFont(new Font("Bahnschrift", Font.PLAIN, 11));
		textFieldMiddleName.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldMiddleName.setColumns(10);
		
		textFieldFirstName = new JTextField();
		textFieldFirstName.setBounds(53, 111, 106, 25);
		textFieldFirstName.setFont(new Font("Bahnschrift", Font.PLAIN, 11));
		textFieldFirstName.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldFirstName.setColumns(10);
		
		textFieldPhoneNumber = new JTextField();
		textFieldPhoneNumber.setBounds(53, 162, 106, 23);
		textFieldPhoneNumber.setFont(new Font("Bahnschrift", Font.PLAIN, 11));
		textFieldPhoneNumber.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldPhoneNumber.setColumns(10);
		
		lblBirthDate = new JLabel("Birthday");
		lblBirthDate.setBounds(172, 142, 103, 14);
		lblBirthDate.setFont(new Font("Bahnschrift", Font.PLAIN, 11));
		lblBirthDate.setVerticalAlignment(SwingConstants.TOP);
		lblBirthDate.setHorizontalAlignment(SwingConstants.LEFT);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String firstName = textFieldFirstName.getText();
				
				if (firstName.length() <= 0) {
					JOptionPane.showMessageDialog(homeframe, "First name required");
					return;
				}
				String middleName = textFieldMiddleName.getText();
				String lastName = textFieldLastName.getText();
				if (lastName.length() <= 0) {
					JOptionPane.showMessageDialog(homeframe, "Last name required");
					return;
				}
				String phoneNumber = textFieldPhoneNumber.getText();
				if (phoneNumber.length() <= 0) {
					JOptionPane.showMessageDialog(homeframe, "Phone number required");
					return;
				}
				if (phoneNumber.length() != 10 && phoneNumber.length() != 11) {
					JOptionPane.showMessageDialog(homeframe, "Phone number length is incorrect");
					return;
				}
				if(phoneNumber.length() == 10) {
					if(phoneNumber.matches("9.\\d*") == false) {
						JOptionPane.showMessageDialog(homeframe, "Phone number format is incorrect");
						return;
					}
				}
				if(phoneNumber.length() == 11) {
					if(phoneNumber.matches("09.\\d*") == false) {
						JOptionPane.showMessageDialog(homeframe, "Phone number format is incorrect");
					return;
					}
				}
				LocalDate birthDate = datePicker.getDate();
				if (birthDate == null) {
					JOptionPane.showMessageDialog(homeframe, "Birthdate required");
					return;
				}
				
				archiveVisitor(firstName, middleName, lastName, phoneNumber, birthDate);
			}
		});
		btnSubmit.setBounds(185, 200, 74, 23);
		btnSubmit.setFont(new Font("Bahnschrift", Font.PLAIN, 11));
		
		JLabel lblAdminPanel = new JLabel("Admin Panel");
		lblAdminPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AdminLogin adminLogin = new AdminLogin();
				adminLogin.frmAdminLogin.setVisible(true);
				
				homeframe.setVisible(false);
			}
		});
		lblAdminPanel.setBounds(355, 235, 65, 14);
		lblAdminPanel.setFont(new Font("Bahnschrift", Font.BOLD, 11));
		homeframe.getContentPane().setLayout(null);
		homeframe.getContentPane().add(lblPhoneNumber);
		homeframe.getContentPane().add(lblBirthDate);
		homeframe.getContentPane().add(textFieldFirstName);
		homeframe.getContentPane().add(lblFirstName);
		homeframe.getContentPane().add(lblMiddleName);
		homeframe.getContentPane().add(textFieldMiddleName);
		homeframe.getContentPane().add(lblFirstName_2);
		homeframe.getContentPane().add(lblAdminPanel);
		homeframe.getContentPane().add(textFieldLastName);
		homeframe.getContentPane().add(textFieldPhoneNumber);
		homeframe.getContentPane().add(datePicker);
		homeframe.getContentPane().add(lblLabel);
		homeframe.getContentPane().add(lblLiveDateTime);
		homeframe.getContentPane().add(btnSubmit);
	}

	private void LiveDateTime(JLabel label) {
		Runnable runnable = new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
				while(true){
					DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMMM dd, yyyy hh:mm:ss a");
					LocalDateTime now = LocalDateTime.now();
					label.setText(dtf.format(now));
					
					try {
						Thread.sleep(1000);
					}catch (InterruptedException e){
						e.printStackTrace();
					}
				}
			}
		};
		Thread t = new Thread(runnable);
		t.start();
	}
	private void archiveVisitor(String firstName, String middleName, String lastName, String phoneNumber, LocalDate birthDate) {
		Visitor newVisitor = new Visitor(firstName, middleName, lastName, phoneNumber, birthDate);
		Visitor.visitorList.add(newVisitor);
		
		JOptionPane.showMessageDialog(homeframe, "Visitor details successfully logged");
		
		textFieldFirstName.setText("");
		textFieldMiddleName.setText("");
		textFieldLastName.setText("");
		textFieldPhoneNumber.setText("");
		datePicker.clear();
	}
}
