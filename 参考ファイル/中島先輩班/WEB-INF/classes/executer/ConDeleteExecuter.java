package executer;

import dba.Accessor;
import bean.*;

public class ConDeleteExecuter extends Executer{
	
	
	public Object execute(Object cb){
		
		ContentsBean CB = (ContentsBean)cb;
		
		Accessor accessor=new Accessor();
		accessor.connect();
		//まずスレッドの中身を削除
		String sql1="UPDATE contents SET con_name='管理者',con_text='削除されました',con_date=SYSDATE WHERE con_no="+CB.getContentNo()+" AND th_no="+CB.getThreadNo();
		accessor.write(sql1);
		
		accessor.commit();
		accessor.close();
		return "コンテンツ内容を削除完了！";
		}
}