/**	
 * Distance calculator class
 * 
 *  This class is responsible for calculation the distance between two points on the sphere(Earth surface).
 *  By using latitude and longitude (in degrees) of two points it computes the great circle distance between them.
 *  
 *  @author: Ankur Yadav
 * 
 */

package MainPackage;

public class DistanceCalculator {
	
	/**
	 * Method: calculateDistance
	 * @param latitudeOfPoint1 Latitude of the first point
	 * @param longitudeOfPoint1 Longitude of the first point
	 * @param latitudeOfPoint2 Latitude of the second point
	 * @param longitudeOfPoint2 Longitude of the second point
	 * @return the distance between the two points given in kilometers		
	 */
	public double calculateDistance(double latitudeOfPoint1, double longitudeOfpoint1, double latitudeOfPoint2, double longitudeOfpoint2){
		double distance = 0d;
		int radius = 6371; // Radius of the Earth in kilometers
		
		// Latitude of both points conversion to radians
		latitudeOfPoint1 = Math.toRadians(latitudeOfPoint1);
		latitudeOfPoint2 = Math.toRadians(latitudeOfPoint2);	
		
		// The absolute difference between Longitudes converted to radians
		double differenceBetweenLongitude = Math.toRadians(Math.abs(longitudeOfpoint1-longitudeOfpoint2));
		
		// Central angle between the two points
		double angleBetweenPoints = Math.acos(Math.sin(latitudeOfPoint1)* Math.sin(latitudeOfPoint2)
								              + Math.cos(latitudeOfPoint1)* Math.cos(latitudeOfPoint2)
								              * Math.cos(differenceBetweenLongitude));
		
		// Distance between the two points
		distance = radius * angleBetweenPoints;
		
		// Returning the distance which is in kilometers
		return distance;
	}
	
}
