package space;

import java.util.Collection;

import org.json.JSONException;
import org.json.JSONObject;

public class point {
	private double x ; //x coordinate
	private double y;  //y coordinate
	
	// unique id, added because i want to have multiple point with same coordinate
	private int id;
	private static int point_id=0;
	
	
	//initialization, assign the incremental id
	public point(double x_in, double y_in) {
		x = x_in; 
		y = y_in;
		id= point.point_id; 
		point.point_id= point.point_id +1;
		
	}

	public double getY() {
		return y;
	}
	
	public double getX() {
		return x;
	}

	//return a json object containing field x and y
	public JSONObject getJSON() {
		JSONObject pj= new JSONObject();
		try {
			pj.put("x", x);
			pj.put("y", y);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return pj;
	}
	

	//check if the two points have the same coordinate
	public boolean isGeoEqual(point p1) {
		return (p1.getX() == x) && (p1.y == y)  ;
	}

	//returnd the id
	public Object getId() {
		return id;
	}

}
