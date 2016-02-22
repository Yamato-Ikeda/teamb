package check;

import java.io.UnsupportedEncodingException;

public class CheckBytes{
		
	public static boolean check(String name, String text){
		try{
			if( name.getBytes("Windows-31J").length>30 || 
				text.getBytes("Windows-31J").length>4000 ||
				text.length()==0
			)
			{
				return true;
			}
			
			
		}catch(UnsupportedEncodingException e){}
		return false;
	}
	
	public static boolean check(String title, String name, String text){
		try{
			if( title.getBytes("Windows-31J").length>100 || 
				name.getBytes("Windows-31J").length>30 || 
				text.getBytes("Windows-31J").length>4000 ||
				text.length()==0
			)
			{
				return true;
			}
			
			
		}catch(UnsupportedEncodingException e){}
		return false;
	}
}