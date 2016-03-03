package executer;

import java.util.ArrayList;
import bean.Bean;
import dba.Accessor;
import bean.ThreadBean;
import bean.ContentsBean;
import java.sql.ResultSet;
import java.sql.SQLException;
import check.*;

public class ThReadExecuter extends Executer{
	
	public Object execute(Object s){
		
		//便宜上
		String str = (String)s;
		
		//DBに接続
		accessor.connect();
		
		//呼び出し元に返すコレクションにアクセスするためのオブジェクト
		ThreadBean _tb = new ThreadBean();
		
		//スレッド一覧を取得----------------------------------------------------------------------
		String sql = "SELECT * FROM THREAD ORDER BY TH_NO DESC";
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