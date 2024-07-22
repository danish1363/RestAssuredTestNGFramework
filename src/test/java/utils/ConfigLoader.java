package utils;
import java.io.IOException;
import java.util.Properties;

public class ConfigLoader {

	private final Properties property;
	private static ConfigLoader configload;

	private ConfigLoader() throws IOException

	{
		property = PropertyUtils.propertyLoader("./src/test/resources/ProjectProperty.properties");

	}

	public static ConfigLoader getconfig() throws IOException

	{
		if (configload == null)

		{

			configload = new ConfigLoader();

		}

		return configload;

	}

	public String getclientId()

	{

		String prop = property.getProperty("client_id");
System.out.println(prop);
		if (prop != null) {
			return prop;

		}

		else {

			throw new RuntimeException("client id not found");
		}
	}

	public String getClientSecret()

	{

		String prop = property.getProperty("client_secret");

		if (prop != null) {
			return prop;

		}

		else {

			throw new RuntimeException("client secret not found");
		}
	}

	public String getGrantType()

	{

		String prop = property.getProperty("grant_type");

		if (prop != null) {
			return prop;

		}

		else {

			throw new RuntimeException("grant type not found");
		}
	}

	public String getRefreshToken()

	{

		String prop = property.getProperty("refresh_token");

		if (prop != null) {
			return prop;

		}

		else {

			throw new RuntimeException("refresh token not found");
		}
	}
	
	public String getuserId()

	{

		String prop = property.getProperty("User");

		if (prop != null) {
			return prop;

		}

		else {

			throw new RuntimeException("refresh token not found");
		}
	}

}
