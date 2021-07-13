package com.testcase;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AddPlace {
	@Test
	
//	public static void main(String[] args) throws FileNotFoundException {
	public static void test1() throws FileNotFoundException
	{
		File connection = new File("../Gsdemo_artifact/postdata.json");
		FileReader  filereader= new FileReader(connection);
		JSONTokener jsontoken= new JSONTokener(filereader);


		JSONObject bodydata = new JSONObject(jsontoken);
		Response res=
				given().
				contentType(ContentType.JSON)
				.body(bodydata.toString())
				.when().post("https://rahulshettyacademy.com/maps/api/place/add/json?key=qaclick123");
		System.out.println(res.asPrettyString());

}
}