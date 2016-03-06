package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import FlattenAnArray.FlattenArray;

public class FlattenArrayTests {
	
	FlattenArray flattenArray = new FlattenArray();
	ArrayList<Object> arrayToFlat;
	ArrayList<Integer> flattenedArray;
	ArrayList<Integer> expectedArray;
	
	@Test
	public void testEmptyArrayReturnedEmptyArray() {
		arrayToFlat = new ArrayList<Object>();
		flattenedArray =  flattenArray.flatArray(arrayToFlat);
		assertTrue(flattenedArray.isEmpty());
	}

	@Test
	public void testArrayWithSingleIntegerElementInTheList() {
		arrayToFlat = new ArrayList<Object>();		
		arrayToFlat.add(4);
		
		expectedArray = new ArrayList<Integer>();
		expectedArray.add(4);
		
		flattenedArray =  flattenArray.flatArray(arrayToFlat);
		assertEquals(expectedArray , flattenedArray);
	}
	
	@Test
	public void testArrayWithSingleListInTheList() {
		arrayToFlat = new ArrayList<Object>();		
		
		ArrayList<Object> firstList = new ArrayList<>();
		firstList.add(4);
		firstList.add(36);
		firstList.add(199);
		firstList.add(77);
		
		arrayToFlat.add(firstList);
		
		expectedArray = new ArrayList<Integer>();
		expectedArray.add(4);
		expectedArray.add(36);
		expectedArray.add(199);
		expectedArray.add(77);
		
		flattenedArray =  flattenArray.flatArray(arrayToFlat);
		assertEquals(expectedArray , flattenedArray);
	}
	
	@Test
	public void testArrayWithSingleIntegerElementAndNullElementInTheListInTheList() {
		arrayToFlat = new ArrayList<Object>();		
		arrayToFlat.add(6);
		
		ArrayList<Object> firstList = new ArrayList<>();
		firstList.add(null);
		arrayToFlat.add(firstList);
		
		expectedArray = new ArrayList<Integer>();
		expectedArray.add(6);
		
		flattenedArray =  flattenArray.flatArray(arrayToFlat);
		assertEquals(expectedArray , flattenedArray);
	}
	
	@Test
	public void testArrayWithSingleIntegerElementAndSingleEmptyListInTheList() {
		arrayToFlat = new ArrayList<Object>();		
		arrayToFlat.add(6);
		
		ArrayList<Object> firstList = new ArrayList<>();
		
		arrayToFlat.add(firstList);
		
		expectedArray = new ArrayList<Integer>();
		expectedArray.add(6);
		
		flattenedArray =  flattenArray.flatArray(arrayToFlat);
		assertEquals(expectedArray , flattenedArray);
	}
	
	@Test
	public void testArrayWithSingleIntegerElementAndSingleListInTheList() {
		arrayToFlat = new ArrayList<Object>();		
		arrayToFlat.add(6);
		
		ArrayList<Object> firstList = new ArrayList<>();
		firstList.add(4);
		firstList.add(36);
		firstList.add(199);
		firstList.add(77);
		
		arrayToFlat.add(firstList);
		
		expectedArray = new ArrayList<Integer>();
		expectedArray.add(6);
		expectedArray.add(4);
		expectedArray.add(36);
		expectedArray.add(199);
		expectedArray.add(77);
		
		flattenedArray =  flattenArray.flatArray(arrayToFlat);
		assertEquals(expectedArray , flattenedArray);
	}
	
	@Test
	public void testArrayWithSingleIntegerElementSingleListAndACharInTheList() {
		arrayToFlat = new ArrayList<Object>();		
		arrayToFlat.add(6);
		
		ArrayList<Object> firstList = new ArrayList<>();
		firstList.add(4);
		firstList.add(36);
		firstList.add(199);
		firstList.add(77);
		
		arrayToFlat.add(firstList);
		arrayToFlat.add('c');
		
		expectedArray = new ArrayList<Integer>();
		expectedArray.add(6);
		expectedArray.add(4);
		expectedArray.add(36);
		expectedArray.add(199);
		expectedArray.add(77);
		
		flattenedArray =  flattenArray.flatArray(arrayToFlat);
		assertEquals(expectedArray , flattenedArray);
	}
	
	@Test
	public void testArrayWithSingleIntegerElementSingleListAndANegativeIntegerInTheList() {
		arrayToFlat = new ArrayList<Object>();		
		arrayToFlat.add(6);
		
		ArrayList<Object> firstList = new ArrayList<>();
		firstList.add(4);
		firstList.add(36);
		firstList.add(199);
		firstList.add(77);
		
		arrayToFlat.add(firstList);
		arrayToFlat.add(-86);
		
		expectedArray = new ArrayList<Integer>();
		expectedArray.add(6);
		expectedArray.add(4);
		expectedArray.add(36);
		expectedArray.add(199);
		expectedArray.add(77);
		expectedArray.add(-86);
		
		flattenedArray =  flattenArray.flatArray(arrayToFlat);
		assertEquals(expectedArray , flattenedArray);
	}
	
	@Test
	public void testArrayWithSingleIntegerElementAndA2LevelNestedListInTheList() {
		arrayToFlat = new ArrayList<Object>();		
		arrayToFlat.add(6);
		
		ArrayList<Object> firstList = new ArrayList<>();
		firstList.add(4);
		firstList.add(36);
		firstList.add(199);
		firstList.add(77);
		
		ArrayList<Object> secondList = new ArrayList<>();
		
		secondList.add(firstList);
		
		arrayToFlat.add(secondList);
		arrayToFlat.add(-86);
		
		expectedArray = new ArrayList<Integer>();
		expectedArray.add(6);
		expectedArray.add(4);
		expectedArray.add(36);
		expectedArray.add(199);
		expectedArray.add(77);
		expectedArray.add(-86);
		
		flattenedArray =  flattenArray.flatArray(arrayToFlat);
		assertEquals(expectedArray , flattenedArray);
	}
}
