package com.ciit.Alupit;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import javax.swing.ButtonGroup;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.github.lgooddatepicker.components.DatePicker;

public class AdminPanel {

	public JFrame frmAdminPanel;
	private JTextField textFieldSearchBar;
	private JLabel lblSearch;
	private JRadioButton rdbtnFirstName;
	private JRadioButton rdbtnDateOfEntry;
	private JRadioButton rdbtnLastName;
	private JLabel lblLiveDateTime;
	private JButton btnLogout;
	private JTable tableResults;
	private String searchResult;
	private SearchType searchSelection;
	private LocalDate searchDate;
	private String column[] = {"Last Name", "First Name", "Middle Name", "Birth Date", "Date of Entry", "Time of Entry"};
	private String data[][] = {};
	private JScrollPane scrollPane;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminPanel window = new AdminPanel();
					window.frmAdminPanel.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdminPanel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAdminPanel = new JFrame();
		frmAdminPanel.setTitle("Admin Panel");
		frmAdminPanel.setResizable(false);
		frmAdminPanel.setBounds(100, 100, 575, 300);
		frmAdminPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblAdminPanel = new JLabel("Admin Panel");
		lblAdminPanel.setBounds(220, 23, 119, 25);
		lblAdminPanel.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		
		textFieldSearchBar = new JTextField();
		textFieldSearchBar.setBounds(53, 79, 153, 20);
		textFieldSearchBar.setFont(new Font("Bahnschrift", Font.PLAIN, 11));
		textFieldSearchBar.setColumns(10);
		
		DatePicker datePicker = new DatePicker();
		
		lblSearch = new JLabel("Search:");
		lblSearch.setBounds(10, 81, 40, 15);
		lblSearch.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		
		rdbtnFirstName = new JRadioButton("First Name");
		rdbtnFirstName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldSearchBar.setVisible(true);
				textFieldSearchBar.setEnabled(true);
				datePicker.setVisible(false);
				datePicker.setEnabled(false);
			}
		});
		rdbtnFirstName.setBounds(294, 78, 81, 23);
		rdbtnFirstName.setFont(new Font("Bahnschrift", Font.PLAIN, 11));
		rdbtnFirstName.setSelected(true);
		textFieldSearchBar.setVisible(true);
		datePicker.setVisible(false);
		
		rdbtnDateOfEntry = new JRadioButton("Date of Entry");
		rdbtnDateOfEntry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldSearchBar.setVisible(false);
				textFieldSearchBar.setEnabled(false);
				datePicker.setVisible(true);
				datePicker.setEnabled(true);
			}
		});
		rdbtnDateOfEntry.setBounds(458, 78, 91, 23);
		rdbtnDateOfEntry.setFont(new Font("Bahnschrift", Font.PLAIN, 11));
		
		rdbtnLastName = new JRadioButton("Last Name");
		rdbtnLastName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldSearchBar.setVisible(true);
				textFieldSearchBar.setEnabled(true);
				datePicker.setVisible(false);
				datePicker.setEnabled(false);
			}
		});
		rdbtnLastName.setBounds(377, 78, 79, 23);
		rdbtnLastName.setFont(new Font("Bahnschrift", Font.PLAIN, 11));
		
		lblLiveDateTime = new JLabel("September 88 8888 88:88:88 am");
		lblLiveDateTime.setBounds(131, 53, 296, 15);
		lblLiveDateTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblLiveDateTime.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		LiveDateTime(lblLiveDateTime);
		
		btnLogout = new JButton("Logout");
		btnLogout.setBounds(10, 11, 72, 23);
		btnLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AdminLogin adminLogin = new AdminLogin();
				adminLogin.frmAdminLogin.setVisible(true);
				
				frmAdminPanel.setVisible(false);
			}
		});
		btnLogout.setFont(new Font("Bahnschrift", Font.PLAIN, 11));
		
		scrollPane = new JScrollPane();
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchResult = textFieldSearchBar.getText();
				searchDate = datePicker.getDate();
				
				if(searchResult.equals("") && textFieldSearchBar.isVisible()) {
					JOptionPane.showMessageDialog(frmAdminPanel, "Search is empty");
					return;
					}
				
				else if(searchDate == null && datePicker.isVisible()) {
					JOptionPane.showMessageDialog(frmAdminPanel, "Search is empty");
					return;
				}
				if(searchResult != null || searchDate != null){
					if (rdbtnFirstName.isSelected()) {
						searchSelection = SearchType.FirstName;
						data = Visitor.Search(searchResult, searchSelection);
					} else if (rdbtnLastName.isSelected()) {
						searchSelection = SearchType.LastName;
						data = Visitor.Search(searchResult, searchSelection);
					} else if (rdbtnDateOfEntry.isSelected()){
						searchSelection = SearchType.EntryDate;
						data = Visitor.Search(searchDate);
					}
						RedrawTable(data, scrollPane);
						if(data == null || data.length == 0 || data[0].length == 0) {
							JOptionPane.showMessageDialog(frmAdminPanel, "No results");
						}
				}
			}
		});
		btnSearch.setBounds(216, 79, 72, 21);
		btnSearch.setFont(new Font("Bahnschrift", Font.PLAIN, 11));
		
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(rdbtnLastName);
		buttonGroup.add(rdbtnFirstName);
		buttonGroup.add(rdbtnDateOfEntry);
		
		
		scrollPane.setBounds(10, 106, 539, 143);
		
		
		
		frmAdminPanel.getContentPane().setLayout(null);
		frmAdminPanel.getContentPane().add(lblAdminPanel);
		frmAdminPanel.getContentPane().add(lblSearch);
		frmAdminPanel.getContentPane().add(textFieldSearchBar);
		frmAdminPanel.getContentPane().add(rdbtnDateOfEntry);
		frmAdminPanel.getContentPane().add(rdbtnFirstName);
		frmAdminPanel.getContentPane().add(rdbtnLastName);
		frmAdminPanel.getContentPane().add(lblLiveDateTime);
		frmAdminPanel.getContentPane().add(btnLogout);
		frmAdminPanel.getContentPane().add(btnSearch);
		frmAdminPanel.getContentPane().add(scrollPane);
		
		
		
		datePicker.setBounds(53, 75, 153, 25);
		frmAdminPanel.getContentPane().add(datePicker);
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
	void RedrawTable(String[][] data, JScrollPane scrollPane) {
		tableResults = new JTable(data, column);
		tableResults.setEnabled(false);
		tableResults.getTableHeader().setResizingAllowed(false);
		tableResults.getTableHeader().setReorderingAllowed(false);
		scrollPane.setViewportView(tableResults);	
	}
}
