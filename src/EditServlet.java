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
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet{
	Connection con;
	ResultSet rs;
	int row;
	PreparedStatement pst;
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String eid=request.getParameter("empid");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/university","root","#Sivaji68");
		    String empid=request.getParameter("empid");
		    String fname=request.getParameter("fname");
		    String lname=request.getParameter("lname");
		    pst=con.prepareStatement("update employee set fname=?,lname=? where empid=?");
		    pst.setString(1, fname);
		    pst.setString(2, lname);
		    pst.setString(3, empid);
		    row=pst.executeUpdate();
		    out.println("<font color=green>Record updated</font>");
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
