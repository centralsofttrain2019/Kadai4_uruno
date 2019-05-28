package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import bean.EmployeeBean;
import bean.EmployeeDispKeyBean;

public class EmployeesDao
{
	private static final String DELETE_SQL =
			"DELETE "
			+ "FROM employees " +
			"WHERE "
			+ "EmployeeID = ?";

	private static final String FIND_KEY_SQL =
			"SELECT "
			+"* " +
			"FROM "
			+ "Employees "+
			"WHERE "
			+"EmployeeID = ?";

	private static final String FIND_ALL_SQL =
			"SELECT "
			+"* " +
			"FROM "
			+ "Employees ";

	private static final String COUNT_SQL =
			"SELECT "
			+"COUNT(*) " +
			"FROM "
			+ "Employees ";

	private Connection con = null;

	public EmployeesDao(Connection con)
	{
		super();
		this.con = con;
	}

	public void deleteEmployee( int id ) throws SQLException
	{
		//---------------------------------------
		// 処理を記述するところ

		// 送信すべきSQLの雛形を作成
		PreparedStatement stmt = con.prepareStatement( DELETE_SQL );
		stmt.setInt( 1, id );

		int r = stmt.executeUpdate();

		if( r!=1 )
			throw new RuntimeException("削除に失敗しました。");
	}

	//-------------------------------
	public EmployeeDispKeyBean findByKey(int id) throws SQLException
	{
		PreparedStatement pstmt = con.prepareStatement( FIND_KEY_SQL );
		EmployeeDispKeyBean ret = new EmployeeDispKeyBean();
		pstmt.setInt(1, id);
		ResultSet rs =pstmt.executeQuery();
		while(rs.next())
		{
			ret.setEmployeeID(rs.getInt("EmployeeID"));
			ret.setEmployeeName(rs.getString("EmployeeName"));
			ret.setHeight(rs.getBigDecimal("Height"));
			ret.seteMail(rs.getString("EMail"));
			ret.setWeight(rs.getBigDecimal("Weight"));
			ret.setHireFiscalYear(rs.getInt("HireFiscalYear"));
			ret.setBirthday(convertToLocalDate(rs.getDate("Birthday")));
			ret.setBloodType(rs.getString("BloodType"));
		}
		return ret;


	}

	public LocalDate convertToLocalDate(java.sql.Date sqlDate){
	    return sqlDate.toLocalDate();
	}

	public List<EmployeeBean> findAll() throws SQLException
	{
		List<EmployeeBean> eList = new ArrayList<EmployeeBean>();
		PreparedStatement pstmt = con.prepareStatement( FIND_ALL_SQL );
		ResultSet rs =pstmt.executeQuery();
		while(rs.next())
		{
			EmployeeBean emp = new EmployeeBean();
			emp.setEmployeeID(rs.getInt("EmployeeID"));
			emp.setEmployeeName(rs.getString("EmployeeName"));
			emp.setHeight(rs.getBigDecimal("Height"));
			emp.seteMail(rs.getString("EMail"));
			emp.setWeight(rs.getBigDecimal("Weight"));
			emp.setHireFiscalYear(rs.getInt("HireFiscalYear"));
			emp.setBirthday(convertToLocalDate(rs.getDate("Birthday")));
			emp.setBloodType(rs.getString("BloodType"));
			eList.add(emp);
		}

		return eList;
	}

	public int countRecords() throws SQLException
	{
		PreparedStatement pstmt = con.prepareStatement( COUNT_SQL );
		ResultSet rs =pstmt.executeQuery();
		int i = 0;
		while(rs.next())
		{
			i = rs.getInt(1);
		}

		return i;
	}

}
