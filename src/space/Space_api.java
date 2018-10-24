package space;

import javax.ws.rs.GET;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/*
 * all the API for the /space domain
 */

@Path("/space")
public class Space_api {
	
	//return a JSONArray containing all the points in the space
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getPoint() {
		return Space.getPoint();
	}
	
	//wipe all the points and lines in the space, return 'done.'
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public String delPoint() {
		Space.wipe();
		return "done.";
	}

	

}