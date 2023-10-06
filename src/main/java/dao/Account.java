package dao;

public class Account {
	private Long idAccount;
	private String name;
	
	private String username;
	private String email;
	private String password;
	private String last_connect;
	
	public void setlast_connect(String last_connect) {
		this.last_connect = last_connect;
	}
	public String getlast_connect() {
		return last_connect;
	}
	public Account() {
		
	}
	public Long getIdAccount() {
		return idAccount;
	}
	public void setIdAccount(Long idAccount) {
		this.idAccount = idAccount;

	}
	
	public Account(String username,String password) {
		this.username = username;
		this.password = password;

	}
	public Account(String name, String username, String email, String password) {
		super();
		this.name = name;
		this.username = username;
		this.email = email;
		this.password = password;
		
        
	}
	//Getters and setters :
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	} 

	
}
