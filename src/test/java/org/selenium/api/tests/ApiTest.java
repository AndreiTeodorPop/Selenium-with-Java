package org.selenium.api.tests;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.selenium.api.data.EmployeeData;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.selenium.api.data.EmployeeDataBuilder.getEmployeeData;

public class ApiTest {

    @Test
    public void testGetAPI() {
        System.out.println("==============================GET======================================");
        RestAssured.baseURI = "https://reqres.in/api/users/7";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET);
        String responseBody = response.getBody().asString();
        System.out.println("Response Body is:" + responseBody);

        int statusCode = response.getStatusCode();
        System.out.println("Status code is: " + statusCode);
        Assert.assertEquals(statusCode, 200);

        String statusLine = response.getStatusLine();
        System.out.println("Status line is:" + statusLine);
        Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
        System.out.println("=======================================================================");
    }

    @Test
    public void testPostAPI() {
        System.out.println("==============================POST=====================================");
        RestAssured.baseURI = "https://reqres.in/api/users";

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

    @Test
    public void testPutAPI() {
        System.out.println("==============================PUT======================================");
        RestAssured.baseURI = "https://reqres.in/api/users/2";
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

    @Test
    public void testPatchAPI() {
        System.out.println("=============================PATCH=====================================");
        RestAssured.baseURI = "https://reqres.in/api/users/2";
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

    @Test
    public void testDeleteAPI() {
        System.out.println("=============================DELETE=====================================");
        RestAssured.baseURI = "https://reqres.in/api/users/2";
        RequestSpecification httpRequest = RestAssured.given();
        JSONObject requestParams = new JSONObject();

        requestParams.put("id", 520);

        httpRequest.header("Content-Type", "application/json");

        httpRequest.body(requestParams.toString()); // attach above data to the request

        Response response = httpRequest.request(Method.DELETE);
        int statusCode = response.getStatusCode();
        System.out.println("Status code is: " + statusCode);
        Assert.assertEquals(statusCode, 204);
        System.out.println("=======================================================================");
    }
}

