import executer.*;

import bean.*;



import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ConReadServlet extends HttpServlet{
	ReadExecuter RE=new ReadExecuter();
	
	
	public void doGet(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{		
		req.setCharacterEncoding("Windows-31J");
		

		int threadNo = Integer.parseInt( req.getParameter("thread") );
		
		ContentsBean CB =new ContentsBean();
		
		ThreadBean tb = (ThreadBean) RE.execute(threadNo);
		
		//CheckReplace cr = new CheckReplace();
		//tb = cr.check(tb);
		
		req.setAttribute("tb",tb);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/contents.jsp");
		dispatcher.forward(req,res);
		
	}
}