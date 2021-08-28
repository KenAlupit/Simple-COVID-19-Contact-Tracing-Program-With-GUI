package com.ciit.Alupit;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;

public class Visitor {
	
	public static LinkedList<Visitor> visitorList = new LinkedList<>();
	
	private String firstName;
	private String MiddleName;
	private String lastName;
	private String phoneNumber;
	private LocalDate birthDate;
	private LocalDate visitDate;
	private String visitTime;
	private DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("hh:mm a");
	
	public Visitor(String firstName, String MiddleName, String lastName, String phoneNumber, LocalDate birthDate) {
		setFirstName(firstName);
		setMiddleName(MiddleName);
		setLastName(lastName);
		setPhoneNumber(phoneNumber);
		setBirthDate(birthDate);
		setVisitDate(LocalDate.now());
		setVisitTime(LocalTime.now());
	}
	
	private void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	private void setMiddleName(String middleName) {
		MiddleName = middleName;
	}
	
	private void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	private void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	private void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	
	private void setVisitDate(LocalDate visitDate) {
		this.visitDate = visitDate;
	}
	
	public void setVisitTime(LocalTime visitTime) {
		this.visitTime = visitTime.format(timeFormat);
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getMiddleName() {
		return MiddleName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public LocalDate getBirthDate() {
		return birthDate;
	}
	
	public LocalDate getVisitDate() {
		return visitDate;
	}
	
	public String getVisitTime() {
		return visitTime;
	}

	
	public static String[][] Search(String searchKeyword, SearchType searchType) {
		LinkedList <Visitor> resultList = new LinkedList<>();
		
		for (Visitor v:visitorList) {
			
			switch(searchType) {
			case LastName:
				if (v.lastName.equalsIgnoreCase(searchKeyword)) {
					resultList.add(v);
				}
				break;
			case FirstName:
				if (v.firstName.equalsIgnoreCase(searchKeyword)) {
					resultList.add(v);
				}
				break;
			}
		}
		String results[][] = new String [resultList.size()][6];
		for(int i = 0; i < resultList.size(); i++) {
			results[i][0] = resultList.get(i).getLastName();
			results[i][1] = resultList.get(i).getFirstName();
			results[i][2] = resultList.get(i).getMiddleName();
			results[i][3] = resultList.get(i).getBirthDate().toString();
			results[i][4] = resultList.get(i).getVisitDate().toString();
			results[i][5] = resultList.get(i).getVisitTime();
			
		}
		
	return results;
	}
	
	public static String[][] Search(LocalDate searchDate) {
		LinkedList <Visitor> resultList = new LinkedList<>();
		
		for (Visitor v:visitorList) {
			LocalDate visitDate = v.getVisitDate();
			if(visitDate.equals(searchDate)) {
				resultList.add(v);
			}
		}
		String results[][] = new String [resultList.size()][6];
		for(int i = 0; i < resultList.size(); i++) {
			results[i][0] = resultList.get(i).getLastName();
			results[i][1] = resultList.get(i).getFirstName();
			results[i][2] = resultList.get(i).getMiddleName();
			results[i][3] = resultList.get(i).getBirthDate().toString();
			results[i][4] = resultList.get(i).getVisitDate().toString();
			results[i][5] = resultList.get(i).getVisitTime();
			
		}
		
	return results;
	}
}
