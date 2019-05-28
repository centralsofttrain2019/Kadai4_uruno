package bean;

import java.io.Serializable;
import java.time.LocalDateTime;

public class LoginBean implements Serializable
{
	private static final long serialVersionUID = 1L;

	private 	String	employeeName	;//	VARCHAR(100),
	private String userId;
	private LocalDateTime loginDateTime;
	private int errorCode;
	private int count;
	private String message;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}


	public int getErrorCode() {
		return errorCode;
	}


	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}


	public String getLoginInfo()
	{
		return "userName:" + this.getEmployeeName()
				+ " login at:" + this.getLoginDateTime().toString();
	}


	public String getEmployeeName() {
		return employeeName;
	}


	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}


	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public LocalDateTime getLoginDateTime() {
		return loginDateTime;
	}
	public void setLoginDateTime(LocalDateTime loginDateTime) {
		this.loginDateTime = loginDateTime;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


}
