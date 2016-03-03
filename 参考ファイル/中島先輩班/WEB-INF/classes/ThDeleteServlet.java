import java.io.*;

import executer.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import bean.ThreadBean;

public class ThDeleteServlet extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res)
		throws	IOException,ServletException
	{
		req.setCharacterEncoding("windows-31j");

		String thre=req.getParameter("threNo");
		
		if(thre == null){
			res.sendRedirect("/testbb/deleteerror.html");
			return;
		}
		
		int threNo=Integer.parseInt(thre);
		ThDeleteExecuter TDE=new ThDeleteExecuter();
		

		String str =(String) TDE.execute(threNo);
		
		
		ThReadExecuter ThRE=new ThReadExecuter();
		ThreadBean TB =new ThreadBean();
		
		ArrayList AL=new ArrayList();
		
		AL=(ArrayList)ThRE.execute("");

		req.setAttribute("al",AL);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/adminthread.jsp");
		dispatcher.forward(req,res);
			
	}
}