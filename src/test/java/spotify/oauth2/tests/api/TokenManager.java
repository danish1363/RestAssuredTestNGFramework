package spotify.oauth2.tests.api;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Instant;
import java.util.HashMap;

import io.restassured.response.Response;
import spotify.oauth2.tests.api.Playlistapi.PlaylistApi;
import utils.ConfigLoader;


public class TokenManager {

	public static String token;
	public static Instant Expirytime;

	public static String getToken()

	{

		try {
			if (token == null || Instant.now().isAfter(Expirytime))// if current time is after expiry time {
			{
				System.out.println("renewing token");
				Response res = tokenManager();
				token = res.path("access_token");
				int expirationInseconds = res.path("expires_in");// seconds in which token will expire
				Expirytime = Instant.now().plusSeconds(expirationInseconds - 300);// expiry time after adding expiration
																					// seconds to current time

			}

			else {

				System.out.println("token is good to use ");
			}
		} catch (Exception e) {
			System.out.println("Token renewing failed");

		}

		return token;

	}

	public static Response tokenManager() throws IOException {

		HashMap<String, String> hs = new HashMap<String, String>();
		hs.put("grant_type", ConfigLoader.getconfig().getGrantType());
		hs.put("refresh_token",ConfigLoader.getconfig().getRefreshToken());
		hs.put("client_secret", ConfigLoader.getconfig().getClientSecret());
		hs.put("client_id", ConfigLoader.getconfig().getclientId());

		Response res = PlaylistApi.refreshToken(hs);

		if (res.statusCode() != 200)

		{

			throw new RuntimeException("Abort! access token generation failed");
		}

		else {

			return res;
		}

	}

}
