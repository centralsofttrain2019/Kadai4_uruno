package bean;

import java.math.BigDecimal;
import java.time.LocalDate;

public class EmployeeBean
{
	private 	int		employeeID	;//	INT	NOT	NULL,
	private 	String	employeeName	;//	VARCHAR(100),
	private 	BigDecimal	height	;//	DECIMAL(10	,	0),
	private 	String	eMail	;//	VARCHAR(100),
	private 	BigDecimal	weight	;//	DECIMAL(10	,	0),
	private 	int		hireFiscalYear	;//	INT,
	private 	LocalDate	birthday	;//	DATE,
	private 	String	bloodType	;//	VARCHAR(2),
	public EmployeeBean() {}
	public int getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public BigDecimal getHeight() {
		return height;
	}
	public void setHeight(BigDecimal height) {
		this.height = height;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	public BigDecimal getWeight() {
		return weight;
	}
	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}
	public int getHireFiscalYear() {
		return hireFiscalYear;
	}
	public void setHireFiscalYear(int hireFiscalYear) {
		this.hireFiscalYear = hireFiscalYear;
	}
	public LocalDate getBirthday() {
		return birthday;
	}
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}
	public String getBloodType() {
		return bloodType;
	}
	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}

	@Override
	public String toString() {
		return "employeeID=" + employeeID + "\n employeeName=" + employeeName
				+ "\n height=" + height
				+ "\n eMail=" + eMail + "\n weight="
				+ weight + "\n hireFiscalYear=" + hireFiscalYear + "\n birthday="
				+ birthday + "\n bloodType=" + bloodType + "\n\n";
	}



}
