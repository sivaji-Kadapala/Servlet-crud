import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/viewemployee")
public class viewemployee extends HttpServlet{
	Connection con;
	ResultSet rs;
	int row;
	PreparedStatement pst;
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/university","root","#Sivaji68");
		 String sql;
		 sql="select * from employee";
		 Statement stmt=con.createStatement();
		 rs=stmt.executeQuery(sql);
		 out.println("<table cellspacing='0' width='350px' border='1'>");
		 out.println("<tr>");
		 out.println("<td>EmpId</td>");
		 out.println("<td>FirstName</td>");
		 out.println("<td>LastName</td>");
		 out.println("<td>Edit</td>");
		 out.println("<td>Delete</td>");
		 out.println("</tr>");
		 while (rs.next()) {
			 out.println("<tr>");
			 out.println("<td>"+rs.getInt("empid")+"</td>");
			 out.println("<td>"+rs.getString("fname")+"</td>");
			 out.println("<td>"+rs.getString("lname")+"</td>");
			 out.println("<td>"+"<a href='Editreturn?empid="+rs.getString("empid")+"'>Edit</a>"+"</td>");
			 out.println("<td>"+"<a href='Delete?empid="+rs.getString("empid")+"'>Delete</a>"+"</td>");
			 out.println("</tr>");
			
		}
		 out.println("</table>");
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
