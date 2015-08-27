

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BrokenPromises
 */
@WebServlet("/BrokenPromises")
public class BrokenPromises extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BrokenPromises() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String year;
		
		try {
			year=request.getParameter("year");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc:oracle:thin:@192.168.0.240:1521:orcl";
			String user="scott";
			String pass="tiger";
			Connection con=DriverManager.getConnection(url,user,pass);
			PreparedStatement pst;
			String querry="select count(orders_demo.order_id),to_char(orders_demo.order_due_date,'month') from orders_demo inner join circuit_design on orders_demo.order_id=circuit_design.order_id where circuit_design.due_date<circuit_design.modified_date and orders_demo.order_id=circuit_design.order_id and to_char(orders_demo.order_due_date,'yyyy')=? group by to_char(orders_demo.order_due_date,'month')"; 
			pst=con.prepareStatement(querry);
			pst.setString(1,year);
			ResultSet rs=pst.executeQuery();
			
			String filename = "C:\\kishore\\reports\\WebContent\\BrokenPromises.csv";
			FileWriter fw = new FileWriter(filename);
			fw.append("ordersNP");
			fw.append(',');
			fw.append("Month");
			fw.append('\n');
			while(rs.next())
			{
			System.out.println(rs.getInt(1));
			fw.append(""+rs.getInt(1));
			fw.append(',');
			fw.append(rs.getString(2));
			fw.append('\n');

			}
			fw.flush();
			fw.close();
			con.close();
			System.out.println("CSV File is created successfully.");
			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher r =request.getRequestDispatcher("BrokenPromisesPie.jsp");
		r.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
