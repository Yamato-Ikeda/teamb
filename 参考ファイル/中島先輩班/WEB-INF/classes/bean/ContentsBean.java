package bean;

public class ContentsBean implements Bean{
	
	private int threadNo;
	private int contentNo;
	private String name;
	private String date;
	private String text;
	
	
//---------<セッター>-----------------------------------
	
	//スレッドNO
	public void setThreadNo(int threadNo){
		this.threadNo = threadNo;
	}
	//コンテンツNO
	public void setContentNo(int contentNo){
		this.contentNo = contentNo;	
	}
	//投稿者名
	public void setName(String name){
		this.name = name;
	}
	//投稿日時
	public void setDate(String date){
		this.date = date;
	}
	//投稿内容
	public void setText(String text){
		this.text = text;
	}

//----------------------------------------------------


//----------<ゲッター>----------------------------------

	//スレッドNO
	public int getThreadNo(){
		return threadNo;
	}
	//コンテンツNO
	public int getContentNo(){
		return contentNo;
	}
	//投稿者名
	public String getName(){
		return name;
	}
	//投稿日時
	public String getDate(){
		return date;
	}
	//投稿内容
	public String getText(){
		return text;
	}

//----------------------------------------------------

}