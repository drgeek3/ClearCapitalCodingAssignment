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

    String apiPath = "https://api.restful-api.dev/objects";

    @Test
    public void testUniqueIds(){
        Response response = RestAssured.get(apiPath);
        JsonPath jsonPath = response.jsonPath();
        List<String> ids = jsonPath.getList("id");
        Set<String> uniqueIds = new HashSet<>(ids);
        Assert.assertEquals(uniqueIds.size(),ids.size());
    }

    @Test
    public void testContainsApple(){
        Response response = RestAssured.get(apiPath);
        JsonPath jsonPath = response.jsonPath();
        List<String> names = jsonPath.getList("name");
        Assert.assertTrue(names.contains("Apple"));
    }

}
