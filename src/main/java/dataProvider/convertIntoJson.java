package dataProvider;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class convertIntoJson{

	public convertIntoJson() throws IOException {
		super();
	}
	
	@SuppressWarnings({ "unchecked", "nls", "rawtypes" })
	public String JsonConverter(String Key,String Summary,String Description,String ActiveSprint, String StepsToProduce,String ActualResult,String ExpectedResult,String IssueType,String BugPriority) throws FileNotFoundException {
		
		JSONObject obj = new JSONObject();
		JSONObject Jsonobj = new JSONObject();

		Map map = new LinkedHashMap();
		map.put("KEY", Key);
		obj.put("project", map);

		obj.put("SUMARY", Summary);
		obj.put("DESCRIPTION", Description);
		obj.put("ACTIVESPRINT_CUSTOMID", ActiveSprint);
		obj.put("STEPSTOREPRODUCE_CUSTOMID", StepsToProduce);
		obj.put("ACTUALRESULT_CUSTOMID", ActualResult);
		obj.put("EXPECTEDRESULT_CUSTOMID", ExpectedResult);
		
		Map map1 = new LinkedHashMap();
		map1.put("ISSUETYPE", IssueType);
		obj.put("issuetype", map1);

		Map map2 = new LinkedHashMap();
		map2.put("BUGPRIORITY_VALUE", BugPriority);
		obj.put("BUGPRIORITY_CUSTOMID", map2);
		Jsonobj.put("fields", obj);
		
		//System.out.println(obj.toJSONString());
		PrintWriter pw = new PrintWriter("./src/main/java/dataProvider/BugJson.json");
		pw.write(obj.toJSONString());
		pw.flush();
		pw.close();
		
		return Jsonobj.toJSONString();

	}

}
