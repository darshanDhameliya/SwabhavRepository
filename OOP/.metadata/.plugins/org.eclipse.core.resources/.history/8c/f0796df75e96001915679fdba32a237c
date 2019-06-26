package ocp.violation;

public class FixedDeposit {

	private String accNo;
	private String name;
	private double principal;
	private float period;
	private FestivalType festival;
	
	public FixedDeposit(String accNo, String name, double principal, float period, FestivalType festival) {
		this.accNo = accNo;
		this.name = name;
		this.principal = principal;
		this.period = period;
		this.festival = festival;
	}
	public String getAccNo() {
		return accNo;
	}

	public String getName() {
		return name;
	}

	public double getPrincipal() {
		return principal;
	}

	public float getPeriod() {
		return period;
	}

	public FestivalType getFestival() {
		return festival;
	}

	
	public double calculateSimpleIntrast()
	{
		return principal*(1+(festival.getRate()*period));
	}
	
	
}
