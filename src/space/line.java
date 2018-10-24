package space;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class line {
	private double m;
	private double b;
	
	private List<point> inner_points;
	
	//generate the two parameter that identify a line by passing two points
	public line(point Pa, point Pb) {
		//check if the line is not vertical
		if((Pa.getX() - Pb.getX()) != 0) {
			m= (Pa.getY() - Pb.getY())/ (Pa.getX() - Pb.getX());
			b= Pa.getY() - (m * Pa.getX());
		}else {
			//if it is vertical use MAX_VALUE as inf. and identify the line by the x parameter
			m= Double.MAX_VALUE;
			b= Pa.getX();
		}
		
		//add the points to the line
		inner_points= new ArrayList<point>();
		inner_points.add(Pa);
		inner_points.add(Pb);
	}

	//check if the parameter m and b are equal
	public boolean isEqual(line l) {
		return (l.getM() == m) && (l.getB() == b);
	}

	private double getM() {
		return m;
	}
	private double getB() {
		return b;
	}
	
	//adding a point that is not already in the line,
	//there can be two points with same coordinates but different ids
	public void addPoint(point p) {
		boolean add= true;
		for( point p1 : inner_points) {
			//check the id, not the coordinates of the points, this allow more than one
			//points in the same spot
			if(p1.getId()==p.getId()) {
				add=false;
			}
		}
		if(add) {
			inner_points.add(p);
		}
	}

	
	public int getNumPoint() {
		return inner_points.size();
	}

	//return the jsonarray of the points (e.g [ {"x": 1, "y":2}, {"x":..... ] )
	public JSONArray getJSONPoints() {
		JSONArray out= new JSONArray();
		try {
			for(point p : inner_points) {
				out.put(p.getJSON());
			}
			return out;
		}catch(NullPointerException e) {
			return out;
		}
	}
	
	

}
