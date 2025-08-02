package apiautomation;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class APITest {

    //Store the apiPath for reuse
    String apiPath = "https://api.restful-api.dev/objects";

    @Test
    public void testUniqueIds(){
        Response response = RestAssured.get(apiPath); //GET the api response
        JsonPath jsonPath = response.jsonPath(); //convert the response to json
        List<String> ids = jsonPath.getList("id"); //put all the ids in a list
        Set<String> uniqueIds = new HashSet<>(ids); //stick them in a set since that interface allows no duplicates
        Assert.assertEquals(uniqueIds.size(),ids.size()); //compare the originaL list to the set to see if they match
    }

    @Test
    public void testContainsApple(){
        Response response = RestAssured.get(apiPath); //GET the api response
        JsonPath jsonPath = response.jsonPath(); //convert the response to json
        List<String> names = jsonPath.getList("name"); //put all the names in a list
        Assert.assertTrue(names.contains("Apple")); //see if all the names contain Apple
    }

}
