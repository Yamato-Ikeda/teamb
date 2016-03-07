import executer.*;

import bean.*;

import java.util.ArrayList;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DeleteServlet extends HttpServlet{
	DeleteExecuter DE=new DeleteExecuter();
	
	
	public void doGet(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{		
		req.setCharacterEncoding("Windows-31J");
		
		
		String p = req.getParameter(post_number);
		String d = req.getParameter(delete_key);
		
		DeleteBean db = new DeleteBean();
		
		
		db.setPost_number(p);
		db.setDelete_key(d);

		//int threadNo = Integer.parseInt( req.getParameter("thread") );
		
		//ContentsBean CB =new ContentsBean();
		//int postNo = -1;
		
		boolean b = (boolean) DE.execute(db);
		
		//CheckReplace cr = new CheckReplace();
		//tb = cr.check(tb);
		String result;
		
		if(b){
			result="ê¨å˜ÇµÇ‹ÇµÇΩÅB";
			
		}else{
			result="é∏îsÇµÇ‹ÇµÇΩÅB";
		}
			System.out.println(result);
		
		//ContentBean tester = (ContentBean)al.get(1);
		//System.out.println(tester.getUser_name());
		
		req.setAttribute("result",result);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/delete.jsp");
		dispatcher.forward(req,res);
		
	}
}