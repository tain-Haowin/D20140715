package tw.edu.kuas.mis.yuan.D20140715;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class D20140716index
 */
@WebServlet("/D20140716index")
public class D20140716index extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public D20140716index() {
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
		
		out.print("<form action=D20140715 method=GET>");
		out.print("姓名：");
		out.print("<input type=text name=name><br/>");
		out.print("年：");
		out.print("<input type=text name=year><br/>");
		out.print("月：");
		out.print("<input type=text name=month><br/>");
		out.print("<input type=submit value=查詢>&nbsp");
		out.print("<input type=reset value=清除>");
		out.print("</form>");
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
