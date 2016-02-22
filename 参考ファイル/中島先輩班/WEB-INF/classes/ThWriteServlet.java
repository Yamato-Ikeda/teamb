import executer.*;
import bean.*;
import check.*;

import java.util.*;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ThWriteServlet extends HttpServlet{
	
	ThWriteExecuter ThWe=new ThWriteExecuter();
	WriteExecuter cWe = new WriteExecuter();
	ThReadExecuter TRE=new ThReadExecuter();
	
	public void doPost(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{		
		req.setCharacterEncoding("Windows-31J");
		
		ThreadBean TB=new ThreadBean();
		ContentsBean CB=new ContentsBean();
		
		
		String title=req.getParameter("title");
		String category=req.getParameter("cat");
		String coname=req.getParameter("name");
		String cotext=req.getParameter("text");
		
		if(coname.length()==0){
			coname="名無し";
		}
		
		//バイト数を超えていないかのチェック-----------
		boolean isError = CheckBytes.check(title,coname,cotext);
		if(isError){
			res.sendRedirect("/testbb/thbyteserror.html");
			return;
		}
		//-------------------------------------------
		
			
		TB.setTitle(title);
		TB.setCategory(category);
		CB.setName(coname);
		CB.setText(cotext);
		
		ArrayList<ContentsBean> AL=new ArrayList<>();
		
		AL.add(CB);
		
		int thc = (int)ThWe.execute(TB);
		
		CB.setThreadNo(thc);
		
		cWe.execute(CB);
		
		//スレッド一覧を取得する
		String a="";
		
		ArrayList ArL=new ArrayList();
		
		ArL=(ArrayList)TRE.execute(a);
	
		req.setAttribute("al",ArL);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/threadresult.jsp");
		dispatcher.forward(req,res);
		
		
	}
}
