package executer;

import java.util.ArrayList;
import dba.Accessor;
import bean.ContentBean;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReadExecuter extends Executer{
	
	public Object execute(Object o){
		
		if(o != null){
			Integer i = (Integer)o;
		}
		
		//DBに接続
		accessor.connect();
		
		ArrayList<ContentBean> al = new ArrayList<ContentBean>();
		
		//コメント一覧を取得----------------------------------------------------------------------
		String sql = "SELECT * FROM Contents ORDER BY post_number DESC";
		try{
			ResultSet rs = accessor.read(sql);
			
			while(rs.next()){
				
				//コレクションに格納する1コメントごとのオブジェクト
				ContentBean tb = new ContentBean();
				
				tb.setPost_number(rs.getInt("post_number"));
				System.out.println(rs.getInt("post_number"));
				/*String title = rs.getString(2);
					title = CheckReplace.check(title);
					tb.setTitle(title);*/
				tb.setUser_name(rs.getString("User_name"));
				System.out.println(rs.getString("User_name"));
				tb.setEmail_address(rs.getString("Email_address"));
				System.out.println(rs.getString("Email_address"));
				tb.setMessage(rs.getString("Message"));
				System.out.println(rs.getInt("Message"));
				tb.setDelete_flag(rs.getBoolean("Delete_flag"));
				System.out.println(rs.getBoolean("Delete_flag"));
				tb.setImage(rs.getString("Image"));
				System.out.println(rs.getString("Image"));
				
				//コレクションに1スレッドごとのオブジェクトを格納
				al.add(tb);
			}
		//----------------------------------------------------------------------------------------------------
		
		}catch(SQLException e){
			System.out.println("えぐぜ：SQLException");
		}
		//DBから切断
		accessor.close();
		
		return al;
	}
	
}