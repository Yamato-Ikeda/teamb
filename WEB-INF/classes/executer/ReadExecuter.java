package executer;

import java.util.ArrayList;
import dba.Accessor;
import bean.ContentBean;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ThReadExecuter extends Executer{
	
	public Object execute(Object s){
		
		//便宜上
		String str = (String)s;
		
		//DBに接続
		accessor.connect();
		
		ContentBean _tb = new ContentBean();
		
		//スレッド一覧を取得----------------------------------------------------------------------
		String sql = "SELECT * FROM Contents ORDER BY post_number DESC";
		try{
			ResultSet rs = accessor.read(sql);
			
			while(rs.next()){
				
				//コレクションに格納する1スレッドごとのオブジェクト
				ThreadBean tb = new ThreadBean();
				
				tb.setThreadNo(rs.getInt(1));
				System.out.println(rs.getInt(1));
				/*String title = rs.getString(2);
					title = CheckReplace.check(title);
					tb.setTitle(title);*/
				tb.setTitle(rs.getString(2));
				System.out.println(rs.getString(2));
				tb.setCategory(rs.getString(3));
				System.out.println(rs.getString(3));
				tb.setCount(rs.getInt(4));
				System.out.println(rs.getInt(4));
				
				//コレクションに1スレッドごとのオブジェクトを格納
				_tb.setThreadList(tb);
			}
		//----------------------------------------------------------------------------------------------------
		
		}catch(SQLException e){
			System.out.println("えぐぜ：SQLException");
		}
		//DBから切断
		accessor.close();
		
		return _tb.getThreadList();
	}
	
}