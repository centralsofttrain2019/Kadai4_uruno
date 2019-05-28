package bean;

import java.io.Serializable;

public class Bean implements Serializable
{
	private String message;
	private LoginBean loginBean;

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}


	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

	public String getLoginInfo()
	{
		return loginBean.getLoginInfo();
	}

}
