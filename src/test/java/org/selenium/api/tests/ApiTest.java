package org.selenium.api.tests;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.selenium.api.data.EmployeeData;
import org.selenium.api.helper.Hooks;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static org.selenium.api.data.EmployeeDataBuilder.getEmployeeData;
import static org.testng.AssertJUnit.assertEquals;

public class ApiTest extends Hooks {

    @Test(priority=1)
    public void testGetAPI() {
        System.out.println("==============================GET======================================");
        RestAssured.baseURI = "https://reqres.in/api/users/7";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET);
        String responseBody = response.getBody().asString();
        System.out.println("Response Body is:" + responseBody);

        final JSONObject jsonObject = new JSONObject(responseBody);
        final JSONObject dataObject = jsonObject.getJSONObject("data");

        int statusCode = response.getStatusCode();
        System.out.println("Status code is: " + statusCode);
        Assert.assertEquals(statusCode, 200);

        String statusLine = response.getStatusLine();
        System.out.println("Status line is:" + statusLine);
        Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
        assertEquals(dataObject.get("email")
                .toString(), "michael.lawson@reqres.in");
        assertEquals(dataObject.get("first_name")
                .toString(), "Michael");
        assertEquals(dataObject.get("last_name")
                .toString(), "Lawson");
        System.out.println(dataObject);
        System.out.println("=======================================================================");
    }

    @Test(priority=2)
    public void testPostAPI() {
        System.out.println("==============================POST=====================================");
        String endpoint = "api/users/";
        baseURI = baseURI + endpoint;
        RequestSpecification httpRequest = RestAssured.given();

        JSONObject requestParams = new JSONObject();

        requestParams.put("email", "nicole.lawson@reqres.in");
        requestParams.put("first_name", "Nicole");
        requestParams.put("last_name", "Lawson");
        requestParams.put("avatar", "https://reqres.in/img/faces/7-image.jpg");


        httpRequest.header("Content-Type", "application/json");

        httpRequest.body(requestParams.toString());

        Response response = httpRequest.request(Method.POST);

        String responseBody = response.getBody().asString();
        System.out.println("Response Body is:" + responseBody);

        int statusCode = response.getStatusCode();
        System.out.println("Status code is: " + statusCode);
        Assert.assertEquals(statusCode, 201);
        System.out.println("=======================================================================");
    }

    @Test(priority=3)
    public void testPutAPI() {
        System.out.println("==============================PUT======================================");
        String endpoint = "api/users/2";
        baseURI = baseURI + endpoint;
        final EmployeeData employeeData = getEmployeeData();

        RequestSpecification httpRequest = RestAssured.given();

        JSONObject requestParams = new JSONObject();
        requestParams.put("name", employeeData.getName());
        requestParams.put("job", employeeData.getJob());

        httpRequest.header("content-type", "application/json");

        Response response = httpRequest.request(Method.PUT);

        String responseBody = response.getBody().asString();
        System.out.println("Response Body is:" + responseBody);

        int statusCode = response.getStatusCode();
        System.out.println("Status code is: " + statusCode);
        Assert.assertEquals(statusCode, 200);
        System.out.println("=======================================================================");
    }

    @Test(priority=4)
    public void testPatchAPI() {
        System.out.println("=============================PATCH=====================================");
        String endpoint = "api/users/2";
        baseURI = baseURI + endpoint;
        final EmployeeData employeeData = getEmployeeData();

        RequestSpecification httpRequest = RestAssured.given();
        JSONObject requestParams = new JSONObject();
        requestParams.put("name", employeeData.getName());
        requestParams.put("job", employeeData.getJob());

        httpRequest.header("content-type", "application/json");

        Response response = httpRequest.request(Method.PATCH);

        String responseBody = response.getBody().asString();
        System.out.println("Response Body is:" + responseBody);

        int statusCode = response.getStatusCode();
        System.out.println("Status code is: " + statusCode);
        Assert.assertEquals(statusCode, 200);
        System.out.println("=======================================================================");
    }

    @Test(priority=5)
    public void testDeleteAPI() {
        System.out.println("=============================DELETE=====================================");
        String endpoint = "api/users/2";
        baseURI = baseURI + endpoint;
        RequestSpecification httpRequest = RestAssured.given();
        JSONObject requestParams = new JSONObject();

        requestParams.put("id", 520);

        httpRequest.header("Content-Type", "application/json");

        httpRequest.body(requestParams.toString());

        Response response = httpRequest.request(Method.DELETE);
        int statusCode = response.getStatusCode();
        System.out.println("Status code is: " + statusCode);
        Assert.assertEquals(statusCode, 204);
        System.out.println("=======================================================================");
    }
}

