package Customermodel;

public class Customer {

	private int Customerid;
	private String Cname;
	private String adress;
	private int phnNumber;
	
	public Customer(int customerid, String cname, String adress, int phnNumber) {
		
		this.Customerid = customerid;
		this.Cname = cname;
		this.adress = adress;
		this.phnNumber = phnNumber;
	}
	
	public int getCustomerid() {
		return Customerid;
	}

	public void setCustomerid(int customerid) {
		this.Customerid = customerid;
	}

	public String getCname() {
		return Cname;
	}

	public void setCname(String cname) {
		this.Cname = cname;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public int getPhnNumber() {
		return phnNumber;
	}

	public void setPhnNumber(int phnNumber) {
		this.phnNumber = phnNumber;
	}
	
}
