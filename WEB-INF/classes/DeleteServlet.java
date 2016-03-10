import executer.*;

import bean.*;
import check.*;

import java.util.ArrayList;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DeleteServlet extends HttpServlet{
	DeleteExecuter DE=new DeleteExecuter();
	
	public void doPost(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{		
		req.setCharacterEncoding("Windows-31J");
		
		String p = req.getParameter("post_number");
		String d = req.getParameter("delete_key");
		if(d.length()==0){
			d=" ";
		}
		
		DeleteBean db = new DeleteBean();
		//DeleteBeanに各入力項目を代入
		try{
			db.setPost_number(Integer.parseInt(p));
		}catch(NumberFormatException e){
			db.setPost_number(0);
		}
		db.setDelete_key(d);
		//削除パスの ' を '' に変換する
		CheckReplace cr = new CheckReplace();
		db = cr.check(db);
		//DeleteExecuterのexecuteを呼び出し、コメントの削除を試みる。結果はBooleanで返される
		Boolean b = (Boolean) DE.execute(db);
		
		String result;
		if(b){
			result="成功しました。";
		}else{
			result="失敗しました。";
		}
		System.out.println(result);//テスト用メッセージ
		
		req.setAttribute("result",result);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/delete.jsp");
		dispatcher.forward(req,res);
		
	}
}