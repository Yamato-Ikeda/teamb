import executer.*;
import bean.*;
import check.*;

import java.util.ArrayList;

import java.io.IOException;
import java.io.File;
import java.awt.image.BufferedImage;
import java.awt.RenderingHints;
import java.awt.Graphics2D;
import javax.imageio.ImageIO;
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
		String image = "";
		Part part = req.getPart("image");
		
		try{
			String contentDisposition = part.getHeader("content-disposition");
			String contentType = part.getHeader("content-type");
			
			long size = part.getSize();
			System.out.println("画像サイズ："+size);
			
			/* アップロードしたファイル名の取得 */
			// 変数contentDispositionから"filename="以降を抜き出す
			int filenamePosition = contentDisposition.indexOf("filename=");
			String filename = contentDisposition.substring(filenamePosition);
			// "filename="と"を除く
			filename = filename.replace("filename=", "");
			filename = filename.replace("\"", "");
			// 絶対パスからファイル名のみ取り出す
			filename = new File(filename).getName();
			
			//boolean isJpegFile = false;
			// JPEG形式のチェック
			if ((contentType.equals("image/jpeg"))
				|| (contentType.equals("image/pjpeg"))) {
				// 画像ファイルをpath+filenameとして保存
					part.write("c:\\teamb\\images/" + filename);
					//isJpegFile = true;
					
					image = filename;
					
					createThumbnail("c:\\teamb\\images/"+ filename,"c:\\teamb\\images\\small/" + filename, 120);
					
			}else{
				System.out.println("jpegではないので保存不可");
			}
			
		}catch(NullPointerException e){
			System.out.println("画像なし");
		}
		
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
	private void createThumbnail(String originFile, String thumbFile, int width) {
		try {
			// 元画像の読み込み
			BufferedImage image = ImageIO.read(new File(originFile));
			// 元画像の情報を取得
			int originWidth = image.getWidth();
			int originHeight = image.getHeight();
			int type = image.getType();
			// 縮小画像の高さを計算
			int height = originHeight * width / originWidth;
			
			//縮小画像の作成
			BufferedImage smallImage = new BufferedImage(width, height, type);
			Graphics2D g2 = smallImage.createGraphics();
			
			// 描画アルゴリズムの設定(品質優先、アンチエイリアスON)
			g2.setRenderingHint(RenderingHints.KEY_RENDERING,  RenderingHints.VALUE_RENDER_DEFAULT);
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,  RenderingHints.VALUE_ANTIALIAS_ON);

			// 元画像の縮小&保存
			g2.drawImage(image, 0, 0, width, height, null);
			ImageIO.write(smallImage, "jpeg", new File(thumbFile));
		} catch (Exception e) {
			log("画像の縮小に失敗: " + e);
		}
	}
}
