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

//model class
import model.Investor;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;




@Path("/InvestorService")
public class InvestorService {
	
	// create object
	Investor investObj = new Investor();

	//Read
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	
	public String readInvestor() {
		return investObj.readInvestor();
	}
	
	//Insert function
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	
	public String insertinvestor(

			
			@FormParam("investorName") String investorName,
			@FormParam("Mail") String Mail,
			@FormParam("phoneNumber") String phoneNumber,
			@FormParam("ProjectCode") String ProjectCode,
			@FormParam("ProjectName") String ProjectName,
			@FormParam("InvestAmount") String InvestAmount) {

		String output = investObj.insertinvestor(investorName, Mail,phoneNumber,ProjectCode,ProjectName,InvestAmount);
		return output;
	}
	
	//update function
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateInvestor(String investData) {
		
		// Convert the input string to a JSON object
		JsonObject investobject = new JsonParser().parse(investData).getAsJsonObject();
				
				// Read the values from the JSON object
				String investorID = investobject.get("investorID").getAsString();
				String investorName = investobject.get("investorName").getAsString();
				String Mail = investobject.get("Mail").getAsString();
				String phoneNumber = investobject.get("phoneNumber").getAsString();
				String ProjectCode = investobject.get("ProjectCode").getAsString();
				String ProjectName = investobject.get("ProjectName").getAsString();
				String InvestAmount= investobject.get("InvestAmount").getAsString();

				String output = investObj.updateInvestor(investorID,investorName,Mail,phoneNumber,ProjectCode,ProjectName,InvestAmount);

				return output;
	}
	
	//Delete function
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteinvestor(String investData) {

		// Convert the input string to an XML document
		Document doc = Jsoup.parse(investData, "", Parser.xmlParser());

		// Read the value from the element <ProductID>
		String investID = doc.select("investID").text();

		String output = investObj.deleteinvestor(investID);
		return output;
	}
	
}
