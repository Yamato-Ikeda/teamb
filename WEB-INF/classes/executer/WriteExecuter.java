package executer;

import java.util.ArrayList;
import bean.*;
import dba.Accessor;
//import bean.ThreadBean;
import bean.ContentBean;
//時間があったらcheckクラスを作る
// import check.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WriteExecuter extends Executer{
	
	public Object execute(Object bean){
		accessor.connect();
		
		ContentBean cb = (ContentBean)bean;
		
		//シングルクォート置換
		//cb = CheckReplace.check(cb);
		
		String sql = "INSERT INTO Contents( post_number, user_name, email_address, message, delete_key,delete_flag,image,post_date) VALUES(";
		//sql = sql.concat("1, 0, '"+cb.getName()+"', SYSDATE, '"+cb.getText()+"' )");
		
		//Contents表に投稿をインサート。CON_NO（コンテンツの通し番号）はそのスレッドのコンテンツ数+1を格納。
		sql = sql.concat("postno.nextval,"+cb.getUser_name()+","+cb.getEmail_address()+","+cb.getMessage()+","+cb.getDelete_key()+","+cb.getDelete_flag()+","+cb.getImage()+", SYSDATE, )");
		accessor.write(sql);

		//Thread表のTH_CON_COUNT（そのスレッドのコンテンツ数）を+1してアップデート。
		//sql = "UPDATE thread SET th_con_count = (SELECT th_con_count+1 FROM thread WHERE th_no = "+cb.getThreadNo()+") WHERE th_no = "+cb.getThreadNo();
		//accessor.write(sql);
		
		accessor.close();
		
		String str = "書き込み成功";
		return str;
		
	}
}