package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import oracle.jdbc.OracleDriver;

public class Model
{
	String name;
	int accno;
	int balance;
	//int amount;
	//int rvcno;
	String email;
	String userid;
	String password;
	String npwd;
	String cpwd;
	String url="jdbc:Oracle:thin:@//localhost:1521/XE";
	String user="system";
	String pwd="system";
	public Connection con;
	public PreparedStatement pstmt;
	ResultSet res;
	private int row;
	
	public String getNpwd()
	{
		return npwd;
	}
	public void setNpwd(String npwd)
	{
		this.npwd = npwd;
	}
	public String getCpwd()
	{
		return cpwd;
	}
	public void setCpwd(String cpwd)
	{
		this.cpwd = cpwd;
	}
	public String getName() 
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public int getAccno()
	{
		return accno;
	}
	public void setAccno(int accno)
	{
		this.accno = accno;
	}
	public int getBalance() 
	{
		return balance;
	}
	public void setBalance(int balance)
	{
		this.balance = balance;
	}
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	public String getUserid()
	{
		return userid;
	}
	public void setUserid(String userid)
	{
		this.userid = userid;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public Model()
	{
		try
		{
			DriverManager.registerDriver(new OracleDriver());
			con=DriverManager.getConnection(url, user, pwd);
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	
    }
	public boolean login() throws Exception
	{
		String sql="select accno from bank where userid=? and password=?";
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1,userid);
		pstmt.setString(2, password);
		res=pstmt.executeQuery();
		if (res.next()==true)
		{
			accno=res.getInt("ACCNO");
			return true;
		}
		else
		{
			return false;
		}
		
	}
	public boolean checkBalance() throws Exception
	{
		String sql="SELECT BALANCE FROM BANK WHERE ACCNO=?";
		pstmt=con.prepareStatement(sql);
		pstmt.setInt(1,accno);
		res=pstmt.executeQuery();
		if(res.next()==true)
		{
			balance=res.getInt("BALANCE");
			return true;
		}
		else
		{
			return false;
		}
		
	}
	public boolean changPassword(String npwd) throws Exception
	{
		String sql="update bank set password=? where password=? and accno=?";
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1,npwd);
		pstmt.setString(2,password);
		pstmt.setInt(3,accno);
		row=pstmt.executeUpdate();
		if(row==0)
		{
			return false;
		}
		else
		{
			return true;
		}
		
		
	}
	public boolean transfer1() throws Exception
	{
		String sql="update bank set balance=balance-? where accno=?";
		pstmt=con.prepareStatement(sql);
		pstmt.setInt(1,balance);
		pstmt.setInt(2,accno);
		row=pstmt.executeUpdate();
		if(row==0)
		{
			return false;
		}
		else
		{
			statement1();
			return true;
		}
		
		
	}
	private void statement1() throws Exception
	{
		String sql="insert into statement(accno,debit) values(?,?)";
		pstmt=con.prepareStatement(sql);
		pstmt.setInt(1,accno);
		pstmt.setInt(2,balance);
		row=pstmt.executeUpdate();
		
	}
	
	public boolean transfer2() throws Exception
	{
		String sql="update bank set balance=balance+? where accno=?";
		pstmt=con.prepareStatement(sql);
		pstmt.setInt(1,balance);
		pstmt.setInt(2,accno);
		row=pstmt.executeUpdate();
		if(row==0)
		{
			return false;
		}
		else
		{
			statement2();
			return true;
		}
		
		
	}
	private void statement2() throws Exception
	{
		
		String sql="insert into statement(accno,credit) values(?,?)";
		pstmt=con.prepareStatement(sql);
		pstmt.setInt(1,accno);
		pstmt.setInt(2,balance);
		row=pstmt.executeUpdate();
		
	}
	public ArrayList getCredit() throws Exception
	{
		String sql="select credit from statement where accno=?";
		pstmt=con.prepareStatement(sql);
		pstmt.setInt(1,accno);
		res=pstmt.executeQuery();
		ArrayList al1=new ArrayList();
		while(res.next()) 
		{
			al1.add(res.getInt("credit"));
		}
		return al1;
		
		
	}
	public ArrayList getDebit() throws Exception
	{
		String sql="select debit from statement where accno=?";
		pstmt=con.prepareStatement(sql);
		pstmt.setInt(1,accno);
		res=pstmt.executeQuery();
		ArrayList al2=new ArrayList();
		while(res.next())
		{
			al2.add(res.getInt("debit"));
		}
		return al2;
		
		
	}
	
	
}
