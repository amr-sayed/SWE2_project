package com.FCI.SWE.ServicesModels;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.FCI.SWE.Models.User;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;

/**
 * <h1>User Entity class</h1>
 * <p>
 * This class will act as a model for user, it will holds user data
 * </p>
 *
 * @author Mohamed Samir
 * @version 1.0
 * @since 2014-02-12
 */
public class UserEntity {
	private String name;
	private String email;
	private String password;
	private long id;

	/**
	 * Constructor accepts user data
	 * 
	 * @param name
	 *            user name
	 * @param email
	 *            user email
	 * @param password
	 *            user provided password
	 */
	public UserEntity(String name, String email, String password) {
		this.name = name;
		this.email = email;
		this.password = password;
	}
	
	private void setId(long id){
		this.id = id;
	}
	
	public long getId(){
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPass() {
		return password;
	}

	
	/**
	 * 
	 * This static method will form UserEntity class using user name and
	 * password This method will serach for user in datastore
	 * 
	 * @param name
	 *            user name
	 * @param pass
	 *            user password
	 * @return Constructed user entity
	 */

	public static UserEntity getUser(String name, String pass) {
		DatastoreService datastore = DatastoreServiceFactory
				.getDatastoreService();

		Query gaeQuery = new Query("users");
		PreparedQuery pq = datastore.prepare(gaeQuery);
		for (Entity entity : pq.asIterable()) {
			if (entity.getProperty("name").toString().equals(name)
					&& entity.getProperty("password").toString().equals(pass)) {
				UserEntity returnedUser = new UserEntity(entity.getProperty(
						"name").toString(), entity.getProperty("email")
						.toString(), entity.getProperty("password").toString());
				returnedUser.setId(entity.getKey().getId());
				return returnedUser;
			}
		}

		return null;
	}

	/**
	 * This method will be used to save user object in datastore
	 * 
	 * @return boolean if user is saved correctly or not
	 */
	public Boolean saveUser() {
		DatastoreService datastore = DatastoreServiceFactory
				.getDatastoreService();
		Query gaeQuery = new Query("users");
		PreparedQuery pq = datastore.prepare(gaeQuery);
		List<Entity> list = pq.asList(FetchOptions.Builder.withDefaults());

		Entity employee = new Entity("users", list.size() + 1);

		employee.setProperty("name", this.name);
		employee.setProperty("email", this.email);
		employee.setProperty("password", this.password);
		datastore.put(employee);

		return true;

	}
	
	public static String getUserByEmail(String email) {
		DatastoreService datastore = DatastoreServiceFactory
				.getDatastoreService();

		Query gaeQuery = new Query("users");
		PreparedQuery pq = datastore.prepare(gaeQuery);
		for (Entity entity : pq.asIterable()) {
			if ( entity.getProperty("email").toString().equals(email) ){
			  return email;
			}
		}

		return null;
	}

	
	public static Boolean confirmFrind (String email ,String femail) {
		System.out.println(email +" "+femail+" enterFunc");
		DatastoreService datastore = DatastoreServiceFactory
				.getDatastoreService();
		Query gaeQuery = new Query("FriendShip");
		PreparedQuery pq = datastore.prepare(gaeQuery);
		List<Entity> list = pq.asList(FetchOptions.Builder.withDefaults());

		//Entity Friend = new Entity("FriendShip", list.size() + 1);
		boolean flag=false;
		for (Entity Friend : pq.asIterable()) {
			System.out.println(Friend.getProperty("cuurent"));
if ( Friend.getProperty("cuurent").toString().equals(femail)&&Friend.getProperty("reciver").toString().equals(email) && Friend.getProperty("bool").toString().equals("false") ){
					System.out.println( " entercond");
					Friend.setProperty("bool", true);
				
					if(datastore.put(Friend).isComplete())
				      	flag=true;
					
}
		}
		
//		Friend.setProperty("cuurent", email);
//		Friend.setProperty("reciver", femail);
//		Friend.setProperty("bool", true);
//		datastore.put(Friend);

		return flag;

	}


	public static Boolean saveFriendShip(String emailOfCurrentUser, String emailOfReciveUser) {
		DatastoreService datastore = DatastoreServiceFactory
				.getDatastoreService();
		Query gaeQuery = new Query("FriendShip");
		PreparedQuery pq = datastore.prepare(gaeQuery);
		List<Entity> list = pq.asList(FetchOptions.Builder.withDefaults());

		Entity Friend = new Entity("FriendShip", list.size() + 1);

		Friend.setProperty("cuurent", emailOfCurrentUser);
		Friend.setProperty("reciver", emailOfReciveUser);
		Friend.setProperty("bool", false);
		datastore.put(Friend);

		return true;

	}
	

	@SuppressWarnings("null")
	public static ArrayList<String>  getFrindRequsts (String email ) {
		ArrayList<String> friendsEmail =new ArrayList<>() ;
		System.out.println("*********Ener***********\nCurrnetUser "+ email);
		DatastoreService datastore = DatastoreServiceFactory
				.getDatastoreService();
		Query gaeQuery = new Query("FriendShip");
		PreparedQuery pq = datastore.prepare(gaeQuery);
		//List<Entity> list = pq.asList(FetchOptions.Builder.withDefaults());
		for (Entity Friend : pq.asIterable()) {
			
			
			System.out.println(Friend.getProperty("cuurent")+"####");
		
if (Friend.getProperty("reciver").toString().equals(email) && Friend.getProperty("bool").toString().equals("false") ){
	
	System.out.println("curr  "+Friend.getProperty("cuurent"));
	friendsEmail.add(Friend.getProperty("cuurent").toString());
					//System.out.println("curr  "+Friend.getProperty("cuurent"));
					
				}
		//System.out.println("*********"+friendsEmail+"r***********");

	}
		return friendsEmail;

	}

	}
