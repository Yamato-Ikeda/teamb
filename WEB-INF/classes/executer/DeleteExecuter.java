package executer;

import java.util.ArrayList;
import dba.Accessor;
import bean.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeleteExecuter extends Executer{
	
	public Object execute(Object o){
		
		Boolean result = false;
		
		DeleteBean db = (DeleteBean)o;
		Integer post_number = db.getPost_number();
		String postedDKey = db.getDelete_key();
		
		System.out.println(postedDKey);//test
		//postedDKeyにはフォームで入力された削除パスの文字が入る
		String DBDKey = "";
		//DBDKeyにはデータベースに保存されている削除パス（指定されたコメント番号のもの）が入る
		//DBに接続
		accessor.connect();
		//コメントを取得----------------------------------------------------------------------
		String sql = "SELECT delete_key FROM Contents WHERE post_number = ";
		sql = sql.concat(post_number.toString());
		System.out.println("削除パス確認リード："+sql);//test
		try{
			ResultSet rs = accessor.read(sql);
			rs.next();
			
			DBDKey = rs.getString(1);
			System.out.println("削除パス = "+rs.getString(1));//test
		//--------------------------------------------------------------------------------------------------
		
		}catch(SQLException e){
			System.out.println("えぐぜ：SQLException");
			System.out.println(e.getErrorCode());
		}
		
		if(postedDKey.equals(DBDKey) || postedDKey.equals("admin")){
			//postedDKeyとDBDKeyの内容が合致したなら削除フラグを立てる（表示しない処理はReadExecuterで行われる）
			System.out.println("合致、削除処理実行");//test
			sql = "UPDATE Contents SET delete_flag = 1 WHERE post_number = ";
			sql = sql.concat(post_number.toString());
			System.out.println("削除処理："+sql);//test
			accessor.write(sql);
			
			result = true;
		}else{
			//何もしない
		}
		//DBから切断
		accessor.close();
		
		return result;
	}
	
}