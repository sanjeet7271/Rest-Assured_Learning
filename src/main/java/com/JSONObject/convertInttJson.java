package com.JSONObject;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class convertInttJson {

	@SuppressWarnings({ "unchecked", "rawtypes", "nls" })
	public static void main(String[] args) throws FileNotFoundException {
		
		JSONObject obj=new JSONObject();
		obj.put("firstName", "John");
		obj.put("lastName", "Smith");
		obj.put("age", 25);
		
		Map map=new LinkedHashMap();
		map.put("streetAddress", "21 2nd Street");
		map.put("city","New York");
		map.put("state", "NY");
		map.put("postalCode", 10021);
		
		obj.put("address", map);
		
		//create jsonArray and create Linkedhashmap
		JSONArray jArr=new JSONArray();
		//map=new LinkedHashMap();
		map.put("type", "home");
		map.put("number","212 555-1234");
		jArr.add(map);
		
		map.put("type", "fax"); 
        map.put("number", "212 555-1234");
        jArr.add(map);
        obj.put("phoneNumbers", jArr);
		
        PrintWriter pw = new PrintWriter("./src/main/java/com/JSONObject/JSONExample.json"); 
        pw.write(obj.toJSONString()); 
          
        pw.flush(); 
        pw.close();

	}

}
