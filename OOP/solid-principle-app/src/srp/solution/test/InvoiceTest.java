package srp.solution.test;
import srp.solution.*;

public class InvoiceTest {
	public static void main(String args[]) {
		Invoice invoice=new Invoice("101", "01-Aug-2019", 3000, 0.05f, 0.03f);
		Printer printer=new ConsolePrinter();
		printer.printInvoice(invoice);
	}
}
