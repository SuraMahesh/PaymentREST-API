package com.demo2.demo2;

import java.util.List;

public interface controller {
	
	public void createPatient(patient_payment_details pat1);
	
	public patient_payment_details getPatient(String patientId);
	
	public List<patient_payment_details> getPatient();
	
	public void upadtePatient(patient_payment_details pat1);
	
	public String deletePatient(String patientId);
}
