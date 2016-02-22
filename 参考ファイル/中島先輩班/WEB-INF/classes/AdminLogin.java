public class AdminLogin{
	public boolean login(String id,String pass){
		if(id.equals(Admin.ID)&&pass.equals(Admin.PW)){
			return true;
		}else{
			return false;
		}
	}
}