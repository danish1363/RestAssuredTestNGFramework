package spotify.oauth2.tests.api;

public enum StatusCode {

  CODE_200(200,""),
  CODE_401(401,"Unauthorized"),
  CODE_400(400,"Bad Request"),
  CODE_201(201,"Created Sucessfully");
  
	public int code;
	public String message;
	

	StatusCode(int code, String message) {
		// TODO Auto-generated constructor stub
	  this.code=code;
	  this.message=message;
	  
	}
	
	
	 
}
