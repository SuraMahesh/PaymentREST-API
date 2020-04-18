package com.demo2.demo2;


import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class patient_payment_details {
	
	private String patientId;
	private int cardNumber;
	private String nameOfTheCard;
	private Date validDate;
	private int cvcCode;
	
	public patient_payment_details(){}
	
	
	public String getPatientId() {
		return patientId;
	}
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	public int getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getNameOfTheCard() {
		return nameOfTheCard;
	}
	public void setNameOfTheCard(String nameOfTheCard) {
		this.nameOfTheCard = nameOfTheCard;
	}
	public Date getValidDate() {
		return validDate;
	}
	public void setValidDate(Date validDate) {
		this.validDate = validDate;
	}
	public int getCvcCode() {
		return cvcCode;
	}
	public void setCvcCode(int cvcCode) {
		this.cvcCode = cvcCode;
	}
	
	@Override
	public String toString() {
		return "patient_payment_details{" + 
				"patientId=" + patientId +
				", cardNumber='" + cardNumber + '\'' +
				", nameOfTheCard='" + nameOfTheCard + '\'' +
				'}';
	}
	
	

}
