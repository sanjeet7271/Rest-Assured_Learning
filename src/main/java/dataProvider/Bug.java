package dataProvider;

import java.io.IOException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;

public class Bug {
	ObjectMapper mapper;
	String endPointURLforLogin;
	int responseCode;
	JsonNode bugJson;
	Response response;
	String json;
	convertIntoJson intoJson;
	@SuppressWarnings("nls")
	String xlFilePath = "./src/main/java/dataProvider/Jira.xlsx";
	@SuppressWarnings("nls")
	String sheetName = "BugDetails";
	ExcelSheetReader ProvideData=new ExcelSheetReader();
	Object[][] data;
	public Bug() throws IOException {
		super();
	}

	@SuppressWarnings("unqualified-field-access")
	@BeforeMethod
	public void setUp() throws IOException {
		mapper = new ObjectMapper();
		intoJson=new convertIntoJson();


	}
	@SuppressWarnings("unqualified-field-access")
	@DataProvider(name = "bug")
	public Object[][] CredentialtoLogin() throws Exception {
		data = ProvideData.testData(xlFilePath, sheetName);
        return data;
	}
	@Test(dataProvider="bug")
	@SuppressWarnings("unqualified-field-access")
	public void JsonConverter(String Key,String Summary,String Description,String ActiveSprint, String StepsToProduce,String ActualResult,String ExpectedResult,String IssueType,String BugPriority) throws JsonProcessingException, IOException{
		String json=intoJson.JsonConverter(Key,Summary,Description,ActiveSprint,StepsToProduce,ActualResult,ExpectedResult,IssueType,BugPriority);
		System.out.println(json);
	}
	
}
