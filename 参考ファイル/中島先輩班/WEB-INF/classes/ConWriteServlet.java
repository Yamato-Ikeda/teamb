import executer.*;
import bean.*;
import check.*;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ConWriteServlet extends HttpServlet{
	
	WriteExecuter We=new WriteExecuter();
	
	public void doPost(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{		
		req.setCharacterEncoding("Windows-31J");
		
		ContentsBean CB=new ContentsBean();
		
		int threadNo = Integer.parseInt( req.getParameter("threadNo") );
		int contentNo = Integer.parseInt( req.getParameter("contentNo") );
		String name=req.getParameter("name");
		String text=req.getParameter("text");
		
		if(name.length()==0){
			name="名無し";
		}
		
		//バイト数を超えていないかのチェック-----------
		boolean isError = CheckBytes.check(name,text);
		if(isError){
			res.sendRedirect("/testbb/conbyteserror.html");
			return;
		}
		//-------------------------------------------
		
		
		CB.setThreadNo(threadNo);
		CB.setContentNo(contentNo);
		CB.setName(name);
		CB.setText(text);
		
		We.execute(CB);
		
		//書き込んだスレッドを表示----------------------------------------------------
		ReadExecuter RE=new ReadExecuter();
		ThreadBean tb = (ThreadBean) RE.execute(threadNo);
		
		req.setAttribute("tb",tb);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/contents.jsp");
		dispatcher.forward(req,res);
		//-----------------------------------------------------------------------------
		
	}
}
