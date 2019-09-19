package com.convertJsonForm;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class simple1 {
	String xlFilePath="./src/main/java/com/convertJsonForm/Jira.xlsx";
	Object[][] data;
	String sheetName="simple1";
	ExcelSheetReader excel=new ExcelSheetReader();
	
	@DataProvider(name="color")
	public Object[][] getColor() throws Exception{
		data=excel.testData(xlFilePath, sheetName);
		
		return data;
	}
	@Test(dataProvider="color")
	public void convertToJson(String color,String value) throws FileNotFoundException {

		JSONArray arr=new JSONArray();
		Map map = new LinkedHashMap();
		map.put("color", color);
		map.put("value", value);
		arr.add(map);
		System.out.println(arr);
		
		PrintWriter pw=new PrintWriter("./src/main/java/com/convertJsonForm/simple1.json");
		pw.write(arr.toString());
		
	}
}
