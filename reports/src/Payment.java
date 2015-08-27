import java.sql.Date;


public class Payment {
	
	float countBill;
	float countPayments;
	int custId;
	public float getCountBill() {
		return countBill;
	}
	public void setCountBill(float countBill) {
		this.countBill = countBill;
	}
	public float getCountPayments() {
		return countPayments;
	}
	public void setCountPayments(float countPayments) {
		this.countPayments = countPayments;
	}
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	
	
}
