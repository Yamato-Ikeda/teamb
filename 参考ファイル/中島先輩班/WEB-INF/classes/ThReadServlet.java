import bean.*;
import executer.*;

import java.util.ArrayList;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ThReadServlet extends HttpServlet{
	ThReadExecuter ThRE=new ThReadExecuter();
	
	public void doGet(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{	
		
		ThreadBean TB =new ThreadBean();
		
		String a="";
		
		ArrayList AL=new ArrayList();
		
		AL=(ArrayList)ThRE.execute(a);
	
		req.setAttribute("al",AL);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/threadresult.jsp");
		dispatcher.forward(req,res);
		
		
	}
}