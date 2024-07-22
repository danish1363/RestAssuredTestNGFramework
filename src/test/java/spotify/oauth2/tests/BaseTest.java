package spotify.oauth2.tests;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeMethod;

public class BaseTest {
	
	@BeforeMethod()
	public void beforemethod(Method m)
	
	
	{
		System.out.println("method name =" + m.getName() + "and thread id="+ Thread.currentThread().getId());
		
		
	}

}
