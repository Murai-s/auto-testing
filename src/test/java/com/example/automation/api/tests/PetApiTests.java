package com.example.automation.api.tests;

import com.example.automation.api.models.Pet;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public class PetApiTests {

    private static final String BASE_URL = "https://petstore.swagger.io/v2";

    private long createdPetId;
    private String petName;

    @Test
    public void testCreatePetSuccessfully() {

        petName = "rex-" + System.currentTimeMillis();

        Pet petToCreate = Pet.builder().name(petName).status("available").build();

        createdPetId = given().
                baseUri(BASE_URL).
                header("Content-Type", "application/json").
                body(petToCreate).
        when().
                post("/pet").
        then().
                statusCode(200).
                body("name", equalTo(petName)).
                body("status", equalTo("available")).
                body("id", notNullValue()).
                log().body().
                extract().
                path("id");

        System.out.println("Создан питомец с ID: " + createdPetId);
    }

    @Test(dependsOnMethods = "testCreatePetSuccessfully")
    public void testFindPetByIdSuccessfully() {

        given().
                baseUri(BASE_URL).
                pathParam("petId", createdPetId).
        when().
                get("/pet/{petId}").
        then().
                statusCode(200).
                body("id", equalTo(createdPetId)).
                body("name", equalTo(petName)).
                log().body();

    }


}
