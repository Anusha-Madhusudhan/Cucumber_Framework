/**
 * 
 */
package com.tekarch.utils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.jayway.jsonpath.JsonPath;
import com.teckarck.constants.FileConstants;

/**
 * 
 */
public class DataProviderClass {
	
	@DataProvider(name = "LoginDataProvider")
	public Object[][] getData() {
		Object[][] loginData = null;
		try {
			loginData=ExcelUtils.readExcelFile("UserCreds");
		} catch (InvalidFormatException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return loginData;
	}
	
	
	
	public static String[][] getDataFromJsonFile() throws IOException {
		String[][] loginData = new String[4][2];
		
		Gson gson=new Gson();
		
		File jsonFile=new File(FileConstants.LOGIN_TEST_DATA_JSON_FILE_PATH);
		
		String jsonString=new String((Files.readAllBytes(Paths.get(FileConstants.LOGIN_TEST_DATA_JSON_FILE_PATH))),StandardCharsets.UTF_8);
		System.out.println("******************");
		System.out.println(jsonString);
		
		ObjectMapper om=new ObjectMapper();
		
		for(int i=0;i<4;i++) {
			
			loginData[i][0]=JsonPath.read(jsonString, "$.userCreds["+i+"].username");
			loginData[i][1]=JsonPath.read(jsonString, "$.userCreds["+i+"].password");
			
			System.out.println("******************");
			System.out.println(loginData[i][0]);
			System.out.println(loginData[i][1]);
			
			
		}
		
		JsonPath.read(jsonString, "$.userCreds[0].username");
		
		
		return loginData;
	}

}
