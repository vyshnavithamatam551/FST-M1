import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Project_Activity {
	
	String ssh_key = "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";
	int id;
	RequestSpecification reqspec;
	

	@BeforeClass
	public void Start() {
		
		reqspec=new RequestSpecBuilder()
				.setContentType(ContentType.JSON)
				.addHeader("Authorization","token "+ssh_key)
				.setBaseUri("https://api.github.com")
				.build();
	
	}
	
	@Test(priority = 1)
	public void addSSH() {
		
		String reqBody="""
			{
	"title": "TestKey",
	"key": "ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIAL8SGUF8T/NEThqkcrtfVZDhjGZDCPdNZSsCduWIY6f"
	}
 """;
		
		Response response = given().spec(reqspec)
				.body(reqBody).when().post("/user/keys");
		
		response.prettyPrint();
		response.then().statusCode(201);
		id=response.then().extract().path("id");
		System.out.println("The key generated is : "+id);
		
	}
	
	@Test(priority = 2)
	public void getSSH() {
		
		Response response = given().spec(reqspec)
				.when().pathParam("keyid",id).get("/user/keys/{keyid}");
		
		response.prettyPrint();
		response.then().statusCode(200);
		Reporter.log(response.toString());
		
	}
	
	@Test(priority = 3)
	public void deleteSSH() {
		
		Response response = given().spec(reqspec)
				.when().pathParam("keyid", id).delete("/user/keys/{keyid}");
		
		response.then().statusCode(204);
		Reporter.log(response.toString());
		
		
	}
}
