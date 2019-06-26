package srp.solution;

public class ConsolePrinter implements Printer{

	@Override
	public void printInvoice(Invoice invoice) {

		System.out.println("no : "+invoice.getNo());
		System.out.println("date : "+invoice.getDate());
		System.out.println("cost : "+invoice.getCost());
		System.out.println("gst : "+invoice.calculateGstTex());
		System.out.println("discount : "+invoice.calculateDiscount());
		System.out.println("total cost : "+invoice.calculateTotalCost());
	}

}
