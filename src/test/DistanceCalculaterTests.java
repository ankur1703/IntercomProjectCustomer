package test;

import static org.junit.Assert.*;

import org.junit.Test;

import DistanceMeasurementUsingCustomerData.DistanceCalculator;
import DistanceMeasurementUsingCustomerData.Point;

public class DistanceCalculaterTests {
	
	DistanceCalculator distanceCalculator = new DistanceCalculator();
	Point fromPoint;
	Point toPoint;
	double distance;
	
	@Test
	public void testDistance0WhenToAndFromPointAre0() {
		fromPoint = new Point(0, 0);
		toPoint = new Point(0, 0);
		
		distance = distanceCalculator.calculateDistance(fromPoint, toPoint);
		
		assertEquals("0.0", Double.toString(distance));
	}
	
	@Test
	public void testDistance0WhenToAndFromAreSamePoints() {
		fromPoint = new Point(0, 0);
		toPoint = fromPoint;
		
		distance = distanceCalculator.calculateDistance(fromPoint, toPoint);
		
		assertEquals("0.0", Double.toString(distance));
	}
	
	@Test
	public void testDistanceWhenToAndFromAreGivenPoints() {
		fromPoint = new Point(53.3381985, -6.2592576);
		toPoint = new Point(53.2451022, -6.238335);;
		
		distance = distanceCalculator.calculateDistance(fromPoint, toPoint);
		
		assertEquals("10.444825878807219", Double.toString(distance));
	}

}
