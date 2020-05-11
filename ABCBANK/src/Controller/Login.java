package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Model;

public class Login extends HttpServlet
{
	
	private HttpSession session;
	boolean value;

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Model m=new Model();
		m.setUserid(request.getParameter("userid"));
		m.setPassword(request.getParameter("password"));
		try 
		{
			 value=m.login();
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		if(value==true)
		{
			session=request.getSession(true);
			session.setAttribute("accno",m.getAccno());
			response.sendRedirect("/ABCBANK/home.html");
		}
		else
		{
			response.sendRedirect("/ABCBANK/loginfail.html");
		}
		
	}

}
