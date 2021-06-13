package jsoninventorydatamgmt.inventorydatamanagement;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class InventoryManagement
{
	
	  static String nameOf;
	  static int weightOf, priceperkgOf, totalInventoryValue, finalInventoryValue;
	 
	
	/**
	 * @param args
	 * @throws IOException
	 * @throws ParseException
	 * Reading json file data and calculating total inventory value for each sub inventory.
	 */
	public static void main(String[] args) throws IOException, ParseException
	{
		JSONParser jsonParser = new JSONParser();
		FileReader fileReader = new FileReader(".\\json\\inventory.json");
		
		Object javaObject = jsonParser.parse(fileReader); //java Object
		JSONObject inventoryJsonObject = (JSONObject) javaObject; //converting java object to json object
		
		JSONArray inventoryRiceJsonArray = (JSONArray) inventoryJsonObject.get("rice");
		JSONArray inventoryPulsesJsonArray = (JSONArray) inventoryJsonObject.get("pulses");
		JSONArray inventoryWheatJsonArray = (JSONArray) inventoryJsonObject.get("wheat");
		
		/**
		 * Reading Rice Array data from json file.
		 * Calculating the total inventory price for rice.
		 */
		for(int i=0; i<inventoryRiceJsonArray.size(); i++)
		{
			JSONObject riceJsonArray = (JSONObject) inventoryRiceJsonArray.get(i);
			
			nameOf = (String) riceJsonArray.get("name");
			weightOf = ((Long) riceJsonArray.get("weight")).intValue();
			priceperkgOf = ((Long) riceJsonArray.get("price per kg")).intValue();
			
			System.out.println("Name Of Rice : "+ nameOf + " \nWeight : " + weightOf + " \nPrice Per Kg : " + priceperkgOf +"\n");
			totalInventoryValue = weightOf * priceperkgOf;
			finalInventoryValue += totalInventoryValue;
		}
			System.out.println("Total value of rice inventory is : " + finalInventoryValue+" \n");
			
			
			/**
			 * Reading pulses Array data from json file.
			 * Calculating the total inventory price for rice.
			 */
			for(int i=0; i<inventoryPulsesJsonArray.size(); i++)
			{
				finalInventoryValue = 0;
				JSONObject puldrdJsonArray = (JSONObject) inventoryPulsesJsonArray.get(i);
				
				nameOf = (String) puldrdJsonArray.get("name");
				weightOf = ((Long) puldrdJsonArray.get("weight")).intValue();
				priceperkgOf = ((Long) puldrdJsonArray.get("price per kg")).intValue();
				
				System.out.println("Name Of Pulses : "+ nameOf + " \nWeight : " + weightOf + " \nPrice Per Kg : " + priceperkgOf +"\n");
				totalInventoryValue = weightOf * priceperkgOf;
				finalInventoryValue += totalInventoryValue;
			}
				System.out.println("Total value of Pulses inventory is : " + finalInventoryValue+" \n");
				
				/**
				 * Reading Wheat Array data from json file.
				 * Calculating the total inventory price for rice.
				 */
				for(int i=0; i<inventoryWheatJsonArray.size(); i++)
				{
					finalInventoryValue = 0;
					JSONObject wheatJsonArray = (JSONObject) inventoryWheatJsonArray.get(i);
					
					nameOf = (String) wheatJsonArray.get("name");
					weightOf = ((Long) wheatJsonArray.get("weight")).intValue();
					priceperkgOf = ((Long) wheatJsonArray.get("price per kg")).intValue();
					
					System.out.println("Name Of Wheat : "+ nameOf + " \nWeight : " + weightOf + " \nPrice Per Kg : " + priceperkgOf +"\n");
					totalInventoryValue = weightOf * priceperkgOf;
					finalInventoryValue += totalInventoryValue;
				}
					System.out.println("Total value of wheat inventory is : " + finalInventoryValue);
	}
}
