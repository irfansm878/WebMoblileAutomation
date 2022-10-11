package apiTests;

import java.io.File;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import stepdefinitioncode.BasePage;
import util.APIUtils;
import util.RequestSpecificationBuilder;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;


public class ApiTest extends APIUtils {
	
	
	RequestSpecificationBuilder rb = new RequestSpecificationBuilder();
	BasePage b1;
	
	@Test
	public void ApiTest1() {
		rb.setQueryParms("page",2);
		
		Response rp = getRequestWithBuilder(b1.getProperties("apiBaseURL")+GET_USERS, rb);
		System.out.println(rp.body().asPrettyString());
		Assert.assertEquals(rp.getStatusCode(), 200);
		JSONObject data = new JSONObject(rp.body().asString());
		JSONArray jsArray= data.getJSONArray("data");
		for(int i=0;i<jsArray.length();i++) {
			  int id=  jsArray.getJSONObject(i).getInt("id");
			  if(id==10) {			  
				  Assert.assertEquals(jsArray.getJSONObject(i).getString("first_name"),"Byron");
				  
			  }
		}
		
		
	}
	
	@Test
	public void ApiTest2() {
		rb.setQueryParms("page",2);
		
		Response rp = postRequestWithJsonFile(b1.getProperties("apiBaseURL")+GET_USERS,rb,"payload");
		System.out.println(rp.body().asPrettyString());
		Assert.assertEquals(rp.getStatusCode(), 201);
		JSONObject data = new JSONObject(rp.body().asString());
		Assert.assertTrue(String.valueOf(data.getInt("id"))!=null);
		
		File Schema= new File(System.getProperty("user.dir")+"//src//test//resources//jsons//Schema.json");
	    rp.then().assertThat().body(matchesJsonSchema(Schema));
		
		
		
	}
	

}
