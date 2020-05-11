package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Model;

public class ChangePassword extends HttpServlet
{

	private HttpSession session;
	private boolean value;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		Model m=new Model();
		session=request.getSession();
		m.setAccno((int)session.getAttribute("accno"));
		m.setPassword(request.getParameter("opwd"));
		String npwd;
		try
		{
			value=m.changPassword(request.getParameter("npwd"));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		if(value==true)
		{
			session.invalidate();
			response.sendRedirect("/ABCBANK/resultSuccess.html");
		}
		else
		{
			response.sendRedirect("/ABCBANK/resultFail.html");
		}
		
	}

}
