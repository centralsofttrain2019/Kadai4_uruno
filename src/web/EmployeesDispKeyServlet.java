package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.EmployeeDispKeyBean;
import bean.LoginBean;
import service.EmployeeService;

/**
 * Servlet implementation class SearchSrvlet
 */
@WebServlet("/KeyServlet")
public class EmployeesDispKeyServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	//ENUM
	public enum Error{
		NFE("ユーザーIDは半角数字で入力してください。"),
		NOE("IDが存在しません。");

		private String message;

		//コンストラクタの定義
		private Error(String message)
		{
			this.message = message;
		}

		//メソッド
		public String getValue()
		{
			return this.message;
		}

	}

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeesDispKeyServlet()
    {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		EmployeeService empse = new EmployeeService();
		int userID = 0;
		int count = empse.employeecount();
		try
		{
			userID = Integer.parseInt(request.getParameter("userid"));

		}
		catch(NumberFormatException e)
		{
			HttpSession ss  = request.getSession(true);
			LoginBean ss1 =(LoginBean)ss.getAttribute("loginBean");
			EmployeeDispKeyBean error = new EmployeeDispKeyBean();
			error.setMessage(Error.NFE.getValue());
			error.setLoginBean(ss1);
			request.setAttribute("bean",error);
			RequestDispatcher disp = request.getRequestDispatcher("/employeeDispKeyError.jsp");
			disp.forward(request, response);
			return;
		}
		if(userID<1||userID>count)
    	{
			HttpSession ss  = request.getSession(true);
			LoginBean ss1 =(LoginBean)ss.getAttribute("loginBean");
			EmployeeDispKeyBean error = new EmployeeDispKeyBean();
			error.setCount(empse.employeecount());
			error.setMessage(Error.NOE.getValue());
			error.setLoginBean(ss1);
			request.setAttribute("bean",error);
			RequestDispatcher disp = request.getRequestDispatcher("/employeeDispKeyError.jsp");
			disp.forward(request, response);
			return;
    	}
		EmployeeDispKeyBean emp = empse.employeefindkey(userID);

		HttpSession ss  = request.getSession(true);
		LoginBean ss1 =(LoginBean)ss.getAttribute("loginBean");
		System.out.println(ss.getId());
		System.out.println(ss1.getLoginInfo());

		emp.setLoginBean(ss1);

		//System.out.println(emp.getLoginInfo());

		request.setAttribute("bean",emp);
		RequestDispatcher disp = request.getRequestDispatcher("/employeesDispKey.jsp");
		disp.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}

}

