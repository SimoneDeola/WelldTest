package space;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/*
 * all the API for the /lines domain
 */

@Path("/lines")
public class Line_api {
	
	//return a JSONArray with all the lines with at least n points. 
	//the lines are defined by a list of all the points contained.
	@GET
	@Path("/{n}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getLines(@PathParam("n") int n) {
		return Space.getLine(n);
		
	}

}
