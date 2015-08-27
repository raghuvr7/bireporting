import java.sql.Connection;
import java.sql.Date;
import java.util.List;


public interface DAOInterface {
	public Connection getConnection();
	public List<OrderService> orderView(Date filterf,Date filtert); 
	public void closeDBconn();
	public List<Payment> paymentView(Date filterf,Date filtert);
	public List<PurchasedProduct> purchasedView(String year);
}
