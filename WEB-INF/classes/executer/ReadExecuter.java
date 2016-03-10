package executer;

import java.util.ArrayList;
import dba.Accessor;
import bean.ContentBean;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReadExecuter extends Executer{
	
	public Object execute(Object o){
		
		Integer i = (Integer)o;
		
		//DBに接続
		accessor.connect();
		
		ArrayList<ContentBean> al = new ArrayList<ContentBean>();
		int count = 0;
		//コメント一覧を取得----------------------------------------------------------------------
		String sql = "SELECT * FROM Contents ORDER BY post_number DESC";
		try{
			ResultSet rs = accessor.read(sql);
			
			while(rs.next()){
				//コレクションに格納する1コメントごとのオブジェクト
				ContentBean tb = new ContentBean();
				
				tb.setPost_number(rs.getInt(1));
				System.out.print(rs.getInt(1));
				tb.setUser_name(rs.getString("User_name"));
				System.out.println(rs.getString("User_name"));
				tb.setEmail_address(rs.getString("Email_address"));
				//System.out.println(rs.getString("Email_address"));
				tb.setMessage(rs.getString(4));
				//System.out.println(rs.getString(4));
				tb.setDelete_flag(rs.getBoolean("Delete_flag"));
				//System.out.println(rs.getBoolean("Delete_flag"));
				tb.setImage(rs.getString("Image"));
				//System.out.println(rs.getString("Image"));
				tb.setDate(rs.getString("Post_date"));
				System.out.println(rs.getString("Post_date"));
				//削除されていないコメントなら、表示されるコメントの数を加算
				if(!rs.getBoolean("Delete_flag")){
					count++;
				}
				//コレクションに1コメントごとのオブジェクトを格納
				//（指定された範囲の１０件のコメントのみ）
				if(count <= i*10 && count >= i*10 - 9){
					al.add(tb);
				}
			}
		//----------------------------------------------------------------------------------------------------
		
		}catch(SQLException e){
			System.out.println("えぐぜ：SQLException");
			System.out.println(e.getErrorCode());
		}
		//DBから切断
		accessor.close();
		
		return al;
	}
	
}