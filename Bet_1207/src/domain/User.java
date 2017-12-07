package domain;


public class User {
	
	private String userId;
	private String password;
	private String name;
	private int point;
	
	public User() {}


	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}


	@Override
	public String toString() {
		return "User [userId=" + userId + ", password=" + password + ", name=" + name + ", point=" + point + "]";
	}
	
	

}
