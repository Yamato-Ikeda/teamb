import java.io.*;

import executer.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import bean.*;

public class ConDeleteServlet extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res)
	throws	IOException,ServletException{

		req.setCharacterEncoding("windows-31j");

		String con=req.getParameter("conNo");
		
		if(con == null){
			res.sendRedirect("/testbb/deleteerror.html");
			return;
		}
		
		int conNo=Integer.parseInt(con);
		
		String th=req.getParameter("threadNo");
		int threNo=Integer.parseInt(th);
		
		
	
		ContentsBean CB =new ContentsBean();
		CB.setThreadNo(threNo);
		CB.setContentNo(conNo);
		
		
	
		ConDeleteExecuter CDE=new ConDeleteExecuter();
		

		
		
		String str =(String) CDE.execute(CB);
		
		//ˆÈ‰º•\Ž¦
		ReadExecuter RE=new ReadExecuter();
		
		ThreadBean tb = (ThreadBean) RE.execute(threNo);
		
		req.setAttribute("tb",tb);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/condelete.jsp");
		dispatcher.forward(req,res);
			
	}
}