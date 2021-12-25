import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/employee")
public class employee extends HttpServlet{
Connection con;
int row;
PreparedStatement pst;
public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
	response.setContentType("text/html");
	PrintWriter out=response.getWriter();
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/university","root","#Sivaji68");
	 String empid=request.getParameter("empid");
	 String empfname=request.getParameter("fname");
	 String emplname=request.getParameter("lname");
	 pst=con.prepareStatement("insert into employee(empid,fname,lname)values(?,?,?)");
	 pst.setString(1, empid);
	 pst.setString(2, empfname);
	 pst.setString(3, emplname);
	 row=pst.executeUpdate();
	 out.println("<font color=green>Record added</font>");
	} 
	catch (Exception e) {
		e.printStackTrace();
	}
}
}
