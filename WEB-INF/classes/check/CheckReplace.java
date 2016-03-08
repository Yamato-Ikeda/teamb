package check;

import bean.*;

import java.util.*;

public class CheckReplace{
	
	public static ContentBean check(ContentBean cb){
		String user_name = cb.getUser_name();
		String email_address = cb.getEmail_address();
		String message = cb.getMessage();
		String image = cb.getImage();
		String delete_key = cb.getDelete_key();
		
		user_name = user_name.replaceAll("'", "''");
		email_address = email_address.replaceAll("'", "''");
		message = message.replaceAll("'", "''");
		image = image.replaceAll("'", "''");
		delete_key = delete_key.replaceAll("'", "''");
		
		cb.setUser_name(user_name);
		cb.setEmail_address(email_address);
		cb.setMessage(message);
		cb.setImage(image);
		cb.setDelete_key(delete_key);

		
		return cb;
	}
	
	public static DeleteBean check(DeleteBean db){
		String delete_key = db.getDelete_key();
		
		delete_key = delete_key.replaceAll("'", "''");
		
		db.setDelete_key(delete_key);
		
		return db;
	}
	
	//public static String check(String s){
		//String str = s;
		
		//str = str.replaceAll("<", "&lt;");
		//str = str.replaceAll(">", "&gt;");
		
		//return str;
	//}
	
}