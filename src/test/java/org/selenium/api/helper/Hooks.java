package org.selenium.api.helper;

import io.restassured.RestAssured;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.HashMap;
import java.util.Map;

public class Hooks {

    @BeforeClass
    public void setup() {
//        RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1/employees";
//        RestAssured.baseURI = "https://reqres.in/api/users";
//        this.manager = new RequestManager();
//        this.manager.createPlaywright();
//        final Map<String, String> headers = new HashMap<>();
//        headers.put("content-type", "application/json");
//        this.manager.setApiRequestContext(baseUrl, headers);
    }

    @AfterClass
    public void tearDown() {
//        this.manager.disposeAPIRequestContext();
//        this.manager.closePlaywright();
    }
}
