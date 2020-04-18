package com.demo2.demo2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class PatientPaymentDataModel implements controller {
	
	List<patient_payment_details> pat;
	
	Connection con = null;
	
	public PatientPaymentDataModel() {
		
		
		String url = "jdbc:mysql://localhost:3306/patientdb";
		String username = "root";
		String password = "";
		

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,username,password);
			System.out.println(" connected");
		}
		catch(Exception e) {
			System.out.println("not connected" + e);
		}
	}
	
	
	
	@Override
	
	public List<patient_payment_details> getPatient() {
		List<patient_payment_details> pat = new ArrayList<patient_payment_details>();
		
		String sql = "SELECT * FROM patients";
		
		try {
			
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				patient_payment_details pa1 = new patient_payment_details();
				
				pa1.setPatientId(rs.getString(1));
				pa1.setCardNumber(rs.getInt(2));
				pa1.setNameOfTheCard(rs.getString(3));
				pa1.setValidDate(rs.getDate(4));
				pa1.setCvcCode(rs.getInt(5));
				
				pat.add(pa1);
				
			}
		} catch (Exception e) {
			System.out.println("catch 1 "+e);
		}
		return pat;

	}
	
	public patient_payment_details getPatient(String patientId){
		
		String sqlq = "SELECT * FROM patients WHERE patientId="+patientId;
		patient_payment_details pa1 = new patient_payment_details();
		
		try {
			Statement st =  con.createStatement();
			ResultSet rs = st.executeQuery(sqlq);
					
					if(rs.next()) {	
						pa1.setPatientId(rs.getString(1));
						pa1.setCardNumber(rs.getInt(2));
						pa1.setNameOfTheCard(rs.getString(3));
						pa1.setValidDate(rs.getDate(4));
						pa1.setCvcCode(rs.getInt(5));
					}
		
	} catch (Exception e) 
	{
		System.out.println("catch 2 "+e);
	}
	
	
		return pa1;
		
	}
	
	@Override
	public void createPatient(patient_payment_details pat1) {
		String sql = "INSERT INTO patients VALUES (?,?,?,?,?)";
		try {
			
			PreparedStatement st = con.prepareStatement(sql);
	
			st.setString(1, pat1.getPatientId());
			st.setInt(2, pat1.getCardNumber());
			st.setString(3, pat1.getNameOfTheCard());
			st.setDate(4, (Date) pat1.getValidDate());
			st.setInt(5, pat1.getCvcCode());
			
			st.execute();
			
		}catch(Exception e){
			
			System.out.println("catch 3 "+e);
			
		}
	}

		
	public void updatePatient(patient_payment_details pat1) {
		String sql = "UPDATE patient set patientId=? , cardNumber=?, nameOfTheCard=?, validDate=?, cvcCode=?";
		
		try {
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1, pat1.getPatientId());
			st.setInt(2, pat1.getCardNumber());
			st.setString(3, pat1.getNameOfTheCard());
			st.setDate(4, (Date) pat1.getValidDate());
			st.setInt(5, pat1.getCvcCode());
			
			st.executeUpdate();
			
		}catch(Exception e){
			
			System.out.println("catch 3 "+e);
			
		}
	}
	
	@Override
	public String deletePatient(String patientId) {
		String sql = "delete from regHospital where id=?";
        String output;
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, patientId);
            st.executeUpdate();
            output = "Successfully Deleted";
        } catch (SQLException e){
            System.out.println(e);
            output = "Error";
        }
            return output;
    }
	}
	
}
	
	
