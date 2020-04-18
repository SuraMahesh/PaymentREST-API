package com.demo2.demo2;


import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("patient")
public class patient_payment_detailsResource {
	
	PatientPaymentDataModel patRepo = new PatientPaymentDataModel();
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	
	public List<patient_payment_details> GetPatient()
	{
		System.out.println("Patient Get API Called");
		return patRepo.getPatient();
	}
	
	@GET
	@Path("patient/{patientId}")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	
	public patient_payment_details GetPatient(@PathParam("patientId") String patientId)
	{
		System.out.println("Patients 1 Get API Called");
		return patRepo.getPatient(patientId);
		
		
	}
	
	@POST
	@Path("patient")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public patient_payment_details CreatePatient(patient_payment_details pat1) {
		
		System.out.println("Patient Create API Called");
		patRepo.createPatient(pat1);
		
		return pat1;
	}
	
	@PUT
	@Path("patient")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public patient_payment_details Upadte(patient_payment_details pat1)
	{
		System.out.println("Patient Update API Called");
		patRepo.updatePatient(pat1);
		
		return pat1;
	}
}
