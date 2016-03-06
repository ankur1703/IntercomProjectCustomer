package FlattenAnArray;

import java.util.ArrayList;

public class FlattenArray {
	ArrayList<Integer> flattenedArray;
	
	public FlattenArray(){
		flattenedArray = new ArrayList<Integer>();
	}
	
	public ArrayList<Integer> flatToArrayListOfIntegersFrom(ArrayList<Object> arrayToFlat) {
		if(arrayToFlat.isEmpty()){
			return new ArrayList<Integer>();
		}
		
		for(Object element: arrayToFlat){
			if(element instanceof ArrayList){
				flatToArrayListOfIntegersFrom((ArrayList<Object>)element);
			}
			else if(element instanceof Integer){
				flattenedArray.add((Integer)element);
			}
		}
		
		return flattenedArray;
	}
	
}
