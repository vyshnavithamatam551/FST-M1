package activities;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import static io.restassured.RestAssured.given;
import io.restassured.response.Response;
import static org.hamcrest.CoreMatchers.equalTo;

public class Activity1 {
	
	String BASEURL="https://petstore.swagger.io/v2";
  @Test(priority = 0)
  public void postPet() {
	  String reqBody = """
	  		{
  "id": 77232,
  "name": "Riley",
  "status": "alive"
}
	  		""";
	  Response response = given().contentType(ContentType.JSON)
			  .body(reqBody).when().post(BASEURL+"/pet");
			  
	  response.prettyPrint();
	  
	  response.then().statusCode(200);
	  response.then().body("id", equalTo(77232));
	  response.then().body("name", equalTo("Riley"));
	  response.then().body("status", equalTo("alive"));
	  
  }
  @Test(priority = 1)
  public void getPet() {
	  
	  Response response = given().contentType(ContentType.JSON)
			      .when().pathParam("petid", 77232).get(BASEURL+"/pet/{petid}");
	  response.then().statusCode(200);
	  response.then().body("id", equalTo(77232));
	  response.then().body("name", equalTo("Riley"));
	  response.then().body("status", equalTo("alive"));
  }
  @Test(priority = 2)
  public void deletePet() {
	  Response response = given().contentType(ContentType.JSON)
			  .when().pathParam("id", 77232).delete(BASEURL+"/pet/{id}");
	  response.prettyPrint();
	  response.then().statusCode(200);
	  response.then().body("message", equalTo("77232"));
	  
  }
}
