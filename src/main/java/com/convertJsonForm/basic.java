package com.convertJsonForm;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class basic {
	
	@Test
	public void convertSimpleJSON() throws FileNotFoundException {
		JSONObject json=new JSONObject();
		json.put("color", "red");
		json.put("value", "#f00");
		json.put("color", "green");
		json.put("value", "#0f0");

		PrintWriter pw = new PrintWriter("./src/main/java/com/convertJsonForm/simple.json"); 
        pw.write(json.toJSONString()); 
          
        pw.flush(); 
        pw.close();
	}

}
