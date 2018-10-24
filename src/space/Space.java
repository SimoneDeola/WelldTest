package space;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Space {
	
	
	private static List<point> points= new ArrayList<point>(); //list of points
	private static List<line> lines= new ArrayList<line>(); //list of unique lines

	

	public static String postPoint(String in) {
		JSONObject input_point=null;
		try {
			//convert the input string into a json
			input_point = new JSONObject(in);
			//convert the json into a point object
			double x= input_point.getDouble("x") ;
			double y = input_point.getDouble("y") ;
			point p= new point(x,y);
			
			//Generate a line pasing through point p and a point in points
			//only if the points have different coordinate
			for(point p1 : points) {
				if(! p.isGeoEqual(p1)) {
					line l= new line(p,p1);
					boolean find=false;
					
					for (line l1 : lines) {
						//check if the line already exist between lines
						if(l1.isEqual(l)) {
							//if the line exist add the point to the line
							l1.addPoint(p);
							find = true;
						}
					}
					//otherwise adding the new line
					if(find==false) {
						lines.add(l);
					}
				}
			}
			
			//add the point to the list
			points.add(p);
			
		} catch (JSONException e) {
			return "Point insertion error: wrong body";
		}
		return "added fine :"+ in;
		
	}

	
	/*
	 * create a jsonarray containing all the points in the space
	 */
	public static String getPoint() {
		JSONArray out= new JSONArray();
		for(point p : points) {
			out.put(p.getJSON());
		}
		return out.toString();
		
	}
	
	
	
	/*
	 * return all the lines with at least n inner points.
	 * generates a jsonarray containing a jsonarray for each line
	 */
	public static String getLine(int n) {
		JSONArray out= new JSONArray();
		for(line l : lines) {
			if(l.getNumPoint()>=n) {
				//put a jsonarray containing the list of points that describe the line
				out.put(l.getJSONPoints());
			}
		}
		return out.toString();
		
	}


	/*
	 * delete all the data in the space.
	 *delete both points and lines.
	 */
	public static void wipe() {
		points= new ArrayList<point>();
		lines = new ArrayList<line>();
	}
	

}
