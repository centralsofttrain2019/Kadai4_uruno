package web;

import java.io.IOException;
import java.time.LocalDateTime;

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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
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
    public LoginServlet() {
        super();
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
	protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response
            )  throws ServletException, IOException
    {



        //画面から入力したデータを取得する


        String str =request.getParameter("userId");
        byte[] bi = str.getBytes("iso-8859-1");
        String userId = new String( bi, "UTF-8" );
        EmployeeService empse = new EmployeeService();
        int userID = 0;
        int count = empse.employeecount();
        try
        {
        	userID = Integer.parseInt(request.getParameter("userId"));

        }
        catch(NumberFormatException e)
		{
			LoginBean error = new LoginBean();
			error.setMessage(Error.NFE.getValue());

			request.setAttribute("error",error);
			RequestDispatcher disp = request.getRequestDispatcher("/loginError.jsp");
			disp.forward(request, response);
			return;
		}

        if(userID<1||userID>count)
    	{
    		LoginBean error = new LoginBean();
    		error.setCount(empse.employeecount());
			error.setMessage(Error.NOE.getValue());
			request.setAttribute("error",error);
			RequestDispatcher disp = request.getRequestDispatcher("/loginError.jsp");
			disp.forward(request, response);
			return;
    	}


        //bean のインスタンスを生成する
        LoginBean bean = new LoginBean();
        bean.setUserId( userId );

		EmployeeDispKeyBean emp = empse.employeefindkey(userID);
		bean.setEmployeeName(emp.getEmployeeName());
        bean.setLoginDateTime( LocalDateTime.now() );


        //セッションの今回の計算結果を保存
        //request.getSession().setAttribute("loginBean", bean);

        HttpSession ss= request.getSession(true);
        ss.setAttribute("loginBean", bean);
        LoginBean ss1 =(LoginBean)ss.getAttribute("loginBean");
		System.out.println(ss.getId());
        System.out.println(ss1.getLoginInfo());

        //beanをリクエストにセット キー名は「bean」とする
        request.setAttribute("bean", ss1);

        //JSPに遷移する
        RequestDispatcher disp = request.getRequestDispatcher("/login.jsp");
        disp.forward(request, response);
    }
}
