/**	
 * Distance calculator class
 * 
 *  This class is responsible for calculation the distance between two points on the sphere(Earth surface).
 *  By using latitude and longitude (in degrees) of two points it computes the great circle distance between them.
 *  
 *  @author: Ankur Yadav
 * 
 */

package DistanceMeasurementUsingCustomerData;

public class DistanceCalculator {
	
	/**
	 * Method: calculateDistance
	 * @param fromPoint: Coordinates of the from point.
	 * @param toPoint: Coordinates of the to point.
	 * @return the distance between the two points given in kilometers		
	 */
	public double calculateDistance(Point fromPoint, Point toPoint){
		double distanceBetweenTwoPoints = 0d;
		final int radiusOfEarthInKilometers = 6371;
		
		// Latitude of both points conversion to radians
		double latitudeOfFromPoint = Math.toRadians(fromPoint.getLatitude());
		double latitudeOfTOPoint = Math.toRadians(toPoint.getLatitude());	
		
		// The absolute difference between Longitudes converted to radians
		double differenceBetweenLongitude = Math.toRadians(Math.abs(fromPoint.getLongitude() - toPoint.getLongitude()));
		
		// Central angle between the two points
		double angleBetweenPoints = Math.acos(Math.sin(latitudeOfFromPoint)*Math.sin(latitudeOfTOPoint)
								              + Math.cos(latitudeOfFromPoint)
								              *Math.cos(latitudeOfTOPoint)
								              *Math.cos(differenceBetweenLongitude));
		
		// Distance between the two points
		distanceBetweenTwoPoints = radiusOfEarthInKilometers * angleBetweenPoints;
		
		// Returning the distance which is in kilometers
		return distanceBetweenTwoPoints;
	}
	
}
