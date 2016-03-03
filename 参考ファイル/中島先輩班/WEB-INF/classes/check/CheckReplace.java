package check;

import bean.*;

import java.util.*;

public class CheckReplace{
	
	public static ContentsBean check(ContentsBean cb){
		String name = cb.getName();
		String text = cb.getText();
		
		name = name.replaceAll("'", "''");
		text = text.replaceAll("'", "''");
		
		cb.setName(name);
		cb.setText(text);
		
		return cb;
	}
	
	public static ThreadBean check(ThreadBean tb){
		String title = tb.getTitle();
		
		title = title.replaceAll("'", "''");
		
		tb.setTitle(title);
		
		return tb;
	}
	
	public static String check(String s){
		String str = s;
		
		str = str.replaceAll("<", "&lt;");
		str = str.replaceAll(">", "&gt;");
		
		return str;
	}
	
}