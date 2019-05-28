package web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.EmployeeBean;
import bean.EmployeeDispAllBean;
import bean.LoginBean;
import service.EmployeeService;

/**
 * Servlet implementation class SearchSrvlet
 */
@WebServlet("/AllServlet")
public class EmployeesDispAllServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeesDispAllServlet()
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
		List<EmployeeBean> empList = new ArrayList<EmployeeBean>();
		empList = empse.employeefindall();
		EmployeeDispAllBean bean = new EmployeeDispAllBean();
		bean.seteList(empList);

		LoginBean loginBean = (LoginBean)request.getSession().getAttribute("loginBean");
		bean.setLoginBean(loginBean);

		request.setAttribute("bean", bean);
		RequestDispatcher disp = request.getRequestDispatcher("/employeesDispAll.jsp");
		disp.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}

}

