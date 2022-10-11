package util;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;



import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APIUtils implements IEndPoints {

	public static String BASE_URL = "";
	RequestSpecification requestSpecification;
	private static int responsecode;
	private static String responseBody;
	public Response postRequestWithHeaderRequestParameter(String url, RequestSpecificationBuilder builder, Map<String,Object> requestParams,  
			Header headerData) {

		final Response response = given().spec(getRequestSpecificationWithHeaders(builder, headerData))
				.body(requestParams)
				.post(url);
		System.out.println(url);
		try {
			responsecode = response.getStatusCode();
			if (response.statusCode() != 200) {
				System.out.println("Failed : RestAssured error code : " + response.statusCode());
			}
			// log(response.prettyPrint());
			responseBody = response.getBody().asString();
		} catch (final Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Failed : HTTP error code : " + response.statusCode());
		}
		return response;
	}

	public Response getRequest(String request, Headers headers) {                 //Simple get request with headers
		Response response = given().headers(headers).when().get(request);
		return response;
	}

	public Response postRequest(String request, String payload) {                //Simple post request with payload-Body
		Response response = given().contentType("application/json").body(payload).post(request);
		return response;
	}

	public Response putRequest(String url, String payLoad) {                    //Simple put request with payload-Body
		return given().contentType("application/json").body(payLoad).put(url);
	}

	public Response putRequest(String url) {                                   //Simple put request [Modifications in DB]
		return given().contentType("application/json").put(url);
	}

	public Response postUplaodFile(String request, String header, String apit, String paramKey, String value,             //Post request with a file upload
			String filePath) {
		Response response = given().header(header, apit).header(paramKey, value).multiPart(new File(filePath)).when()
				.post(request);
		return response;

	}

	public Response putUploadFile(String request, String filePath, String docValue, String value1, String docCode,     //Put request with a file upload
			String value2) {
		Response response = given().multiPart(docValue, value1).multiPart(docCode, value2)
				.multiPart("file", new File(filePath)).when().put(request);
		return response;
	}

	public Response postRequestWithBuilder(String url, RequestSpecificationBuilder builder, String payload) {          //Post request with builder

		final Response response = given().spec(getRequestSpecification(builder)).body(payload).post(url);
		try {
			responsecode = response.getStatusCode();
			if (response.statusCode() != 200) {
				System.out.println("Failed : RestAssured error code : " + response.statusCode());
			}
			// log(response.prettyPrint());
			responseBody = response.getBody().asString();
		} catch (final Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Failed : HTTP error code : " + response.statusCode());
		}
		return response;
	}
	
	
	public Response postRequestWithHeaderBuilder(String url, RequestSpecificationBuilder builder, Header header) {         //Post request with header builder

		final Response response = given().spec(getRequestSpecificationWithHeaders(builder,header)).post(url);
		try {
			responsecode = response.getStatusCode();
			if (response.statusCode() != 200) {
				System.out.println("Failed : RestAssured error code : " + response.statusCode());
			}
			// log(response.prettyPrint());
			responseBody = response.getBody().asString();
		} catch (final Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Failed : HTTP error code : " + response.statusCode());
		}
		return response;
	}
	
	public Response putRequestWithHeaderBuilder(String url, RequestSpecificationBuilder builder, Header header) {         //Put request with header builder

		final Response response = given().spec(getRequestSpecificationWithHeaders(builder,header)).put(url);
		try {
			responsecode = response.getStatusCode();
			if (response.statusCode() != 200) {
				System.out.println("Failed : RestAssured error code : " + response.statusCode());
			}
			// log(response.prettyPrint());
			responseBody = response.getBody().asString();
		} catch (final Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Failed : HTTP error code : " + response.statusCode());
		}
		return response;
	}
	

	public Response postRequestUploadFile(String url, RequestSpecificationBuilder builder, String fileName,
			String password) {

		Response response = given().spec(getRequestSpecification(builder))
				.multiPart(new File(System.getProperty("user.dir") + "//src//test//resources//" + fileName))
				.contentType("multipart/file").body(password).post(url);
		return response;

	}

	public Response deleteRequestWithBuilder(String url, RequestSpecificationBuilder builder) {  // TO DELETE A ENTRY 

		final Response response = given().spec(getRequestSpecification(builder)).delete(url);
		try {
			responsecode = response.getStatusCode();
			if (response.statusCode() != 200) {
				System.out.println("Failed : RestAssured error code : " + response.statusCode());
			}
			responseBody = response.getBody().asString();
		} catch (final Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Failed : HTTP error code : " + response.statusCode());
		}
		return response;
	}

	public Response deleteRequestWithHeaderBuilder(String url, RequestSpecificationBuilder builder,String fileName,Header header) { // TO DELETE A ENTRY 

		final Response response = given()
				.body(new File(System.getProperty("user.dir") + "//src//test//resources//inputJSON/" + fileName))
				.spec(getRequestSpecificationWithHeaders(builder,header)).delete(url);
		try {
			responsecode = response.getStatusCode();
			if (response.statusCode() != 200) {
				System.out.println("Failed : RestAssured error code : " + response.statusCode());
			}
			responseBody = response.getBody().asString();
		} catch (final Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Failed : HTTP error code : " + response.statusCode());
		}
		return response;
	}
	
	public Response deleteRequestWithHeaderBuilder(String url, RequestSpecificationBuilder builder,Header header) { // TO DELETE A ENTRY 

		final Response response = given()
				.spec(getRequestSpecificationWithHeaders(builder,header)).delete(url);
		try {
			responsecode = response.getStatusCode();
			if (response.statusCode() != 200) {
				System.out.println("Failed : RestAssured error code : " + response.statusCode());
			}
			responseBody = response.getBody().asString();
		} catch (final Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Failed : HTTP error code : " + response.statusCode());
		}
		return response;
	}
	
	public String createJSONArrayDataUsingFile (Map<String, String> data, String filename) {    //TO MODIFY DATA IN A JSON FILE
        Object obj = null;
        JSONObject jo =null;            
        JSONArray jsonArray=new JSONArray();
        try {
            obj = new JSONParser().parse(new FileReader(System.getProperty("user.dir")
                    + "/src/test/resources/inputJson/"  + "/" + filename + ".json"));
        } catch (Exception e) {
            e.printStackTrace();
        }



        JSONArray ja=(JSONArray) obj;
        for(int i=0;i<ja.size();i++)
        {
             jo = (JSONObject) ja.get(i);
            Set<String> keys = data.keySet();
            Iterator it = keys.iterator();
            while (it.hasNext()) {
                String key = (String) it.next();
                jo.put(key, data.get(key));
        }
            jsonArray .add(jo);
        
        }
        System.out.println(jsonArray.toString());



        PrintWriter pw = null;
        try {
            pw = new PrintWriter(System.getProperty("user.dir") + "/src/test/resources/inputJson/" + "/"
                    + filename + ".json");
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        pw.write(jsonArray.toString());
        pw.flush();
        pw.close();
        return jsonArray.toString();
        
	}

	public String createJSONDataUsingFile(Map<String, String> data, String filename) {    //TO MODIFY DATA IN A JSON FILE
		Object obj = null;
		try {
			obj = new JSONParser().parse(new FileReader(System.getProperty("user.dir")
					+ "/src/test/resources/inputJson/"  + "/" + filename + ".json"));
		} catch (Exception e) {
			e.printStackTrace();
		}

		JSONObject jo = (JSONObject) obj;
		
		Set<String> keys = data.keySet();
		Iterator it = keys.iterator();
		while (it.hasNext()) {
			String key = (String) it.next();
			jo.put(key, data.get(key));
		}

		PrintWriter pw = null;
		try {
			pw = new PrintWriter(System.getProperty("user.dir") + "/src/test/resources/inputJson/" + "/"
					+ filename + ".json");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pw.write(jo.toString());
		pw.flush();
		pw.close();
		return jo.toString();
	}

	public Response postRequestWithJsonFile(String url, RequestSpecificationBuilder builder, String fileName) {  //HEADER DECLARED EXPLICITLY IN QUERY PARAMETERS

		final Response response = given().spec(getRequestSpecification(builder))
				.body(new File(System.getProperty("user.dir") + "//src//test//resources//jsons//" + fileName+".json"))
				.post(url);
			responsecode = response.getStatusCode();
			responseBody = response.getBody().asString();
	
		return response;
	}

	public Response postRequestWithHeaderJsonFile(String url, RequestSpecificationBuilder builder, String fileName,  //USED IN PROJECT
			Header headerData) {

		Response response = null;
		try {
		response=given().spec(getRequestSpecificationWithHeaders(builder, headerData))
				.body(new File(System.getProperty("user.dir") + "//src//test//resources//inputJson/" + fileName+".json"))
				.post(url);
		} catch (final Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			responsecode = response.getStatusCode();
			if (response.statusCode() != 200) {
				System.out.println("Failed : RestAssured error code : " + response.statusCode());
			}
			// log(response.prettyPrint());
			responseBody = response.getBody().asString();
		} catch (final Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Failed : HTTP error code : " + response.statusCode());
		}
		return response;
	}


	public Response postRequestWithMultipartFileUpload(String url, RequestSpecificationBuilder builder, String fileName,            //.CSV/IMG Files upload
			String emailId) {

		final Response response = given().spec(getRequestSpecification(builder)).contentType("multipart/form-data")
				.multiPart(new File(System.getProperty("user.dir") + "//src//test//resources//inputJSON/" + fileName))
				.param("password", emailId).log().all().post(url);
		try {
			responsecode = response.getStatusCode();
			if (response.statusCode() != 200) {
				System.out.println("Failed : RestAssured error code : " + response.statusCode());
			}
			// log(response.prettyPrint());
			responseBody = response.getBody().asString();
		} catch (final Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Failed : HTTP error code : " + response.statusCode());
		}
		return response;
	}

	public RequestSpecification getRequestSpecificationWithHeaders(RequestSpecificationBuilder parameters,    //USED FOR QUERY PARAMETERS
			Header headerData) {
		requestSpecification = given().pathParams(parameters.getPathParams()).queryParams(parameters.getQueryParms())
				.header(headerData).contentType("application/json");

		return requestSpecification;

	}

	public RequestSpecification getRequestSpecification(RequestSpecificationBuilder parameters) {   //USED FOR QUERY PARAMETERS
		requestSpecification = given().pathParams(parameters.getPathParams()).queryParams(parameters.getQueryParms())
				.header("Content-Type", "application/json");
		return requestSpecification;

	}
	
	

	public Response getRequestWithBuilder(String url, RequestSpecificationBuilder builder) {   //GET REQUEST SPECIFICATION BULDER WITHOUT HEADER

		System.out.println(url);
		final Response response = given().spec(getRequestSpecification(builder)).get(url);
		try {
			responsecode = response.getStatusCode();
			if (response.statusCode() != 200) {
				System.out.println("Failed : RestAssured error code : " + response.statusCode());
			}
			responseBody = response.getBody().asString();
		} catch (final Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Failed : HTTP error code : " + response.statusCode());
		}
		return response;
	}

	
}
