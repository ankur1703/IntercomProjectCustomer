package MainPackage;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.SortedSet;
import java.util.TreeSet;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Reader {
	private SortedSet<Customer> customers ;
	
	Reader(){
		customers = new TreeSet<Customer>();
	}
	public void readJason(){
		JSONParser parser = new JSONParser();
		BufferedReader bufferedReader = null;
		try{
			FileReader fileReader = new FileReader("CustomerData/customers.json");
			bufferedReader = new BufferedReader(fileReader);
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				JSONObject customerJSON = (JSONObject) parser.parse(line);
				
			    int user_id = Integer.parseInt(customerJSON.get("user_id").toString());
			    String name = customerJSON.get("name").toString();
				double latitude = Double.parseDouble(customerJSON.get("latitude").toString());
			    double longitude = Double.parseDouble(customerJSON.get("longitude").toString());			
			    Customer customer = new Customer(user_id, name, latitude, longitude);
			    customers.add(customer);
			}			
		}
		catch(FileNotFoundException e){
			System.out.println("File not found:- Exception message: " + e.toString());
		}
		catch(EOFException e){
			System.out.println("End of file while reading:- Exception message: " + e.toString());
		}
		catch(IOException e){
			System.out.println("Generic IO exception:- Exception message: " + e.toString());
		}
		catch(ParseException e){
			System.out.println("Parsing failed:- Exception message: " + e.toString());
		}
		finally{
			try {
				bufferedReader.close();
			} catch (IOException e) {
				System.out.println("BufferedReader didn't close. Exception message: " + e.toString());
			}
		}
	}

	public SortedSet<Customer> getCustomers() {
		return customers;
	}
}
