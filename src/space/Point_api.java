package space;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/*
 * all the API for the /point domain
 */

@Path("/point")
public class Point_api {
	
	
	//insert a point with body {"x": ... , "y": .... }
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String insertPoint(String in) {
		return Space.postPoint(in);
	}
	

}
