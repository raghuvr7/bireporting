

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/ServiceTickets")
public class ServiceTickets extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String tdate;String fdate;
		System.out.println("done");
		try {
		fdate=request.getParameter("ddate");
		tdate=request.getParameter("edate");
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		java.util.Date fDate = formatter.parse(fdate);
		java.sql.Date Fdate=new java.sql.Date(fDate.getTime());
		java.util.Date tDate = formatter.parse(tdate);
		java.sql.Date Tdate=new java.sql.Date(tDate.getTime());
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url="jdbc:oracle:thin:@localhost:1521:orcl";
		
		 String filename = "C:\\kishore\\reports\\WebContent\\ServiceTickets.csv";
		 FileWriter fw = new FileWriter(filename);
		
		 String user="scott";
		String pass="admin";
		
		Connection con=DriverManager.getConnection(url,user,pass);
		PreparedStatement pst;
		String query="select count(type_status),service_id from customer_ticket where creation_date between ? and ? group by service_id";
		pst=con.prepareStatement(query);
		pst.setDate(1,Fdate);
		pst.setDate(2,Tdate); 
		ResultSet rs=pst.executeQuery();
		  fw.append("countTickets");
		  fw.append(',');
		  fw.append("serviceType");
		   fw.append('\n');
		   System.out.println("hello");
		  while(rs.next())
		  {
			  System.out.println(rs.getInt(1));
			  fw.append(""+rs.getInt(1));
			  fw.append(',');
			  
			  if(rs.getInt(2)==1)
				  fw.append("voice");
			  else if(rs.getInt(2)==2)
				  fw.append("data");
			  else if(rs.getInt(2)==3)
				  fw.append("fios");
			  else if(rs.getInt(2)==4)
				  fw.append("bundles");
			  else if(rs.getInt(2)==5)
				  fw.append("wireless");
			  else if(rs.getInt(2)==6)
				  fw.append("enterprise");
			  
			  	  fw.append('\n');
			  
		  }
		  fw.flush();
		  fw.close();
		  con.close();
		  System.out.println("CSV File is created successfully.");
		} 
		
		catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		RequestDispatcher r =request.getRequestDispatcher("ServiceTicketD3.jsp");
		r.forward(request, response);

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
