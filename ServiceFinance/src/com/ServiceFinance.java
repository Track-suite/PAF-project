package com;

//Model
import model.Finance;

//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

//For JSON
import com.google.gson.*;

//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

//SET PATH ..............................................
@Path("/FinanceService")
public class ServiceFinance {
	
	// Object
	Finance finance1Obj = new Finance();

	// Read
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)

	public String readFinance() {

		return finance1Obj.readFinance();
	}
	
	// Insert
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertFinance(

			@FormParam("finance_Type") String finance_Type,
			@FormParam("cost") String cost,
			@FormParam("account_Type") String account_Type) {

		String output = finance1Obj.insertFinance(finance_Type, cost, account_Type);
		return output;
	}

	// Update
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateFinance(String finance1Data) {

		// Convert the input string to a JSON object
		JsonObject finance1Object = new JsonParser().parse(finance1Data).getAsJsonObject();

		// Read the values from the JSON object
		String finance_ID = finance1Object.get("finance_ID").getAsString();
		String finance_Type = finance1Object.get("finance_Type").getAsString();
		String cost = finance1Object.get("cost").getAsString();
		String account_Type = finance1Object.get("account_Type").getAsString();

		String output = finance1Obj.updateFinance(finance_ID, finance_Type, cost, account_Type);

		return output;
	}

	
	// Delete
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteFinance(String finance1Data) {

		// Convert the input string to an XML document
		Document doc = Jsoup.parse(finance1Data, "", Parser.xmlParser());

		// Read the value from the element <ProductID>
		String finance_ID = doc.select("finance_ID").text();

		String output = finance1Obj.deleteFinance(finance_ID);
		return output;
	}

}
