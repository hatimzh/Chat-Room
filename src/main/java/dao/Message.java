package dao;

public class Message {
	private long idMessage;
	private String username;
	private String content;
	private String timetamp;
	private long idAccount;
	public Message(String username, String content,long idAccount) {
		super();
		this.idMessage = idMessage;
		this.username = username;
		this.content = content;
		this.idAccount=idAccount;
	}
	
	public Message() {
		super();
	}
	
	public long getIdAccount() {
		return idAccount;
	}

	public void setIdAccount(long idAccount) {
		this.idAccount = idAccount;
	}
	
	public String getTimetamp() {
		return timetamp;
	}

	public void setTimetamp(String timetamp) {
		this.timetamp = timetamp;
	}

	public long getIdMessage() {
		return idMessage;
	}
	public void setIdMessage(long idMessage) {
		this.idMessage = idMessage;
	}
	public String getusername() {
		return username;
	}
	public void setusername(String username) {
		this.username = username;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
}
