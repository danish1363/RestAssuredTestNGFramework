package utils;

import com.github.javafaker.Faker;

public class FakerUtils {
	
	
	public static String  GenerateName()
	
	{
		Faker f= new Faker();
	return	f.regexify("[A-Za-z1-9_]{10}");
		
		
	}
	
public static String  GenerateDescription()
	
	{
		Faker f= new Faker();
	return	f.regexify("[A-Za-z_]{10}");
		
		
	}
public static String  GenerateRandomToken()

{
	Faker f= new Faker();
return	f.regexify("[0-9a-zA-Z]{10}");
	
	
}

}
