import executer.*;
import bean.*;
import check.*;

import java.util.ArrayList;

import java.io.IOException;
import java.io.File;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

public class WriteServlet extends HttpServlet{
	ReadExecuter RE=new ReadExecuter();
	WriteExecuter We=new WriteExecuter();
	
	public void doPost(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{		
		req.setCharacterEncoding("Windows-31J");
		System.out.println("投稿");
		ContentBean CB=new ContentBean();
		

		String user_name = req.getParameter("user_name");
		String email_address = req.getParameter("email_address");
		String message = req.getParameter("message");
		String delete_key = req.getParameter("delete_key");
		Part part = req.getPart("image");
		
		String contentDisposition = part.getHeader("content-disposition");
		String contentType = part.getHeader("content-type");
		
		long size = 0;
		
		try{
			size = part.getSize();
			// uploadフォルダの絶対パスを調べる
		String path = getServletContext().getRealPath("upload");

		/* アップロードしたファイル名の取得 */
		// 変数contentDispositionから"filename="以降を抜き出す
		int filenamePosition = contentDisposition.indexOf("filename=");
		String filename = contentDisposition.substring(filenamePosition);
		// "filename="と"を除く
		filename = filename.replace("filename=", "");
		filename = filename.replace("\"", "");
		// 絶対パスからファイル名のみ取り出す
		filename = new File(filename).getName();

		boolean isJpegFile = false;
		// JPEG形式のチェック
		if ((contentType.equals("image/jpeg"))
				|| (contentType.equals("image/pjpeg"))) {
			// 画像ファイルをpath+filenameとして保存
			part.write(path + "/" + filename);
			isJpegFile = true;
			
			// サムネール画像の作成
			createThumbnail(path + "/" + filename, path + "/small/" + filename, 120);
		}

		}catch(NullPointerException e){System.out.println("画像なし");}
		System.out.println(size+"byte");

		if(user_name.length()==0){
			user_name="名無し";
		}
		if(delete_key.length()==0){
			delete_key=" ";
		}
		System.out.println(user_name+"さんの投稿");
		//バイト数を超えていないかのチェック-----------
		/*boolean isError = CheckBytes.check(name,text);
		if(isError){
			res.sendRedirect("/testbb/conbyteserror.html");
			return;
		}
		//-------------------------------------------
		*/
		
		CB.setUser_name(user_name);
		CB.setEmail_address(email_address);
		CB.setMessage(message);
		CB.setDelete_key(delete_key);
		CB.setImage(image);
		
		CheckReplace cr = new CheckReplace();
		CB = cr.check(CB);
		
		We.execute(CB);
		
		int postNo = -1;
		ArrayList al = (ArrayList) RE.execute(postNo);
		
		req.setAttribute("al",al);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/practice.jsp");
		dispatcher.forward(req,res);
		
		//書き込んだスレッドを表示----------------------------------------------------
		/*ReadExecuter RE=new ReadExecuter();
		ThreadBean tb = (ThreadBean) RE.execute(threadNo);
		
		req.setAttribute("tb",tb);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/contents.jsp");
		dispatcher.forward(req,res);*/
		//-----------------------------------------------------------------------------
		
	}
}
