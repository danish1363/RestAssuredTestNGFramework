package spotify.oauth2.tests;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Link;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import spotify.oauth2.tests.api.StatusCode;
import spotify.oauth2.tests.api.Playlistapi.PlaylistApi;
import spotify.oauth2.tests.pojo.PlaylistPojo;
import utils.DataLoader;
import utils.FakerUtils;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;




@Epic("Spotify Oauth 2.0")
@Feature("Playlist Api Testing")
public class PlaylistTests extends BaseTest{
	
	
	@Step
	public void assertResponses(PlaylistPojo ResonsePojo,PlaylistPojo Requestpojo)
	
	{
		assertThat(ResonsePojo.getName(), equalTo(Requestpojo.getName()));
		assertThat(ResonsePojo.getDescription(), equalTo(Requestpojo.getDescription()));
		assertThat(ResonsePojo.get_public(), equalTo(Requestpojo.get_public()));
		
		
	}
	
	
	
	
	
	@Step
	public void asserstatuscode(int ExpectedStatusCode,StatusCode sc)
	
	{
		assertThat(ExpectedStatusCode, equalTo(sc.code));
		
		
	}
	
	
	@Step
	public PlaylistPojo setdata(String Name,String Description,boolean public_)
	{
		
		// Json Builder Pattern
		   //return new PlaylistPojo.setName(Name).setDescription(Description).setPublic(public_);
		
	return	PlaylistPojo.builder().name(Name).description(Description)._public(public_).build();
	}
	@Step
	public PlaylistPojo setdataforInvalidTestCase(String Description,boolean public_)
	{
		
	return	PlaylistPojo.builder().description(Description)._public(public_).build();
	}
	

	@Story("Create Playlist")
    @Description("This test case will create a playlist and take payload which contains name, description and public parameters")
	@Test(description="Should be able to create a playlist")
	public void CreatePlaylist() throws IOException

	{

		PlaylistPojo RequestPlaylist=setdata(FakerUtils.GenerateName(),FakerUtils.GenerateDescription(),false);
		Response res = PlaylistApi.post(RequestPlaylist);

		asserstatuscode(res.statusCode(), StatusCode.CODE_201);

		PlaylistPojo ResponsePlaylist = res.as(PlaylistPojo.class);
		
		assertResponses(ResponsePlaylist,RequestPlaylist);

	

	}
	
	@Story("get Playlist")
    @Description("This test case will get us all info on playlist by providing playlist id and path parameter ")
	@Test(description="Should be able to get a playlist info")
	public void getPlaylist() throws IOException

	{

		PlaylistPojo RequestPlaylist = setdata("Rio Playlist","dogs songs",true);
		Response res = PlaylistApi.get(DataLoader.getconfig().getplaylistId());
		asserstatuscode(res.statusCode(), StatusCode.CODE_200);
		PlaylistPojo ResponsePlaylist = res.as(PlaylistPojo.class);
		assertResponses(ResponsePlaylist,RequestPlaylist);


	}
     
    @Story("Update playlist")
    @Description("This Test case will be able to update playlist by taking the playlist id as path param and upddating the record")

	@Test(description="Should be able to update a playlist")
	public void updatePlaylist() throws IOException

	{
		PlaylistPojo RequestPlaylist = setdata(FakerUtils.GenerateName(),FakerUtils.GenerateDescription(),false);
		Response res = PlaylistApi.update(DataLoader.getconfig().updatePlaylistId(), RequestPlaylist);
		asserstatuscode(res.statusCode(), StatusCode.CODE_200);

	}
    
    @Story("Create_Playlist_Without_name_Field")
@Description("This is a negetive scenerio to check playlist is not created when Name is not provided in payload")
@Issue("AUTH-123")
@Link(name="link",type="mylink")
	@Test(description="Should not be able to create a playlist without Name")
	public void shouldnotBeAbleToCreatePlaylist() throws IOException

	{

		PlaylistPojo RequestPlaylist = setdataforInvalidTestCase(FakerUtils.GenerateDescription(),true);

		Response res = PlaylistApi.post(RequestPlaylist);

		asserstatuscode(res.statusCode(), StatusCode.CODE_400);

	}
    
    @Story("Create_Playlist_With_Expired_Token")
@Description("this test case will not create playlist because we are passing expired token ")
	@Test(description="Should not be able to craete playlist with expired token")
	public void shouldnotBeAbleToCreatePlaylistwithExpiredToken() throws IOException

	{

		PlaylistPojo RequestPlaylist = setdata(FakerUtils.GenerateName(),FakerUtils.GenerateDescription(),true);

		Response res = PlaylistApi.postwithtoken(RequestPlaylist, FakerUtils.GenerateRandomToken());

		asserstatuscode(res.statusCode(), StatusCode.CODE_401);

		// (res.asString()., equalTo("The access token expired"))

	}

}
