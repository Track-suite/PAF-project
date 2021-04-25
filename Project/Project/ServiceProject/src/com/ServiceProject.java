package com;

//Model
import model.Project;


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
@Path("/ProjectService")
public class ServiceProject {

	Project project = new Project();
	
	// Read
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)

	public String readPayment() {

		return project.readProject();
	}
	
	// Insert
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertProject(

			@FormParam("name") String name,
			@FormParam("cost") String cost,
			@FormParam("duration") String duration,
			@FormParam("author") String author
			) {

		String output = project.insertProject(name, cost, duration, author);
		return output;
	}

	// Update
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateProject(String projectData) {

		// Convert the input string to a JSON object
		JsonObject projectObject = new JsonParser().parse(projectData).getAsJsonObject();

		// Read the values from the JSON object
		String id = projectObject.get("id").getAsString();
		String name = projectObject.get("name").getAsString();
		String cost = projectObject.get("cost").getAsString();
		String duration = projectObject.get("duration").getAsString();
		String author = projectObject.get("author").getAsString();
		

		String output = project.updateProject(id, name, cost, duration, author);

		return output;
	}

	
	// Delete
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteProject(String projectData) {

		// Convert the input string to an XML document
		Document doc = Jsoup.parse(projectData, "", Parser.xmlParser());

		// Read the value from the element <ProductID>
		String id = doc.select("id").text();

		String output = project.deleteProject(id);
		return output;
	}
}
