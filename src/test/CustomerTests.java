package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import DistanceMeasurementUsingCustomerData.Customer;

public class CustomerTests {

	Customer customer;
	
	@Before
	public void setUp() throws Exception {
		customer = new Customer(0, "Customer Name", 66.5, -5.0);		
	}
	
	@Test
	public void testGetName() {
		assertEquals("Customer Name", customer.getName());
	}
	
	@Test
	public void testGetId() {
		assertEquals(0, customer.getUser_id());
	}
	
	@Test
	public void testGetLatitude() {
		assertEquals(66.5, customer.getLatitude(), 0.0001);
	}
	
	@Test
	public void testGetLongitude() {
		assertEquals(-5.0, customer.getLongitude(), 0.0001);
	}
	
}
