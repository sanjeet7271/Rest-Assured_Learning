package com.convertJsonForm;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

/**
 {
	"id": "0001",
	"type": "donut",
	"name": "Cake",
	"ppu": 0.55,
	"batters":
		{
			"batter":
				[
					{ "id": "1001", "type": "Regular" },
					{ "id": "1002", "type": "Chocolate" },
					{ "id": "1003", "type": "Blueberry" },
					{ "id": "1004", "type": "Devil's Food" }
				]
		},
	"topping":
		[
			{ "id": "5001", "type": "None" },
			{ "id": "5002", "type": "Glazed" },
			{ "id": "5005", "type": "Sugar" },
			{ "id": "5007", "type": "Powdered Sugar" },
			{ "id": "5006", "type": "Chocolate with Sprinkles" },
			{ "id": "5003", "type": "Chocolate" },
			{ "id": "5004", "type": "Maple" }
		]
}
 
 
 */

public class complexJson {
	JSONObject JOBJ,JOBJ1;
	Map map,map1,map2,map3,map4,map5;
	JSONArray arr,arr1;
	@Test
	public void convertToJson() throws FileNotFoundException {
		JOBJ=new JSONObject();
		JOBJ.put("id", "0001");
		JOBJ.put("type", "Donut");
		JOBJ.put("name", "Cake");
		JOBJ.put("ppu", "0.55");
		
		map=new LinkedHashMap();
		JOBJ1=new JSONObject();
		arr=new JSONArray();
		map1=new LinkedHashMap();
		map1.put("id", "1001");
		map1.put("type", "Regular");
		arr.add(map1);
		map2=new LinkedHashMap();
		map2.put("id", "1002");
		map2.put("type", "Chocolate");
		
		map3=new LinkedHashMap();
		map3.put("id", "1003");
		map3.put("type", "Blueberry");
		
		arr.add(map2);
		JOBJ1.put("batter", arr);
		JOBJ.put("batters", JOBJ1);
		
		arr1=new JSONArray();
		map4=new LinkedHashMap();
		map4.put("id", "5001");
		map4.put("value", "None");
		arr1.add(map4);
		
		map5=new LinkedHashMap();
		map5.put("id", "5002");
		map5.put("value", "Glazed");
		arr1.add(map5);
		
		JOBJ.put("topping", arr1);
		
		System.out.println(JOBJ);
		PrintWriter pw=new PrintWriter("./src/main/java/com/convertJsonForm/complex1.json");
		pw.write(JOBJ.toString());
		 pw.flush(); 
	     pw.close();
	}
}
