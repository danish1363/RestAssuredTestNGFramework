package utils;
import java.io.IOException;
import java.util.Properties;

public class DataLoader {
	
	private final Properties property;
		private static DataLoader dataLoad;

		private DataLoader() throws IOException

		{
			property = PropertyUtils.propertyLoader("./src/test/resources/DataLoader.properties");

		}

		public static DataLoader getconfig() throws IOException

		{
			if (dataLoad == null)

			{

				dataLoad = new DataLoader();

			}

			return dataLoad;

		}

		public String getplaylistId()
		{

			String prop = property.getProperty("getplaylistId");
	System.out.println(prop);
			if (prop != null) {
				return prop;

			}

			else {

				throw new RuntimeException("id for get  not found");
			}
		}

		public String updatePlaylistId()

		{

			String prop = property.getProperty("PlaylistUpdateId");

			if (prop != null) {
				return prop;

			}

			else {

				throw new RuntimeException("id for update not found");
			}
		}

	}



