package org.prog.session18.steps;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.prog.session16.dto.ResultsDto;

public class ApiSteps {

    public static ResultsDto results;

    @Given("I request {int} random people from service")
    public void requestPeopleFromService(int number) {
        results = RestAssured
                .given()
                .baseUri("https://randomuser.me/")
                .basePath("/api/")
                .queryParam("noinfo")
                .queryParam("inc", "gender,name,nat")
                .queryParam("results", number)
                .get()
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract()
                .as(ResultsDto.class);
    }
}
