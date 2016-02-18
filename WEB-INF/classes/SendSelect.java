import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;



public class SendSelect{
	public static void main(String[] args){
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");

			//Oracleに接続する
			Connection cn=
				DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl",
				"scott","tiger");
			System.out.println("接続完了");
			
			//select文
			String sql=" SELECT * from emp";

			//Statementインターフェイスを実装するクラスをインスタンス化する
			Statement st=cn.createStatement();

			//select文を実行し
			//ResultSetインターフェイスを実装したクラスの
			//インスタンスが返る
			ResultSet rs=st.executeQuery(sql);

			//カーソルを一行だけスクロールし、データをフェッチする
			rs.next();
			String empno=rs.getString (1);	//1列目のデータを取得
			String ename=rs.getString(2);	//2列目のデータを取得
			String job=rs.getString(3);	//3列目のデータを取得
			
			System.out.println("empno"+"\t"+"ename"+"\t"+"job");
			System.out.println(empno+"\t"+ename+"\t"+job);
			

			
			//Oracleから切断する
			cn.close();

			System.out.println("切断完了");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
			System.out.println("クラスがないみたい。");
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("SQL関連の例外みたい。");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}

