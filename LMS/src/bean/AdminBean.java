package bean;

public class AdminBean {
	private String user;
	private String password;
	private String user_name;
	public AdminBean(String user, String password, String user_name) {
		super();
		this.user = user;
		this.password = password;
		this.user_name = user_name;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	
	public AdminBean() {
		// TODO Auto-generated constructor stub
	}
}
