package bean;

import java.util.List;

public class EmployeeDispAllBean extends  Bean
{
	private List<EmployeeBean> eList;
	public EmployeeDispAllBean() {}
	public List<EmployeeBean> geteList() {
		return eList;
	}
	public void seteList(List<EmployeeBean> eList) {
		this.eList = eList;
	}

}
