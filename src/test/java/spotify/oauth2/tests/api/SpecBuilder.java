package spotify.oauth2.tests.api;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;


public class SpecBuilder {

	

	public static RequestSpecification RequestSpecification() throws FileNotFoundException

	{

		
		return new RequestSpecBuilder().setBaseUri(System.getProperty("BASE_URI")).
				//setBaseUri("https://api.spotify.com").
				setBasePath(Routes.BasePath)
				.setContentType(ContentType.JSON)
				.addFilter(new AllureRestAssured()).log(LogDetail.ALL)
				.build();

	}

	public static  ResponseSpecification Responsesepecification()

	{
		return new ResponseSpecBuilder().log(LogDetail.ALL).build();

	}
	
	public static  RequestSpecification AuthorizeSpec() throws FileNotFoundException

	{
		
		return new RequestSpecBuilder().setBaseUri(System.getProperty("BASE_URI_TOKEN")).
				//setBaseUri("https://accounts.spotify.com/")
				setContentType(ContentType.URLENC).addFilter(new AllureRestAssured())
				.build();

	}
	

}
