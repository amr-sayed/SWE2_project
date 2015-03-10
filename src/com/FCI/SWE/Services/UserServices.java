package com.FCI.SWE.Services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.server.mvc.Viewable;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.FCI.SWE.Models.User;
import com.FCI.SWE.ServicesModels.UserEntity;
import com.google.apphosting.utils.config.ClientDeployYamlMaker.Request;

/**
 * This class contains REST services, also contains action function for web
 * application
 * 
 * @author Mohamed Samir
 * @version 1.0
 * @since 2014-02-12
 *
 */
@Path("/")
@Produces(MediaType.TEXT_PLAIN)
public class UserServices {
	
	
	/*@GET
	@Path("/index")
	public Response index() {
		return Response.ok(new Viewable("/jsp/entryPoint")).build();
	}*/


		/**
	 * Registration Rest service, this service will be called to make
	 * registration. This function will store user data in data store
	 * 
	 * @param uname
	 *            provided user name
	 * @param email
	 *            provided user email
	 * @param pass
	 *            provided password
	 * @return Status json
	 */
	@POST
	@Path("/RegistrationService")
	public String registrationService(@FormParam("uname") String uname,
			@FormParam("email") String email, @FormParam("password") String pass) {
		UserEntity user = new UserEntity(uname, email, pass);
		user.saveUser();
		JSONObject object = new JSONObject();
		object.put("Status", "OK");
		return object.toString();
	}

	/**
	 * Login Rest Service, this service will be called to make login process
	 * also will check user data and returns new user from datastore
	 * @param uname provided user name
	 * @param pass provided user password
	 * @return user in json format
	 */
	@POST
	@Path("/LoginService")
	public String loginService(@FormParam("uname") String uname,
			@FormParam("password") String pass) {
		JSONObject object = new JSONObject();
		UserEntity user = UserEntity.getUser(uname, pass);
		if (user == null) {
			object.put("Status", "Failed");

		} else {
			object.put("Status", "OK");
			object.put("name", user.getName());
			object.put("email", user.getEmail());
			object.put("password", user.getPass());
			object.put("id", user.getId());
		}
		return object.toString();

	}
	
@POST
@Path("/addFriendService")
public String addFriendService(@FormParam("email") String email){
	JSONObject object = new JSONObject();
	String curUser= User.getCurrentActiveUser().getEmail();
	String checkEmail=UserEntity.getUserByEmail(email);
	System.out.println(curUser);
	System.out.println(checkEmail);
	
	if(checkEmail==null){
		object.put("Status", "Failed");
	}else{
		object.put("Status", "OK");
		object.put("email",email );
		UserEntity.saveFriendShip(curUser,email);
		
	}
	return object.toString();

}

@POST
@Path("/frindConfirmService")
public String frindConfirmService(@FormParam("fname") String fname) {
	System.out.println("Servece rest frindConfirmService");
	JSONObject object = new JSONObject();
	String urlParameters = "Status=" + "Failed" ;
	boolean flag=UserEntity.confirmFrind(User.getCurrentActiveUser().getEmail(), fname);
	if(flag==true){
	 object.put("Status", "OK");
	}
	else{
		 object.put("Status", "failed");
				
	}
	return object.toString() ;
}



 public static ArrayList<String> requsts = new ArrayList<>();

@POST
@Path("/seeFriendRequsts")
public String seeFriendRequsts( ) {
	System.out.println("seeFriendRequsts");
	requsts=UserEntity .getFrindRequsts(User.getCurrentActiveUser().getEmail());
	System.out.println("req  "+requsts);
	JSONObject object = new JSONObject();
	object.put("Status", "OK");
	return object.toString();
}






	

}