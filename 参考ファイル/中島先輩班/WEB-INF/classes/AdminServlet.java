import java.io.*;

import java.util.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.*;
import executer.*;

public class AdminServlet extends HttpServlet{
	static int isLogin = 0;
	public void doPost(HttpServletRequest req,HttpServletResponse res)
		throws	IOException,ServletException{
			req.setCharacterEncoding("windows-31j");
			String id=req.getParameter("id");
			String pass=req.getParameter("pass");
			
			AdminLogin log=new AdminLogin();
			
			
			
			boolean flag=log.login(id,pass);
			System.out.println(id+pass);
			
			if(flag==true){
				isLogin = 1;
				doGet(req,res);
			}else{
				req.setAttribute("result","IDÇ‡ÇµÇ≠ÇÕPasswardÇ™ä‘à·Ç¡ÇƒÇ¢Ç‹Ç∑ÅB");
				RequestDispatcher dispatcher = req.getRequestDispatcher("/LoginFailed.html");
				dispatcher.forward(req,res);
			}
		}
	public void doGet(HttpServletRequest req,HttpServletResponse res)
		throws	IOException,ServletException{
			ThReadExecuter ThRE=new ThReadExecuter();
			ThreadBean TB =new ThreadBean();
			
			if( isLogin == 1 ){
				String a="";
			
				ArrayList AL=new ArrayList();
				
				AL=(ArrayList)ThRE.execute(a);
		
				req.setAttribute("al",AL);
				RequestDispatcher dispatcher = req.getRequestDispatcher("/adminthread.jsp");
				dispatcher.forward(req,res);
				isLogin = 0;
			}
			else{
				res.sendRedirect("/testbb/");
			}
		}
	
}