package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Model;

public class Transfer extends HttpServlet
{
	
	private HttpSession session;
	private boolean value;
	private boolean result;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		Model m=new Model();
		session=request.getSession();
		m.setAccno((int)session.getAttribute("accno"));
		String amount2=request.getParameter("amount");
		int amount=Integer.parseInt(amount2);
		m.setBalance(amount);
		String rvcno2=request.getParameter("rvcno");
		int rvcno=Integer.parseInt(rvcno2);
		try
		{
			value=m.transfer1();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		if(value==true)
		{
			try
			{
				m.setAccno(rvcno);
				result=m.transfer2();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			if(result==true)
			{
				response.sendRedirect("/ABCBANK/transferSuccess.html");
			}
			else
			{
				response.sendRedirect("/ABCBANK/transferfail.html");

			}
			
		}
		else
		{
			response.sendRedirect("/ABCBANK/transferfail.html");

		}
	
	}

}
