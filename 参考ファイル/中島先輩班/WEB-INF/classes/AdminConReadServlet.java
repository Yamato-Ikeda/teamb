import java.io.*;

import executer.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import bean.*;

public class AdminConReadServlet extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse res)
		throws	IOException,ServletException
	{
		req.setCharacterEncoding("windows-31j");
		
		int threadNo = Integer.parseInt( req.getParameter("thread") );
		
		ContentsBean CB =new ContentsBean();
		
		ReadExecuter RE=new ReadExecuter();
		
		ThreadBean tb = (ThreadBean) RE.execute(threadNo);
		
		req.setAttribute("tb",tb);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/condelete.jsp");
		dispatcher.forward(req,res);
			
	}
}