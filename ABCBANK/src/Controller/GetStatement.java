package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Model;


public class GetStatement extends HttpServlet 
{
	
	private HttpSession session;
	public ArrayList al1;
	public ArrayList al2;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		Model m=new Model();
		session=request.getSession();
		m.setAccno((int) session.getAttribute("accno"));
		try
		{
			al1=m.getCredit();
			al2=m.getDebit();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		if((al1.isEmpty())&&(al2.isEmpty()))
		{
			response.sendRedirect("/ABCBANK/statementfail.html");
		}
		else
		{
			session.setAttribute("al1",al1);
			session.setAttribute("al2",al2);
			response.sendRedirect("/ABCBANK/getresult.jsp");
		}
	}

}
