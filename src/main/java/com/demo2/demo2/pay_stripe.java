package com.demo2.demo2;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@Path("payment/")
public class pay_stripe {
	
	StripeProcessHandling sh = new StripeProcessHandling();
	
	@POST
	@Path("ppatient")
	@Consumes( MediaType.APPLICATION_FORM_URLENCODED)
	public String createUser(@FormParam("email") String  email, @FormParam("name") String name) {
	
		String output = sh.createUser(email,name);
		return output;
		
	}
	
	@POST
	@Path("addcard")
	@Consumes( MediaType.APPLICATION_FORM_URLENCODED)
	public String addCard(@FormParam("userId") String userId,@FormParam("number") String number,@FormParam("exp_month") String exp_month,@FormParam("exp_year") String exp_year,@FormParam("cvc") String cvc)  {
		
		String output = sh.addCardtoUser(userId,number,exp_month,exp_year,cvc);
		return output;
	}
	
	@POST
	@Path("paycharge")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String payCharge(@FormParam("cusId") String cusId,@FormParam("amount") String amount) {
		
		String output = sh.payCharge(cusId,amount);
		return output;
	}

}