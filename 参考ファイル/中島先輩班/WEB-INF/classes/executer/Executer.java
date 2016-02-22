package executer;

import java.util.ArrayList;
import bean.Bean;
import dba.Accessor;

import java.sql.ResultSet;

public abstract class Executer{
	Accessor accessor = new Accessor();
	
	public abstract Object execute(Object object);
}