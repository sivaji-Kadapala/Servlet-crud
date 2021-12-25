import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/Delete")
public class Delete extends HttpServlet{
	Connection con;
	ResultSet rs;
	int row;
	PreparedStatement pst;
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String empid=request.getParameter("empid");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/university","root","#Sivaji68");
		   
		   
		    pst=con.prepareStatement("delete from employee where empid=?");
		    pst.setString(1, empid);
		   
		    row=pst.executeUpdate();
		    out.println("<font color=green>Record deleted</font>");
		} 
		catch (Exception e) {
			e.printStackTrace();
		}}

}
