package projectContant;

import java.util.ArrayList;
import java.util.List;

public class DataBase {
	
	private List <Forum> forums;
	private List <User> users;
	
	public DataBase ()
	{
		forums = new ArrayList<Forum>();
		forums.add(new Forum("dogs"));
		forums.add(new Forum("food"));
		forums.add(new Forum("fish"));
		forums.add(new Forum("candy"));
		forums.add(new Forum("liquer"));
		
		users = new ArrayList<User>();
		users.add(new User("Haim", "1234"));
		users.add(new User("Moti", "1234"));
		users.add(new User("Dani", "1234"));
		users.add(new User("Levi", "1234"));
	}
	public boolean isUser(String user, String pass)
	{
		for (User u : users)
			if (u.password.equals(pass) && u.username.equals(user))
				return true;
		return false;
	}
	
	public List <Forum> getForums()
	{
		return this.forums;
	}
	public List <User> getUsers()
	{
		return this.users;
	}

}
