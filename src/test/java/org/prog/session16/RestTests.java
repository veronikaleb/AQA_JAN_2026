package org.prog.session16;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.prog.session16.dto.ResultsDto;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RestTests {

    @Test
    public void testApiCall() {
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://randomuser.me/");
        requestSpecification.basePath("/api/");
        requestSpecification.queryParam("noinfo");
        // TODO: add location to request - ВИКОНАНО
        requestSpecification.queryParam("inc", "gender,name,nat,location");

        Response response = requestSpecification.get();
        response.prettyPrint();

        ValidatableResponse validatableResponse = response.then();
        validatableResponse.statusCode(200);
        validatableResponse.contentType(ContentType.JSON);

        // TODO: validate street number and name in location are not empty - ВИКОНАНО
        validatableResponse.body("results[0].location.street.number", Matchers.notNullValue());
        validatableResponse.body("results[0].location.street.name",
                Matchers.allOf(Matchers.notNullValue(), Matchers.not(Matchers.emptyString())));
    }

    @Test
    public void testApiCall2() {
        RestAssured
                .given()
                .baseUri("https://randomuser.me/")
                .basePath("/api/")
                .queryParam("noinfo")
                .queryParam("inc", "gender,name,nat,location") // Додано location
                .get()
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                // Валідація через Matchers
                .body("results[0].location.street.number", Matchers.notNullValue())
                .body("results[0].location.street.name", Matchers.not(Matchers.emptyString()));
    }

    @Test
    public void testApiCall3() {
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://randomuser.me/");
        requestSpecification.basePath("/api/");
        requestSpecification.queryParam("noinfo");
        requestSpecification.queryParam("inc", "gender,name,nat,location"); // Додано location

        Response response = requestSpecification.get();

        // Десеріалізація JSON у Java-об'єкт
        ResultsDto dto = response.as(ResultsDto.class);

        // Перевірка через Assert (TestNG) та твої DTO
        Assert.assertNotNull(dto.getResults().get(0).getGender(), "Gender should not be null");

        // Перевірка вулиці через DTO (використовуємо методи, згенеровані @Data)
        Assert.assertNotNull(dto.getResults().get(0).getLocation().getStreet().getNumber(),
                "Street number should not be null");
        Assert.assertFalse(dto.getResults().get(0).getLocation().getStreet().getName().isEmpty(),
                "Street name should not be empty");

        System.out.println("Test passed for street: " + dto.getResults().get(0).getLocation().getStreet().getName());
    }
}