package spotify.oauth2.tests.api.Playlistapi;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import io.restassured.response.Response;
import spotify.oauth2.tests.api.ReusableApiMethods;
import spotify.oauth2.tests.api.Routes;
import spotify.oauth2.tests.api.TokenManager;
import spotify.oauth2.tests.pojo.PlaylistPojo;
import utils.ConfigLoader;

public class PlaylistApi {

	public static Response post(PlaylistPojo pp) throws IOException

	{

		return ReusableApiMethods.post(pp, TokenManager.getToken(), Routes.Users+ConfigLoader.getconfig().getuserId()+Routes.Playlists);

	}

	public static Response postwithtoken(PlaylistPojo pp, String Token) throws IOException

	{
		return ReusableApiMethods.post(pp, Token,Routes.Users+ConfigLoader.getconfig().getuserId()+Routes.Playlists);

	}

	public static Response get(String playlistid) throws FileNotFoundException

	{
		return ReusableApiMethods.get(Routes.Playlists + playlistid, TokenManager.getToken());

	}

	public static Response update(String playlistid, PlaylistPojo pp) throws FileNotFoundException

	{
		return ReusableApiMethods.update(pp, TokenManager.getToken(), Routes.Playlists + playlistid);

	}
	
	public static Response refreshToken(HashMap<String,String> hs) throws FileNotFoundException
	
	{
		
	return	ReusableApiMethods.GenerateTokenPost(hs);
		
		
	}

}
