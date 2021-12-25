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
@WebServlet("/Editreturn")
public class Editreturn extends HttpServlet{
	Connection con;
	ResultSet rs;
	int row;
	PreparedStatement pst;
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String eid=request.getParameter("empid");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/university","root","#Sivaji68");
		    pst=con.prepareStatement("select * from employee where empid=?");
		    pst.setString(1, eid);
		    rs=pst.executeQuery();
		    while (rs.next()) {
				out.println("<form action='EditServlet' method='POST'");
				out.println("<table");
				out.println("<tr><td>EmpId</td><td><input type='text' name='empid' id='empid' value='"+rs.getString("empid")+"'/></td></tr>");
				out.println("<tr><td>FirstName</td><td><input type='text' name='fname' id='fname' value='"+rs.getString("fname")+"'/></td></tr>");
				out.println("<tr><td>LastName</td><td><input type='text' name='lname' id='lname' value='"+rs.getString("lname")+"'/></td></tr>");
				out.println("<tr><td colspan='2'><input type='submit'  value='Edit'/></td></tr>");
				out.println("</table");
				out.println("</form");
				
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
