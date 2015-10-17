package MainPackage;

public class DistanceCalculater {
	
	public double calculateDistance(double latitudeOfPoint1, double longitudeOfpoint1, double latitudeOfPoint2, double longitudeOfpoint2){
		double distance = 0d;
		int radius = 6371;
		
		latitudeOfPoint1 = Math.toRadians(latitudeOfPoint1);
		latitudeOfPoint2 = Math.toRadians(latitudeOfPoint2);	
		double differenceBetweenLongitude = Math.toRadians(Math.abs(longitudeOfpoint1-longitudeOfpoint2));
		
		double angleBetweenPoints = Math.acos(Math.sin(latitudeOfPoint1)*Math.sin(latitudeOfPoint2)
								              + Math.cos(latitudeOfPoint1)*Math.cos(latitudeOfPoint2)
								              *Math.cos(differenceBetweenLongitude));
		
		distance = radius*angleBetweenPoints;
		return distance;
	}
	
}
