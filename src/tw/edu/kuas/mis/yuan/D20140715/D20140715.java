package tw.edu.kuas.mis.yuan.D20140715;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
/**
 * Servlet implementation class D20140715
 */
@WebServlet("/D20140715")
public class D20140715 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public D20140715() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		System.out.println("DOGET");
		java.io.PrintWriter out = response.getWriter();
		int year=Integer.parseInt(request.getParameter("year"));
		int month=Integer.parseInt(request.getParameter("month"));
		String name=(request.getParameter("name"));
		int date=1;
		Calendar cal = Calendar.getInstance();//設定年月日
		cal.set(year,month-1,date);
		
		
		
		String n=String.format("姓名：%s<br/>%d年%d月",name,cal.get(Calendar.YEAR),cal.get(Calendar.MONTH)+1);
		out.print(n);
		
		//out.print("姓名：");
		//out.print(name);
		//out.print("<br/>");
		//out.print(cal.get(Calendar.YEAR));
		//out.print("年");
		//out.print(cal.get(Calendar.MONTH)+1);
		//out.print("月");
		int Dom =cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		//out.print(cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		//out.print("日");
		int Dow = cal.get(Calendar.DAY_OF_WEEK)-1;//判斷為星期幾


		//out.print(cal.get(Calendar.DAY_OF_WEEK)-1+"<br/>"); 一星期的第幾天
		out.print("<table border=1>");
		//out.print(Dom+Dow+"<br>"); 日期表格判斷
		int mond;
		if((Dom+Dow)<=28)
		{mond=4;}
		else if((Dom+Dow)>=36)
		{mond=6;}
		else
		{mond=5;}
		int dd=1;int m=1;// dd=天數  m
		for(int i=0;i<=mond;i++){
			out.print("<tr>");
			for(int j=0;j<7;j++)
			{
				out.print("<td>");
				if(i==0){
					switch(j)
					{
					case 0:
					out.print("日");
					break;
					case 1:
					out.print("一");
					break;
					case 2:
					out.print("二");
					break;
					case 3:
					out.print("三");
					break;
					case 4:
					out.print("四");
					break;
					case 5:
					out.print("五");
					break;
					case 6:
					out.print("六");
					break;
					}	//switch case end
									}//for circle end
			if(i>0 && dd<=cal.getActualMaximum(Calendar.DAY_OF_MONTH)  && m>cal.get(Calendar.DAY_OF_WEEK)+6){
			if(i>0){	
			out.print(dd);
			dd++;
			}
			}
									m++;
				out.print("</td>");
				
			}
		out.print("</tr>");
		}
		out.print("</table>");
	}//GET尾

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		System.out.println("DOPOST");
		java.io.PrintWriter out = response.getWriter();
		out.println("HELLO POST");
		out.print("查詢成功");
	}

}
