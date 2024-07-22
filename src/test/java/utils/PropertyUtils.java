package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtils {
	
	
	
	public static Properties propertyLoader(String Filepath) throws IOException
	
	{
		Properties LoadProperties = new Properties();
		
		try
		{
		
		
		BufferedReader br= new BufferedReader(new FileReader(Filepath));
		
		LoadProperties.load(br);
		br.close();
		
		}
		
		catch(Exception e)
		{
			
			System.out.println("File not found or readable");
		}
		
		return LoadProperties;
	}

}
