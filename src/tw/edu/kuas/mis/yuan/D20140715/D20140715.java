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
		Calendar cal = Calendar.getInstance();//�]�w�~���
		cal.set(year,month-1,date);
		
		
		
		String n=String.format("�m�W�G%s<br/>%d�~%d��",name,cal.get(Calendar.YEAR),cal.get(Calendar.MONTH)+1);
		out.print(n);
		
		//out.print("�m�W�G");
		//out.print(name);
		//out.print("<br/>");
		//out.print(cal.get(Calendar.YEAR));
		//out.print("�~");
		//out.print(cal.get(Calendar.MONTH)+1);
		//out.print("��");
		int Dom =cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		//out.print(cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		//out.print("��");
		int Dow = cal.get(Calendar.DAY_OF_WEEK)-1;//�P�_���P���X


		//out.print(cal.get(Calendar.DAY_OF_WEEK)-1+"<br/>"); �@�P�����ĴX��
		out.print("<table border=1>");
		//out.print(Dom+Dow+"<br>"); ������P�_
		int mond;
		if((Dom+Dow)<=28)
		{mond=4;}
		else if((Dom+Dow)>=36)
		{mond=6;}
		else
		{mond=5;}
		int dd=1;int m=1;// dd=�Ѽ�  m
		for(int i=0;i<=mond;i++){
			out.print("<tr>");
			for(int j=0;j<7;j++)
			{
				out.print("<td>");
				if(i==0){
					switch(j)
					{
					case 0:
					out.print("��");
					break;
					case 1:
					out.print("�@");
					break;
					case 2:
					out.print("�G");
					break;
					case 3:
					out.print("�T");
					break;
					case 4:
					out.print("�|");
					break;
					case 5:
					out.print("��");
					break;
					case 6:
					out.print("��");
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
	}//GET��

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		System.out.println("DOPOST");
		java.io.PrintWriter out = response.getWriter();
		out.println("HELLO POST");
		out.print("�d�ߦ��\");
	}

}
