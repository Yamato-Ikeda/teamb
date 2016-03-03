package Bean;

class DeleteBean{
	private Integer post_number;
	private String delete_key;

	public void setPost_number(int post_number){
		this.post_number = post_number;
	}
	public void setDelete_key(String delete_key){
		this.delete_key = delete_key;
	}

	public Integer getPost_number(){
		return post_number;
	}
	public String getDelete_key(){
		return delete_key;
	}
}