package tw.edu.kuas.mis.yuan.D20140715;
import java.text.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class play
 */
@WebServlet("/play")
public class play extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public play() {
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
		Calendar.getInstance();
		String a = "%s is more important than %s.";
        String b = "He who has hope has everything.";
        String c = "台上 %d 分鐘，台下 %d 年功。";
         
        out.println(String.format(a, "Imagination", "knowledge"));
        out.println(String.format(b, "everything"));
        out.println(String.format(c, 1, 10));
        
        String h = "%f 是 %s";
        out.print(String.format(h,3.1415926,"pi"));
        
        out.print(String.format( "%s is more important than %s.",1,10)+"<br/>");
        //out.print(String.format("[0:0]",1)+"<br/>");
    
        
        //String formatStr = "%03d";
        String formatAns = String.format("%010.2f", 12.3);
        out.println("數字補零:"+formatAns+"<br/>");
        String formatAns2 = String.format("%,09f", 19.2,"<br/>");
        out.println(formatAns2);
        //String formatAns3 = String.format("%c", "kk");
        //out.println(formatAns3);
        
        
        //out.print(String.format("%s5","kuas"));
        
	}
	
	


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
