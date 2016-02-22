package bean;

import java.util.ArrayList;
	
public class ThreadBean implements Bean{
	
	private int threadNo;
	private String title;
	private String category;
	private int contentsCount;
	
	private ArrayList<ContentsBean> contentsList = new ArrayList<ContentsBean>();
	private ArrayList<ThreadBean> threadList = new ArrayList<ThreadBean>();


//-----------------<セッター>---------------------------------

	//スレッドNO
	public void setThreadNo(int threadNo){
		this.threadNo = threadNo;
	}
	//スレッドタイトル
	public void setTitle(String title){
		this.title = title;
	}
	//カテゴリ
	public void setCategory(String category){
		this.category = category;
	}
	//投稿数
	public void setCount(int contentsCount){
		this.contentsCount = contentsCount;
	}
	//スレッドの全件データをArrayListにセット
	public void setContentsList(ContentsBean list){
		contentsList.add(list);
	}
	//スレッド一覧をArrayListにセット
	public void setThreadList(ThreadBean list){
		threadList.add(list);
	}
//-----------------------------------------------------------

//-----------------<ゲッター>---------------------------------

	//スレッドNO
	public int getThreadNo(){
		return threadNo;
	}
	//スレッドタイトル
	public String getTitle(){
		return title;
	}
	//カテゴリ
	public String getCategory(){
		return category;
	}
	//投稿数
	public int getContentsCount(){
		return contentsCount;
	}
	//スレッドの全件データを返す
	public ArrayList getContentsList(){
		return contentsList;
	}
	//スレッド一覧を返す
	public ArrayList getThreadList(){
		return threadList;
	}
	
//-----------------------------------------------------------
}

