package bean;

public class ContentBean{
	private Integer post_number;
	private String user_name;
	private String email_address;
	private String message;
	private String delete_key;
	private boolean delete_flag;
	private String image;
	private String date;

	
	public void setPost_number(int post_number){
		this.post_number = post_number;
	}
	public void setEmail_address(String email_address){
		this.email_address = email_address;
	}
	//つくりかけ

		
	//せったー
	//セッタ
		
	public void setPost_number(int post_number){
		this.post_number = post_number;
	}
	public void setUser_name(String user_name){
		this.user_name = user_name;
	}
	public void setEmail_address(String email_address){
		this.email_address = email_address;
	}
	public void setMessage(String message){
		this.message = message;
	}
	
	public void setDelete_key(String delete_key){
		this.delete_key = delete_key;
	}
	public void setDelete_flag(boolean delete_flag){
		this.delete_flag = delete_flag;
	}
	public void setImage(String image){
		this.image = image;
	}
	public void setDate(String date){
		this.date = date;
	}
	
	//げったー
	
	public Integer getPost_number(){
		return post_number;
	}
	public String getUser_name(){
		return user_name;
	}
	public String getEmail_address(){
		return email_address;
	}
	
	public String getMessage(){
		return message;
	}
	public String getDelete_key(){
		return delete_key;
	}
	public boolean getDelete_flag(){
		return delete_flag;
	}
	public String getImage(){
		return image;
	}
	public String getDate(){
		return date;
	}
	

}