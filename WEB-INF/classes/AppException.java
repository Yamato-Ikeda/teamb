package ex;

public class AppException extends ServletException{
	public AppException(String mess,Throwable e){
		super(mess,e);
	}
}