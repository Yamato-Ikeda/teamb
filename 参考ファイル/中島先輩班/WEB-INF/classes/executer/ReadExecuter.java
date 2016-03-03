package executer;

import java.util.ArrayList;
import bean.Bean;
import dba.Accessor;
import bean.ThreadBean;
import bean.ContentsBean;
import java.sql.ResultSet;
import java.sql.SQLException;
import check.CheckReplace;

public class ReadExecuter extends Executer{
	
	public Object execute(Object thNo){
		
		//引数で来た表示するスレッドNo
		int threadNo = (int)thNo;
		
		//DBに接続
		accessor.connect();
		
		//表示するスレッドの情報を取得----------------------------------------------------------------------
		String sql = "SELECT TH_NO,TH_TITLE,TH_CATEGORY,TH_CON_COUNT FROM THREAD WHERE TH_NO = "+threadNo;
		
		ThreadBean tb = new ThreadBean();
		try{
			ResultSet rs = accessor.read(sql);
			
			rs.next();
			tb.setThreadNo(rs.getInt(1));
			//tb.setTitle(rs.getString(2));
			String title = rs.getString(2);
			title = CheckReplace.check(title);
			tb.setTitle(title);
			tb.setCategory(rs.getString(3));
			tb.setCount(rs.getInt(4));
		//--------------------------------------------------------------------------------------------------
			
			
			
		//スレッドのコンテンツを全件取得---------------------------------------------------------------------
			sql = "SELECT TH_NO,CON_NO,CON_NAME,TO_CHAR(CON_DATE,'YYYY/MM/DD(DY) HH24:MI:SS'),CON_TEXT FROM CONTENTS WHERE TH_NO = "+threadNo+" ORDER BY CON_NO";
			rs = accessor.read(sql);
			
			while(rs.next()){
				ContentsBean cb = new ContentsBean();
				cb.setThreadNo(rs.getInt(1));
				System.out.println(rs.getInt(1));
				cb.setContentNo(rs.getInt(2));
				System.out.println(rs.getInt(2));
				cb.setName(rs.getString(3));
				System.out.println(rs.getString(3));
				cb.setDate(rs.getString(4));
				System.out.println(rs.getString(4));
				cb.setText(rs.getString(5));
				System.out.println(rs.getString(5));
				
				tb.setContentsList(cb);
		//----------------------------------------------------------------------------------------------------
				
			}
			}catch(SQLException e){
				System.out.println("えぐぜ：SQLException");
			}
		
		//DBから切断
		accessor.close();
		
		return tb;
	}
	
}