package TaskManager.model;

public class User {

	private String login;
	private String password;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEqual(String login, String password) {
		if(!this.login.equals(login)) {
			return false;
		}
		
		if(!this.password.equals(password)) {
			return false;
		}
		
		return true;
	}
}

