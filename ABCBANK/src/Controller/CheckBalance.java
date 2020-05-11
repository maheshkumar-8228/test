package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Model;

public class CheckBalance extends HttpServlet
{
		private HttpSession session;
		private int accno;
		private boolean value;

		protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
		{
			Model m=new Model();
			session=request.getSession();
			m.setAccno((int)session.getAttribute("accno"));
			
			try 
			{
				 value=m.checkBalance();
				
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
			if(value==true)
			{
				session=request.getSession(true);
				session.setAttribute("balance",m.getBalance());
				response.sendRedirect("/ABCBANK/balance.jsp");
			}
			else
			{
				response.sendRedirect("/ABCBANK/loginfail.html");
			}
			
		
		}

}
