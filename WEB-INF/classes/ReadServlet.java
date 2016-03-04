import executer.*;

import bean.*;

import java.util.ArrayList;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ReadServlet extends HttpServlet{
	ReadExecuter RE=new ReadExecuter();
	
	
	public void doGet(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{		
		req.setCharacterEncoding("Windows-31J");
		

		//int threadNo = Integer.parseInt( req.getParameter("thread") );
		
		//ContentsBean CB =new ContentsBean();
		int postNo = -1;
		ArrayList al = (ArrayList) RE.execute(postNo);
		
		//CheckReplace cr = new CheckReplace();
		//tb = cr.check(tb);
		
		ContentBean tester = (ContentBean)al.get(1);
		System.out.println(tester.getUser_name());
		
		req.setAttribute("al",al);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/practice.jsp");
		dispatcher.forward(req,res);
		
	}
}