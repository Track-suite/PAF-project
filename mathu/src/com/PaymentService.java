package com;

//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
//For JSON
import com.google.gson.*;
//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

import model.Payment;



@Path("/Payment")

public class PaymentService {

	Payment payment = new Payment();
	

	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML) 
	
	public String readPayment() 
	{ 
		return payment.readPayment(); 
	
	}
	
	
	
	
	
	

	@POST
	@Path("/") 
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED) 
	@Produces(MediaType.TEXT_PLAIN) 

	public String insertPayment(@FormParam("user_id") String user_id, 
						@FormParam("method") String method, 
						@FormParam("status") String status, 
						@FormParam("amount") String amount,
						@FormParam("date") String date,
						@FormParam("description") String description)
						
	{ 
	
		String output = payment.insertPayment(user_id, method, status, amount, date, description); 
		return output; 
 
	}









	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)

	public String updatePayment(String itemData)
	{

		JsonObject itemObject = new JsonParser().parse(itemData).getAsJsonObject();

		String payment_id  = itemObject.get("payment_id").getAsString();
		String user_id    = itemObject.get("user_id").getAsString();
		String method    = itemObject.get("method").getAsString();
		String status   = itemObject.get("status").getAsString();
		String amount       = itemObject.get("amount").getAsString();
		String date     = itemObject.get("date").getAsString();
		String description      = itemObject.get("description").getAsString();
		
	
		String output    = payment.updatePayment(payment_id, user_id, method, status, amount, date, description );
		
		return output;
		
		}
			
		










	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)

	public String deletePayment(String itemData)
	{

		Document doc = Jsoup.parse(itemData, "", Parser.xmlParser());

		String payment_id = doc.select("payment_id").text();
	
		String output = payment.deletePayment(payment_id);
	
		return output;
	}



}
