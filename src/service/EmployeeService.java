package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.EmployeeBean;
import bean.EmployeeDispKeyBean;
import dao.Dao;
import dao.EmployeesDao;

public class EmployeeService
{
	public	List<EmployeeBean> employeefindall()
	{
		List<EmployeeBean> empList = new ArrayList<EmployeeBean>();
		try(Connection con = Dao.getConnection())
		{
			EmployeesDao dao = new EmployeesDao(con);
			empList = dao.findAll();

			return empList;
		}
		catch( SQLException | ClassNotFoundException e )
		{
			e.printStackTrace();

		}
		return null;

	}

	public EmployeeDispKeyBean employeefindkey(int userID) {
		try(Connection con = Dao.getConnection())
		{
			EmployeeDispKeyBean emp = new EmployeeDispKeyBean();
			EmployeesDao dao = new EmployeesDao(con);
			emp = dao.findByKey(userID);

			return emp;
		}
		catch( SQLException | ClassNotFoundException e )
		{
			e.printStackTrace();

		}
		return null;
	}

	public	int employeecount()
	{
		try(Connection con = Dao.getConnection())
		{
			EmployeesDao dao = new EmployeesDao(con);
			int count = dao.countRecords();

			return count;
		}
		catch( SQLException | ClassNotFoundException e )
		{
			e.printStackTrace();

		}
		return 0;

	}


}
