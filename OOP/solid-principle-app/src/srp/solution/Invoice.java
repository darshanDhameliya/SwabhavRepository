package srp.solution;

public class Invoice {

	private String no;
	private String date;
	private double cost;
	private float percentageOfDiscount;
	private float percentageOfGst;
	
	public Invoice (String no,String date,double cost,float percentageOfDiscount,float percentageOfGst)
	{
		this.no=no;
		this.date=date;
		this.cost=cost;
		this.percentageOfDiscount=percentageOfDiscount;
		this.percentageOfGst=percentageOfGst;
	}
	public String getNo() {
		return no;
	}

	public String getDate() {
		return date;
	}

	public double getCost() {
		return cost;
	}

	
	public double calculateGstTex()
	{
		return cost*percentageOfGst;
	}
	public double calculateDiscount()
	{
		return cost*percentageOfDiscount;
	}
	public double calculateTotalCost()
	{
		return cost+calculateGstTex()-calculateDiscount();
	}
}
