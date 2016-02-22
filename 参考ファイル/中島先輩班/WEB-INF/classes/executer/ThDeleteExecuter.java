package executer;

import dba.Accessor;


public class ThDeleteExecuter extends Executer{
	
	
	public Object execute(Object tn){
		
		int threNo = (int)tn;
		
		Accessor accessor=new Accessor();
		accessor.connect();
		//まずスレッドの中身を削除
		String sql1="DELETE contents WHERE th_no="+threNo;
		accessor.write(sql1);
		
		//次にスレッドを削除
		String sql2="DELETE thread WHERE th_no="+threNo;
		accessor.write(sql2);
		
		accessor.commit();
		accessor.close();
		return "スレッド削除完了！";
		}
}