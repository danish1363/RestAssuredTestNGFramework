package spotify.oauth2.tests.api;

import java.io.FileNotFoundException;
import java.util.HashMap;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class ReusableApiMethods {

	public static Response post(Object pp, String token, String path) throws FileNotFoundException

	{

		return given(SpecBuilder.RequestSpecification()).auth().oauth2(token).
				body(pp)
				.when()
				.post(path).then().spec(SpecBuilder.Responsesepecification()).extract().response();

	}

	public static Response postwithtoken(Object pp, String token, String path) throws FileNotFoundException

	{

		return given(SpecBuilder.RequestSpecification()).auth().oauth2(token)
				.body(pp).when()
				.post(path).then().spec(SpecBuilder.Responsesepecification()).extract().response();

	}

	public static Response get(String path, String token) throws FileNotFoundException

	{

		return given(SpecBuilder.RequestSpecification()).auth().oauth2(token)
				.when().get(path)
				.then().spec(SpecBuilder.Responsesepecification()).log().all().assertThat().statusCode(200).extract()
				.response();

	}

	public static Response update(Object pp, String token, String path) throws FileNotFoundException

	{

		return given(SpecBuilder.RequestSpecification()).auth().oauth2(token)
				.body(pp).when()
				.put(path).then()

				.spec(SpecBuilder.Responsesepecification()).extract().response();
	}

	public static Response GenerateTokenPost(HashMap<String, String> hs) throws FileNotFoundException

	{
		return given(SpecBuilder.AuthorizeSpec()).formParams(hs).when().
				post(Routes.Tokenpath).then()
				.spec(SpecBuilder.Responsesepecification()).extract().response();

	}

}
