

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PaymentView
 */
@WebServlet("/PaymentView")
public class PaymentView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaymentView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tdate;String fdate;
		//System.out.println("done");
		try {
			fdate=request.getParameter("ddate");
			tdate=request.getParameter("edate");
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			java.util.Date fDate = formatter.parse(fdate);
			java.sql.Date Fdate=new java.sql.Date(fDate.getTime());
			java.util.Date tDate = formatter.parse(tdate);
			java.sql.Date Tdate=new java.sql.Date(tDate.getTime());
			System.out.println(tdate);
			DAOimplement e=new DAOimplement();	
			System.out.println("from date "+Fdate);
			System.out.println("to date "+Tdate);
			List<Payment> listP=e.paymentView(Fdate,Tdate);
			request.setAttribute("bills",listP);
			RequestDispatcher rd=request.getRequestDispatcher("ViewBill.jsp");
			rd.forward(request,response);
	}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
