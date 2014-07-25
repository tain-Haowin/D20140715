package tw.edu.kuas.mis.yuan.D20140715;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out=response.getWriter();
		out.print("<form action=Logincheck method=GET>");
		out.print("±b¸¹¡G<input type=text name=account><br/>");
		out.print("±K½X¡G<input type=text name=password><br/>");
		out.print("<input type=submit value=°e¥X>");
		out.print("</form>");
		String account = request.getParameter("yuan").toString();
        String password = request.getParameter("1234").toString();
		request.getSession().setAttribute("account","password");
		//response.sendRedirect("D20140716index");
		if("account".equals("yuan") && "password".equals("1234"))
		{
			request.getSession().setAttribute("login","true");
			
			//response.sendRedirect("D20140716index");
		}
		else
		{
		out.print("error");	
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
